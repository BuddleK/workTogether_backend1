package com.wt.app.admin.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.wt.app.dto.AccountModifyDTO;
import com.wt.app.dto.AdminCareFileDTO;
import com.wt.app.dto.AdminCareSignupDTO;
import com.wt.app.dto.AdminFileDownloadDTO;
import com.wt.app.dto.AdminLoginDTO;
import com.wt.app.dto.AdminNewsBoardDTO;
import com.wt.app.dto.AdminNewsBoardListDTO;
import com.wt.app.dto.FileNoticeDTO;
import com.wt.app.dto.FilesLicenseDTO;
import com.wt.app.dto.LicenseModifyDTO;
import com.wt.config.MyBatisConfig;

public class AdminDAO {

	private final SqlSession sqlSession;

	public AdminDAO() {
        sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
    }
//		로그인
    public Integer login(AdminLoginDTO dto) {
        return sqlSession.selectOne("admin.login", dto);
    }
    public String getAdminName(int adminNumber) {
        return sqlSession.selectOne("admin.getAdminName", adminNumber);
    }

	/* ======================= [Care] ======================= */

	public List<AdminCareSignupDTO> pendingListPaged(Map<String, Integer> pageMap) {
		return sqlSession.selectList("admin.carePendingListPaged", pageMap);
	}

	public int carePendingCount() {
		return sqlSession.selectOne("admin.carePendingCount");
	}

	public AdminCareSignupDTO careSignupOne(int usersNumber) {
		return sqlSession.selectOne("admin.careSignupOne", usersNumber);
	}

	public int careApprove(int usersNumber) {
		return sqlSession.update("admin.careApprove", usersNumber);
	}

	public int careReject(int usersNumber) {
		return sqlSession.delete("admin.careReject", usersNumber);
	}

	public int careRejectAll(int usersNumber) {
		return sqlSession.delete("admin.careRejectAll", usersNumber);
	}

	// 파일 조회
	public AdminCareFileDTO careFileLicense(int licenseFilesNumber) {
		return sqlSession.selectOne("admin.careFileLicense", licenseFilesNumber);
	}

	public AdminCareFileDTO careFileAccount(int accountFilesNumber) {
		return sqlSession.selectOne("admin.careFileAccount", accountFilesNumber);
	}

	public AdminCareFileDTO careFileProfile(int profilesFilesNumber) {
		return sqlSession.selectOne("admin.careFileProfile", profilesFilesNumber);
	}

	// (선택) 자격증 파일 INSERT - 현재 매퍼는 seq_files.NEXTVAL 직접 사용(키 반환 없음)
	public void insertLicenseFile(FilesLicenseDTO dto) {
		sqlSession.insert("admin.careInsertLicenseFile", dto);
	}

	/* ======================= [파일 다운로드 공용] ======================= */

	public AdminFileDownloadDTO downloadLicense(int licenseFilesNumber) {
		return sqlSession.selectOne("admin.fileDownloadLicense", licenseFilesNumber);
	}

	public AdminFileDownloadDTO downloadAccount(int accountFilesNumber) {
		return sqlSession.selectOne("admin.fileDownloadAccount", accountFilesNumber);
	}

	/* ===== [News 연동 파일(tbl_files_notice)] ===== */

	/** 파일 INSERT (mapper selectKey로 PK 주입됨) → 생성된 notice_files_number 반환 */
	public int insertNoticeFile(FilesLicenseDTO dto) {
		sqlSession.insert("admin.fileNoticeInsert", dto);
		return dto.getLicenseFilesNumber(); // PK 반환
	}

	public FileNoticeDTO selectNoticeFileByNews(int newsNumber) {
		return sqlSession.selectOne("admin.fileNoticeSelect", newsNumber);
	}

	public int deleteNoticeFileByNews(int newsNumber) {
		return sqlSession.delete("admin.fileNoticeDelete", newsNumber);
	}

	public Integer getNoticeFilesNumberByNews(int newsNumber) {
		return sqlSession.selectOne("admin.fileNoticeGetNoticeFilesNumber", newsNumber);
	}

	/** 뉴스 테이블에 files_number 연결/변경 */
	public int updateNewsFileRef(int newsNumber, int filesNumber) {
		Map<String, Object> param = new HashMap<>();
		param.put("newsNumber", newsNumber);
		param.put("filesNumber", filesNumber);
		return sqlSession.update("admin.newsUpdateFilesNumber", param);
	}

	/* ======================= [News] ======================= */
	// 뉴스 목룍 조회
	public List<AdminNewsBoardListDTO> selectAll(Map<String, Integer> pageMap) {
		System.out.println("모든 뉴스 조회하기 - selectAll로 : " + pageMap);
		List<AdminNewsBoardListDTO> list = sqlSession.selectList("admin.newSelect", pageMap);
		System.out.println("뉴스 조회 결과 : " + list);
		return list;
	}
	
	//뉴스 총 갯수
	public int getNewsTotal() {
		System.out.println("게시글 총 개수 조회 - getNewsTotal 메소드 실행");
		return sqlSession.selectOne("admin.newsGetTotal");
	}
	
	//뉴스 추가 후 자동으로 생성된 뉴스 번호 반환 파일 테이블에서도 사용 예 
	public int insertNews(AdminNewsBoardDTO newsDTO) {
		int insert = sqlSession.insert("admin.newsInsert", newsDTO);
		return newsDTO.getNewsNumber();
	}
	
	// 뉴스 수정
	public void updateNews(AdminNewsBoardDTO newsDTO) {
		int result = sqlSession.update("admin.newsUpdate", newsDTO);
	}
	
	//뉴스 상세조회 단건
	public AdminNewsBoardDTO select(int newsNumber) {
		System.out.println("뉴스 상세 페이지 조회(단건조회)");
	    return sqlSession.selectOne("admin.newsSelectOne", newsNumber);
	}
	
	//뉴스 삭제
	public int deleteNews(int newsNumber) {
		System.out.println("뉴스 삭제 - deleteNews 메소드 실행. 삭제할 뉴스 번호: " + newsNumber);
		int deleteResult = sqlSession.delete("admin.newsDelete", newsNumber);
		return deleteResult;
	}
	
	//뉴스 파일번호 연결하기
	public void updateNewsFilesNumber(Map<String, Object> params) {
		System.out.println("뉴스 파일 번호 업데이트 - updateNewsFilesNumber 메소드 실행. 파라미터: " + params);
		int result = sqlSession.update("admin.newsUpdateFilesNumber", params);
		
	}
	
	//파일 등록
	public int insertFileNotice(FileNoticeDTO fileDTO) {
		System.out.println("뉴스 관련 파일 추가 - insertFileNotice 메소드 실행: " + fileDTO);
		int insertResult = sqlSession.insert("admin.fileNoticeInsert", fileDTO);
		return fileDTO.getNoticeFilesNumber();
	}
	
	public FileNoticeDTO selectFileNotice(int newsNumber) {
		System.out.println("뉴스에 연결된 파일 조회 - selectFileNotice 메소드 실행. 뉴스 번호: " + newsNumber);
		FileNoticeDTO fileDetail = sqlSession.selectOne("admin.fileNoticeSelect", newsNumber);
		if (fileDetail != null) {
			System.out.println("뉴스 파일 조회 결과: " + fileDetail.getNoticeFilesName());
		} else {
			System.out.println(newsNumber + "번 뉴스에 연결된 파일 정보를 찾을 수 없습니다.");
		}
		return fileDetail;
	}

	//파일 삭제 (뉴스번호 기준)
	public void deleteFileNotice(int newsNumber) {
		System.out.println("뉴스에 연결된 파일 삭제 - deleteFileNotice 메소드 실행. 뉴스 번호: " + newsNumber);
		int deleteResult = sqlSession.delete("admin.fileNoticeDelete", newsNumber);
		System.out.println("뉴스 파일 삭제 결과: " + deleteResult + " (1이면 성공)");
	}

	//뉴스 번호로 연결된 파일 번호 조회
	public int getNoticeFilesNumberByNewsNumber(int newsNumber) {
		System.out.println("뉴스 번호로 파일 번호 조회 - getNoticeFilesNumberByNewsNumber 메소드 실행. 뉴스 번호: " + newsNumber);
		Integer filesNumber = sqlSession.selectOne("admin.fileNoticeGetNoticeFilesNumber", newsNumber);
		if (filesNumber != null) {
			System.out.println(newsNumber + "번 뉴스에 연결된 파일 번호: " + filesNumber);
		} else {
			System.out.println(newsNumber + "번 뉴스에 연결된 파일이 없거나 찾을 수 없습니다.");
		}
		return (filesNumber != null) ? filesNumber : 0; // 파일이 없을 경우 0 반환 (혹은 예외 처리)
	}

/*	public List<AdminNewsBoardListDTO> newsSelectAll(int startRow, int endRow) {
		Map<String, Object> param = new HashMap<>();
		param.put("startRow", startRow);
		param.put("endRow", endRow);
		return sqlSession.selectList("admin.newsSelectAll", param);
	}

	public int newsGetTotal() {
		return sqlSession.selectOne("admin.newsGetTotal");
	}

	*//** 등록 시 mapper의 selectKey로 newsNumber가 dto에 세팅됩니다. *//*
	public void newsInsert(AdminNewsBoardDTO dto) {
		sqlSession.insert("admin.newsInsert", dto);
	}

	public int newsUpdate(AdminNewsBoardDTO dto) {
		return sqlSession.update("admin.newsUpdate", dto);
	}

	public AdminNewsBoardDTO newsSelectOne(int newsNumber) {
		return sqlSession.selectOne("admin.newsSelectOne", newsNumber);
	}

	public int newsDelete(int newsNumber) {
		return sqlSession.delete("admin.newsDelete", newsNumber);
	}

	public int insertNews(AdminNewsBoardDTO dto) {
		sqlSession.insert("admin.newsInsert", dto);
		return dto.getNewsNumber();
	}*/

	/* ============ [Care 이력수정: 자격증/통장사본] ============ */
	/* 자격증 이력 INSERT → 생성된 license_modify_number 반환 */
	public int licenseModifyInsert(LicenseModifyDTO dto) {
		sqlSession.insert("admin.licenseModifyInsert", dto);
		return dto.getLicenseModifyNumber();
	}

	/* 통장사본 이력 INSERT → 생성된 account_modify_number 반환 */
	public int accountModifyInsert(AccountModifyDTO dto) {
		sqlSession.insert("admin.accountModifyInsert", dto);
		return dto.getAccountModifyNumber();
	}

	/* 특정 회원의 최신 자격증 이력 1건 */
	public LicenseModifyDTO licenseModifyLatestByUser(int usersNumber) {
		return sqlSession.selectOne("admin.licenseModifyLatestByUser", usersNumber);
	}

	/* 특정 회원의 최신 통장사본 이력 1건 */
	public AccountModifyDTO accountModifyLatestByUser(int usersNumber) {
		return sqlSession.selectOne("admin.accountModifyLatestByUser", usersNumber);
	}

	/** 자격증 이력 적용: care_users 갱신 + 최신 PENDING 1건 APPLIED */
	public int careerApplyLicense(int usersNumber) {
		int u1 = sqlSession.update("admin.careerApplyLicense_UpdateCareUsers", usersNumber);
		int u2 = sqlSession.update("admin.careerApplyLicense_MarkApplied", usersNumber);
		return (u1 > 0 && u2 > 0) ? 1 : 0;
	}

	/** 자격증 이력 잔여 PENDING → CLEARED */
	public int careerClearLicense(int usersNumber) {
		return sqlSession.update("admin.careerClearLicense", usersNumber);
	}

	/** 통장사본 이력 적용: care_users 갱신 + 최신 PENDING 1건 APPLIED */
	public int careerApplyAccount(int usersNumber) {
		int u1 = sqlSession.update("admin.careerApplyAccount_UpdateCareUsers", usersNumber);
		int u2 = sqlSession.update("admin.careerApplyAccount_MarkApplied", usersNumber);
		return (u1 > 0 && u2 > 0) ? 1 : 0;
	}

	/** 통장사본 이력 잔여 PENDING → CLEARED */
	public int careerClearAccount(int usersNumber) {
		return sqlSession.update("admin.careerClearAccount", usersNumber);
	}
}
