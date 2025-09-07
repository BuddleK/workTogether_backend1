package com.wt.app.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.admin.dao.AdminDAO;
import com.wt.app.dto.AdminUserManagerDTO;

public class AdminUserDetailController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		AdminDAO adminDAO = new AdminDAO();
		Result result = new Result();

		String usersNumberStr = request.getParameter("usersNumber");
		if (usersNumberStr == null || usersNumberStr.trim().isEmpty()) {
			System.out.println("usersNumber 값이 없습니다");
			result.setPath("/app/admin/userManager.jsp"); // 게시글 목록 페이지로 리다이렉트
			result.setRedirect(true);
			return result;
		}

		int usersNumber = Integer.valueOf(usersNumberStr);

		AdminUserManagerDTO adminUserManagerDTO = adminDAO.adminUserManagerDetail(usersNumber);

		if (adminUserManagerDTO == null) {
			System.out.println("존재하지 않는 유저 입니다" + usersNumber);
			result.setPath("/app/admin/userManager.jsp"); // 게시글 목록 페이지로 리다이렉트
			result.setRedirect(true);
			return result;
		}

		request.setAttribute("admin", adminUserManagerDTO);
		result.setPath("/app/admin/userDetail.jsp");
		result.setRedirect(false);
		return result;
	}

}
