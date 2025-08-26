package com.wt.app.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;

public class SubwayListController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();

		result.setPath("/subway/subwayList.sw");
		result.setRedirect(false);
		return result;

	}

}
