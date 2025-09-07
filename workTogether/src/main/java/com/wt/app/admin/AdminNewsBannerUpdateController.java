package com.wt.app.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.admin.dao.AdminDAO;
import com.wt.app.dto.AdminNewsBannerDTO;

public class AdminNewsBannerUpdateController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idStr = request.getParameter("bannerNewsNumber");
		Result result = new Result();

		// 신규 등록 폼
		if (idStr == null || idStr.isBlank()) {
			result.setPath("/app/admin/bannerUpdate.jsp");
			result.setRedirect(false);
			return result;
		}

		// 수정 폼
		int id;
		try {
			id = Integer.parseInt(idStr.trim());
		} catch (NumberFormatException e) {
			result.setPath(request.getContextPath() + "/admin/adminNewsBanner.ad");
			result.setRedirect(true);
			return result;
		}

		AdminDAO dao = new AdminDAO();
		AdminNewsBannerDTO banner = dao.adminNewsBannerSelectOne(id);
		if (banner == null) {
			result.setPath(request.getContextPath() + "/admin/adminNewsBanner.ad");
			result.setRedirect(true);
			return result;
		}

		request.setAttribute("banner", banner);
		result.setPath("/app/admin/bannerUpdate.jsp");
		result.setRedirect(false);
		return result;
	}
}