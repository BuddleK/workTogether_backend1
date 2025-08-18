package com.wt.app.normalUsers.dao;

import org.apache.ibatis.session.SqlSession;

import com.wt.config.MyBatisConfig;

public class NormalUsersDAO {
	public SqlSession sqlSession;

	public NormalUsersDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
}
