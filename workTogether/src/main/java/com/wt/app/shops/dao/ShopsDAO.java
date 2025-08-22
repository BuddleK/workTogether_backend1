package com.wt.app.shops.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.wt.app.dto.ShopsListDTO;
import com.wt.config.MyBatisConfig;

public class ShopsDAO {
	public SqlSession sqlSession;

	public ShopsDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	// 모든 가게 리스트 가져오기
		public List<ShopsListDTO> shopSelectAll(Map<String, Integer> pgMap) {
			System.out.println("모든 가게 조회하기 - selectAll 메소드 실행 : " );
			List<ShopsListDTO> list = sqlSession.selectList("shops.listAll", pgMap);
			System.out.println("조회결과 : " + list);
			return list;
		}
		
	// 총 가게 수
		public int getTotal() {
			System.out.println("가게 총 개수 조회 - getTotal 메소드 실행");
			return sqlSession.selectOne("shops.getTotal");
		}
}
