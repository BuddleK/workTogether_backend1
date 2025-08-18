package com.wt.app.shops.dao;

import org.apache.ibatis.session.SqlSession;

import com.wt.config.MyBatisConfig;

public class ShopsDAO {
	public SqlSession sqlSession;

	public ShopsDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
}
