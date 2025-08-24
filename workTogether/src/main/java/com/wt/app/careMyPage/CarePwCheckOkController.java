package com.wt.app.careMyPage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;

public class CarePwCheckOkController implements Execute {

	@Override
	public Result Execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Result result = new Result();

		CarePwcheckDAO carePwCheckDAO = new CarePwCheckDAO(); 
		
		HttpSession session = request.getSession();
		Integer usersNumber = (Integer) session.getAttribute("usersNumber");
		
		
		
		
		
		result.setPath("/app/myPageCare/careProfile.jsp");
		result.setRedirect(false);
		return result;
	}

}
