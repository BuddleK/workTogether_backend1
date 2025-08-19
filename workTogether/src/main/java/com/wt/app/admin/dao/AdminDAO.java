package com.wt.app.admin.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.wt.app.dto.AdminDTO;
import com.wt.config.MyBatisConfig;

public class AdminDAO {
    public SqlSession sqlSession;

    public AdminDAO() {
        sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
        
        
        
    }
    
    public AdminDTO login(String adminId, String adminPw) {
    	Map<String, String> params = new HashMap<>();
        params.put("adminId", adminId);
        params.put("adminPw", adminPw);
        return sqlSession.selectOne("com.wt.app.admin.dao.AdminMapper.login", params);
    }
    
}
