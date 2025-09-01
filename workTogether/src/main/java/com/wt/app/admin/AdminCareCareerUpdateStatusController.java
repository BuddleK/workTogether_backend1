package com.wt.app.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.admin.dao.AdminDAO;

public class AdminCareCareerUpdateStatusController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 System.out.println("==== AdminCareCareerUpdateStatusController 실행 ====");

	        Result result = new Result();

	        String usersNumberStr = request.getParameter("usersNumber");
	        if (usersNumberStr == null || usersNumberStr.isBlank()) {
	            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "usersNumber 파라미터가 필요합니다.");
	            return null;
	        }

	        int usersNumber;
	        try {
	            usersNumber = Integer.parseInt(usersNumberStr);
	        } catch (NumberFormatException e) {
	            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "usersNumber 형식이 올바르지 않습니다.");
	            return null;
	        }

	        String what = request.getParameter("what");
	        if (what == null || what.isBlank()) what = "all";

	        AdminDAO dao = new AdminDAO();
	        int appliedCount = 0;

	        try {
	            if ("license".equalsIgnoreCase(what) || "all".equalsIgnoreCase(what)) {
	                appliedCount += dao.careerApplyLicense(usersNumber);
	                dao.careerClearLicense(usersNumber);
	            }

	            if ("account".equalsIgnoreCase(what) || "all".equalsIgnoreCase(what)) {
	                appliedCount += dao.careerApplyAccount(usersNumber);
	                dao.careerClearAccount(usersNumber);
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "이력수정 적용 처리 중 오류");
	            return null;
	        }

	        // 3) 상세로 리다이렉트 (결과 플래그 포함)
	        String page = request.getParameter("page");
	        StringBuilder redirect = new StringBuilder();
	        redirect.append(request.getContextPath())
	                .append("/admin/careCareer/detail.ad?usersNumber=").append(usersNumber);
	        if (page != null && !page.isBlank()) {
	            redirect.append("&page=").append(page);
	        }
	        redirect.append("&applied=").append(appliedCount > 0 ? "Y" : "N");

	        result.setPath(redirect.toString());
	        result.setRedirect(true);
	        return result;
	    }

}
