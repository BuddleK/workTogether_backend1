package com.wt.app.careMyPage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.users.dao.UsersDAO;

public class CarePwCheckController implements Execute{
	@Override
	public Result Execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		UsersDAO usersDAO = new UsersDAO();
		Result result = new Result();
		HttpSession session = request.getSession();
		
		String usersPassword = request.getParameter("usersPassword");
		Integer usersNumber = (Integer) session.getAttribute("usersNumber");
		
		
		
		return result;
	}	
}
