package com.wt.app.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.admin.dao.AdminDAO;

public class AdminPointReturnRejectOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Result result = new Result();

		// 파라미터
		String idParam = request.getParameter("pointReturnId");
		if (idParam == null || idParam.isEmpty())
			idParam = request.getParameter("id");
		if (idParam == null || idParam.isEmpty())
			idParam = request.getParameter("point_return_id");

		long pointReturnId = -1L;
		try {
			pointReturnId = Long.parseLong(idParam);
		} catch (Exception ignore) {
		}

		// 세션의 관리자 번호 우선, 없으면 파라미터에서 읽기
		Integer adminFromSession = (Integer) request.getSession().getAttribute("adminNumber");
		int adminUsersNumber = (adminFromSession != null) ? adminFromSession : 0;
		if (adminUsersNumber == 0) {
			String adminParam = request.getParameter("adminUsersNumber");
			try {
				adminUsersNumber = (adminParam == null || adminParam.isEmpty()) ? 0 : Integer.parseInt(adminParam);
			} catch (Exception ignore) {
			}
		}

		String adminMemo = request.getParameter("adminMemo");
		if (adminMemo == null)
			adminMemo = "";

		// 목록 복귀용 파라미터
		String pageParam = request.getParameter("page");
		int page = 1;
		try {
			page = (pageParam == null || pageParam.isEmpty()) ? 1 : Integer.parseInt(pageParam);
		} catch (Exception ignore) {
		}

		String status = request.getParameter("status");
		if (status == null)
			status = "";

		// 유효성 체크
		if (pointReturnId <= 0 || adminUsersNumber <= 0) {
			result.setRedirect(true);
			result.setPath(request.getContextPath() + "/app/error.jsp");
			return result;
		}

		// 반려 처리
		AdminDAO dao = new AdminDAO();
		int updated = dao.pointReturnReject(pointReturnId, adminUsersNumber, adminMemo);

		// 리스트로 리다이렉트
		result.setRedirect(true);
		result.setPath(request.getContextPath() + "/admin/pointReturnListOk.ad?page=" + page + "&status=" + status
				+ "&ok=" + (updated > 0 ? "1" : "0"));
		return result;
	}
}