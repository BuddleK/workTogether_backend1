package com.wt.app.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.admin.dao.AdminDAO;
import com.wt.app.dto.CarePointreturnDTO;

public class AdminPointReturnDetailOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String idParam = request.getParameter("pointReturnId");
		if (idParam == null || idParam.isEmpty()) {
			idParam = request.getParameter("pointReturnNumber");
		}
		if (idParam == null || idParam.isEmpty()) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "pointReturnId is required");
			return null;
		}

		long pointReturnId;
		try {
			pointReturnId = Long.parseLong(idParam);
		} catch (NumberFormatException e) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "invalid pointReturnId");
			return null;
		}

		AdminDAO dao = new AdminDAO();
		CarePointreturnDTO item = dao.pointReturnOne(pointReturnId);
		if (item == null) {

			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}

		request.setAttribute("item", item);

		Result result = new Result();
		result.setPath("/app/admin/refundDetail.jsp");
		result.setRedirect(false);
		return result;
	}
}