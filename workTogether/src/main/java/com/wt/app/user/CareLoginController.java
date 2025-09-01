package com.wt.app.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;

public class CareLoginController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("돌봄 로그인 컨트롤러 페이지 이동");
		Result result = new Result();
		result.setRedirect(false);
		result.setPath("/app/login/loginCare.jsp");
		return result;
	}
}
