package com.wt.app.users.dao;

import org.apache.ibatis.session.SqlSession;

import com.wt.app.dto.CareSignDTO;
import com.wt.app.dto.UsersLoginDTO;
import com.wt.config.MyBatisConfig;



public class CareUsersDAO {
    public SqlSession sqlSession;

    public CareUsersDAO() {
        sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
    }
    public void sign(CareSignDTO caresginDTO) {
    	sqlSession.insert("Care.sign", caresginDTO);
    }
    
    public boolean checkId(String usersId) {
    	return (Integer) sqlSession.selectOne("Care.checkId", usersId) < 1;
    }
    
    public boolean checkEmail(String usersEmail) {
        return (Integer) sqlSession.selectOne("Care.checkEmail", usersEmail) < 1;
    }
    
    public int login(UsersLoginDTO UsersLoginDTO) { 
    	Integer CareUsersNumber =
    		 sqlSession.selectOne("Care.login", UsersLoginDTO); 
    	return CareUsersNumber == null ? -1 : CareUsersNumber ; 
    	}

}