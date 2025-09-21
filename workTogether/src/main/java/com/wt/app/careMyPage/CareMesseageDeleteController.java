package com.wt.app.careMyPage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;

public class CareMesseageDeleteController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("======CareMarkDeleteController======");
		System.out.println("삭제~");
		Result result = new Result();
		
		
		result.setPath("/myPageCare/careMesseage.cp");
		//result.setRedirect(false);
		return result;
	}
}
