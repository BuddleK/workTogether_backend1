package com.wt.app.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.admin.dao.AdminDAO;

public class AdminNewsWriteController implements Execute{

	@Override
	public Result Execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 System.out.println("==== AdminNewsWriteController 실행(작성 페이지 이동) ====");

	        AdminDAO adminDAO = new AdminDAO();
	        Result result = new Result();
	        HttpSession session = request.getSession();

	        Integer adminNumber = (Integer) session.getAttribute("adminNumber");
	        String path = null;

	        if (adminNumber == null) {
	            // 로그인 안 한 경우 → 로그인 페이지
	            path = "/app/admin/login.jsp";
	        } else {
	            // 로그인 한 경우 → 뉴스 작성 페이지
	            path = "/app/admin/news/newsWrite.jsp";
	            request.setAttribute("adminName", adminDAO.getAdminName(adminNumber));
	        }

	        result.setPath("/app/admin/newsBoardAdd.jsp");
	        result.setRedirect(false);

	        return result;
	}

}
