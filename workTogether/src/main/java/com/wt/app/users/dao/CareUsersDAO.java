package com.wt.app.users.dao;

import org.apache.ibatis.session.SqlSession;

import com.wt.app.dto.CareSignDTO;
import com.wt.app.dto.NormalUsersDTO;
import com.wt.app.dto.UsersLoginDTO;
import com.wt.config.MyBatisConfig;



public class CareUsersDAO {
	 public SqlSession sqlSession;

	    public CareUsersDAO() {
	        sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	    }

	    public void sign(CareSignDTO dto) {
	        sqlSession.insert("CareUsersMapper.join", dto);
    }

}