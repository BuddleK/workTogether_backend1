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
		case "/admin/adminUserManagerListOk.ad":
			System.out.println("관리자 회원관리 페이지 요청");
			result = new AdminUserManagerListOkController().Execute(request, response);
			break;
		case "/admin/adminUserDetailOk.ad":
			System.out.println("관리자 회원관리 디테일 페이지 요청");
			result = new AdminUserDetailOkController().Execute(request, response);
			break;
		case "/admin/adminNoticeOk.ad":
			System.out.println("관리자 공지사항 관리 페이지 요청");
			break;
		case "/admin/adminNoticeInsertOk.ad":
			System.out.println("관리자 공지사항 추가 페이지 요청");
			break;
		}

	}

}
