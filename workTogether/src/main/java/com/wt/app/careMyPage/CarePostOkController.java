package com.wt.app.careMyPage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.careMyPage.dao.CarePostDAO;

public class CarePostOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CarePostDAO carePostDAO = new CarePostDAO();
		Result result = new Result();

		

		result.setPath("/app/main.jsp");
		result.setRedirect(true);
		return result;
	}

}
