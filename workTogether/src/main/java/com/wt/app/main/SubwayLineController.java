package com.wt.app.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;

public class SubwayLineController implements Execute {

	@Override
	public Result Execute(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();

		result.setPath("/subway/subway.jsp");
		result.setRedirect(false);
		return result;

	}

}
