package com.wt.app.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Result;
import com.wt.app.admin.dao.AdminDAO;
import com.wt.app.dto.AdminDTO;

public class AdminLoginOkController {
	 public Result execute(HttpServletRequest request, HttpServletResponse response) {
	        Result result = new Result();
	        AdminDAO adminDAO = new AdminDAO();

	        String adminId = request.getParameter("adminId");
	        String adminPw = request.getParameter("adminPw");

	        AdminDTO admin = adminDAO.login(adminId, adminPw);

	        if (admin != null) {
	            request.getSession().setAttribute("admin", admin);
	            result.setPath(request.getContextPath() + "/admin/dashboard.ad");
	            result.setRedirect(true);
	        } else {
	            request.setAttribute("loginError", "아이디 또는 비밀번호가 올바르지 않습니다.");
	            result.setPath("/app/admin/login.jsp");
	            result.setRedirect(false);
	        }
	        return result;
	    }
}
