package com.wt.app.careMyPage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;

public class CareMesseageController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Result result = new Result();

		result.setPath("/app/myPageCare/careMessage.jsp");
		result.setRedirect(false);
		return result;
	}

}
