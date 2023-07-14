package com.project.myapp.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.myapp.member.dto.MemberDto;

@Repository
public class MemberDaoImpl implements MemberDao{
	
	@Autowired
	private SqlSession session;

	@Override
	public List<MemberDto> getList(MemberDto dto) {
		
		return session.selectList("member.getList",dto);
	}

	@Override
	public int getCount(MemberDto dto) {
		
		return session.selectOne("member.getCount", dto);
	}

	@Override
	public void insert(MemberDto dto) {
		session.insert("member.insert", dto);
		
	}

	@Override
	public MemberDto getData(int num) {
		
		return session.selectOne("member.getData", num);
	}

	@Override
	public MemberDto getData(MemberDto dto) {
		
		return session.selectOne("member.getData2", dto);
	}

	@Override
	public void addViewCount(int num) {
		session.update("member.addViewCount", num);
		
	}

	@Override
	public void delete(int num) {
		session.delete("member.delete", num);
		
	}

	@Override
	public void update(MemberDto dto) {
		session.update("member.update", dto);
		
	}

}