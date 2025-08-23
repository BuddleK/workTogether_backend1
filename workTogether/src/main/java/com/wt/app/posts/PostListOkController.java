package com.wt.app.posts;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;

public class PostListOkController implements Execute {

	@Override
	public Result Execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("====postListOkController 실행====");
		Result result = new Result();
		result.setPath("/app/post/postMain.jsp");
		result.setRedirect(false);
		
		return result;
	}
	
}
