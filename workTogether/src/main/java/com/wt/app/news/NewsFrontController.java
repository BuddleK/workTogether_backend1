package com.wt.app.news;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Result;
import com.wt.app.posts.PostListOkController;
import com.wt.app.posts.PostReadOkController;

/**
 * Servlet implementation class NewsFrontController
 */
@WebServlet("/NewsFrontController")
public class NewsFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsFrontController() {
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
		
		String target = request.getRequestURI().substring(request.getContextPath().length());
		System.out.println("NewsFrontController 현재 경로 : " + target);
		Result result = new Result();
		
		switch(target) {
		case "/news/newsMain.ne"://예시
			System.out.println("뉴스 페이지 요청");
//임시		request.getRequestDispatcher("/app/post/post.jsp").forward(request, response);
			result = new NewsListOkController().execute(request, response);
			System.out.println(result);
			break;
			
		case "/news/newsAllList.ne":
			System.out.println("뉴스 전체 페이지 요청");
			result = new NewsAllListController().execute(request, response);
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
