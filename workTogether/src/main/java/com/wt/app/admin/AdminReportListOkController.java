package com.wt.app.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.admin.dao.AdminDAO;
import com.wt.app.dto.AdminReportListDTO;

public class AdminReportListOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("==============AdminReportListOkController 진입============");
		
		Result result = new Result();
		
		//postsNumber가 빈 문자열이거나 null인 경우
		String postsNumberStr = request.getParameter("postsNumber");
		if(postsNumberStr == null || postsNumberStr.trim().isEmpty()) {
			System.out.println("postsNumber 값이 없습니다.");
			result.setPath("/admin/adminReportList.ad"); //신고글 목록 페이지로 리다이렉트
			result.setRedirect(true);
			return result;
		}
		
		int postsNumber = Integer.parseInt(postsNumberStr);
		
		AdminDAO adminDAO = new AdminDAO();
		
		//DB에서 게시글 가져오기
		AdminReportListDTO adminDTO = adminDAO.reportDetail(postsNumber);
		System.out.println(adminDTO);
		
		//게시글이 존재하지 않을 경우 처리
		if(adminDTO == null) {
			System.out.println("존재하지 않는 게시글입니다. " + postsNumber);
			result.setPath("/admin/adminReportList.ad");
			result.setRedirect(true);
			return result;
		}
		
		request.setAttribute("report", adminDTO);
		result.setPath("/app/admin/reportDetail.jsp");
	    result.setRedirect(false);
	    return result;
	}
	

}
