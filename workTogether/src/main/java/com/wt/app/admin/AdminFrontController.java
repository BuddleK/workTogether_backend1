package com.wt.app.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Result;

/**
 * Servlet implementation class AdminFrontController
 */
public class AdminFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminFrontController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		String target = request.getRequestURI().substring(request.getContextPath().length());
		System.out.println("현재경로 : " + target);
		Result result = new Result();

		switch (target) {

		/* =============== [Auth] =============== */
		case "/admin/login.ad":
			System.out.println("관리자 로그인 페이지 요청");
			result = new AdminLoginController().execute(request, response);
			break;

		case "/admin/loginOk.ad":
			System.out.println("관리자 로그인 처리 요청");
			result = new AdminLoginOkController().execute(request, response);
			break;

		case "/admin/logoutOk.ad":
			System.out.println("관리자 로그아웃 처리 요청");
			result = new AdminLogoutController().execute(request, response);
			break;

		/* =============== [News] =============== */
			
		case "/admin/news/newsListOk.ad":
			System.out.println("뉴스 목록 처리 요청");
			result = new AdminNewsListOkController().execute(request, response);
			break;

		case "/admin/news/newsReadOk.ad":
			System.out.println("뉴스 상세 페이지 처리 요청");
			result = new AdminNewsReadOkController().execute(request, response);
			break;

		case "/admin/news/newsWrite.ad":
			System.out.println("뉴스 작성 페이지 이동 요청");
			result = new AdminNewsWriteController().execute(request, response);
			break;

		case "/admin/news/newsWriteOk.ad":
			System.out.println("뉴스 작성 완료 요청");
			result = new AdminNewsWriteOkController().execute(request, response);
			break;

		case "/admin/news/newsDeleteOk.ad":
			System.out.println("뉴스 삭제 완료 요청");
			result = new AdminNewsDeleteOkController().execute(request, response);
			break;

		case "/admin/news/newsUpdate.ad":
			System.out.println("뉴스 수정 페이지 이동 요청");
			result = new AdminNewsUpdateController().execute(request, response);
			break;

		case "/admin/news/newsUpdateOk.ad":
			System.out.println("뉴스 수정 완료 요청");
			result = new AdminNewsUpdateOkController().execute(request, response);
			break;

		/* =============== [Care 가입신청/파일] =============== */
		case "/admin/care/list.ad":
			System.out.println("가입신청 대기 목록 처리 요청");
			result = new AdminCareListController().execute(request, response);
			break;

		case "/admin/care/detail.ad":
			System.out.println("가입신청 단건 상세 처리 요청");
			result = new AdminCareDetailController().execute(request, response);
			break;

		case "/admin/care/approve.ad":
			System.out.println("가입신청 승인 처리 요청");
			result = new AdminCareApproveController().execute(request, response);
			break;

		case "/admin/care/reject.ad":
			System.out.println("가입신청 반려 처리 요청");
			result = new AdminCareRejectController().execute(request, response);
			break;

		case "/admin/care/rejectAll.ad":
			System.out.println("가입신청 일괄 반려 처리 요청");
			result = new AdminCareRejectAllController().execute(request, response);
			break;

		case "/admin/care/fileMeta.ad":
			System.out.println("첨부파일 조회 요청");
			result = new AdminCareFileController().execute(request, response);
			break;

		case "/admin/care/fileDownload.ad":
			System.out.println("첨부파일 다운로드 요청");
			result = new AdminCareFileDownloadController().execute(request, response);
			break;

		/* =============== [Care 이력 수정] =============== */
		case "/admin/careCareer/list.ad":
			result = new AdminCareCareerListController().execute(request, response);
			break;

		case "/admin/careCareer/detail.ad":
			result = new AdminCareCareerDetailController().execute(request, response);
			break;

		case "/admin/careCareer/updateStatus.ad":
			result = new AdminCareCareerUpdateStatusController().execute(request, response);
			break;

		
//		김태현 코드 시작
		case "/admin/adminUserManagerList.ad":
			System.out.println("관리자 회원관리 페이지 요청");
			result = new AdminUserManagerListController().execute(request, response);
			System.out.println(result);
			break;
		case "/admin/adminUserDetail.ad":
			System.out.println("관리자 회원관리 디테일 페이지 요청");
			result = new AdminUserDetailController().execute(request, response);
			break;
		case "/admin/adminNotice.ad":
			System.out.println("관리자 공지사항 관리 페이지 요청");
			result = new AdminNoticeController().execute(request, response);
			break;
		case "/admin/adminNoticeInsert.ad":
			System.out.println("관리자 공지사항 추가 페이지 요청");
			result = new AdminNoticeInsertController().execute(request, response);
			break;
		case "/admin/adminNoticeInsertOk.ad":
			System.out.println("관리자 공지사항 추가 완료 페이지 요청");
			result = new AdminNoticeInsertOkController().execute(request, response);
			break;
		case "/admin/adminNoticeDeleteOk.ad":
			System.out.println("관리자 공지사항 삭제 완료 페이지 요청");
			result = new AdminNoticeDeleteOkController().execute(request, response);
			break;
		case "/admin/adminNoticeUpdateOk.ad":
			System.out.println("관리자 공지사항 수정 완료 페이지 요청");
			result = new AdminNoticeUpdateOkController().execute(request, response);
			break;
		case "/admin/adminNoticeDetail.ad":
			System.out.println("관리자 공지사항 상세 페이지 요청");
			result = new AdminNoticeDetailController().execute(request, response);
			break;
		case "/admin/adminReportList.ad":
			System.out.println("관리자 신고글 페이지 요청");
			result = new AdminReportListController().execute(request, response);
			break;
		case "/admin/adminReportDeleteOk.ad":
			System.out.println("관리자 신고글 삭제 완료 요청");
			result = new AdminReportDeleteOkController().execute(request, response);
			break;
		case "/admin/adminNewsBannerInsert.ad":
			System.out.println("관리자 뉴스 베너 쓰기 페이지 요청");
			result = new AdminNewsBannerInsertController().execute(request, response);
			break;
		case "/admin/adminNewsBannerInsertOk.ad":
			System.out.println("관리자 뉴스 베너 추가 완료 요청");
			result = new AdminNewsBannerInsertOkController().execute(request, response);
			break;
		case "/admin/adminNewsBannerDetail.ad":
			System.out.println("관리자 뉴스 베너 상세 페이지 요청");
			result = new AdminNewsBannerDetailController().execute(request, response);
			break;
		case "/admin/adminNewsBanner.ad":
			System.out.println("관리자 뉴스 베너 페이지 요청");
			result = new AdminNewsBannerController().execute(request, response);
			break;
		case "/admin/adminNewsBannerUpdate.ad":
			System.out.println("관리자 뉴스 베너 수정 페이지 요청");
			result = new AdminNewsBannerUpdateController().execute(request, response);
			break;
		case "/admin/adminNewsBannerUpdateOk.ad":
			System.out.println("관리자 뉴스 베너 수정 완료 요청");
			result = new AdminNewsBannerUpdateOkController().execute(request, response);
			break;
		case "/admin/adminNewsBannerDeleteOk.ad":
			System.out.println("관리자 뉴스 베너 삭제 완료 요청");
			result = new AdminNewsBannerDeleteOkController().execute(request, response);
			break;
		case "/admin/adminReferenceList.ad":
			System.out.println("관리자 문의 관리 페이지 요청");
			result = new AdminReferenceListController().execute(request, response);
			break;
		case "/admin/adminReferenceDetail.ad":
			System.out.println("관리자 문의 상세 페이지 요청");
			result = new AdminReferenceDetailController().execute(request, response);
			break;
		
		}

		// 공통 포워딩/리다이렉트
		if (result != null && result.getPath() != null) {
			if (result.isRedirect()) {
				response.sendRedirect(result.getPath());
			} else {
				request.getRequestDispatcher(result.getPath()).forward(request, response);
			}
		} else {
			// 컨트롤러 내부에서 직접 응답을 끝낸 경우를 제외하고는 오류로 처리
			if (!response.isCommitted()) {
				response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			}
		}
	}
}
