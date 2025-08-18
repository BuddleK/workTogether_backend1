package com.wt.app.admin.dao;

import org.apache.ibatis.session.SqlSession;

import com.wt.config.MyBatisConfig;

public class AdminDAO {
	public SqlSession sqlSession;

	public AdminDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
}
