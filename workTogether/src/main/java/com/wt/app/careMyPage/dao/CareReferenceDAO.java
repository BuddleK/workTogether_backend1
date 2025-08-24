package com.wt.app.careMyPage.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.wt.app.dto.CareReferenceDTO;
import com.wt.config.MyBatisConfig;

public class CareReferenceDAO {
	public SqlSession sqlSession;

	public CareReferenceDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	//문의 목록 전체 조회
	public List<CareReferenceDTO> refereneceAll(Map<String, Integer> pageMap) {
		System.out.println("문의글 조회하기 - referenceAll 메소드 실행 : " + pageMap);
		List<CareReferenceDTO> list = sqlSession.selectList("careReference.referenceAll", pageMap);
		System.out.println("조회결과 : " + list);
		return list;
	}
	
}
