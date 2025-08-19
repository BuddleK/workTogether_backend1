package com.wt.app.user.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.wt.app.dto.UserDTO;
import com.wt.app.dto.UsersDTO;
import com.wt.config.MyBatisConfig;

public class UserDAO {
    public SqlSession sqlSession;

    public UserDAO() {
        sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
    }
   
    public int loginByType(UsersDTO usersDTO) {
    	Integer usersNumber = sqlSession.selectOne("users.loginByType", usersDTO);
    	if(usersNumber == null) {
    		return 0;
    	}
    	return usersNumber;
    }
    
    public int insertUser(UsersDTO usersDTO) {
        sqlSession.insert("users.insert", usersDTO);
        // selectKey가 usersDTO.usersNumber에 값을 채워줌
        return usersDTO.getUsersNumber();
    }

    public boolean checkId(String usersId) {
        return (Integer) sqlSession.selectOne("users.checkId", usersId) < 1;
     }

    public boolean checkEmail(String usersEmail) {
        return (Integer) sqlSession.selectOne("users.checkEmail", usersEmail) < 1;
    }
}