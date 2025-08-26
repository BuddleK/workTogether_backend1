package com.wt.app.posts;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.posts.dao.PostsDAO;

public class PostWriteController implements Execute{

	@Override
	public Result Execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("==============PostWriteController 진입============");
		
		PostsDAO postsDAO = new PostsDAO();
		Result result = new Result();
		HttpSession session = request.getSession();
		Integer memberNumber = (Integer)session.getAttribute("memberNumber");
		String path = null;
		
		if(memberNumber == null) {
			path = "/app/login/login.jsp";
		}else {
			path = "/app/post/postWrite.jsp";
			request.setAttribute("userId", "writeTest01");
		}
		
		path = "/app/post/postWrite.jsp";
		request.setAttribute("userId", "writeTest01");
		
		result.setPath(path);
		result.setRedirect(false);
		
		return result;
	}
	

}
