package com.wt.app.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.admin.dao.AdminCareDAO;

public class AdminCareRejectController implements Execute {

	@Override
	public Result Execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("==== AdminCareRejectController 실행 ====");
		
		Result result = new Result();
		AdminCareDAO admincareDAO = new AdminCareDAO();
		
		String usersNumberStr = request.getParameter("usersNumber");
		if(usersNumberStr == null) {
			System.out.println("파라미터 없음");
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}
		int usersNumber;
        try {
            usersNumber = Integer.parseInt(usersNumberStr);
        } catch (NumberFormatException e) {
            System.out.println("[Reject] usersNumber 형식 오류: " + usersNumberStr);
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return null;
        }

        String rejectReason = request.getParameter("rejectReason");
        if (rejectReason != null && !rejectReason.trim().isEmpty()) {
            System.out.println("사유: " + rejectReason);
        }

        admincareDAO.rejectCare(usersNumber);
        System.out.println("반려 처리 완료 usersNumber=" + usersNumber);

        String page = request.getParameter("page"); // 옵션
        String redirectUrl = request.getContextPath() + "/admin/care/list.ad" + (page != null ? "?page=" + page : "");
        result.setPath(redirectUrl);
        result.setRedirect(true);

        System.out.println("==== 리다이렉트 → " + redirectUrl + " ====");
        return result;
	}

}
