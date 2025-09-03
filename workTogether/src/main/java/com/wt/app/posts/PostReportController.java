package com.wt.app.posts;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
		
//		HttpSession session = request.getSession();
//		Integer memberNumber = (Integer)session.getAttribute("memberNumber");
		
		Integer memberNumber = (Integer)request.getSession().getAttribute("memberNumber");
		int authorNumber = Integer.parseInt(request.getParameter("postsUsersNumber"));
		int postNumber = Integer.parseInt(request.getParameter("postsNumber"));
		
		System.out.println("===============신고컨트롤~~~================");

		System.out.println("memberNumber : " + memberNumber);
		System.out.println("authorNumber : " + authorNumber);
		System.out.println("postNumber : " + postNumber);
		
		if(memberNumber == null) {
			System.out.println("오류 : 로그인 된 사용자가 없습니다");
			response.sendRedirect("/app/login/loginNormal.jsp");
			return null;
		}
		
		if((int)memberNumber == authorNumber) {
			System.out.println("자기가 쓴 글은 신고할 수 없음");
			response.sendRedirect("/post/postReadOk.po?postsNumber=" + request.getParameter("postsNumber"));
			return null;
		}
		
		Map<String, Integer> reportMap = new HashMap<>();
		reportMap.put("postsNumber", postNumber);
		reportMap.put("usersNumber", authorNumber);
		
		int reCount = postsDAO.checkReport(reportMap);
		
		System.out.println("신고 수 : " + reCount);
		
		
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
