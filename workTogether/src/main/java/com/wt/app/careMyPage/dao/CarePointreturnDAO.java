package com.wt.app.careMyPage.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.wt.config.MyBatisConfig;

public class CarePointreturnDAO {
	public SqlSession sqlSession;
	
	public CarePointreturnDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	//포인트 조회!
	public int getPoint(int usersNumber) {
		System.out.println("개인 포인트 조회 - getPoint 메소드 싱행 : " + usersNumber);
		int result = sqlSession.selectOne("carePointreturn.getPoint", usersNumber);
		return result;
	}
	
	//계좌번호 조회
	public String getPassbook(int usersNumber) {
		System.out.println("개인 계좌 조회 - getPassbook 메소드 싱행 : " + usersNumber);
		String result = sqlSession.selectOne("carePointreturn.getPassbook", usersNumber);
		return result;
	}
	
//	포인트 업데이트 메소드(포인트 차감)
	public void updatePoint(Map<String, Integer> updatePointMap) {
		System.out.println("포인트 업데이트 메소드(포인트 차감) - updatePoint 메소드 실행 ");
		int result = sqlSession.update("carePointreturn.updatePoint", updatePointMap);
		System.out.println("포인트 업데이트 결과 : " + result);
	}
	
//	환급 신청 레코드 생성
	public void insertRefund(Map<String, Object> insertRefundMap) {
		System.out.println("환급 신청 레코드 생성 - insertRefund 메소드 실행 ");
		int result = sqlSession.update("carePointreturn.insertRefund", insertRefundMap);
		System.out.println("환급 신청 생성 결과 : " + result);
	}
}
