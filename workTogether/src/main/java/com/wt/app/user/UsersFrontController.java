package com.wt.app.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import com.example.app.member.LoginController;
import com.wt.app.Result;
//import com.wt.app.careUsers.CaresUsersLoginOkController;
import com.wt.app.careUsers.careUsersLoginOkController;
import com.wt.app.normalUsers.NormalUsersLoginOkController;

/**
 * Servlet implementation class AdminFrontController
 */
public class UsersFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UsersFrontController() {
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
		System.out.println("현재 경로 : " + target);

		Result result = new Result();

		switch (target) {

//		case "/users/login.us":
//			System.out.println("일반/돌봄 로그인 페이지 요청");
//			result = new UsersLoginController.Execute(request, response);
//			break;
		
		case "/users/Normaljoin.us":
			System.out.println("일반회원 회원가입 처리 요청");
			request.getRequestDispatcher("/app/sign/terms.jsp").forward(request, response);
			break;

		case "/care/Carejoin.us":
			System.out.println("돌봄회원 회원가입 처리 요청");
			request.getRequestDispatcher("/app/sign/terms.jsp").forward(request, response);
			break;
			
			
		case "/cares/CarejoinOk.us":
			System.out.println("돌봄회원 회원가입 성공시");
			result = new CareJoinOkController().Execute(request, response);
			break;

		case "/normal/NormaljoinOk.us":
			System.out.println("일반회원 회원가입 성공시");
			result = new NormalJoinOkController().Execute(request, response);
			break;
			
		case "/users/login.us":
			System.out.println("일반/돌봄 로그인 페이지 요청");
			result = new UsersLoginController().Execute(request, response);
			System.out.println("리절트");
			break;
			
		case "/normal/loginOk.us":
			System.out.println("일반 로그인 처리 요청");
			result = new NormalUsersLoginOkController().Execute(request, response);
			break;
			
		case "/cares/loginOk.us":
			System.out.println("돌봄 로그인 처리 요청");
			result = new careUsersLoginOkController().Execute(request, response);
			break;

			
		case "/users/logoutOk.us":
			System.out.println("로그아웃 처리 요청");
			result = new UsersLogoutController().Execute(request, response);
			break;

		

		

		case "/member/sendSMS.me":
			System.out.println("핸드폰 인증 요청");
			break;
		case "/member/verifyCode.me":
			System.out.println("인증번호 확인 요청");
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
