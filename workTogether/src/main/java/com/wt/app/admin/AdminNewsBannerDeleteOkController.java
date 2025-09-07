package com.wt.app.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.admin.dao.AdminDAO;

public class AdminNewsBannerDeleteOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Result result = new Result();

		int id;
		try {
			id = Integer.parseInt(request.getParameter("bannerNewsNumber"));
		} catch (Exception e) {
			result.setPath(request.getContextPath() + "/admin/adminNewsBanner.ad");
			result.setRedirect(true);
			return result;
		}

		AdminDAO adminDAO = new AdminDAO();
		adminDAO.adminNewsBannerDelete(id);

		result.setPath(request.getContextPath() + "/admin/adminNewsBanner.ad");
		result.setRedirect(true);
		return result;
	}

}
