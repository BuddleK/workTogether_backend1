package com.wt.app.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.main.dao.MainDAO;

public class MainController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MainDAO mainDAO = new MainDAO();
		Result result = new Result();
		
		
		
		result.setPath("/app/Main.jsp");
		result.setRedirect(false);
		return result;
	}

}	
