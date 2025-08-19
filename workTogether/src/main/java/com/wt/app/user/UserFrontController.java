package com.wt.app.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wt.app.Result;

/**
 * Servlet implementation class AdminFrontController
 */
public class UserFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserFrontController() {
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
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 request.setCharacterEncoding("UTF-8");
	     response.setCharacterEncoding("UTF-8");
	     response.setContentType("text/html; charset=UTF-8");
	     
	     String target = request.getRequestURI().substring(request.getContextPath().length());
	        System.out.println("현재 경로(USER) : " + target);

	        Result result = null;

	        switch (target) {

	            case "/user/join.us":
	                result = new Result();
	                result.setPath("/app/sign/join.jsp"); 
	                result.setRedirect(false);
	                break;

	            case "/user/joinOk.us":
	                if (!"POST".equalsIgnoreCase(request.getMethod())) {
	                    response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
	                    return;
	                }
	                result = new UserJoinOkController().execute(request, response);
	                break;

	            case "/user/login.us":
	                result = new Result();
	                result.setPath("/app/login/login.jsp");
	                result.setRedirect(false);
	                break;

	            case "/user/loginOk.us":
	                if (!"POST".equalsIgnoreCase(request.getMethod())) {
	                    response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
	                    return;
	                }
	                result = new UserLoginOkController().Execute(request, response);
	                break;

	            case "/user/logoutOk.us":
	                HttpSession session = request.getSession(false);
	                if (session != null) session.invalidate();
	                result = new Result();
	                result.setPath(request.getContextPath() + "/index");
	                result.setRedirect(true);
	                break;

	             case "/user/findId.us":
	                 result = new Result();
	                 result.setPath("/app/login/findId.jsp");
	                 result.setRedirect(false);
	                 break;

	             case "/user/findIdOk.us":
	                 if (!"POST".equalsIgnoreCase(request.getMethod())) {
	                     response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
	                     return;
	                 }
	                 result = new UserFindIdOkController().execute(request, response);
	                 break;

	             case "/user/findPassword.us":
	                 result = new Result();
	                 result.setPath("/app/login/findPassworld.jsp");
	                 result.setRedirect(false);
	                 break;

	             case "/user/findPwOk.us":
	                 if (!"POST".equalsIgnoreCase(request.getMethod())) {
	                     response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
	                     return;
	                 }
	                 result = new UserFindPwOkController().execute(request, response);
	                 break;

	             case "/user/findPwCheck.us":
	            	    result = new com.wt.app.user.UserFindPwCheckController().execute(request, response);
	            	    break;


	            default:
	                response.sendError(HttpServletResponse.SC_NOT_FOUND);
	                return;
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
