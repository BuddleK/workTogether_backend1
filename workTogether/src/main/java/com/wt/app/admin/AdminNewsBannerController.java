package com.wt.app.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.admin.dao.AdminDAO;
import com.wt.app.dto.AdminNewsBannerDTO;

public class AdminNewsBannerController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Result result = new Result();
		AdminDAO adminDAO = new AdminDAO();

		List<AdminNewsBannerDTO> list = adminDAO.adminNewsBannerSelect(); // 최신 6개
		request.setAttribute("banners", list);

		result.setPath("/app/admin/bannerBoard.jsp");
		result.setRedirect(false);
		return result;
	}

}
