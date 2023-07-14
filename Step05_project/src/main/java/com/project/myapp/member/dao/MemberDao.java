package com.project.myapp.member.dao;



import java.util.List;

import com.project.myapp.member.dto.MemberDto;

public interface MemberDao {
	List<MemberDto> getList(MemberDto dto);
	//모든 row의 수
	int getCount(MemberDto dto);
	
	void insert(MemberDto dto);
	
	MemberDto getData(int num);
	
	MemberDto getData(MemberDto dto);
	
	void addViewCount(int num);
	
	void delete(int num);
	
	void update(MemberDto dto);
	
}
