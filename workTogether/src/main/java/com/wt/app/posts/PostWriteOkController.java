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
		//로그인한 사용자 번호 가져오기
		Integer usersNumber = (Integer) request.getSession().getAttribute("usersNumber");
		System.out.println("로그인 한 멤버 번호 : " + usersNumber);
		
		if(usersNumber == null) {
			System.out.println("오류 : 로그인 된 사용자가 없습니다");
			response.sendRedirect("/app/login/loginNormal.jsp");
			return null;
		}
		
		
		String title = request.getParameter("postTitle");
		String context = request.getParameter("postContext");
		
		System.out.println(title + " 잘 나오나!!!!??");
		
		postsDTO.setUsersNumber(usersNumber);
		postsDTO.setPostsTitle(title);
		postsDTO.setPostsContent(context);
		
		postsDAO.insertPosts(postsDTO);
		
		result.setPath("/post/postMain.po");
		result.setRedirect(false);
		
		
		return result;
	}
	
}
