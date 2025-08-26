package com.wt.app.report;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.shops.dao.ShopsDAO;

public class ReportOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ShopsDAO shopsDAO = new ShopsDAO();
		Result result = new Result();
		
		
		
		return result;
	}

}
