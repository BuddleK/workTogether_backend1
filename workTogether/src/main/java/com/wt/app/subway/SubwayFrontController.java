package com.wt.app.subway;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Result;
import com.wt.app.main.SubwayListController;
import com.wt.app.normal.mypage.CheckPwOkController;

/**
 * Servlet implementation class AdminFrontController
 */
public class SubwayFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SubwayFrontController() {
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
		case "/subway/subwayList.sw":
			System.out.println("지하철 노선 출력 요청");
			result = new SubwayListController().execute(request, response);
			System.out.println(result);
			break;
		case "/subway/subwayDetail.sw":
			System.out.println("지하철 상세 페이지 요청");
			result = new SubwayDetailController().execute(request, response);
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
