package com.wt.app.normal.mypage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;

public class NormalHeartListDeleteOkController implements Execute{

	@Override
	public Result Execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Result result = new Result();

		result.setPath("/admin/normalHeartListDeleteOk.mn");
        result.setRedirect(false);
        return result;
	}
	
}
