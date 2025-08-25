package com.wt.app.careMyPage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.reflection.SystemMetaObject;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.careMyPage.dao.CareModifyDAO;
import com.wt.app.dto.AdminCareSignupDTO;
import com.wt.app.dto.CareModifyDTO;

public class CareModifyController implements Execute{
	
	@Override
	public Result Execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	System.out.println("fdssdfsfd");
		CareModifyDAO careModifyDAO = new CareModifyDAO();
		CareModifyDTO careModifyDTO = new CareModifyDTO();
		Result result = new Result();
		
//		String usersNumber = Integer.parseInt(usersNumber);
		System.out.println("fdfdfdff");
		String usersNumberStr = request.getParameter("usersNumber");
		if (usersNumberStr == null || usersNumberStr.trim().isEmpty()) {
			System.out.println("[Detail] usersNumber 파라미터 없음");
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}
		
		
		System.out.println("fds");
		

		result.setPath("/app/myPageCare/careModify.jsp");
		result.setRedirect(false);
		return result;
	}
	
}
