package com.wt.app.admin.dao;

import org.apache.ibatis.session.SqlSession;

import com.wt.app.dto.AdminLoginDTO;
import com.wt.config.MyBatisConfig;

public class AdminDAO {
    public SqlSession sqlSession;
    
    public AdminDAO() {
    	sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
    }
    
	
    public int login(AdminLoginDTO AdminLoginDTO) { 
    	Integer memberNumber =
    		 sqlSession.selectOne("admin.login", AdminLoginDTO); 
    	return memberNumber == null ? -1 : 1 ; 
    	}

}
