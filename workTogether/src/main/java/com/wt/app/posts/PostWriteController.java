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
		//로그인한 사용자 번호 가져오기
		Integer usersNumber = (Integer) request.getSession().getAttribute("usersNumber");
		System.out.println("로그인 한 멤버 번호 : " + usersNumber);
		String path = null;
		
		if(usersNumber == null) {
			path = "/app/login/loginNormal.jsp";
		}else {
			path = "/app/post/postWrite.jsp";
//			request.setAttribute("userId", postsDAO.get);
		}
		
		System.out.println("멤버넘버~~~!!!" + usersNumber);
		
		
		
		result.setPath(path);
		result.setRedirect(false);
		
		return result;
	}
	

}
