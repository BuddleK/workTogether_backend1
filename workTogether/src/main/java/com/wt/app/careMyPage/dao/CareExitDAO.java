package com.wt.app.careMyPage.dao;

import org.apache.ibatis.session.SqlSession;

import com.wt.config.MyBatisConfig;

public class CareExitDAO {
	public SqlSession sqlSession;
	
	public CareExitDAO(){
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	//돌봄 연관  삭제
	public void delCareProExit(int usersNumber) {
		System.out.println("돌봄 연관 정보 삭제하기 - delCareProExit 메소드 실행 : " + usersNumber);
		sqlSession.delete("careExit.delCareProExit", usersNumber);
	}
	
	//회원 삭제
	public void delCareExit(int usersNumber) {
		System.out.println("회원 삭제하기 - delCareExit 메소드 실행 : "+ usersNumber);
		sqlSession.delete("careExit.delCareExit", usersNumber);
	}
	
	//S 상태에 있는 매칭 수 조회
	public int countReserve(int usersNumber) {
		System.out.println("S 상태에 있는 매칭 수 조회 - countReserve 메소드 실행" + usersNumber);
		return sqlSession.selectOne("careExit.countReserve", usersNumber);
	}
	
	
	
}
