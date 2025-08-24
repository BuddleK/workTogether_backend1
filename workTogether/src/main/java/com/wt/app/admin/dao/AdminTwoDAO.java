package com.wt.app.admin.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.wt.app.dto.AdminNewsBannerDTO;
import com.wt.app.dto.AdminNoticeListDTO;
import com.wt.app.dto.AdminReferenceListDTO;
import com.wt.app.dto.AdminReportListDTO;
import com.wt.app.dto.AdminUserManagerDTO;
import com.wt.config.MyBatisConfig;

public class AdminTwoDAO {
	public SqlSession sqlSession;

	public AdminTwoDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}

	public int getTotal() {
		System.out.println("게시글 총 개수 조회 - getTotal 메소드 실행");
		return sqlSession.selectOne("admin.getTotal");
	}

	public List<AdminUserManagerDTO> adminUserManager(Map<String, Integer> pageMap) {
		List<AdminUserManagerDTO> list = sqlSession.selectList("admin.adminUserManager");
		System.out.println("조회결과 : " + list);
		return list;
	}

	public AdminUserManagerDTO adminUserManagerDetail(int usersNumber) {
		System.out.println("회원 정보 상세 페이지");
		return sqlSession.selectOne("admin.adminUserManagerDetail", usersNumber);
	}

	public List<AdminNoticeListDTO> adminNoticeListSearch() {
		List<AdminNoticeListDTO> list = sqlSession.selectList("admin.adminNoticeListSearch");
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
		return adminNewsBannerDTO.getNewsNumber();
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
