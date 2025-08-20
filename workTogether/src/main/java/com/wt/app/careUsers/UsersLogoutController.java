package com.wt.app.careUsers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;

public class UsersLogoutController implements Execute{

	@Override
	public Result Execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Result result = new Result();
		request.getSession().invalidate(); // 세션 무효화
		result.setPath("/login/login.us");
		result.setRedirect(true);
		return result;
	}
	
}
