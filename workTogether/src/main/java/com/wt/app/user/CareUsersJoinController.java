package com.wt.app.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.user.dao.UserDAO;

public class CareUsersJoinController implements Execute{

	@Override
	public Result Execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String usersType = request.getParameter("usersType");
		String usersId = request.getParameter("usersId");
		String usersEmail = request.getParameter("usersEmail");
		
		UserDAO userDAO = new UserDAO();
		
		if (!userDAO.checkId(usersId)) {
		      Result result = new Result();
		      result.setRedirect(true);
		      result.setPath(request.getContextPath() + ( "C".equalsIgnoreCase(usersType)
		          ? "/users/joinCare.us?error=id"
		          : "/users/joinNormal.us?error=id"));
		      return result;
		    }
		    if (!userDAO.checkEmail(usersEmail)) {
		      Result result = new Result();
		      result.setRedirect(true);
		      result.setPath(request.getContextPath() + ( "C".equalsIgnoreCase(usersType)
		          ? "/users/joinCare.us?error=email"
		          : "/users/joinNormal.us?error=email"));
		      return result;
		    }
		return null;
	}

}
