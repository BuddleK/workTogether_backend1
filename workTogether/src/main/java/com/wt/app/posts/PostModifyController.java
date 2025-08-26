package com.wt.app.posts;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.posts.dao.PostsDAO;

public class PostModifyController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int postsNumber = Integer.valueOf(request.getParameter("postsNumber"));
		PostsDAO postsDAO = new PostsDAO();
		Result result = new Result();
		
		request.setAttribute("post", postsDAO.select(postsNumber));
		
		result.setPath("/app/post/postModify.jsp");
		result.setRedirect(false);
			
		return result;
	}
	

}
