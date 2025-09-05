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
import com.wt.app.dto.AdminNewsBannerDTO;
import com.wt.app.dto.AdminNewsBoardDTO;
import com.wt.app.dto.AdminNewsBoardListDTO;
import com.wt.app.dto.AdminNoticeListDTO;
import com.wt.app.dto.AdminReferenceListDTO;
import com.wt.app.dto.AdminReportListDTO;
import com.wt.app.dto.AdminUserManagerDTO;
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
	public int insertNoticeFile(FileNoticeDTO dto) {
		sqlSession.insert("admin.fileNoticeInsert", dto);
		return dto.getNoticeFilesNumber(); // PK 반환
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
	public List<AdminNewsBoardListDTO> selectAll(Map<String, Integer> pageMap) {
        return sqlSession.selectList("admin.newsSelectAll", pageMap);
	}

	// 뉴스 총 개수
    public int getNewsTotal() {
        return sqlSession.selectOne("admin.newsGetTotal");
    }

    // 뉴스 등록
    public int insertNews(AdminNewsBoardDTO newsDTO) {
        sqlSession.insert("admin.newsInsert", newsDTO);
        return newsDTO.getNewsNumber();
    }

    // 뉴스 수정
    public void updateNews(AdminNewsBoardDTO newsDTO) {
        sqlSession.update("admin.newsUpdate", newsDTO);
    }

    // 뉴스 단건 조회
    public AdminNewsBoardDTO select(int newsNumber) {
        return sqlSession.selectOne("admin.newsSelectOne", newsNumber);
    }

    // 뉴스 삭제
    public int deleteNews(int newsNumber) {
        return sqlSession.delete("admin.newsDelete", newsNumber);
    }

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
	
	
//	김태현 코드 시작
	public int getUserTotal() {
		System.out.println("게시글 총 개수 조회 - getTotal 메소드 실행");
		return sqlSession.selectOne("admin.getUserTotal");
	}

	public int getNoticeTotal() {
		System.out.println("게시글 총 개수 조회 - getTotal 메소드 실행");
		return sqlSession.selectOne("admin.getNoticeTotal");
	}
	
	public List<AdminUserManagerDTO> adminUserManager(Map<String, Integer> pageMap) {
		List<AdminUserManagerDTO> list = sqlSession.selectList("admin.adminUserManager", pageMap);
		System.out.println("조회결과 : " + list);
		return list;
	}

	public AdminUserManagerDTO adminUserManagerDetail(int usersNumber) {
		System.out.println("회원 정보 상세 페이지");
		return sqlSession.selectOne("admin.adminUserManagerDetail", usersNumber);
	}

	public List<AdminNoticeListDTO> adminNoticeListSearch(Map<String, Integer> pageMap) {
		List<AdminNoticeListDTO> list = sqlSession.selectList("admin.adminNoticeListSearch", pageMap);
		System.out.println("조회결과 : " + list);
		return list;
	}

	public int adminNoticeListInsert(AdminNoticeListDTO adminNoticeListDTO) {
		sqlSession.insert("admin.adminNoticeListInsert", adminNoticeListDTO);
		return adminNoticeListDTO.getNoticeNumber();
	}

	public void adminNoticeListUpdate(AdminNoticeListDTO adminNoticeListDTO) {
		sqlSession.update("admin.adminNoticeListUpdate", adminNoticeListDTO);
		System.out.println("공지사항 수정 완료");
	}

	public void adminNoticeListDelete(int noticeNumber) {
		sqlSession.delete("admin.adminNoticeListDelete", noticeNumber);
		System.out.println("공지사항 삭제 완료");
	}

	public List<AdminReportListDTO> adminReportListSelect() {
		List<AdminReportListDTO> list = sqlSession.selectList("admin.adminReportListSelect");
		return list;
	}

	public void adminReportListDelete(int postNumber) {
		sqlSession.delete("admin.adminReportListDelete");
		System.out.println("신고글 삭제 완료");
	}

	public int adminNewsBannerInsert(AdminNewsBannerDTO adminNewsBannerDTO) {
		sqlSession.insert("admin.adminNewsBannerInsert", adminNewsBannerDTO);
		return adminNewsBannerDTO.getBannerNewsNumber();
	}

	public List<AdminNewsBannerDTO> adminNewsBannerSelect() {
		List<AdminNewsBannerDTO> list = sqlSession.selectList("admin.adminNewsBannerSelect");
		return list;
	}

	public void adminNewsBannerUpdate(AdminNewsBannerDTO adminNewsBannerDTO) {
		sqlSession.update("admin.adminNewsBannerUpdate", adminNewsBannerDTO);
		System.out.println("뉴스 베너 수정 완료");
	}

	public void adminNewsBannerDelete(int newsNumber) {
		sqlSession.delete("admin.adminNewsBannerDelete", newsNumber);
		System.out.println("뉴스 베너 삭제 완료");
	}

	public List<AdminReferenceListDTO> adminReferenceListSelect(AdminReferenceListDTO adminReferenceListDTO) {
		List<AdminReferenceListDTO> list = sqlSession.selectList("admin.adminReferenceListSelect",
				adminReferenceListDTO);
		return list;
	}
}
