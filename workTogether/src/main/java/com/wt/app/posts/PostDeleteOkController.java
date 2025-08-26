package com.wt.app.posts;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;

public class PostDeleteOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Result result = new Result();
        System.out.println("===============삭제오케이컨트롤러 진입================");
        int postsNumber = Integer.valueOf(request.getParameter("postsNumber"));
        
        System.out.println("0의 valueOf는? " + Integer.valueOf(null));
        
        result.setPath("/post/postMain.po");
		return null;
	}
	
}
