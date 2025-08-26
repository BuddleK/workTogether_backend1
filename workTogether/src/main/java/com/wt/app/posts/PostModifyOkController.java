package com.wt.app.posts;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.dto.PostsDTO;
import com.wt.app.posts.dao.PostsDAO;

public class PostModifyOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PostsDAO postsDAO = new PostsDAO();
		PostsDTO postsDTO = new PostsDTO();
		Result result = new Result();
		
		System.out.println("===============수정오케이컨트롤러~~~================");
		
		String title = request.getParameter("postTitle");
		String context = request.getParameter("postContext");
		
		System.out.println("수정한 제목 : " + title + ", 내용 : " + context);
		
		postsDAO.update(postsDTO);
		
		result.setPath("/post/postReadOk.po?postsNumber=" + request.getParameter("postNumber"));
		return result;
	}
	
}
