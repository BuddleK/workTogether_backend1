package com.wt.app.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.dto.UsersDTO;
import com.wt.app.user.dao.UserDAO;

public class UsersJoinOkController implements Execute{

	@Override
	public Result Execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		UsersDTO usersDTO = new UsersDTO();
		UserDAO usersDAO = new UserDAO();
		Result result = new Result();

		request.setCharacterEncoding("UTF-8");
		//공통 으로 들어가는 것들
		usersDTO.setUsersType(request.getParameter("usersType")); //n or c
		usersDTO.setUsersType(request.getParameter("usersId"));
		usersDTO.setUsersType(request.getParameter("usersName"));
		usersDTO.setUsersType(request.getParameter("usersPassword"));
		usersDTO.setUsersType(request.getParameter("usersEmail"));
		usersDTO.setUsersType(request.getParameter("usersPhone"));
		usersDTO.setUsersType(request.getParameter("usersPostalCode"));
		usersDTO.setUsersType(request.getParameter("usersAddressLine1"));
		usersDTO.setUsersType(request.getParameter("usersAddressLine2"));
		
		//일반
		
		
		return null;
	}
	

	
	
	
}
