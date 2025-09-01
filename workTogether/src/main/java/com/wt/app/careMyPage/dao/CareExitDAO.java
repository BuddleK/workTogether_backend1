package com.wt.app.careMyPage.dao;

import org.apache.ibatis.session.SqlSession;

import com.wt.config.MyBatisConfig;

public class CareExitDAO {
	public SqlSession sqlSession;
	
	public CareExitDAO(){
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	//매칭회원 있는지 조회
	
	//회원 삭제
	public void careExit(int usersNUmber) {
		System.out.println("회원 삭제하기 - careExit 메소드 실행 : ");
		sqlSession.delete("careExit.careExit");
	}
	
	
	
}
