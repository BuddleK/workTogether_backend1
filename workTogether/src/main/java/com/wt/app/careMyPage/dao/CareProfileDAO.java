package com.wt.app.careMyPage.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.wt.app.dto.CareProfilePictureDTO;
import com.wt.app.dto.CareProfileDTO;
import com.wt.config.MyBatisConfig;

public class CareProfileDAO {
	public SqlSession sqlSession;

	public CareProfileDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
//	프로필 사진 가져오기
	public CareProfilePictureDTO getProPic(int usersNumber) {
		System.out.println("getProIc - 프로필 사진 가져오는 메소드");
		return sqlSession.selectOne("careProfile.getProPic", usersNumber);
	}
	
//	프로필 정보 가져오기
	public CareProfileDTO getProfile(int usersNumber) {
		System.out.println("getProfile - 프로필 상세 조회 메소드");
		return sqlSession.selectOne("careProfile.getProfile", usersNumber);
	}
	
//	로그인한 회원의 요일정보가 존재하는지 확인 0-없음, 1-있음
	public boolean checkDay(int usersNumber) {
		System.out.println("checkDay - 요일 정보 유무 확인 메소드");
		return (Integer)sqlSession.selectOne("careProfile.checkDay", usersNumber) == 0 ? true : false;
	}
	
//	요일 정보 INSERT
	public void insertDay(CareProfileDTO careProfileDTO) {
		System.out.println("insertDay - 요일 insert 메소드");
		int result = sqlSession.insert("careProfile.insertDay", careProfileDTO);
		System.out.println("insertDay결과 : " + result);
	}
	
//	요일 정보 UPDATE
	public void updateDay(CareProfileDTO careProfileDTO) {
		System.out.println("updateDay - 요일 update 메소드");
		int result = sqlSession.update("careProfile.updateDay", careProfileDTO);
		System.out.println("updateDay결과 : " + result);
	}
	
//	주소 정보 UPDATE
	public void updateAddr(CareProfileDTO careProfileDTO) {
		System.out.println("updateAddr - 주소 update 메소드");
		int result = sqlSession.update("careProfile.updateAddr", careProfileDTO);
		System.out.println("updateDay결과 : " + result);
	}
	
//	프로필 사진 정보 UPDATE
	public void updateProPic(CareProfileDTO careProfileDTO) {
		System.out.println("updateProPic - 프로필 사진 update 메소드");
		int result = sqlSession.update("careProfile.updateProPic", careProfileDTO);
		System.out.println("updateDay결과 : " + result);
	}
	
//	소개글 UPDATE
	public void updateIntro(CareProfileDTO careProfileDTO) {
		System.out.println("updateIntro - 소개글 update 메소드");
		int result = sqlSession.update("careProfile.updateIntro", careProfileDTO);
		System.out.println("updateDay결과 : " + result);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public CareProfileDTO profileSelect(int careNumber) {
	      System.out.println("프로필 사진 조회");
	      return sqlSession.selectOne("careProfile.profileSelect", careNumber);
	   }
	public CareProfileDTO profileDelete(int profilesFileNumber) {
		System.out.println("프로필 사진 삭제");
		return sqlSession.selectOne("careProfile.profileDelete", profilesFileNumber);
	}
	public CareProfileDTO profileInsert(int profilesFilesNumber, String profilesFilesType, String profilesFilesName,
			String profilesFilesPath, int profilesFilesSizeBytes, String profilesCreatedDate) {
		System.out.println("프로필 사진 추가");
		Map<String, Object> profile = new HashMap<>();
	    profile.put("profilesFilesNumber", profilesFilesNumber);
	    profile.put("profilesFilesType", profilesFilesType);
	    profile.put("profilesFilesName", profilesFilesName);
	    profile.put("profilesFilesPath", profilesFilesPath);
	    profile.put("profilesFilesSizeBytes", profilesFilesSizeBytes);
	    profile.put("profilesCreatedDate", profilesCreatedDate);
		return sqlSession.selectOne("careProfile.profileInsert", profile);
	}
	public CareProfileDTO daySelect(int careNumber) {
		System.out.println("프로필 요일 조회");
		return sqlSession.selectOne("careProfile.daySelect", careNumber);
	}
	public CareProfileDTO addressSelect(int usersNumber) {
		System.out.println("프로필 주소 조회");
		return sqlSession.selectOne("careProfile.addressSelect", usersNumber);
	}
	public CareProfileDTO introSelect(int usersNumber) {
		System.out.println("프로필 소개글 조회");
		return sqlSession.selectOne("careProfile.introSelect", usersNumber);
	}
	
	public CareProfileDTO dayUpdate(String dayMonday,String dayTuesday,String dayWednesday,String dayThursday,
			String dayFriday,String daySaturday,String daySunday,int usersNumber) {
		System.out.println("프로필 요일 수정");
		Map<String, Object> day = new HashMap<>();
		day.put("dayMonday", dayMonday);
		day.put("dayTuesday", dayTuesday);
		day.put("dayWednesday", dayWednesday);
		day.put("dayThursday", dayThursday);
		day.put("dayFriday", dayFriday);
		day.put("daySaturday", daySaturday);
		day.put("daySunday", daySunday);
		day.put("careNumber", usersNumber);
		return sqlSession.selectOne("careProfile.dayUpdate", day);
	}
	
	//프로필 자격증, 계좌 수정 삭제,추가?
	
	
	
	/*
	 * public CareProfileDTO addressUpdate(String usersPostsalCode,String
	 * usersPostsalCode,String usersPostsalCode, int usersNumber) {
	 * System.out.println("프로필 주소 수정"); Map<String, Object> address = new
	 * HashMap<>(); address.put("usersPostsalCode", usersPostsalCode);
	 * address.put("usersPostsalCode", usersPostsalCode);
	 * address.put("usersPostsalCode", usersPostsalCode); address.put("usersNumber",
	 * usersNumber); return sqlSession.selectOne("careProfile.addressUpdate",
	 * address); }
	 */
	public CareProfileDTO introUpdate(String careIntroText, int careNumber) {
		System.out.println("프로필 소개글 수정");
		Map<String, Object> intro = new HashMap<>();
		intro.put("careIntroText", careIntroText);
		intro.put("careNumber", careNumber);
		return sqlSession.selectOne("careProfile.addressUpdate", intro);
	}
	
	
	
	
	
	
	
}
