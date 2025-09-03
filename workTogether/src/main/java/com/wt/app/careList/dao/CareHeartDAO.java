package com.wt.app.careList.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.wt.app.dto.CareHeartDTO;
import com.wt.config.MyBatisConfig;

public class CareHeartDAO {
	public SqlSession sqlSession;

	public CareHeartDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
		
	// 하트 검사 
		public int selectHeartN (Map<String, Integer> numbers) {
			return sqlSession.selectOne("careList.showHeartN", numbers) != null ? sqlSession.selectOne("careList.showHeartN", numbers) : -1;
		}
		
		public int selectHeartC (Map<String, Integer> numbers) {
			return sqlSession.selectOne("careList.showHeartC", numbers) != null ? sqlSession.selectOne("careList.showHeartC", numbers) : -1;
		}
		
	// 하트 추가
		public void addHeart(CareHeartDTO dto) {
			sqlSession.insert("careList.addHeart", dto);
		}
		
	// 하트 취소
		public void delete(CareHeartDTO dto) {
			sqlSession.delete("careList.deleteHeart", dto);
		}
		
	
}
