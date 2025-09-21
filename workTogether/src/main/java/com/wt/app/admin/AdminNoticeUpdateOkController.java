package com.wt.app.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.admin.dao.AdminDAO;
import com.wt.app.dto.AdminNoticeListDTO;

public class AdminNoticeUpdateOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Result result = new Result();
		
        int noticeNumber = Integer.parseInt(request.getParameter("noticeNumber"));
        String noticeTitle = request.getParameter("noticeTitle");
        String noticeContent = request.getParameter("noticeContent");

        AdminNoticeListDTO adminNoticeListDTO = new AdminNoticeListDTO();
        adminNoticeListDTO.setNoticeNumber(noticeNumber);
        adminNoticeListDTO.setNoticeTitle(noticeTitle);
        adminNoticeListDTO.setNoticeContent(noticeContent);
        
        AdminDAO adminDAO = new AdminDAO();
        adminDAO.adminNoticeListUpdate(adminNoticeListDTO);
        
		result.setPath("/admin/adminNoticeDetail.ad");
		result.setRedirect(true);
		return result;
	}

}
