package com.wt.app.careMyPage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Result;

/**
 * Servlet implementation class CareMyPageFrontController
 */
@MultipartConfig
public class CareMyPageFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CareMyPageFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String target = request.getRequestURI().substring(request.getContextPath().length());
		System.out.println("CareModifyFrontController 현재 경로 : " + target);
		Result result = new Result();
		switch(target) {
		case "/myPageCare/carePwCheck.cp":
			System.out.println("비밀번호 확인 페이지 요청");
			result = new CarePwCheckController().execute(request, response);
			break;
		case "/myPageCare/carePwCheckOk.cp":
			System.out.println("비밀번호 확인 페이지 처리 요청");
			result = new CarePwCheckOkController().execute(request, response);
			break;
		case "/myPageCare/careProfile.cp":
			System.out.println("프로필 수정 페이지 요청");
			result = new CareProfileController().execute(request, response);
			break;
		case "/myPageCare/careProfileUpdate.cp":
			System.out.println("프로필 수정 요청");
			result = new CareProfileUpdateController().execute(request, response);
			break;
		case "/myPageCare/careModify.cp":
			System.out.println("개인정보 수정 페이지 요청");
			result = new CareModifyController().execute(request, response);
			break;
		case "/myPageCare/careMark.cp":
			System.out.println("찜한목록 페이지 요청");
			result = new CareMarkController().execute(request, response);
			break;
		case "/myPageCare/careMatching.cp":
			System.out.println("매칭기록 페이지 요청");
			result = new CareMatchingController().execute(request, response);
			break;
		case "/myPageCare/careMesseage.cp":
			System.out.println("쪽지함 페이지 요청");
			result = new CareMesseageController().execute(request, response);
			break;
		case "/myPageCare/carePost.cp":
			System.out.println("게시글 관리 페이지 요청");
			result = new CarePostController().execute(request, response);
			break;
		case "/myPageCare/carePointreturn.cp":
			System.out.println("포인트 환급 페이지 요청");
			result = new CarePointreturnController().execute(request, response);
			break;
		case "/myPageCare/careReference.cp":
			System.out.println("1대1문의 페이지 요청");
			result = new CareReferenceController().execute(request, response);
			break;
		case "/myPageCare/careExit.cp":
			System.out.println("회원탈퇴 페이지 요청");
			result = new CareExitController().execute(request, response);
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
