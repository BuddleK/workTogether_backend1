package com.wt.app.careMyPage.dao;

import org.apache.ibatis.session.SqlSession;

import com.wt.app.dto.CareReferenceDPDTO;
import com.wt.config.MyBatisConfig;

public class CareReferenceDPDAO {

	public SqlSession sqlSession;

	public CareReferenceDPDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	//매칭 추가
		public void referenceInsert(CareReferenceDPDTO careReferenceDPDTO){
			System.out.println("문의 추가 메소드 - referenceInsert 메소드 실행 ");
			sqlSession.insert("careReferenceDP.referenceInsert", careReferenceDPDTO);
		}
}
