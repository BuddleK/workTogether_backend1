package com.wt.app.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Result;
import com.wt.app.careMyPage.CareExitController;
import com.wt.app.careMyPage.CareMarkController;
import com.wt.app.careMyPage.CareMatchingController;
import com.wt.app.careMyPage.CarePointreturnController;
import com.wt.app.careMyPage.CarePostController;
import com.wt.app.careMyPage.CareProfileController;
import com.wt.app.careMyPage.CarePwCheckController;
import com.wt.app.careMyPage.CarePwCheckOkController;
import com.wt.app.careMyPage.CareReferenceController;

/**
 * Servlet implementation class MainFrontController
 */
public class MainFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainFrontController() {
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
		System.out.println("PostsFrontController 현재 경로 : " + target);
		Result result = new Result();
		switch(target) {
		case "/main.main":
			System.out.println("메인 페이지 요청");
			result = new MainController().execute(request, response);
			System.out.println(result);
			break;
		case "/mainOk.main":
			System.out.println("메인 페이지 처리 요청");
			result = new MainOkController().execute(request, response);
			System.out.println(result);
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
