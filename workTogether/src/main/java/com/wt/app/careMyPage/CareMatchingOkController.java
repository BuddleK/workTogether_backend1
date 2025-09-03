package com.wt.app.careMyPage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.careMyPage.dao.CareMatchingDAO;

public class CareMatchingOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CareMatchingDAO careMatchingDAO = new CareMatchingDAO();
		Result result = new Result();

		HttpSession session = request.getSession();
		Integer usersNumber = (Integer) session.getAttribute("usersNumber");
		
//		 int matchingAdd = careMatchingDAO.matchingAdd(careMatchingDTO);
		
		
		
		

		result.setPath("/myPageCare/careMatching.cp");
		result.setRedirect(true);
		return result;
	}

}
