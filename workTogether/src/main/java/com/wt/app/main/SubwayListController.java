package com.wt.app.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.subway.dao.SubwayDAO;

public class SubwayListController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response) {
		SubwayDAO subwayDAO = new SubwayDAO();
		Result result = new Result();
		
		

		result.setPath("/app/subway/subway.jsp");
		result.setRedirect(false);
		return result;

	}

}
