package com.wt.app.posts;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.dto.PostsDTO;
import com.wt.app.posts.dao.PostsDAO;

public class PostReadOkController implements Execute {

	@Override
	public Result Execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Result result = new Result();
		
		//postsNumber가 빈 문자열이거나 null인 경우
		String postsNumberStr = request.getParameter("postsNumber");
		if(postsNumberStr == null || postsNumberStr.trim().isEmpty()) {
			System.out.println("postsNumber 값이 없습니다.");
			result.setPath("/app/post/postMain.jsp"); //게시글 목록 페이지로 리다이렉트
			result.setRedirect(true);
			return result;
		}
		
		int postsNumber = Integer.parseInt(postsNumberStr);
		
		PostsDAO postsDAO = new PostsDAO();
		
		//DB에서 게시글 가져오기
		PostsDTO postsDTO = postsDAO.select(postsNumber);
		
		//게시글이 존재하지 않을 경우 처리
		if(postsDTO == null) {
			System.out.println("존재하지 않는 게시글입니다. " + postsNumber);
			result.setPath("/app/board/boardList.jsp");
			result.setRedirect(true);
			return result;
		}
		
		//로그인한 사용자 번호 가져오기
		Integer loginMemberNumber = (Integer) request.getSession().getAttribute("memberNumber");
		System.out.println("로그인 한 멤버 번호 : " + loginMemberNumber);
		
		//현재 게시글의 자성자 번호 가져오기
		int postsWriterNumber = postsDTO.getUsersNumber();
		System.out.println("현재 게시글 작성자 번호 : " + postsWriterNumber);
		
		//로그인한 사용자가 작성자가 아닐 때만 조회수 증가
		if(!Objects.equals(loginMemberNumber, postsWriterNumber)) {
			postsDAO.updateReadCount(postsNumber);
		}
		
		request.setAttribute("post", postsDTO);
		result.setPath("/app/post/postDetail.jsp");
		result.setRedirect(false);
		
		return result;
	}
	
	
	
}
