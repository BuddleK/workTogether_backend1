package com.wt.app.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.admin.dao.AdminDAO;
import com.wt.app.dto.AdminLoginDTO;

public class AdminLoginOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		AdminLoginDTO adminDTO = new AdminLoginDTO();
		AdminDAO adminDAO = new AdminDAO();
		int adminNumber = 1;
		Result result = new Result();
		String path = null;

		HttpSession session = request.getSession(); // ++++++세션저장

		adminDTO.setAdminId(request.getParameter("adminId"));
		adminDTO.setAdminPassword(request.getParameter("adminPassword"));

		adminNumber = adminDAO.login(adminDTO);

		if (adminNumber != -1) {
			// 로그인 성공 → 세션 저장 후 관리자 화면으로
			path = "/admin/care/list.ad";
			session.setAttribute("adminNumber", adminNumber);
			System.out.println("세션값 : " + adminNumber);

		} else {
			path = "/admin/adminlogin.ad";
			System.out.println(adminNumber);
		}
		result.setRedirect(true); // 세션에 저장된 값은 유지
		result.setPath(path);
		return result;
	}

}
