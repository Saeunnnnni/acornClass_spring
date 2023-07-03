package com.gura.spring04.gallery.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring04.gallery.service.GalleryService;

@Controller
public class GalleryController {
	
	@Autowired
	private GalleryService service;
	
	@RequestMapping("/gallery/list")
	public String getList(HttpServletRequest request) {
		
		return "gallery/list";
	}
	
	@RequestMapping("/gallery/delete")
	public ModelAndView delete(int num, HttpServletRequest request, ModelAndView mView) {
		service.deleteGallery(num, request);
		
		mView.setViewName("/gallery/delete");
		return mView;
	}
	//ajax 프로필 사진 업로드 요청 처리
	   @RequestMapping(value="/gallery/upload_form")
	   @ResponseBody
	   public Map<String, Object> profileUpload(HttpServletRequest request, MultipartFile image){
	      //서비스를 이용해서 이미를 upload 폴더에 저장하고 리턴되는 Map을 리턴해서 json 문자열 응답하기
	      return service.saveGallery(request, image);
	   }
	
	
}
