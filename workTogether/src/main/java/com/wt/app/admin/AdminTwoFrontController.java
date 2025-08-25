package com.wt.app.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Result;

/**
 * Servlet implementation class AdminTwoFrontController
 */
public class AdminTwoFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminTwoFrontController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
		case "/admin/adminUserManagerList.adt":
			System.out.println("관리자 회원관리 페이지 요청");
			result = new AdminUserManagerListController().Execute(request, response);
			System.out.println(result);
			break;
		case "/admin/adminUserDetail.adt":
			System.out.println("관리자 회원관리 디테일 페이지 요청");
			result = new AdminUserDetailController().Execute(request, response);
			break;
		case "/admin/adminNotice.adt":
			System.out.println("관리자 공지사항 관리 페이지 요청");
			result = new AdminNoticeController().Execute(request, response);
			break;
		case "/admin/adminNoticeInsert.adt":
			System.out.println("관리자 공지사항 추가 페이지 요청");
			result = new AdminNoticeInsertController().Execute(request, response);
			break;
		case "/admin/adminNoticeInsertOk.adt":
			System.out.println("관리자 공지사항 추가 완료 페이지 요청");
			result = new AdminNoticeInsertOkController().Execute(request, response);
			break;
		case "/admin/adminNoticeDeleteOk.adt":
			System.out.println("관리자 공지사항 삭제 완료 페이지 요청");
			result = new AdminNoticeDeleteOkController().Execute(request, response);
			break;
		case "/admin/adminNoticeUpdateOk.adt":
			System.out.println("관리자 공지사항 수정 완료 페이지 요청");
			result = new AdminNoticeUpdateOkController().Execute(request, response);
			break;
		case "/admin/adminNoticeDetail.adt":
			System.out.println("관리자 공지사항 상세 페이지 요청");
			result = new AdminNoticeDetailController().Execute(request, response);
			break;
		case "/admin/adminReportList.adt":
			System.out.println("관리자 신고글 페이지 요청");
			result = new AdminReportListController().Execute(request, response);
			break;
		case "/admin/adminReportDeleteOk.adt":
			System.out.println("관리자 신고글 삭제 완료 요청");
			result = new AdminReportDeleteOkController().Execute(request, response);
			break;
		case "/admin/adminNewsBannerInsert.adt":
			System.out.println("관리자 뉴스 베너 쓰기 페이지 요청");
			result = new AdminNewsBannerInsertController().Execute(request, response);
			break;
		case "/admin/adminNewsBannerInsertOk.adt":
			System.out.println("관리자 뉴스 베너 추가 완료 요청");
			result = new AdminNewsBannerInsertOkController().Execute(request, response);
			break;
		case "/admin/adminNewsBannerDetail.adt":
			System.out.println("관리자 뉴스 베너 상세 페이지 요청");
			result = new AdminNewsBannerDetailController().Execute(request, response);
			break;
		case "/admin/adminNewsBanner.adt":
			System.out.println("관리자 뉴스 베너 페이지 요청");
			result = new AdminNewsBannerController().Execute(request, response);
			break;
		case "/admin/adminNewsBannerUpdate.adt":
			System.out.println("관리자 뉴스 베너 수정 페이지 요청");
			result = new AdminNewsBannerUpdateController().Execute(request, response);
			break;
		case "/admin/adminNewsBannerUpdateOk.adt":
			System.out.println("관리자 뉴스 베너 수정 완료 요청");
			result = new AdminNewsBannerUpdateOkController().Execute(request, response);
			break;
		case "/admin/adminNewsBannerDeleteOk.adt":
			System.out.println("관리자 뉴스 베너 삭제 완료 요청");
			result = new AdminNewsBannerDeleteOkController().Execute(request, response);
			break;
		case "/admin/adminReferenceList.adt":
			System.out.println("관리자 문의 관리 페이지 요청");
			result = new AdminReferenceListController().Execute(request, response);
			break;
		case "/admin/adminReferenceDetail.adt":
			System.out.println("관리자 문의 상세 페이지 요청");
			result = new AdminReferenceDetailController().Execute(request, response);
			break;
		}
		
		if (result != null) {
			if (result.isRedirect()) {
				response.sendRedirect(result.getPath());
			} else {
				request.getRequestDispatcher(result.getPath()).forward(request, response);
			}
		}
	}

}
