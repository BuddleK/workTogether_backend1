package com.wt.app.posts;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.dto.AdminNoticeListDTO;
import com.wt.app.posts.dao.PostsDAO;

public class PostAlimDetailController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("====PostAlimDetailController 실행====");
		
		Result result = new Result();
		PostsDAO postsDAO = new PostsDAO();
		AdminNoticeListDTO adminNoticeListDTO = new AdminNoticeListDTO();
		

		
		
		
		int noticeNumber = Integer.parseInt(request.getParameter("noticeNumber"));
		System.out.println("공지 번호 : " + noticeNumber);
		

		//로그인한 사용자 번호 가져오기
		Integer loginMemberNumber = (Integer) request.getSession().getAttribute("usersNumber");
		System.out.println("로그인 한 멤버 번호 : " + loginMemberNumber);
		
		
		//로그인 된 상태면 조회수 증가
		if(loginMemberNumber != null) {
			postsDAO.updateNoticeViewCount(noticeNumber);
		}
		
		adminNoticeListDTO = postsDAO.getNoticeDetail(noticeNumber);
		
		String updatedDate = null;
		
		updatedDate = postsDAO.getNoticeDetailUpdated(noticeNumber);
		//수정된 적이 없어 수정 날짜가 비어 있을 경우 "-"로 표시함
		if(updatedDate == null) {
			updatedDate = "-";
		}
		

		

		
		
		
		String content = postsDAO.getNoticeDetailContent(noticeNumber);
		

		request.setAttribute("notice", adminNoticeListDTO);
		request.setAttribute("updatedDate", updatedDate);
		request.setAttribute("content", content);
		
		result.setPath("/app/post/postArlim.jsp");
		result.setRedirect(false);
		return result;
	}
}
