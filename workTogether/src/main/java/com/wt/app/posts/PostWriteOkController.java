package com.wt.app.posts;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.reflection.SystemMetaObject;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.dto.PostsDTO;
import com.wt.app.posts.dao.PostsDAO;

public class PostWriteOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("==============PostWriteOkController 진입============");

		PostsDAO postsDAO = new PostsDAO();
		PostsDTO postsDTO = new PostsDTO();
		Result result = new Result();
		
//		Integer memberNumber = (Integer)request.getSession().getAttribute("memberNumber");
//		Integer memberNumber = (Integer)request.getAttribute("memberNumber");
		Integer memberNumber = (Integer)40;
		
		System.out.println("memberNumber : " + memberNumber);
		
		if(memberNumber == null) {
			System.out.println("오류 : 로그인 왼 사용자가 없습니다");
			response.sendRedirect("/app/login/login.jsp");
			return null;
		}
		
		
		String title = request.getParameter("postTitle");
		String context = request.getParameter("postContext");
		
		System.out.println(title + " 잘 나오나!!!!??");
		
		postsDTO.setUsersNumber(memberNumber);
		postsDTO.setPostsTitle(title);
		postsDTO.setPostsContent(context);
		
		postsDAO.insertPosts(postsDTO);
		
		result.setPath("/post/postMain.po");
		result.setRedirect(false);
		
		
		return result;
	}
	
}
