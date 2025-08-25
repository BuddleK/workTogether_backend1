package com.wt.app.careMyPage.dao;

import org.apache.ibatis.session.SqlSession;

import com.wt.app.dto.CarePwCheckDTO;
import com.wt.config.MyBatisConfig;

public class CarePwCheckDAO {
	public SqlSession sqlSession;
	
	public CarePwCheckDAO(){
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	//비밀번호 일치 체크
	public boolean checkPw(int usersNumber, String usersPassword) {
		System.out.println("비번 일치 체크 - checkPw 메소드 실행");
		CarePwCheckDTO carePwCheckDTO = new CarePwCheckDTO();
		carePwCheckDTO.setUsersNumber(usersNumber);
		carePwCheckDTO.setUsersPassword(usersPassword);
		Integer result = sqlSession.selectOne("carePwCheck.checkPw", carePwCheckDTO);
		return result != null && result > 0;
	}
}
