package com.wt.app.careList.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.wt.app.dto.CareListDTO;
import com.wt.app.dto.MessageSRDTO;
import com.wt.config.MyBatisConfig;

public class CareListDAO {
	public SqlSession sqlSession;

	public CareListDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
//	전체 돌봄 회원 조회
	public List<CareListDTO> selectAll(Map<String, Integer> pageMap) {
		System.out.println("모든 돌봄 조회하기 - selectAll 메소드 실행 : " + pageMap);
		List<CareListDTO> list = sqlSession.selectList("careList.listExecptHeart", pageMap);
		System.out.println("조회결과 : " + list);
		return list;
	}
	
	// 돌봄 총 개수 가져오기
		public int getTotal() {
			System.out.println("돌봄 총 개수 조회 - getTotal 메소드 실행");
			// 페이지네이션을 위해 전체 돌봄 회원 수 총 조회
			return sqlSession.selectOne("careList.getTotal");
		}
		
	// 하트 검사 
		public int selectHeartN (Map<String, Integer> numbers) {
			return sqlSession.selectOne("careList.showHeartN", numbers) != null ? sqlSession.selectOne("careList.showHeartN", numbers) : -1;
		}
		
		public int selectHeartC (Map<String, Integer> numbers) {
			return sqlSession.selectOne("careList.showHeartC", numbers) != null ? sqlSession.selectOne("careList.showHeartC", numbers) : -1;
		}
		
	// 쪽지 보내기(첫 시도)
		public void sendMsg(MessageSRDTO messageSTDTO) {
			//insert로 쪽지 전송시 db에 저장
			sqlSession.insert("message.insert", messageSTDTO);
		}
	// 돌봄 세부 페이지
		public CareListDTO selectDetail(int usersCareNumber) {
			System.out.println("돌봄 상세 페이지 조회");
			// selectOne으로 가져온 db정보의 값 dto로 출력
			return sqlSession.selectOne("careList.detail", usersCareNumber);
		}
	
}
