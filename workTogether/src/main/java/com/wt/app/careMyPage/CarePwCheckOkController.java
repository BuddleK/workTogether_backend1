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
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Result result = new Result();
		HttpSession session = request.getSession();
		CarePwCheckDAO carePwCheckDAO = new CarePwCheckDAO();
		
		Integer usersNumber = (Integer) session.getAttribute("usersNumber");
		String inputPassword = request.getParameter("usersPassword");
		boolean pwCheck = false;
		
		System.out.println("123");
		pwCheck = carePwCheckDAO.checkPw(usersNumber, inputPassword);
		System.out.println("456");
		
		if(pwCheck) {
			System.out.println("성공");
            result.setPath("/myPageCare/careProfile.cp");
            result.setRedirect(true);
        } else {
        	System.out.println("실패");
        	request.setAttribute("pwCheck", false);
            result.setPath("/myPageCare/carePwCheck.cp");
            result.setRedirect(false);
            request.setAttribute("errorMessage", "비밀번호가 올바르지 않습니다.");
        }

		return result;
	}

}
