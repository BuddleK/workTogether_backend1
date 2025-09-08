package com.wt.app.posts;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.dto.PostsListDTO;
import com.wt.app.posts.dao.PostsDAO;

public class PostListOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("====postListOkController 실행====");
		PostsDAO postsDAO = new PostsDAO();
		Result result = new Result();
		
		//방금 선택한 페이지
		String temp = request.getParameter("page");
		//선택한 페이지 번호가 null이면 1을 넣어줌
		int page = (temp == null) ? 1 : Integer.valueOf(temp);
		//보여줄 행 수
		int rowCount = 10;
		//보여줄 페이지 숫자 수
		int pageCount = 4;
		
		//시작 행 번호
		int startRow = (page - 1) * rowCount + 1;
		//끝 행 번호
		int endRow = startRow + rowCount - 1;
		
		Map<String, Integer> pageMap = new HashMap<>();
		pageMap.put("startRow", startRow);
		pageMap.put("endRow", endRow);
		
		List<PostsListDTO> postsList = postsDAO.selectAll(pageMap);
		request.setAttribute("postsList", postsList);
		
		int total = postsDAO.getTotal();
		int realEndPage = (int) Math.ceil(total / (double) rowCount);
		int endPage = (int) (Math.ceil(page/(double) pageCount) * pageCount);
		int startPage = endPage - (pageCount - 1);
		
		endPage = Math.min(endPage, realEndPage);
		
		boolean prev = startPage > 1;
		boolean next = endPage < realEndPage;
		
		request.setAttribute("page", page);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("prev", prev);
		request.setAttribute("next", next);
		
		System.out.println("====페이징정보 확인====");
		System.out.println("pageMap : " + pageMap);
		System.out.println("postsList : " + postsList);
		System.out.println("startPage : " + startPage + ", endPage : " + endPage + ", prev : " + prev + ", next : " + next);
		System.out.println("====================");
		
		result.setPath("/app/post/postMain.jsp");
		result.setRedirect(false);
		
		
		return result;
	}
	
}
