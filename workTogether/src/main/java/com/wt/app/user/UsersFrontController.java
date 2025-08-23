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

		  // ===== 회원가입(일반) =====
        case "/users/joinNormal.us":
            System.out.println("일반회원 가입 페이지 요청");
            request.getRequestDispatcher("/app/sign/signNormal.jsp").forward(request, response);
            return;

        case "/users/joinNormalOk.us":
            System.out.println("일반회원 가입 처리 요청");
            result = new NormalJoinOkController().Execute(request, response);
            break;

        // ===== 회원가입(돌봄) =====
        case "/users/joinCare.us":
            System.out.println("돌봄회원 가입 페이지 요청");
            request.getRequestDispatcher("/app/sign/signCare.jsp").forward(request, response);
            return;

        case "/users/joinCareOk.us":
            System.out.println("돌봄회원 가입 처리 요청");
            result = new CareJoinOkController().Execute(request, response);
            break;

        // ===== 로그인/로그아웃 =====
        case "/users/login.us":
            System.out.println("로그인 페이지 요청");
            result = new LoginController().Execute(request, response); // /app/login/login.jsp 로 포워드
            break;

        case "/users/loginOk.us":
            System.out.println("로그인 처리 요청");
            result = new LoginOkController().Execute(request, response); // 대문자 E
            break;

        case "/users/logoutOk.us":
            System.out.println("로그아웃 처리 요청");
            result = new LogoutOkController().Execute(request, response);
            break;

        // ===== 아이디 중복 =====
        case "/users/checkIdOk.us":
            System.out.println("아이디 중복 확인 요청");
            result = new CheckIdOkController().Execute(request, response);
            break;

        // ===== 아이디 찾기 =====
        case "/users/findId.us":
            System.out.println("아이디 찾기 페이지 요청");
            request.getRequestDispatcher("/app/login/findId.jsp").forward(request, response);
            return;

        case "/users/findIdOk.us":
            System.out.println("아이디 찾기 처리 요청");
            result = new FindIdOkController().Execute(request, response);
            break;

        // ===== 비밀번호 찾기/변경 =====
        case "/users/findPw.us":
            System.out.println("비밀번호 찾기 페이지 요청");
            request.getRequestDispatcher("/app/login/findPassword.jsp").forward(request, response);
            return;

        case "/users/findPwOk.us":
            System.out.println("비밀번호 찾기 처리 요청");
            result = new FindPwOkController().Execute(request, response);
            break;

        case "/users/updatePwOk.us":
            System.out.println("새 비밀번호 저장 요청");
            result = new UpdatePwOkController().Execute(request, response);
            break;

        // ===== 6자리 인증번호 / 우편번호 =====
        case "/users/sendSMS.us":
			System.out.println("핸드폰 인증 요청");
			break;
		
        case "/users/verifyCode.us":
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
