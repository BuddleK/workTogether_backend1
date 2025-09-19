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
import com.wt.app.dto.CarePointreturnDTO;
import com.wt.app.dto.FileNoticeDTO;
import com.wt.app.dto.FilesLicenseDTO;
import com.wt.app.dto.LicenseModifyDTO;
import com.wt.config.MyBatisConfig;
import com.wt.app.dto.CareCareerRowDTO;

public class AdminDAO {

	/** 기본 세션(오토커밋) — 조회/단순 DML 용 */
	private final SqlSession sqlSession;

	public AdminDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}

	/* ======================= [Auth] ======================= */

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
		return sqlSession.update("admin.careReject", usersNumber);
	}

	public int careRejectAll(int usersNumber) {
		return sqlSession.delete("admin.careRejectAll", usersNumber);
	}

	/** care_accept 값 임의 업데이트(W/Y/N) */
	public void updateCareAccept(int usersNumber, String status) {
		Map<String, Object> params = new HashMap<>();
		params.put("usersNumber", usersNumber);
		params.put("status", status);
		sqlSession.update("admin.updateCareAccept", params);
	}

	/** 반려 사유 기록 */
	public int insertRejectUser(int usersNumber, int adminNumber, String rejectComment) {
		Map<String, Object> p = new HashMap<>();
		p.put("usersNumber", usersNumber);
		p.put("adminNumber", adminNumber);
		p.put("rejectComment", rejectComment);
		return sqlSession.insert("admin.insertRejectUser", p);
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

	// (선택) 자격증 파일 INSERT
	public void insertLicenseFile(FilesLicenseDTO dto) {
		sqlSession.insert("admin.careInsertLicenseFile", dto);
	}

	/* ======================= [파일 다운로드 공용] ======================= */

	public AdminFileDownloadDTO fileDownloadLicense(int fileNumber) {
		return sqlSession.selectOne("admin.fileDownloadLicense", fileNumber);
	}

	public AdminFileDownloadDTO fileDownloadAccount(int fileNumber) {
		return sqlSession.selectOne("admin.fileDownloadAccount", fileNumber);
	}

	/* ===== [News 연동 파일(tbl_files_notice)] ===== */

	public int insertNoticeFile(FileNoticeDTO dto) {
		sqlSession.insert("admin.fileNoticeInsert", dto);
		return dto.getNoticeFilesNumber();
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

	public int getNewsTotal() {
		return sqlSession.selectOne("admin.newsGetTotal");
	}

	public int insertNews(AdminNewsBoardDTO newsDTO) {
		sqlSession.insert("admin.newsInsert", newsDTO);
		return newsDTO.getNewsNumber();
	}

	public void updateNews(AdminNewsBoardDTO newsDTO) {
		sqlSession.update("admin.newsUpdate", newsDTO);
	}

	public AdminNewsBoardDTO select(int newsNumber) {
		return sqlSession.selectOne("admin.newsSelectOne", newsNumber);
	}

	public int deleteNews(int newsNumber) {
		return sqlSession.delete("admin.newsDelete", newsNumber);
	}

	/* ============ [Care 이력수정: 자격증/통장사본] ============ */

	public int licenseModifyInsert(LicenseModifyDTO dto) {
		sqlSession.insert("admin.licenseModifyInsert", dto);
		return dto.getLicenseModifyNumber();
	}

	public int accountModifyInsert(AccountModifyDTO dto) {
		sqlSession.insert("admin.accountModifyInsert", dto);
		return dto.getAccountModifyNumber();
	}

	public LicenseModifyDTO licenseModifyLatestByUser(int usersNumber) {
		return sqlSession.selectOne("admin.licenseModifyLatestByUser", usersNumber);
	}

	public AccountModifyDTO accountModifyLatestByUser(int usersNumber) {
		return sqlSession.selectOne("admin.accountModifyLatestByUser", usersNumber);
	}

	public int careerApplyLicense(int usersNumber) {
		int u1 = sqlSession.update("admin.careerApplyLicense_UpdateCareUsers", usersNumber);
		int u2 = sqlSession.update("admin.careerApplyLicense_MarkApplied", usersNumber);
		return (u1 > 0 && u2 > 0) ? 1 : 0;
	}

	public int careerClearLicense(int usersNumber) {
		return sqlSession.update("admin.careerClearLicense", usersNumber);
	}

	public int careerApplyAccount(int usersNumber) {
		int u1 = sqlSession.update("admin.careerApplyAccount_UpdateCareUsers", usersNumber);
		int u2 = sqlSession.update("admin.careerApplyAccount_MarkApplied", usersNumber);
		return (u1 > 0 && u2 > 0) ? 1 : 0;
	}

	public int careerClearAccount(int usersNumber) {
		return sqlSession.update("admin.careerClearAccount", usersNumber);
	}

	// 김태현 코드 시작
	public int getUserTotal() {
		return sqlSession.selectOne("admin.getUserTotal");
	}

	public int getNoticeTotal() {
		return sqlSession.selectOne("admin.getNoticeTotal");
	}

	public List<AdminUserManagerDTO> adminUserManager(Map<String, Integer> pageMap) {
		return sqlSession.selectList("admin.adminUserManager", pageMap);
	}

	public AdminUserManagerDTO adminUserManagerDetail(int usersNumber) {
		return sqlSession.selectOne("admin.adminUserManagerDetail", usersNumber);
	}

	public void adminUserNameUpdate(AdminUserManagerDTO adminUserManagerDTO) {
		sqlSession.update("admin.adminUserNameUpdate", adminUserManagerDTO);
	}

	public void adminUserPassbookUpdate(AdminUserManagerDTO adminUserManagerDTO) {
		sqlSession.update("admin.adminUserPassbookUpdate", adminUserManagerDTO);
	}

	public void adminUserDelete(int usersNumber) {
		sqlSession.delete("admin.adminUserDelete", usersNumber);
	}
	
	public List<AdminNoticeListDTO> adminNoticeListSearch(Map<String, Integer> pageMap) {
		return sqlSession.selectList("admin.adminNoticeListSearch", pageMap);
	}
	
	public AdminNoticeListDTO adminNoticeDetailSearch(int noticeNumber){
		return sqlSession.selectOne("admin.adminNoticeDetail",noticeNumber);
	}

	public int adminNoticeListInsert(AdminNoticeListDTO adminNoticeListDTO) {
		sqlSession.insert("admin.adminNoticeListInsert", adminNoticeListDTO);
		return adminNoticeListDTO.getNoticeNumber();
	}

	public void adminNoticeListUpdate(AdminNoticeListDTO adminNoticeListDTO) {
		sqlSession.update("admin.adminNoticeListUpdate", adminNoticeListDTO);
	}

	public void adminNoticeListDelete(int noticeNumber) {
		sqlSession.delete("admin.adminNoticeListDelete", noticeNumber);
	}

	public List<AdminReportListDTO> adminReportListSelect(Map<String, Object> pageMap) {
		return sqlSession.selectList("admin.adminReportListSelect");
	}

	public void adminReportListDelete(int postNumber) {
		sqlSession.delete("admin.adminReportListDelete", postNumber);
	}

	/* ======================= [News Banners] ======================= */

	public int adminNewsBannerInsert(AdminNewsBannerDTO dto) {
		sqlSession.insert("admin.adminNewsBannerInsert", dto);
		return dto.getBannerNewsNumber();
	}

	public int adminNewsBannerUpdate(AdminNewsBannerDTO dto) {
		return sqlSession.update("admin.adminNewsBannerUpdate", dto);
	}

	public int adminNewsBannerDelete(int bannerNewsNumber) {
		return sqlSession.delete("admin.adminNewsBannerDelete", bannerNewsNumber);
	}

	public List<AdminNewsBannerDTO> adminNewsBannerSelect() {
		return sqlSession.selectList("admin.adminNewsBannerSelect");
	}

	public AdminNewsBannerDTO adminNewsBannerSelectOne(int bannerNewsNumber) {
		return sqlSession.selectOne("admin.adminNewsBannerSelectOne", bannerNewsNumber);
	}

	public int adminNewsBannerCountAll() {
		return sqlSession.selectOne("admin.bannerCountAll");
	}

	public Integer adminNewsBannerFindOldestId() {
		return sqlSession.selectOne("admin.bannerFindOldestId");
	}

	public int adminNewsBannerReplace(AdminNewsBannerDTO dto) {
		return sqlSession.update("admin.bannerReplace", dto);
	}

	public int adminNewsBannerUpsertFile(int bannerNewsNumber, String filePath, String fileName, String fileExt,
			long fileSize) {
		Map<String, Object> p = new HashMap<>();
		p.put("bannerNewsNumber", bannerNewsNumber);
		p.put("path", filePath);
		p.put("fileName", fileName);
		p.put("fileType", fileExt);
		p.put("sizeBytes", fileSize);
		return sqlSession.update("admin.bannerUpsertFile", p);
	}

	/* ======================= [Reference(문의)] ======================= */

	public List<AdminReferenceListDTO> adminReferenceListSelect() {
		return sqlSession.selectList("admin.adminReferenceListSelect");
	}

	public AdminReferenceListDTO adminReferenceDetail(int referenceNumber) {
		return sqlSession.selectOne("admin.adminReferenceDetail", referenceNumber);
	}

	/* ======================= [Point Refunds / 환급] ======================= */

	// 환급 요청 등록
	public long pointReturnInsert(CarePointreturnDTO dto) {
		sqlSession.insert("admin.pointReturnInsert", dto);
		return dto.getPointReturnId();
	}

	// 환급 요청 목록 (페이지네이션)
	public List<CarePointreturnDTO> pointReturnListPaged(int startRow, int endRow, String status) {
		Map<String, Object> p = new HashMap<>();
		p.put("startRow", startRow);
		p.put("endRow", endRow);
		p.put("status", status);
		return sqlSession.selectList("admin.pointReturnListPaged", p);
	}

	public int pointReturnCount(String status) {
		Map<String, Object> p = new HashMap<>();
		p.put("status", status);
		return sqlSession.selectOne("admin.pointReturnCount", p);
	}

	public CarePointreturnDTO pointReturnOne(long pointReturnId) {
		return sqlSession.selectOne("admin.pointReturnOne", pointReturnId);
	}

	public int pointReturnApproveDeductUserPoint(long pointReturnId) {
		Map<String, Object> p = new HashMap<>();
		p.put("pointReturnId", pointReturnId);
		return sqlSession.update("admin.pointReturnApprove_DeductUserPoint", p);
	}

	public int pointReturnApproveMark(long pointReturnId) {
		Map<String, Object> p = new HashMap<>();
		p.put("pointReturnId", pointReturnId);
		// 매퍼는 status='Y', refunded_at=SYSDATE 로 업데이트
		return sqlSession.update("admin.pointReturnApprove_Mark", p);
	}

	public int pointReturnReject(long pointReturnId, int adminUsersNumber, String adminMemo) {
		Map<String, Object> p = new HashMap<>();
		p.put("pointReturnId", pointReturnId);
		p.put("adminUsersNumber", adminUsersNumber);
		p.put("adminMemo", adminMemo);
		return sqlSession.update("admin.pointReturnReject", p);
	}

	public boolean approvePointReturn(long pointReturnId) {
		try (SqlSession tx = MyBatisConfig.getSqlSessionFactory().openSession(false)) {
			Map<String, Object> p = new HashMap<>();
			p.put("pointReturnId", pointReturnId);

			int d = tx.update("admin.pointReturnApprove_DeductUserPoint", p);
			if (d != 1) {
				tx.rollback();
				return false;
			}

			int m = tx.update("admin.pointReturnApprove_Mark", p);
			if (m != 1) {
				tx.rollback();
				return false;
			}

			tx.commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// 신고글 관련
	public int reportTotal() {
		System.out.println("신고글 개수 조회 - reportTotal 메소드 실행");
		return sqlSession.selectOne("admin.reportTotal");
	}

	public AdminReportListDTO reportDetail(int postsNumber) {
		System.out.println("신고글 상세 페이지 조회");
		return sqlSession.selectOne("admin.reportDetail", postsNumber);
	}

//	============ [Care 이력수정: 통장 사본 목록/상태] ============  추가함
	public List<CareCareerRowDTO> careCareerListPaged(int startRow, int endRow, String column, String keyword) {
		Map<String, Object> p = new HashMap<>();
		p.put("startRow", startRow);
		p.put("endRow", endRow);
		p.put("column", column);
		p.put("keyword", keyword);
		return sqlSession.selectList("admin.careCareerListPaged", p);
	}

	// 총 개수
	public int careCareerCount(String column, String keyword) {
		Map<String, Object> p = new HashMap<>();
		p.put("column", column);
		p.put("keyword", keyword);
		return sqlSession.selectOne("admin.careCareerCount", p);
	}

	// 상태 변경 (Y/N/W)
	public int careCareerUpdateStatus(int accountModifyNumber, String status) {
		Map<String, Object> p = new HashMap<>();
		p.put("accountModifyNumber", accountModifyNumber);
		p.put("status", status);
		return sqlSession.update("admin.careCareerUpdateStatus", p);
	}
	
	public int careCareerApproveLatestByUser(int usersNumber) {
	    return sqlSession.update("admin.careCareerApproveLatestByUser", usersNumber);
	}
	
	public int careCareerRejectLatestByUser(int usersNumber) {
	    return sqlSession.update("admin.careCareerRejectLatestByUser", usersNumber);
	}



}
