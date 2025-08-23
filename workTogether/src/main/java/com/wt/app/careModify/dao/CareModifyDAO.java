package com.wt.app.careModify.dao;

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
	public List<CareModifyDTO> nameSelect(Map<String, Integer> pageMap){
		List<CareModifyDTO> list = sqlSession.selectList("careModify.nameSelect", pageMap);
		System.out.println("조회결과 : " + list);
		return list;
	}
	//회원 주소 조회
	public List<CareModifyDTO> addressSelect(Map<String, Integer> pageMap){
		List<CareModifyDTO> list = sqlSession.selectList("careModify.addressSelect", pageMap);
		System.out.println("조회결과 : " + list);
		return list;
	}
	//회원 전화번호 조회
	public List<CareModifyDTO> phoneSelect(Map<String, Integer> pageMap){
		List<CareModifyDTO> list = sqlSession.selectList("careModify.phoneSelect", pageMap);
		System.out.println("조회결과 : " + list);
		return list;
	}
	//회원 아이디 조회
	public List<CareModifyDTO> idSelect(Map<String, Integer> pageMap){
		List<CareModifyDTO> list = sqlSession.selectList("careModify.idSelect", pageMap);
		System.out.println("조회결과 : " + list);
		return list;
	}
	//회원 이메일 조회
	public List<CareModifyDTO> emailSelect(Map<String, Integer> pageMap){
		List<CareModifyDTO> list = sqlSession.selectList("careModify.emailSelect", pageMap);
		System.out.println("조회결과 : " + list);
		return list;
	}
	//회원 비밀번호 조회
	public List<CareModifyDTO> passwordSelect(Map<String, Integer> pageMap){
		List<CareModifyDTO> list = sqlSession.selectList("careModify.passwordSelect", pageMap);
		System.out.println("조회결과 : " + list);
		return list;
	}
	//회원 주소 수정
	public void addressUpdate(CareModifyDTO CareModifyDTO) {
		System.out.println("주소 정보 수정 - addressUpdate 메소드 실행" + CareModifyDTO);
		int result = sqlSession.update("careModify.addressUpdate", CareModifyDTO);
		System.out.println("업데이트 결과 : " + result);
	}
	//회원 전화번호 수정
	public void phoneUpdate(CareModifyDTO CareModifyDTO) {
		System.out.println("전화번호 정보 수정 - phoneUpdate 메소드 실행" + CareModifyDTO);
		int result = sqlSession.update("careModify.addressUpdate", CareModifyDTO);
		System.out.println("업데이트 결과 : " + result);
	}
	//회원 이메일 수정
	public void emailUpdate(CareModifyDTO CareModifyDTO) {
		System.out.println("이메일 정보 수정 - emailUpdate 메소드 실행" + CareModifyDTO);
		int result = sqlSession.update("careModify.addressUpdate", CareModifyDTO);
		System.out.println("업데이트 결과 : " + result);
	}
	//회원 비밀번호 수정
	public void passwordUpdate(CareModifyDTO CareModifyDTO) {
		System.out.println("비밀번호 정보 수정 - passwordUpdate 메소드 실행" + CareModifyDTO);
		int result = sqlSession.update("careModify.addressUpdate", CareModifyDTO);
		System.out.println("업데이트 결과 : " + result);
	}


	
	
}
