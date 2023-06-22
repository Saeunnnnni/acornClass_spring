package com.gura.spring02.guest.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gura.spring02.guest.dto.GuestDto;

//component scan
@Repository
public class GuestDaoImpl implements GuestDao{
	
	//memberDao를 impl하면 오류가 나는 이유는 memberDao가 미완성의 추상메소드이기 때문에 오류가 발생한다.
	//그래서 add해서 메소드들을 override해주면 오류가 사라짐 ! 

	@Autowired
	private SqlSession session;
	//mybatis기반으로 db연동을 할기위한 핵심 의존객체를 Dependency Inection 받는다.

	@Override
	public void insert(GuestDto dto) {
		session.insert("guest.insert", dto);
		/*
		 * 
		 * Mapper's namespace => guest
		 * sql's id => insert
		 * parameterType => GuestDto
		 */
	}

	@Override
	public void update(GuestDto dto) {
		session.update("guest.update", dto);
		
	}

	@Override
	public void delete(GuestDto dto) {
		session.delete("guest.delete", dto);
		
	}

	@Override
	public GuestDto getData(int num) {
		/* 
		 * Mapper's namespace => guest
		 * sql's id => getData
		 * parameterType => int 
		 * resultType => GuestDto		 * 
		 */
		return session.selectOne("guest.getData", num);
	}

	@Override
	public List<GuestDto> getList() {
		return session.selectList("guest.getList");
		 
	}
	
	

}
