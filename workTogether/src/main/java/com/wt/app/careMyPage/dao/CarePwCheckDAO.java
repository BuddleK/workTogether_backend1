package com.wt.app.careMyPage.dao;

import org.apache.ibatis.session.SqlSession;

import com.wt.config.MyBatisConfig;

public class CarePwCheckDAO {
	public SqlSession sqlSession;
	
	public CarePwCheckDAO(){
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	
	//비밀번호 일치 체크
	public int checkPw(int usersNumber, String usersPassword) {
		System.out.println("비번 일치 체크 - checkPw 메소드 실행");
		return sqlSession.selectOne("carePwCheck.checkPw");
	}
}
