package com.wt.app.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.admin.dao.AdminTwoDAO;

public class AdminNoticeInsertOkController implements Execute{

	@Override
	public Result Execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		AdminTwoDAO adminTwoDAO = new AdminTwoDAO();
		Result result = new Result();
		
		Integer adminNumber = (Integer)request.getSession().getAttribute("adminNumber");
		
		if(adminNumber == null) {
			System.out.println("로그인된 관리자가 없습니다");
			response.sendRedirect("adminLogin.jsp");
			return null;
		}
		
		
	}
	
}
