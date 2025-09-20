package com.wt.app.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.admin.dao.AdminDAO;
import com.wt.app.dto.AdminNoticeListDTO;

public class AdminNoticeDetailController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Result result = new Result();
		
		String noticeNumberStr = request.getParameter("noticeNumber");
		AdminDAO adminDAO = new AdminDAO();
		
		if (noticeNumberStr == null || noticeNumberStr.trim().isEmpty()) {
			System.out.println("noticeNumber 값이 없습니다");
			result.setPath("/admin/adminNotice.ad"); // 게시글 목록 페이지로 리다이렉트
			result.setRedirect(true);
			return result;
		}
		
		int noticeNumber = Integer.valueOf(noticeNumberStr);
		AdminNoticeListDTO notice = adminDAO.adminNoticeDetailSearch(noticeNumber); 
		
		if(notice == null) {
			System.out.println("존재하지 않는 게시글 입니다" + noticeNumber);
			result.setPath("/admin/adminNotice.ad"); // 게시글 목록 페이지로 리다이렉트
			result.setRedirect(true);
			return result;
		}
		
		request.setAttribute("notice", notice);
		result.setPath("/app/admin/noticeDetail.jsp");
	    result.setRedirect(false);
	    return result;
	}
	
}
