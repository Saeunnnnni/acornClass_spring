package com.project.myapp.member.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.project.myapp.member.dto.MemberDto;

public interface MemberService {
	void getList(HttpServletRequest request);
	void getDetail(ModelAndView mView, int num);
	void saveContent(MemberDto dto,  HttpServletRequest request);
	void updateContent(MemberDto dto);
	void deleteCountent(int num, HttpServletRequest request);
	void getData(HttpServletRequest request);
}
