package com.wt.app.careMyPage.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.wt.app.dto.CareMarkDTO;
import com.wt.app.dto.CareMatchingDTO;
import com.wt.config.MyBatisConfig;

public class CareMatchingDAO {
	public SqlSession sqlSession;
	
	public CareMatchingDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	//매칭 추가
	public void matchingAdd(CareMatchingDTO careMatchingDTO){
		System.out.println("매칭 추가 메소드 - matchingAdd 메소드 실행 ");
		sqlSession.insert("careMatching.matchingAdd", careMatchingDTO);
	}
	//매칭 개수
	public int matchingTotal() {
		System.out.println("매칭 개수 조회 - matchingTotal 메소드 실행");
		return sqlSession.selectOne("careMatching.matchingTotal");
	}
	
	//매칭 조회
	public List<CareMatchingDTO> matchingMonth(Map<String, Integer> pageMap){
		System.out.println("매칭 조회하기- matchingMonth 메소드 실행 : " + pageMap);
		List<CareMatchingDTO> list = sqlSession.selectList("careMatching.matchingMonth", pageMap);
		System.out.println("조회결과 : " + list);
		return list;
	}
	

}
                                                                   
