package com.wt.app.careMyPage.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.wt.app.dto.CareModifyDTO;
import com.wt.app.dto.NormalModifyDTO;
import com.wt.config.MyBatisConfig;

public class CareModifyDAO {
	public SqlSession sqlSession;
	
	public CareModifyDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	//회원 이름 조회
	public String nameSelect(int usersNumber) {
		return sqlSession.selectOne("careModify.nameSelect", usersNumber);
	}
	//회원 주소 조회
	public String addressSelect(int usersNumber) {
		return sqlSession.selectOne("careModify.addressSelect", usersNumber);
	}
	//회원 전화번호 조회
	public String phoneSelect(int usersNumber) {
		return sqlSession.selectOne("careModify.phoneSelect", usersNumber);
	}
	//회원 아이디 조회
	public String idSelect(int usersNumber) {
		return sqlSession.selectOne("careModify.idSelect", usersNumber);
	}
	//회원 이메일 조회
	public String emailSelect(int usersNumber) {
		return sqlSession.selectOne("careModify.emailSelect", usersNumber);
	}
	//회원 비밀번호 조회
	public String passwordSelect(int usersNumber) {
		return sqlSession.selectOne("careModify.passwordSelect", usersNumber);
	}
	//회원 주소 수정
	public void addressUpdate(CareModifyDTO careModifyDTO) {
		sqlSession.update("careModify.addressUpdate", careModifyDTO);
	}
	//회원 전화번호 수정
	public void phoneUpdate(CareModifyDTO careModifyDTO) {
		sqlSession.update("careModify.phoneUpdate", careModifyDTO);
	}
	//회원 이메일 수정
	public void emailUpdate(CareModifyDTO careModifyDTO) {
		sqlSession.update("careModify.emailUpdate", careModifyDTO);
	}
	//회원 비밀번호 수정
	public void passwordUpdate(CareModifyDTO careModifyDTO) {
		sqlSession.update("careModify.passwordUpdate", careModifyDTO);
	}


	
	
}
