package com.wt.app.admin.dao;

import org.apache.ibatis.session.SqlSession;

import com.wt.app.dto.AdminDTO;
import com.wt.config.MyBatisConfig;

public class AdminDAO {
    public SqlSession sqlSession;
    
    public AdminDAO() {
    	sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
    }
    
    public int login(AdminDTO adminDTO) {
        Integer adminNumber = sqlSession.selectOne("admin.login", adminDTO);
        if (adminNumber == null) { 
        	return 0;
        }
        return adminNumber;
    }

}
