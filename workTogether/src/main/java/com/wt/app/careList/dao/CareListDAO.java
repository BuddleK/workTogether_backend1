package com.wt.app.careList.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.wt.app.dto.CareListDTO;
import com.wt.config.MyBatisConfig;

public class CareListDAO {
	public SqlSession sqlSession;

	public CareListDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
//	전체 돌봄 회원 조회
	public List<CareListDTO> selectAll(Map<String, Integer> pageMap) {
		System.out.println("모든 돌봄 조회하기 - selectAll 메소드 실행 : " + pageMap);
		List<CareListDTO> list = sqlSession.selectList("careList.listAll", pageMap);
		System.out.println("조회결과 : " + list);
		return list;
	}
	
	// 돌봄 총 개수 가져오기
		public int getTotal() {
			System.out.println("돌봄 총 개수 조회 - getTotal 메소드 실행");
			return sqlSession.selectOne("careList.getTotal");
		}
		
	//	하트 추가
		public void addHeart() {
			sqlSession.insert("careList.addHeart");
		}
		
	// 하트 삭제
		public void deleteHeart( ) {
			sqlSession.delete("careList.deleteHeart");
		}
	
}
