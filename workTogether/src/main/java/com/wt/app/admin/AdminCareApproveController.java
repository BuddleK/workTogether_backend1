package com.wt.app.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.admin.dao.AdminDAO;

public class AdminCareApproveController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("==== AdminCareApproveController 실행 ====");

		Result result = new Result();
		AdminDAO admincareDAO = new AdminDAO();

		String usersNumberStr = request.getParameter("usersNumber");
		if (usersNumberStr == null) {
			System.out.println(" usersNumber 파라미터 없음");
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}

		int usersNumber;
		try {
			usersNumber = Integer.parseInt(usersNumberStr);
		} catch (NumberFormatException e) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}

		admincareDAO.careApprove(usersNumber);

		String page = request.getParameter("page");
		String redirectUrl = request.getContextPath() + "/admin/care/list.ad" + (page != null ? "?page=" + page : "");
		result.setPath(redirectUrl);
		result.setRedirect(true);

		System.out.println("==== 리다이렉트 → " + redirectUrl + " ====");
		return result;
	}

}
