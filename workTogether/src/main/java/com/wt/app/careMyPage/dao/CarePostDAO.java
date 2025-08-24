package com.wt.app.careMyPage.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.wt.app.dto.CarePostDTO;
import com.wt.config.MyBatisConfig;

public class CarePostDAO {
	public SqlSession sqlSession;
	
	public CarePostDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	//게시글 전체 조회
	public List<CarePostDTO> postAll(Map<String, Integer> pageMap){
		List<CarePostDTO> list = sqlSession.selectList("carePost.postAll", pageMap);
		System.out.println("조회결과 : " + list);
		return list;
	}
	//게시글 개수 가져오기
	public int postTotal() {
		System.out.println("게시글 총 개수 조회 - postTotal 메소드 실행");
		return sqlSession.selectOne("carePost.postTotal");
	}
	//게시글 삭제하기
	public void postDelete(CarePostDTO carePostDTO) {
		System.out.println("게시글 삭제하기 - postDelete 메소드 실행" + carePostDTO);
		sqlSession.delete("carePost.postDelete", carePostDTO);
		System.out.println("게시글 삭제하기 실행 완료");
	}
	
}
