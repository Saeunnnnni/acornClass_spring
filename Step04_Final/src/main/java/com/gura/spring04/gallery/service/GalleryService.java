package com.gura.spring04.gallery.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring04.gallery.dto.GalleryDto;

public interface GalleryService {
	public void getList(HttpServletRequest request);
	
	public Map<String, Object>saveGallery(HttpServletRequest request, 
			MultipartFile mFile);
	
	public void deleteGallery(int num, HttpServletRequest request);
	
	public void getGalleryData(int num , ModelAndView mView);
	
	public void updateGallery(GalleryDto dto);
}
