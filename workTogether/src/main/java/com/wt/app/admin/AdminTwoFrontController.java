package com.wt.app.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
		case "/admin/adminUserManagerList.ad":
			System.out.println("관리자 회원관리 페이지 요청");
			result = new AdminUserManagerListController().Execute(request, response);
			break;
		case "/admin/adminUserDetail.ad":
			System.out.println("관리자 회원관리 디테일 페이지 요청");
			result = new AdminUserDetailController().Execute(request, response);
			break;
		case "/admin/adminNotice.ad":
			System.out.println("관리자 공지사항 관리 페이지 요청");
			result.setRedirect(true);
			break;
		case "/admin/adminNoticeInsert.ad":
			System.out.println("관리자 공지사항 추가 페이지 요청");
			result.setRedirect(true);
			break;
		case "/admin/adminNoticeInsertOk.ad":
			System.out.println("관리자 공지사항 추가 완료 페이지 요청");
			result.setRedirect(true);
			break;
		case "/admin/adminNoticeDeleteOk.ad":
			System.out.println("관리자 공지사항 삭제 완료 페이지 요청");
			result.setRedirect(true);
			break;
		case "/admin/adminNoticeUpdateOk.ad":
			System.out.println("관리자 공지사항 수정 완료 페이지 요청");
			result.setRedirect(true);
			break;
		case "/admin/adminNoticeDetail.ad":
			System.out.println("관리자 공지사항 상세 페이지 요청");
			result.setRedirect(true);
			break;
		case "/admin/adminReportList.ad":
			System.out.println("관리자 신고글 페이지 요청");
			result.setRedirect(true);
			break;
		case "/admin/adminReportDeleteOk.ad":
			System.out.println("관리자 신고글 삭제 완료 요청");
			result.setRedirect(true);
			break;
		case "/admin/adminNewsBannerInsert.ad":
			System.out.println("관리자 뉴스 베너 쓰기 페이지 요청");
			result.setRedirect(true);
			break;
		case "/admin/adminNewsBannerInsertOk.ad":
			System.out.println("관리자 뉴스 베너 추가 완료 요청");
			result.setRedirect(true);
			break;
		case "/admin/adminNewsBannerDetail.ad":
			System.out.println("관리자 뉴스 베너 상세 페이지 요청");
			result.setRedirect(true);
			break;
		case "/admin/adminNewsBanner.ad":
			System.out.println("관리자 뉴스 베너 페이지 요청");
			result.setRedirect(true);
			break;
		case "/admin/adminNewsBannerUpdate.ad":
			System.out.println("관리자 뉴스 베너 수정 페이지 요청");
			result.setRedirect(true);
			break;
		case "/admin/adminNewsBannerUpdateOk.ad":
			System.out.println("관리자 뉴스 베너 수정 완료 요청");
			result.setRedirect(true);
			break;
		case "/admin/adminNewsBannerDeleteOk.ad":
			System.out.println("관리자 뉴스 베너 삭제 완료 요청");
			result.setRedirect(true);
			break;
		case "/admin/adminReferenceList.ad":
			System.out.println("관리자 문의 관리 페이지 요청");
			result.setRedirect(true);
			break;
		case "/admin/adminReferenceDetail.ad":
			System.out.println("관리자 문의 상세 페이지 요청");
			result.setRedirect(true);
			break;
		}
	}

}
