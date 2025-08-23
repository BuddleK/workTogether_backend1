package com.wt.app.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Result;

/**
 * Servlet implementation class AdminCareFrontController
 */
public class AdminCareFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminCareFrontController() {
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
		String target = request.getRequestURI().substring(request.getContextPath().length());
		System.out.println("AdminNewsFrontController 현재 경로 : " + target);

		Result result = new Result();

		switch (target) {
		case "/admin/care/list.ad":
			System.out.println("가입신청 대기 목록 처리 요청");
			result = new AdminCareListController().Execute(request, response);
			break;

		case "/admin/care/detail.ad":
			System.out.println("가입신청 단건 상세 처리 요청");
			result = new AdminCareDetailController().Execute(request, response);
			break;

		case "/admin/care/approve.ad":
			System.out.println("가입신청 승인 처리 요청");
			result = new AdminCareApproveController().Execute(request, response);
			break;

		case "/admin/care/reject.ad":
			System.out.println("가입신청 반려(케어만) 처리 요청");
			result = new AdminCareRejectController().Execute(request, response);
			break;

		case "/admin/care/rejectAll.ad":
			System.out.println("가입신청 반려(유저까지) 처리 요청");
			result = new AdminCareRejectAllController().Execute(request, response);
			break;

		/* ============== 첨부파일 ============== */

		case "/admin/care/fileMeta.ad":
			System.out.println("첨부파일 메타 조회 요청");
			result = new AdminCareFileMetaController().Execute(request, response);
			break;

		case "/admin/care/fileDownload.ad":
			System.out.println("첨부파일 다운로드 요청");
			result = new AdminCareFileDownloadController().Execute(request, response);
			break;

		/* ============== 확장 예정 ============== */
		// case "/admin/care/refundList.ad": ...
		// case "/admin/care/historyList.ad": ...
		}

		if (result != null) {
			if (result.isRedirect()) {
				response.sendRedirect(result.getPath());
			} else {
				request.getRequestDispatcher(result.getPath()).forward(request, response);
			}
		} else {
			// 매칭되는 액션이 없을 때
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
	}

}
