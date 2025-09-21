package com.wt.app.careMyPage.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.wt.app.dto.CareMatchingDTO;
import com.wt.app.dto.CareMessageDTO;
import com.wt.config.MyBatisConfig;

public class CareMatchingDAO {
	public SqlSession sqlSession;
	
	public CareMatchingDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	// 받은 쪽지 가져오기
	public List<CareMessageDTO> getRM(Map<String, Integer> getRMMap){
		System.out.println("받은 쪽지 가져오기 - getRM메소드 실행 : " + getRMMap);
		List<CareMessageDTO> list = sqlSession.selectList("careMatching.getRM", getRMMap);
		return list;
	}
	
	//받은 쪽지 수
	public int totalGetRM(int usersNumber) {
		System.out.println("받은 쪽지 수 - totalGetRM메소드 실행 : " + usersNumber);
		return sqlSession.selectOne("careMatching.totalGetRM", usersNumber);
	}
	
	// 보낸 쪽지 가져오기
	public List<CareMessageDTO> getSM(Map<String, Integer> getSMMap){
		System.out.println("보낸 쪽지 가져오기 - getSM메소드 실행 : " + getSMMap);
		List<CareMessageDTO> list = sqlSession.selectList("careMatching.getSM", getSMMap);
		return list;
	}
	
	//보낸 쪽지 수
	public int totalGetSM(int usersNumber) {
		System.out.println("보낸 쪽지 수 - totalGetSM메소드 실행 : " + usersNumber);
		return sqlSession.selectOne("careMatching.totalGetSM", usersNumber);
	}
	
	public List<CareMatchingDTO> getMonthMatching(Map<String, Integer> getMonthMatchingMap){
		System.out.println("월 별 매칭조회 - getMonthMatching메소드 실행 : " + getMonthMatchingMap);
		List<CareMatchingDTO> list = sqlSession.selectList("careMatching.getMonthMatching", getMonthMatchingMap);
		return list;
	}
	
	//일치매칭 개수
	public int getMonthMatchingCount(Map<String, Integer> getMonthMatchingCountMap) {
		System.out.println("일치 매칭 개수 조회 - getMonthMatchingCount 메소드 실행");
		return sqlSession.selectOne("careMatching.getMonthMatchingCount", getMonthMatchingCountMap);
	}
	
	//아이디 회원번호 검색
	public int searchId(String userId) {
		System.out.println("아이디로 회원번호 검색 - searchId 메소드 실행");
		return sqlSession.selectOne("careMatching.searchId", userId);
	}
	
	//회원번호로 타입 검색
	public String searchType(int normalNumber) {
		System.out.println("회원번호로 타입 검색 - searchType 메소드 실행");
		return sqlSession.selectOne("careMatching.searchType", normalNumber);
	}
	
	//매칭 정보 추가
	public void insertMatching(Map<String, Object> insertMatchingMap) {
		System.out.println("매칭 정보 추가 - insertMatching 메소드 실행");
		sqlSession.selectOne("careMatching.insertMatching", insertMatchingMap);
	}
	
	
	//매칭 추가
	/*
	 * public void matchingAdd(CareMatchingDTO careMatchingDTO){
	 * System.out.println("매칭 추가 메소드 - matchingAdd 메소드 실행 ");
	 * sqlSession.insert("careMatching.matchingAdd", careMatchingDTO); }
	 */
	//매칭 개수
	/*
	 * public int matchingTotal() {
	 * System.out.println("매칭 개수 조회 - matchingTotal 메소드 실행"); return
	 * sqlSession.selectOne("careMatching.matchingTotal"); }
	 */
	
	//매칭 조회
	/*
	 * public List<CareMatchingDTO> matchingMonth(Map<String, Integer> pageMap){
	 * System.out.println("매칭 조회하기- matchingMonth 메소드 실행 : " + pageMap);
	 * List<CareMatchingDTO> list =
	 * sqlSession.selectList("careMatching.matchingMonth", pageMap);
	 * System.out.println("조회결과 : " + list); return list; }
	 */
	

}
                                                                   
