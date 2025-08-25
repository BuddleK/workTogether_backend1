package com.wt.app.comment;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Result;

/**
 * Servlet implementation class FavoriteFrontController
 */
public class CommentFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentFrontController() {
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
		System.out.println(target);
		Result result = new Result();

		switch (target) {
		
		case "/comment/commentListOk.co":
			System.out.println("댓글 목록 컨트롤러 진입");
			result = new CommentListOkController().Execute(request, response);
			break;
		
		case "/comment/commentWriteOk.co":
			System.out.println("댓글 작성 컨트롤러 진입");
			result = new CommentWriteOkController().Execute(request, response);
			break;

		
//		case "/comment/commentDeleteOk.co":
//		    System.out.println("댓글 삭제 컨트롤러 진입");
//		    result = new CommentDeleteOkController().execute(request, response);
//		    break;
//
//		case "/comment/commentUpdateOk.co":
//		    System.out.println("댓글 수정 컨트롤러 진입");
//		    result = new CommentUpdateOkController().execute(request, response);
//		    break;
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
