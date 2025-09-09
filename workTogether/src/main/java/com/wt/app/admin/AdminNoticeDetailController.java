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
		
		int noticeNumber = Integer.parseInt(request.getParameter("noticeNumber"));
		AdminDAO adminDAO = new AdminDAO();
		List<AdminNoticeListDTO> notice = adminDAO.adminNoticeDetailSearch(noticeNumber); 
		
		request.setAttribute("notice", notice);
		
		result.setPath("/app/admin/noticeDetail.jsp");
	    result.setRedirect(false);
	    return result;
	}
	
}
