package com.project.myapp.users.service;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.project.myapp.user.dao.UsersDao;
import com.project.myapp.users.dto.UsersDto;

public class UsersServiceImpl implements UsersService{
	
	@Autowired
	private UsersDao dao;
	

	@Override
	public void addUser(UsersDto dto) {
		//비밀번호를 암호화해줄 객체를 생성
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		//암호화된 비밀번호 얻어내서 
		String encodedPwd=encoder.encode(dto.getPwd());
		//UsersDto 객체에 다시 담고 
		dto.setPwd(encodedPwd);
		//UsersDao 객체를 이용해서 DB 에 저장하기 
		dao.insert(dto);
		
	}

	@Override
	public void loginProcess(UsersDto dto, HttpSession session) {
		boolean isValid=false; //변수 생성
		
		UsersDto resultDto=dao.getData(dto.getId()); //아이디를 이용해 회원 정보를 가져온다.
		
		if(resultDto != null) {
			isValid  = BCrypt.checkpw(dto.getPwd(), resultDto.getPwd());
		}
		if(isValid) {
			session.setAttribute("id", resultDto.getId());
		}
	}

	@Override
	public void getInfo(HttpSession session, ModelAndView mView) {
		String id=(String)session.getAttribute("id");
		
		UsersDto dto= dao.getData(id);
		
		mView.addObject("dto",dto);
		
	}

	@Override
	public Map<String, Object> saveProfileImage(HttpServletRequest request, MultipartFile mFile) {
		 //업로드된 파일에 대한 정보를 MultipartFile 객체를 이용해서 얻어낼수 있다.   
	      
	      //원본 파일명
	      String orgFileName=mFile.getOriginalFilename();
	      //upload 폴더에 저장할 파일명을 직접구성한다.
	      // 1234123424343xxx.jpg
	      String saveFileName=System.currentTimeMillis()+orgFileName;
	      
	      // webapp/upload 폴더까지의 실제 경로 얻어내기 
	      String realPath=request.getServletContext().getRealPath("/resources/upload");
	      // upload 폴더가 존재하지 않을경우 만들기 위한 File 객체 생성
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
	      
	      // json 문자열을 출력하기 위한 Map 객체 생성하고 정보 담기 
	      Map<String, Object> map=new HashMap<String, Object>();
	      map.put("imagePath", "/resources/upload/"+saveFileName);
	      
	      return map;
	}

	@Override
	public void updateUser(UsersDto dto, HttpSession session) {
		String id=(String)session.getAttribute("id");
		
		dto.setId(id);
		
		dao.update(dto);
		
	}

	@Override
	public void deleteUser(HttpSession session, ModelAndView mView) {
		String id=(String)session.getAttribute("id");
		
		dao.delete(id);
		
		session.removeAttribute("id");
		mView.addObject("id",id);
		
	}

}