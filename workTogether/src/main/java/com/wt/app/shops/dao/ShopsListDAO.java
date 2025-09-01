package com.wt.app.shops.dao;

import org.apache.ibatis.session.SqlSession;

import com.wt.app.dto.ShopsListDTO;
import com.wt.config.MyBatisConfig;

public class ShopsListDAO {
	public SqlSession sqlSession;

	public ShopsListDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	
	// 게시글 상세 페이지 조회 메소드
	public ShopsListDTO select(int shopsNumber) {
		System.out.println("가게 상세 페이지 조회(단건조회)");
		return sqlSession.selectOne("shops.detail", shopsNumber);
	}
	
}
