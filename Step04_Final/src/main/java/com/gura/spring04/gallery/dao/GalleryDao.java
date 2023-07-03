package com.gura.spring04.gallery.dao;

import java.util.List;
import com.gura.spring04.gallery.dto.GalleryDto;

public interface GalleryDao {
	//갤러리 추가 
	public void insert(GalleryDto dto);
	//갤러리의 갯수
	public GalleryDto getData(int num);
	//갤러리 삭제
	public void delete(int num);
	//갤러리 목록
	public List<GalleryDto> getList(GalleryDto dto);
	// 갤러리 수정
	public void update(GalleryDto dto);
	public int getCount(GalleryDto dto);
}
