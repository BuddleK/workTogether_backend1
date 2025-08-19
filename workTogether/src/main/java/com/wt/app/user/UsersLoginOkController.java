package com.wt.app.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.dto.UsersDTO;
import com.wt.app.user.dao.UserDAO;

public class UsersLoginOkController implements Execute{

	@Override
	public Result Execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		UsersDTO usersDTO = new UsersDTO();
		UserDAO userDAO = new UserDAO();
		Result result = new Result();
		
		usersDTO.setUsersId(request.getParameter("usersId"));
		usersDTO.setUsersPassword(request.getParameter("usersPassword"));
		usersDTO.setUsersType(request.getParameter("usersType"));
		
		int usersNumber = userDAO.loginByType(usersDTO);
		
		if(usersNumber > 0) {
			HttpSession session = request.getSession();
			session.setAttribute("usersNumber", usersNumber);
			session.setAttribute("userId", usersDTO.getUsersId());
			session.setAttribute("usersType", usersDTO.getUsersType());
			
			result.setRedirect(true);
			result.setPath(request.getContextPath() + "main.jsp");
		} else {
			result.setRedirect(true);
			result.setPath(request.getContextPath() + "/app/login/login.jsp");
		}
		
		return result;
	}

}
