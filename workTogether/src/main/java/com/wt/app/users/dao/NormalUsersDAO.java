package com.wt.app.users.dao;

import org.apache.ibatis.session.SqlSession;

import com.wt.app.dto.NormalSignDTO;
import com.wt.app.dto.NormalUsersDTO;
import com.wt.app.dto.UsersLoginDTO;
import com.wt.config.MyBatisConfig;

public class NormalUsersDAO {
	public SqlSession sqlSession;

	public NormalUsersDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}

	 public void sign(NormalSignDTO dto) {
	        sqlSession.insert("NormalUsersMapper.join", dto);
	    }
	
}
