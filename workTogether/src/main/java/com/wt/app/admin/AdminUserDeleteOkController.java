package com.wt.app.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.admin.dao.AdminDAO;

public class AdminUserDeleteOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int usersNumber = Integer.parseInt(request.getParameter("usersNumber"));
		AdminDAO adminDAO = new AdminDAO();
		adminDAO.adminUserDelete(usersNumber);

		Result result = new Result();
		
		result.setPath(request.getContextPath() + "/admin/adminUserManagerList.ad");
		result.setRedirect(true);
		return result;
	}

}
