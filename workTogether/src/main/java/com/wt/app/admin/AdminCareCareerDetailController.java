package com.wt.app.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.admin.dao.AdminDAO;
import com.wt.app.dto.AccountModifyDTO;
import com.wt.app.dto.AdminCareFileDTO;
import com.wt.app.dto.AdminUserManagerDTO;
import com.wt.app.dto.LicenseModifyDTO;

public class AdminCareCareerDetailController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("==== AdminCareCareerDetailController 실행 ====");
		String usersNumberStr = request.getParameter("usersNumber");
		if (usersNumberStr == null || usersNumberStr.isBlank()) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "usersNumber 파라미터가 필요합니다.");
			return null;
		}

		final int usersNumber;
		try {
			usersNumber = Integer.parseInt(usersNumberStr);
		} catch (NumberFormatException e) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "usersNumber 형식이 올바르지 않습니다.");
			return null;
		}

		AdminDAO dao = new AdminDAO();

		// 1) 사용자 기본정보
		AdminUserManagerDTO user = dao.adminUserManagerDetail(usersNumber);
		if (user == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND, "사용자를 찾을 수 없습니다.");
			return null;
		}

		// 2) 통장사본 최신건 파일 조회(없으면 null 그대로)
		AccountModifyDTO lastAcc = dao.accountModifyLatestByUser(usersNumber);
		AdminCareFileDTO accountFile = null;
		if (lastAcc != null && lastAcc.getAccountFilesNumber() != 0) {
			accountFile = dao.careFileAccount(lastAcc.getAccountFilesNumber());
		}

		// 3) JSP에서 쓸 속성 세팅
		request.setAttribute("usersNumber", usersNumber);
		request.setAttribute("user", user); // ★ JSP: ${user.usersName}, ${user.usersPhone} ...
		request.setAttribute("accountFile", accountFile); // ★ JSP: ${accountFile.fileName} 등

		// 버튼 액션 URL
		request.setAttribute("approveAction", request.getContextPath() + "/admin/careCareer/approve.ad");
		request.setAttribute("rejectAction", request.getContextPath() + "/admin/careCareer/reject.ad");

		Result result = new Result();
		result.setPath("/app/admin/careCareerDetailUpdate.jsp");
		result.setRedirect(false);
		return result;
	}
}