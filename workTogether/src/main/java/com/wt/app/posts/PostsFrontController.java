package com.wt.app.posts;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.wt.app.Result;

/**
 * Servlet implementation class AdminFrontController
 */
public class PostsFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostsFrontController() {
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
		case "/post/postAlimDetail.po"://예시
			System.out.println("공지사항 디테일 페이지요청");
//임시		request.getRequestDispatcher("/app/post/postMain.jsp").forward(request, response);
			result = new PostAlimDetailController().execute(request, response);
			System.out.println(result);
			break;
		case "/post/postMain.po"://예시
			System.out.println("게시물 목록 페이지 요청");
//임시		request.getRequestDispatcher("/app/post/postMain.jsp").forward(request, response);
			result = new PostListOkController().execute(request, response);
			System.out.println(result);
			break;
		case "/post/postReadOk.po":
			System.out.println("게시글 상세 페이지 처리 요청");
//임시		request.getRequestDispatcher("/app/post/postDetaillogin.jsp").forward(request, response);
			result = new PostReadOkController().execute(request, response);
			break;
		case "/post/postWrite.po":
			System.out.println("게시글 작성 페이지 이동 요청");
//			request.getRequestDispatcher("/app/post/postWrite.jsp").forward(request, response);
			result = new PostWriteController().execute(request, response);
			break;
		case "/post/postWriteOk.po":
			System.out.println("게시글 작성 완료 요청");
//			request.getRequestDispatcher("/app/post/postMain.jsp").forward(request, response);
			result = new PostWriteOkController().execute(request, response);
			break;
		case "/post/postUpdate.po":
			System.out.println("게시글 수정 페이지 이동 요청");
//			request.getRequestDispatcher("/app/post/postModify.jsp").forward(request, response);
			result = new PostModifyController().execute(request, response);
			break;
		case "/post/postUpdateOk.po":
			System.out.println("게시글 수정 완료 요청");
//			request.getRequestDispatcher("/app/post/postMain.jsp").forward(request, response);
			result = new PostModifyOkController().execute(request, response);
			break;
		case "/post/postDeleteOk.po":
			System.out.println("게시글 삭제 완료 요청");
//			request.getRequestDispatcher("/app/post/postMain.jsp").forward(request, response);
			result = new PostDeleteOkController().execute(request, response);
			break;
		case "/post/postSearch.po":
			System.out.println("게시글 검색 요청");
			result = new PostSearchOkController().execute(request, response);
			break;
		case "/post/postReport.po":
			System.out.println("게시글 신고 요청");
			result = new PostReportController().execute(request, response);
			break;
		case "/post/postReportCancel.po":
		    System.out.println("게시글 신고 취소 요청");
		    result = new PostReportCancelController().execute(request, response);
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
