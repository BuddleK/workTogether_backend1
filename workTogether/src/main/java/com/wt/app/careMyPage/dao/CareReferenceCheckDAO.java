package com.wt.app.careMyPage.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.wt.app.dto.CareReferenceCheckDTO;
import com.wt.config.MyBatisConfig;

public class CareReferenceCheckDAO {
	public SqlSession sqlSession;

	public CareReferenceCheckDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	//문의 내용 조회
	public CareReferenceCheckDTO select(int usersNumber, int referenceNumber) {
		System.out.println("게시글 상세 페이지 조회(단건조회)");
		Map<String, Object> check = new HashMap<>();
	    check.put("usersNumber", usersNumber);
	    check.put("referenceNumber", referenceNumber);
		return sqlSession.selectOne("careReferenceCheck.referenceCheck", check);
	}
}
