package com.project.myapp.users.controller;

import java.net.URLEncoder;
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

import com.project.myapp.users.dto.UsersDto;
import com.project.myapp.users.service.UsersService;



@Controller
public class UsersController {
	@Autowired
	private UsersService service;
	
	//회원 탈퇴 요청 처리
	@RequestMapping(value="/users/delete")
	public ModelAndView delete(HttpSession session, ModelAndView mView) {
		service.deleteUser(session, mView);
		
		mView.setViewName("/users/delete");
		return mView;
	}
	
	@RequestMapping(value="/users/update", method=RequestMethod.POST)
	public ModelAndView update(UsersDto dto, HttpSession session, ModelAndView mView) {
		//서비스를 이용해서 개인정보를 수정하고 
		service.updateUser(dto, session);
		//개인정보 보기로 리다이렉트 이동시킨다.
		mView.setViewName("redirect:/users/info");
		return mView;
	}
	
	//ajax 프로필 사진 업로드 요청 처리
	   @RequestMapping(value="/users/profile_upload", method=RequestMethod.POST)
	   @ResponseBody
	   public Map<String, Object> profileUpload(HttpServletRequest request, MultipartFile image){
	      //서비스를 이용해서 이미를 upload 폴더에 저장하고 리턴되는 Map을 리턴해서 json 문자열 응답하기
	      return service.saveProfileImage(request, image);
	   }
	   
		//개인정보 수정폼 요청 처
		@RequestMapping("/users/updateform")
		public ModelAndView updateform(HttpSession session, ModelAndView mView) {
			service.getInfo(session, mView);
			mView.setViewName("users/updateform");
			return mView;
			
		}
		//개인 정보 보기 요청 처리 
		@RequestMapping("/users/info")
		public ModelAndView info(HttpSession session, ModelAndView mView) {
			
			service.getInfo(session, mView);
			
			mView.setViewName("users/info");
			return mView;
		}	
		@RequestMapping("/users/logout")
		public String logout(HttpSession session) {
			//세션에서 id 라는 키값으로 저장된 값 삭제 
			session.removeAttribute("id");
			return "users/logout";
		}	
		//로그인 요청 처리
		@RequestMapping("/users/login")
		public ModelAndView login(ModelAndView mView, UsersDto dto, String url, HttpSession session) {
			/*
			 *  서비스에서 비즈니스 로직을 처리할때 필요로  하는 객체를 컨트롤러에서 직접 전달을 해 주어야 한다.
			 *  주로, HttpServletRequest, HttpServletResponse, HttpSession, ModelAndView
			 *  등등의 객체 이다. 
			 */
			service.loginProcess(dto, session);
			
			//로그인 후에 가야할 목적지 정보를 인코딩 하지 않는것과 인코딩 한 것을 모두 ModelAndView 객체에 담고 
			String encodedUrl=URLEncoder.encode(url);
			mView.addObject("url", url);
			mView.addObject("encodedUrl", encodedUrl);
			
			//view page 로 forward 이동해서 응답한다.
			mView.setViewName("users/login");
			return mView;
		}		
		
		//로그인 폼 요청 처리
		@RequestMapping(method=RequestMethod.GET, value="/users/loginform")
		public String loginForm() {
			
			return "users/loginform";
		}
		
		//회원 가입 요청처리 
		@RequestMapping(method = RequestMethod.POST, value = "/users/signup")
		public ModelAndView signup(ModelAndView mView, UsersDto dto) {
			//서비스를 이용해서 DB 에 저장하고 
			service.addUser(dto);
			//view page 로 forward 이동해서 응답
			mView.setViewName("users/signup");
			return mView;
		}	
		
		/*
		 *  GET 방식 /users/signup_form 요청을 처리할 메소드 
		 *  - 요청방식이 다르면 실행되지 않는다. 
		 */
		@RequestMapping(method = RequestMethod.GET, value = "/users/signup_form")
		public String signupForm() {
			
			return "users/signup_form";
		}	
			
}