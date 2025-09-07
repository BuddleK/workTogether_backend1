package com.wt.app.careMyPage.dao;

import org.apache.ibatis.session.SqlSession;

import com.wt.app.dto.CarePWCheckDTO;
import com.wt.config.MyBatisConfig;

public class CarePwCheckDAO {
	public SqlSession sqlSession;
	
	public CarePwCheckDAO(){
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	//비밀번호 일치 체크
	public boolean checkPw(int usersNumber, String usersPassword) {
		System.out.println("비번 일치 체크 - checkPw 메소드 실행");
		CarePWCheckDTO carePwCheckDTO = new CarePWCheckDTO();
		carePwCheckDTO.setUsersNumber(usersNumber);
		carePwCheckDTO.setUsersPassword(usersPassword);
		int count = sqlSession.selectOne("carePwCheck.checkPw", carePwCheckDTO);
		System.out.println("비번 체크 count : " + count);
		return count > 0? true:false;
	}
}
