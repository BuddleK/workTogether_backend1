package com.wt.app.normal.mypage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Result;
import com.wt.app.admin.AdminUserManagerListController;

/**
 * Servlet implementation class MyPageNormalFrontController
 */
public class MyPageNormalFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MyPageNormalFrontController() {
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
		case "/myPageNormal/checkPw.mn":
			System.out.println("마이페이지 일반회원 비밀번호 확인 페이지 요청");
			request.getRequestDispatcher("/app/myPageNormal/normalPwCheck.jsp").forward(request, response);
			break;
		case "/myPageNormal/checkPwOk.mn":
			System.out.println("마이페이지 일반회원 비밀번호 확인 완료 요청");
			result = new CheckPwOkController().execute(request, response);
			break;
		case "/myPageNormal/normalModify.mn":
			System.out.println("마이페이지 일반회원 회원정보 수정 페이지 요청");
			result = new NormalModifyController().execute(request, response);
			break;
		case "/myPageNormal/normalModifyOk.mn":
			System.out.println("마이페이지 일반회원 회원정보 수정 완료 요청");
			result = new NormalModifyOkController().execute(request, response);
			break;
		case "/myPageNormal/normalfavoriteList.mn":
			System.out.println("마이페이지 일반회원 가게 찜 리스트 페이지 요청");
			result = new NormalfavoriteListController().execute(request, response);
			break;
		case "/myPageNormal/normalfavoriteListDeleteOk.mn":
			System.out.println("마이페이지 일반회원 가게 찜 삭제 완료 요청");
			result = new NormalfavoriteListDeleteOkController().execute(request, response);
			break;
		case "/myPageNormal/normalHeartList.mn":
			System.out.println("마이페이지 일반회원 하트 리스트 페이지 요청");
			result = new NormalHeartListController().execute(request, response);
			break;

		case "/myPageNormal/normalHeartListTotal.mn":
			System.out.println("마이페이지 일반회원 하트 리스트 페이지 요청");
			result = new NormalHeartListTotalController().execute(request, response);
			break;
		case "/myPageNormal/normalHeartListDeleteOk.mn":
			System.out.println("마이페이지 일반회원 하트 리스트 삭제 완료 요청");
			result = new NormalHeartListDeleteOkController().execute(request, response);
			break;
		case "/myPageNormal/normalMatchingListOk.mn":
			System.out.println("마이페이지 일반회원 매칭 관리 페이지 요청js");
			result = new NormalMatchingListOkController().execute(request, response);
			break;

		case "/myPageNormal/normalMatching.mn":
			System.out.println("마이페이지 일반회원 매칭 관리 페이지 요청");
			result = new NormalMatchingController().execute(request, response);
			break;
		case "/myPageNormal/normalPostsList.mn":
			System.out.println("마이페이지 일반회원 게시판 리스트 페이지 요청");
			result = new NormalPostsListController().execute(request, response);
			break;
		case "/myPageNormal/normalPostsListDeleteOk.mn":
			System.out.println("마이페이지 일반회원 게시판 삭제 완료 요청");
			result = new NormalPostsListDeleteOkController().execute(request, response);
			break;
		case "/myPageNormal/normalReferenceInsert.mn":
			System.out.println("마이페이지 일반회원 문의 추가 페이지 요청");
			result = new NormalReferenceInsertController().execute(request, response);
			break;
		case "/myPageNormal/normalReferenceInsertOk.mn":
			System.out.println("마이페이지 일반회원 문의 추가 완료 요청");
			result = new NormalReferenceInsertOkController().execute(request, response);
			break;
		case "/myPageNormal/normalReferenceList.mn":
			System.out.println("마이페이지 일반회원 문의 리스트 페이지 요청");
			result = new NormalReferenceListController().execute(request, response);
			break;
		case "/myPageNormal/normalExit.mn":
			System.out.println("마이페이지 일반회원 회원탈퇴 페이지 요청");
			result = new NormalExitController().execute(request, response);
			break;
		case "/myPageNormal/normalExitOk.mn":
			System.out.println("마이페이지 일반회원 회원탈퇴 완료 요청");
			result = new NormalExitOkController().execute(request, response);
			break;
		}

		if (result != null && result.getPath() != null) {
			if (result.isRedirect()) {
				response.sendRedirect(result.getPath());
			} else {
				request.getRequestDispatcher(result.getPath()).forward(request, response);
			}
		}
	}
}
