package com.wt.app.normalUsers.dao;

import org.apache.ibatis.session.SqlSession;

import com.wt.app.dto.NormalSignDTO;
import com.wt.app.dto.UsersLoginDTO;
import com.wt.config.MyBatisConfig;

public class NormalUsersDAO {
	public SqlSession sqlSession;

	public NormalUsersDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}

	public void sign(NormalSignDTO caresginDTO) {
		sqlSession.insert("NormalUsers.sign", caresginDTO);
	}

	public boolean checkId(String usersId) {
		return (Integer) sqlSession.selectOne("Normal.checkId", usersId) < 1;
	}

	public boolean checkEmail(String usersEmail) {
		return (Integer) sqlSession.selectOne("Normal.checkEmail", usersEmail) < 1;
	}
	
	public int login(UsersLoginDTO UsersLoginDTO) { 
    	Integer normalUsersNumber =
    		 sqlSession.selectOne("Normal.login", UsersLoginDTO); 
    	return normalUsersNumber == null ? -1 : normalUsersNumber ;
    	}
}
