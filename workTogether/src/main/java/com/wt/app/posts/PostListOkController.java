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
	public Result Execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("====postListOkController 실행====");
		System.out.println("여기가 문젠가1");
		PostsDAO postsDAO = new PostsDAO();
		System.out.println("여기가 문젠가2");
		Result result = new Result();
		
		
		String temp = request.getParameter("page");
		int page = (temp == null) ? 1 : Integer.valueOf(temp);
		int rowCount = 10;
		int pageCount = 5;
		
		int startRow = (page - 1) * rowCount + 1;
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
		System.out.println("boardList : " + postsList);
		System.out.println("startPage : " + startPage + ", endPage : " + endPage + ", prev : " + prev + ", next : " + next);
		System.out.println("====================");
		
		result.setPath("/app/post/postMain.jsp");
		result.setRedirect(false);
		
		System.out.println("잘... 가져왔으려나");
		
		return result;
	}
	
}
