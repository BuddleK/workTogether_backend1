package com.wt.app.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.admin.dao.AdminDAO;

public class AdminCareCareerRejectController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 String usersNumberStr = request.getParameter("usersNumber");
		    if (usersNumberStr == null || usersNumberStr.isBlank()) {
		      response.sendError(HttpServletResponse.SC_BAD_REQUEST, "usersNumber 파라미터가 필요합니다.");
		      return null;
		    }

		    int usersNumber;
		    try { usersNumber = Integer.parseInt(usersNumberStr); }
		    catch (NumberFormatException e) {
		      response.sendError(HttpServletResponse.SC_BAD_REQUEST, "usersNumber 형식이 올바르지 않습니다.");
		      return null;
		    }

		    AdminDAO dao = new AdminDAO();
		    int updated = dao.careCareerRejectLatestByUser(usersNumber); // 최신 1건을 'N'

		    Result result = new Result();
		    result.setPath(request.getContextPath() + "/admin/careCareer/list.ad?rej="+updated);
		    result.setRedirect(true);
		    return result;
		  }
		}