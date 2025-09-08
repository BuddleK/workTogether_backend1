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
			result.setPath("/admin/adminUserManagerList.ad"); // 게시글 목록 페이지로 리다이렉트
			result.setRedirect(true);
			return result;
		}

		int usersNumber = Integer.valueOf(usersNumberStr);

		AdminUserManagerDTO adminUserManagerDTO = adminDAO.adminUserManagerDetail(usersNumber);

		if (adminUserManagerDTO == null) {
			System.out.println("존재하지 않는 유저 입니다" + usersNumber);
			result.setPath("/admin/adminUserManagerList.ad"); // 게시글 목록 페이지로 리다이렉트
			result.setRedirect(true);
			return result;
		}

		request.setAttribute("admin", adminUserManagerDTO);
        // 회원 타입에 따라 다른 JSP로 이동
        if ("N".equals(adminUserManagerDTO.getusersType())) {
            result.setPath("/app/admin/userDetail.jsp"); // 일반 회원
        } else if ("C".equals(adminUserManagerDTO.getusersType())) {
            result.setPath("/app/admin/careDetail.jsp"); // 돌봄 회원
        } else {
            // 혹시 모를 예외 케이스 → 기본 userDetail.jsp로 이동
            result.setPath("/app/admin/userDetail.jsp");
        }
		result.setRedirect(false);
		return result;
	}

}
