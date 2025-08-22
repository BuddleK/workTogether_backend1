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

	public List<NormalModifyDTO> normalSearch() {
		System.out.println("모든 게시글 조회하기 - normalSearch 메소드 실행");
		List<NormalModifyDTO> list = sqlSession.selectList(null);
		System.out.println("조회결과 : " + list);
		return list;
	}

}
