package com.wt.app.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wt.app.Execute;
import com.wt.app.Result;

public class AdminNoticeUpdateController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Result result = new Result();
		
		HttpSession session = request.getSession();
		Integer adminNumber = (Integer)session.getAttribute("adminNumber");
		String path = null;
		
		if(adminNumber == null) {
			path = "/admin/login.ad";
		}else {
			path = "/app/admin/noticeModify.jsp";
		}
		
		
		result.setPath(path);
		result.setRedirect(false);
		
		return result;
		
	}

}
