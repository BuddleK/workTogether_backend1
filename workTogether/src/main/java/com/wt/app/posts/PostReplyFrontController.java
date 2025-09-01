package com.wt.app.posts;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Result;

/**
 * Servlet implementation class PostReplyFrontController
 */
public class PostReplyFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostReplyFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
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
		String target = request.getRequestURI().substring(request.getContextPath().length());
		System.out.println(target);
		Result result = new Result();

		switch (target) {
		case "/reply/postReplyWriteOk.re":
			System.out.println("댓글 작성 컨트롤러 진입");
			result = new PostReplyWriteOkController().execute(request, response);
			break;

		case "/reply/postReplyListOk.re":
			System.out.println("댓글 목록 컨트롤러 진입");
			result = new PostReplyListOkController().execute(request, response);
			break;
		case "/reply/postReplyDeleteOk.re":
		    System.out.println("댓글 삭제 컨트롤러 진입");
		    result = new PostReplyDeleteOkController().execute(request, response);
		    break;

		case "/reply/postReplyUpdateOk.re":
		    System.out.println("댓글 수정 컨트롤러 진입");
		    result = new PostReplyUpdateOkController().execute(request, response);
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
