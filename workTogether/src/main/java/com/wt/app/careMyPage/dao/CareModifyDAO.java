package com.wt.app.careMyPage.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.wt.app.dto.CareModifyDTO;
import com.wt.app.dto.CareProfileDTO;
import com.wt.app.dto.NormalModifyDTO;
import com.wt.config.MyBatisConfig;

public class CareModifyDAO {
	public SqlSession sqlSession;
	
	public CareModifyDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	//개인정보 CareModifyDTO 가져오기
	public CareModifyDTO getInfo(int usersNumber) {
		System.out.println("getInfo - 개인정보 상세 조회 메소드");
		return sqlSession.selectOne("careModify.getInfo", usersNumber);
	}
	
	//일치하는 이메일 있는지 확인 0 또는 1 반환
	/*
	 * public int checkEmail(String usersEmail) {
	 * System.out.println("checkEmail - 일치 이메일 count 메소드"); return
	 * sqlSession.selectOne("careModify.checkEmail", usersEmail); }
	 */
	// 주소 수정
	public void modAddress(CareModifyDTO careModifyDTO) {
		System.out.println("modAddress - 주소 수정 메소드");
		int result = sqlSession.update("careModify.modAddress", careModifyDTO);
		System.out.println("modAddress결과 : " + result);
	}
	// 전화번호 수정
	public void modPhone(CareModifyDTO careModifyDTO) {
		System.out.println("modPhone - 전화번호 수정 메소드");
		int result = sqlSession.update("careModify.modPhone", careModifyDTO);
		System.out.println("modPhone결과 : " + result);
	}
	// 이메일 수정
	/* public void modEmail(CareModifyDTO careModifyDTO) {
	 * System.out.println("modEmail - 이메일 수정 메소드"); int result =
	 * sqlSession.update("careModify.modEmail", careModifyDTO);
	 * System.out.println("modEmail결과 : " + result); }
	 */
	// 비밀번호 수정
	public void modPassword(CareModifyDTO careModifyDTO) {
		System.out.println("modPassword - 비밀번호 수정 메소드");
		int result = sqlSession.update("careModify.modPassword", careModifyDTO);
		System.out.println("modPassword결과 : " + result);
	}
	
	
	
	
	
	
	
	
	
	
	//회원 이름 조회
	public String nameSelect(int usersNumber) {
		return sqlSession.selectOne("careModify.nameSelect", usersNumber);
	}
	
	//우편 번호 조회
	public String postarSelect(int usersNumber) {
		return sqlSession.selectOne("careModify.postarSelect", usersNumber);
	}
	
	//회원 주소 조회
	public String address1Select(int usersNumber) {
		return sqlSession.selectOne("careModify.address1Select", usersNumber);
	}
	//회원 주소 조회
		public String address2Select(int usersNumber) {
			return sqlSession.selectOne("careModify.address2Select", usersNumber);
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
