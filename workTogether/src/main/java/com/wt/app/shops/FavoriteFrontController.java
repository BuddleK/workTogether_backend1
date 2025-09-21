package com.wt.app.shops;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.wt.app.Result;

/**
 * Servlet implementation class FavoriteFrontController
 */
public class FavoriteFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FavoriteFrontController() {
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
		case "/favorite/favoriteOk.fa":
			System.out.println("찜 상태 컨트롤러 진입");
			result = new FavoriteOkController().execute(request, response);
			break;
		
		case "/favorite/favoriteAddOk.fa":
			System.out.println("찜 추가 컨트롤러 진입");
			result = new AddFavoriteOkController().execute(request, response);
			break;

		case "/favorite/favoriteDeleteOk.fa":
		    System.out.println("찜 삭제 컨트롤러 진입");
		    result = new CancleFavoriteOKController().execute(request, response);
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
