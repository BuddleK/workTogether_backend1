package com.wt.app.admin.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.wt.app.dto.AdminCareFileDTO;
import com.wt.app.dto.AdminCareSignupDTO;
import com.wt.app.dto.AdminFileDownloadDTO;
import com.wt.app.dto.AdminLoginDTO;
import com.wt.app.dto.AdminNewsBoardDTO;
import com.wt.app.dto.AdminNewsBoardListDTO;
import com.wt.app.dto.FileNoticeDTO;
import com.wt.app.dto.FilesLicenseDTO;
import com.wt.config.MyBatisConfig;

public class AdminDAO {

	private final SqlSession sqlSession;

	public AdminDAO() {
		// 필요 시 트랜잭션 사용하려면 false로 열고 수동 commit/rollback 하세요.
		this.sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}

	/* ======================= [Auth] ======================= */

	/** 로그인 성공 시 admin_number, 실패 시 -1 */
	public int login(AdminLoginDTO adminLoginDTO) {
		Integer adminNumber = sqlSession.selectOne("admin.login", adminLoginDTO);
		return adminNumber == null ? -1 : adminNumber;
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
	public int careInsertLicenseFile(FilesLicenseDTO dto) {
	    sqlSession.insert("admin.careInsertLicenseFile", dto);
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

	public List<AdminNewsBoardListDTO> newsSelectAll(int startRow, int endRow) {
		Map<String, Object> param = new HashMap<>();
		param.put("startRow", startRow);
		param.put("endRow", endRow);
		return sqlSession.selectList("admin.newsSelectAll", param);
	}

	public int newsGetTotal() {
		return sqlSession.selectOne("admin.newsGetTotal");
	}

	/** 등록 시 mapper의 selectKey로 newsNumber가 dto에 세팅됩니다. */
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
	}
}
