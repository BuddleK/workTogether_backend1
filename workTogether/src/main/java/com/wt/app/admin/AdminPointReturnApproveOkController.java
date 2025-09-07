package com.wt.app.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.admin.dao.AdminDAO;

public class AdminPointReturnApproveOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String prn = request.getParameter("pointReturnNumber"); // hidden에서 옴
		String page = request.getParameter("page");
		String status = request.getParameter("status");

		if (prn == null || prn.isEmpty()) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "pointReturnNumber is required");
			return null;
		}

		long pointReturnId = Long.parseLong(prn);

		AdminDAO dao = new AdminDAO();
		boolean ok = (dao.pointReturnApproveMark(pointReturnId) == 1); // ★ 차감 없이 상태만 Y + refunded_at=SYSDATE

		// 목록으로 리다이렉트
		StringBuilder url = new StringBuilder();
		url.append(request.getContextPath()).append("/admin/pointReturnListOk.ad").append("?result=")
				.append(ok ? "ok" : "fail");
		if (page != null && !page.isEmpty())
			url.append("&page=").append(page);
		if (status != null && !status.isEmpty())
			url.append("&status=").append(status);

		Result r = new Result();
		r.setPath(url.toString());
		r.setRedirect(true);
		return r;
	}
}