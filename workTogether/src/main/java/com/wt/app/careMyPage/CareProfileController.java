package com.wt.app.careMyPage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;

public class CareProfileController implements Execute {

	@Override
	public Result Execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Result result = new Result();
		
		String dayMonday = request.getParameter("dayMonday"); 
		String dayTuesday = request.getParameter("dayTuesday"); 
		String dayWednesday = request.getParameter("dayWednesday"); 
		String dayThursday = request.getParameter("dayThursday"); 
		String dayFriday = request.getParameter("dayFriday"); 
		String daySaturday = request.getParameter("daySaturday"); 
		String daySunday = request.getParameter("daySunday"); 
        String usersPostsalCode = request.getParameter("usersPostsalCode");   
        String usersAddressLine1 = request.getParameter("usersAddressLine1");   
        String usersAddressLine2 = request.getParameter("usersAddressLine2");   
        String careIntroText = request.getParameter("careIntroText");   // 소개글
        String fileName = request.getParameter("file"); 

		result.setPath("/app/myPageCare/careProfile.jsp");
		result.setRedirect(false);
		return result;
	}

}
