package com.wt.app.careMyPage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.careMyPage.dao.CareMarkDAO;

public class CareMarkOkController implements Execute{

	@Override
	public Result Execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CareMarkDAO careMarkDAO = new CareMarkDAO();
		Result result = new Result();

		

		result.setPath("/myPageCare/careMark.cp");
		result.setRedirect(true);
		return result;
	}
	
}
