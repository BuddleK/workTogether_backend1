package com.wt.app.careMyPage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.careMyPage.dao.CareMarkDAO;

public class CareMarkOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CareMarkDAO careMarkDAO = new CareMarkDAO();
		Result result = new Result();

		HttpSession session = request.getSession();
		// 로그인 한 회원 정보 가져오기
		Integer usersNumber = (Integer) request.getSession().getAttribute("usersNumber");
		
		String usersPfavoritesNumberassword = request.getParameter("favoritesNumber");
		String favoritesShopsNumber = request.getParameter("favoritesShopsNumber");
		String favoritesCreatedDate = request.getParameter("favoritesCreatedDate");
		String shopsName = request.getParameter("shopsName");
		String shopsRoadAddress = request.getParameter("shopsRoadAddress");
		String shopsPhone = request.getParameter("shopsPhone");
		
		

		result.setPath("/myPageCare/careMark.cp");
		result.setRedirect(true);
		return result;
	}
	
}
