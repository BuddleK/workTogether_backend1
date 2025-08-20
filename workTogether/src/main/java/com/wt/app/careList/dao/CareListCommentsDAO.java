package com.wt.app.careList.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.wt.app.dto.CareCommentsDTO;
import com.wt.app.dto.CareListDTO;
import com.wt.config.MyBatisConfig;

public class CareListCommentsDAO {
	public SqlSession sqlSession;

	public CareListCommentsDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	//후기 목록
	public List<CareCommentsDTO> selectAll (int careNumber) {
		System.out.println("모든 후기 조회하기 - selectAll 메소드 실행 : " );
		List<CareCommentsDTO> list = sqlSession.selectList("commentsList.commentsListAll", careNumber);
		System.out.println("조회결과 : " + list);
		return list;
	}
	
	//후기 전체 개수
	public int getTotal() {
		System.out.println("후기 총 개수 조회 - getTotal 메소드 실행");
		return sqlSession.selectOne("commentsList.commentsGetTotal");
	}
	
	//후기 추가
	public void addComment(int careNumber) {
		System.out.println("후기 추가 실행");
		sqlSession.insert("commentsList.commentsAdd", careNumber);
		System.out.println("후기 추가 완료");
	}
	
	//후기 수정
	public void updateComment(int careNumber) {
		System.out.println("후기 수정 실행");
		sqlSession.update("commentsList.updateComments", careNumber);
		System.out.println("후기 수정 완료");
	}
	
	//후기 삭제
	public void deleteComment(int careNumber) {
		System.out.println("후기 삭제 실행");
		sqlSession.delete("commentsList.commentDelete", careNumber);
		System.out.println("후기 삭제 완료");
	}
	
	
}
