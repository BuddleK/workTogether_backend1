package com.wt.app.careMyPage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.careMyPage.dao.CarePwCheckDAO;

public class CarePwCheckOkController implements Execute {

	@Override
	public Result Execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Result result = new Result();

		CarePwCheckDAO carePwCheckDAO = new CarePwCheckDAO(); 
		
		HttpSession session = request.getSession();
		Integer usersNumber = (Integer) session.getAttribute("usersNumber");
		
        String usersPassword = request.getParameter("usersPassword");
        
        int pwCheck = carePwCheckDAO.checkPw(usersNumber, usersPassword);
		
		if(pwCheck == 1) {
			result.setPath("/myPageCare/careProfile.cp");
			result.setRedirect(false);
		}else {
			result.setPath("/myPageCare/carePwCheck.cp");
            result.setRedirect(false);
		}
		
		return result;
	}

}
