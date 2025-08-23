package com.wt.app.admin.dao;

import org.apache.ibatis.session.SqlSession;

import com.wt.app.dto.AdminFileDownloadDTO;
import com.wt.config.MyBatisConfig;

public class AdminFileDAO {
	public SqlSession sqlSession;

	public AdminFileDAO() {
		// 오토커밋(true)
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}

	// 자격증 파일 다운로드 정보 조회
	public AdminFileDownloadDTO downloadLicense(int fileNumber) {
		System.out.println("자격증 파일 다운로드 조회 - downloadLicense 실행: fileNumber=" + fileNumber);
		AdminFileDownloadDTO dto = sqlSession.selectOne("adminFile.downloadLicense", fileNumber);
		System.out.println("조회 결과: " + dto);
		return dto;
	}

	// 통장 사본 파일 다운로드 정보 조회
	public AdminFileDownloadDTO downloadAccount(int fileNumber) {
		System.out.println("통장 사본 파일 다운로드 조회 - downloadAccount 실행: fileNumber=" + fileNumber);
		AdminFileDownloadDTO dto = sqlSession.selectOne("adminFile.downloadAccount", fileNumber);
		System.out.println("조회 결과: " + dto);
		return dto;
	}
}