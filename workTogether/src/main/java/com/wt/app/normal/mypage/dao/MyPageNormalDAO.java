package com.wt.app.normal.mypage.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.wt.app.dto.NormalModifyDTO;
import com.wt.config.MyBatisConfig;

public class MyPageNormalDAO {
	public SqlSession sqlSession;

	public MyPageNormalDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}

	public boolean checkPw(String usersPassword) {
		return (Integer) sqlSession.selectOne("myPageNormal.checkPw", usersPassword) < 1;
	}

	public List<NormalModifyDTO> normalSearch(String usersId) {
		System.out.println("모든 게시글 조회하기 - normalSearch 메소드 실행" + usersId);
		List<NormalModifyDTO> list = sqlSession.selectList("myPageNormal.normalSearch", usersId);
		System.out.println("조회결과 : " + list);
		return list;
	}
	
	public void normalModify(NormalModifyDTO normalModifyDTO){
		System.out.println("게시글 수정 - normalModify 메소드 실행"+ normalModifyDTO);
		int result = sqlSession.update("myPageNormal.normalModify", normalModifyDTO);
		System.out.println("업데이트 결과 : " + result);
	}
	
	

}
