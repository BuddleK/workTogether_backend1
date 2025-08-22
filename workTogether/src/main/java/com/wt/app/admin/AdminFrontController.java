package com.wt.app.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Result;
import com.wt.app.news.AdminNewsDeleteOkController;
import com.wt.app.news.AdminNewsListOkController;
import com.wt.app.news.AdminNewsReadOkController;
import com.wt.app.news.AdminNewsUpdateController;
import com.wt.app.news.AdminNewsUpdateOkController;
import com.wt.app.news.AdminNewsWriteController;
import com.wt.app.news.AdminNewsWriteOkController;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String target = request.getRequestURI().substring(request.getContextPath().length());
		System.out.println("현재경로 : " + target);
		Result result = new Result();
		
		switch (target) {
		case "/admin/login.ad":
			System.out.println("관리자 로그인페이지 요청");
			request.getRequestDispatcher("/app/admin/adminLogin.jsp").forward(request, response);
			result = new AdminLoginController().Execute(request, response);
			break;
		case "/admin/loginOk.ad":
			System.out.println("관리자 로그인 처리 요청");
			request.getRequestDispatcher("/app/admin/userManager.jsp").forward(request, response);
			result = new AdminLoginOkController().Execute(request, response);
			break;
		case "/admin/logoutOk.ad":
			System.out.println("관리자 로그아웃 처리 요청");
			result = new AdminLogoutController().Execute(request, response);
			break;
			
		case "/admin/news/newsListOk.ad":
            System.out.println("뉴스 목록 처리 요청");
            result = new AdminNewsListOkController().Execute(request, response);
            System.out.println(result);
            break;

        case "/admin/news/newsReadOk.ad":
            System.out.println("뉴스 상세 페이지 처리 요청");
            result = new AdminNewsReadOkController().Execute(request, response);
            break;

        case "/admin/news/newsWrite.ad":
            System.out.println("뉴스 작성 페이지 이동 요청");
            result = new AdminNewsWriteController().Execute(request, response);
            break;

        case "/admin/news/newsWriteOk.ad":
            System.out.println("뉴스 작성 완료 요청");
            result = new AdminNewsWriteOkController().Execute(request, response);
            break;

        case "/admin/news/newsDeleteOk.ad":
            System.out.println("뉴스 삭제 완료 요청");
            result = new AdminNewsDeleteOkController().Execute(request, response);
            break;

        case "/admin/news/newsUpdate.ad":
            System.out.println("뉴스 수정 페이지 이동 요청");
            result = new AdminNewsUpdateController().Execute(request, response);
            break;

        case "/admin/news/newsUpdateOk.ad":
            System.out.println("뉴스 수정 완료 요청");
            result = new AdminNewsUpdateOkController().Execute(request, response);
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
