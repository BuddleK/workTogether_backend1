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
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("==============PostWriteController 진입============");
		
		Result result = new Result();
		HttpSession session = request.getSession();
		Integer memberNumber = (Integer)session.getAttribute("memberNumber");
		String path = null;
		
		if(memberNumber == null) {
			path = "/app/login/loginNormal.jsp";
		}else {
			path = "/app/post/postWrite.jsp";
//			request.setAttribute("userId", postsDAO.get);
		}
		
		System.out.println("멤버넘버~~~!!!" + memberNumber);
		
		
		
		result.setPath(path);
		result.setRedirect(false);
		
		return result;
	}
	

}
