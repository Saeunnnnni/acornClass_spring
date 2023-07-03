package com.gura.spring04.gallery.service;

import java.io.File;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring04.exception.NotDeleteException;
import com.gura.spring04.gallery.dao.GalleryDao;
import com.gura.spring04.gallery.dto.GalleryDto;

@Service
public class GalleryServiceImpl implements GalleryService{
	
	@Autowired
	private GalleryDao dao;
	
	
	@Override
	public void getList(HttpServletRequest request) {
		//한 페이지에 몇개씩 표시할 것인지
	      final int PAGE_ROW_COUNT=5;
	      //하단 페이지를 몇개씩 표시할 것인지
	      final int PAGE_DISPLAY_COUNT=5;

	      //보여줄 페이지의 번호를 일단 1이라고 초기값 지정
	      int pageNum=1;
	      
	      //페이지 번호가 파라미터로 전달되는지 읽어와 본다.
	      String strPageNum=request.getParameter("pageNum");
	      //만일 페이지 번호가 파라미터로 넘어 온다면
	      if(strPageNum != null){
	         //숫자로 바꿔서 보여줄 페이지 번호로 지정한다.
	         pageNum=Integer.parseInt(strPageNum);
	      }  
	      //보여줄 페이지의 시작 ROWNUM
	      int startRowNum=1+(pageNum-1)*PAGE_ROW_COUNT;
	      //보여줄 페이지의 끝 ROWNUM
	      int endRowNum=pageNum*PAGE_ROW_COUNT;
	      GalleryDto dto = new GalleryDto();
	      dto.setStartRowNum(startRowNum);
	      dto.setEndRowNum(endRowNum);
	      
	      List<GalleryDto> list=dao.getList(dto);
	    //전체 글의 갯수(검색 키워드가 있는경우 키워드에 부합하는 전체 글의 갯수)
	      int totalRow=dao.getCount(dto);
	      
	      //하단 시작 페이지 번호 
	      int startPageNum = 1 + ((pageNum-1)/PAGE_DISPLAY_COUNT)*PAGE_DISPLAY_COUNT;
	      //하단 끝 페이지 번호
	      int endPageNum=startPageNum+PAGE_DISPLAY_COUNT-1;
	      
	      //전체 페이지의 갯수 구하기
	      int totalPageCount=(int)Math.ceil(totalRow/(double)PAGE_ROW_COUNT);
	      //끝 페이지 번호가 이미 전체 페이지 갯수보다 크게 계산되었다면 잘못된 값이다.
	      if(endPageNum > totalPageCount){
	         endPageNum=totalPageCount; //보정해 준다. 
	      }
	      
	      request.setAttribute("list", list);
	}

	@Override
	public Map<String, Object> saveGallery(HttpServletRequest request, 
			MultipartFile mFile) {
		
		
		 String orgFileName=mFile.getOriginalFilename();
		 
		String saveFileName=System.currentTimeMillis()+orgFileName;
		
		String realPath=request.getServletContext().getRealPath("/resource/upload");
		
		File upload=new File(realPath);
		
		 if(!upload.exists()) {//만일 존재 하지 않으면
	         upload.mkdir(); //만들어준다.
	      }
	      
	      try {
	         //파일을 저장할 전체 경로를 구성한다.  
	         String savePath=realPath+File.separator+saveFileName;
	         //임시폴더에 업로드된 파일을 원하는 파일을 저장할 경로에 전송한다.
	         mFile.transferTo(new File(savePath));
	      }catch(Exception e) {
	         e.printStackTrace();
	      }
	      
	      Map<String, Object> map=new HashMap<String, Object>();
	      map.put("imagePath", "/resources/upload/"+saveFileName);
	      
		return map;
	}

	@Override
	public void deleteGallery(int num, HttpServletRequest request) {
		GalleryDto dto=dao.getData(num);
		String id=(String)request.getSession().getAttribute("id");
		if(!dto.getWriter().contentEquals(id)) {
			throw new NotDeleteException("남의 파일 지우기 없기!");
		}
				
		String saveFileName=dto.getImagePath();
		String path=request.getServletContext().getRealPath("/resource/upload")+
				File.separator+saveFileName;
		new File(path).delete();
		dao.delete(num);
	}

	@Override
	public void getGalleryData(int num, ModelAndView mView) {
		GalleryDto dto=dao.getData(num);
		mView.addObject("dto", dto);
		
	}

	@Override
	public void updateGallery(GalleryDto dto) {
		dao.update(dto);
	}

}
