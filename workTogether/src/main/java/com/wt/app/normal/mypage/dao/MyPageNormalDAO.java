package com.wt.app.normal.mypage.dao;

import org.apache.ibatis.session.SqlSession;

import com.wt.config.MyBatisConfig;

public class MyPageNormalDAO {
	public SqlSession sqlSession;

	public MyPageNormalDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	public boolean checkPw(String usersPassword){
		return (Integer) sqlSession.selectOne("myPageNormal.checkPw", usersPassword) < 1;
	}
	
	
	
}
