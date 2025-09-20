package com.wt.app.careMyPage.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.wt.app.dto.CareMarkDTO;
import com.wt.config.MyBatisConfig;

public class CareMarkDAO {
	public SqlSession sqlSession;
	
	public CareMarkDAO(){
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	//찜 목록 전체 조회
	public List<CareMarkDTO> getMarks(Map<String, Integer> pageMap) {
		System.out.println("찜 목록 전체 조회 - getMarks 메소드 실행 : " + pageMap);
		List<CareMarkDTO> list = sqlSession.selectList("careMark.getMarks", pageMap);
		System.out.println("조회결과 : " + list);
		return list;
	}
	
	//찜 삭제 메소드
	public void delMark(int favoritesNumber) {
		System.out.println("찜 삭제 실행 - delMark : " + favoritesNumber);
		sqlSession.delete("careMark.delMark", favoritesNumber);
		System.out.println("찜 삭제 쿼리 실행 완료");
	}
	
	
	
	//찜 목록 전체 조회
	public List<CareMarkDTO> markAll(Map<String, Integer> pageMap) {
		System.out.println("찜 목록 전체 조회 - markAll 메소드 실행 : " + pageMap);
		List<CareMarkDTO> list = sqlSession.selectList("careMark.markAll", pageMap);
		System.out.println("조회결과 : " + list);
		return list;
	}
	
	//찜 목록 개수
	public int markTotal(int usersNumber) {
		System.out.println("찜 개수 조회 - markTotal 메소드 실행");
		return sqlSession.selectOne("careMark.markTotal", usersNumber);
	}
	
	//찜 목록 삭제
	public void markDelete() {
		sqlSession.delete("careMark.markDelete");
	}
}
