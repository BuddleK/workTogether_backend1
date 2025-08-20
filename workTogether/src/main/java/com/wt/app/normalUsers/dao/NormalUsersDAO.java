package com.wt.app.normalUsers.dao;

import org.apache.ibatis.session.SqlSession;

import com.wt.app.dto.NormalUserDTO;
import com.wt.config.MyBatisConfig;

public class NormalUsersDAO {
	
	public SqlSession sqlSession;

	public NormalUsersDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
		public void insert(NormalUserDTO normalUserDTO) {
			sqlSession.insert("normalUsers.insert", normalUserDTO);
		
	}
}
