package com.wt.app.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.admin.dao.AdminDAO;
import com.wt.app.dto.AdminReportListDTO;

public class AdminReportDeleteOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("===AdminReportDeleteOkController 실행===");
		AdminDAO adminDAO = new AdminDAO();
		Result result = new Result();
		
		// 1. 삭제할 게시글 번호 받아오기
	    int postsNumber = Integer.parseInt(request.getParameter("postsNumber"));
	    System.out.println(postsNumber);

	    // 2. DAO에서 삭제
	    adminDAO.adminReportListDelete(postsNumber);

		result.setPath("/admin/adminReportList.ad");
	    result.setRedirect(false);	
	    return result;
	}

}
