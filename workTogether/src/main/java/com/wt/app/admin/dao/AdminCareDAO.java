package com.wt.app.admin.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.wt.app.dto.AdminCareFileDTO;
import com.wt.app.dto.AdminCareSignupDTO;
import com.wt.config.MyBatisConfig;

public class AdminCareDAO {
	public SqlSession sqlSession;

	public AdminCareDAO() {
		// 오토커밋(true)
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}

	// 가입신청 대기 목록(페이징)
	public List<AdminCareSignupDTO> pendingListPaged(Map<String, Integer> pageMap) {
		System.out.println("가입신청 대기 목록(페이징) - pendingListPaged 실행: " + pageMap);
		List<AdminCareSignupDTO> list = sqlSession.selectList("adminCare.pendingListPaged", pageMap);
		System.out.println("조회 결과: " + list);
		return list;
	}

	// 가입신청 대기 총 개수
	public int pendingCount() {
		System.out.println("가입신청 대기 총 개수 - pendingCount 실행");
		int total = sqlSession.selectOne("adminCare.pendingCount");
		System.out.println("총 개수: " + total);
		return total;
	}

	// 가입신청 단건 조회
	public AdminCareSignupDTO signupOne(int usersNumber) {
		System.out.println("가입신청 단건 조회 - signupOne 실행: usersNumber=" + usersNumber);
		AdminCareSignupDTO dto = sqlSession.selectOne("adminCare.signupOne", usersNumber);
		System.out.println("조회 결과: " + dto);
		return dto;
	}

	// 가입 승인
	public int approve(int usersNumber) {
		System.out.println("가입 승인 - approve 실행: usersNumber=" + usersNumber);
		int result = sqlSession.update("adminCare.approve", usersNumber);
		System.out.println("승인 결과: " + result);
		return result;
	}

	// 가입 반려(케어만 삭제)
	public int rejectCare(int usersNumber) {
		System.out.println("가입 반려(케어만 삭제) - rejectCare 실행: usersNumber=" + usersNumber);
		int result = sqlSession.delete("adminCare.rejectCare", usersNumber);
		System.out.println("삭제 결과: " + result);
		return result;
	}

	// 가입 반려(유저까지 삭제)
	public int rejectAll(int usersNumber) {
		System.out.println("가입 반려(유저까지 삭제) - rejectAll 실행: usersNumber=" + usersNumber);
		int result = sqlSession.delete("adminCare.rejectAll", usersNumber);
		System.out.println("삭제 결과: " + result);
		return result;
	}

	// 자격증 조회
	public AdminCareFileDTO fileLicense(int fileNumber) {
		System.out.println("자격증 파일 조회 - fileLicense 실행: fileNumber=" + fileNumber);
		AdminCareFileDTO dto = sqlSession.selectOne("adminCare.fileLicense", fileNumber);
		System.out.println("조회 결과: " + dto);
		return dto;
	}

	// 통장 사본 조회
	public AdminCareFileDTO fileAccount(int fileNumber) {
		System.out.println("통장 사본 파일 조회 - fileAccount 실행: fileNumber=" + fileNumber);
		AdminCareFileDTO dto = sqlSession.selectOne("adminCare.fileAccount", fileNumber);
		System.out.println("조회 결과: " + dto);
		return dto;
	}

	// 프로필 조회
	public AdminCareFileDTO fileProfile(int fileNumber) {
		System.out.println("프로필 파일 메타 조회 - fileProfile 실행: fileNumber=" + fileNumber);
		AdminCareFileDTO dto = sqlSession.selectOne("adminCare.fileProfile", fileNumber);
		System.out.println("조회 결과: " + dto);
		return dto;
	}
}