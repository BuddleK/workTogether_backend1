package com.wt.app.posts;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;

public class PostSearchOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Result result = new Result();
		
		String keyWord = request.getParameter("keyWord");
		
		System.out.println("keyWord : " + keyWord);
		
		result.setPath("/app/post/postMain.jsp");
		result.setRedirect(false);
		
		return result;
	}
	

}
