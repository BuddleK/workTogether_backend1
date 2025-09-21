package com.wt.app.careList;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Result;

/**
 * Servlet implementation class AdminFrontController
 */
public class CareListFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CareListFrontController() {
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
			throws ServletException, IOException {
		String target = request.getRequestURI().substring(request.getContextPath().length());
		System.out.println("CareListFrontController 현재 경로 : " + target);
		Result result = new Result();
		
		switch (target) {
		case "/careList/careListOk.cl":
			System.out.println("돌봄 목록 처리 요청");
			// 임시로 이동처리
			result = new CareListOkController().execute(request, response);
			System.out.println(result);
			break;
		case "/careList/careListDetailOk.cl" : 
			System.out.println("돌봄 세부 페이지 처리 요청");
			result = new CareListDetailOkController().execute(request, response);
			break;
		case "/careList/careSendMsgOk.cl" : 
			System.out.println("쪽지 페이지 처리 요청");
			result = new CareListSendMsgOkController().execute(request, response);
			break;
		case "/careList/careListSearchOk.cl" : 
			System.out.println("쪽지 페이지 처리 요청");
			result = new CareListSearchOkController().execute(request, response);
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
