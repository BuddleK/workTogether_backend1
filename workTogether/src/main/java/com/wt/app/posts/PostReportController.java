package com.wt.app.posts;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.dto.PostsDTO;
import com.wt.app.posts.dao.PostsDAO;

public class PostReportController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PostsDAO postsDAO = new PostsDAO();
		PostsDTO postsDTO = new PostsDTO();
		Result result = new Result();
		HttpSession session = request.getSession();
		Integer memberNumber = (Integer)session.getAttribute("memberNumber");
		
		System.out.println("===============신고컨트롤~~~================");
		
		
		//신고를 한 상태인지 확인해야 함
		//DAO에 신고여부 확인 함수 추가 필요
		
		//신고가 안 되어 있다면~~~~~
		// 신고 테이블에 신고 행 추가, 게시글 신고 수 업데이트.
		
		
//		String title = request.getParameter("postTitle");
//		String context = request.getParameter("postContext");
//		int number = Integer.valueOf(request.getParameter("postNumber"));
//		
//		System.out.println("수정한 제목 : " + title + ", 내용 : " + context);
//		
//		postsDTO.setPostsNumber(number);
//		postsDTO.setPostsTitle(title);
//		postsDTO.setPostsContent(context);
//		
//		postsDAO.update(postsDTO);
		
		result.setPath("/post/postReadOk.po?postsNumber=" + request.getParameter("postsNumber"));
		return result;
	}
	
}
