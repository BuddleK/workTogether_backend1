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
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	System.out.println("fdssdfsfd");
		CareModifyDAO careModifyDAO = new CareModifyDAO();
		CareModifyDTO careModifyDTO = new CareModifyDTO();
		Result result = new Result();
		
//		String usersNumber = Integer.parseInt(usersNumber);
		Integer usersNumberStr = (Integer)request.getSession().getAttribute("usersNumber");
		
		System.out.println(usersNumberStr);
		
		if (usersNumberStr == null) {
			System.out.println("세션 없음");
//			return null;
		}
		System.out.println(usersNumberStr);
		
		result.setPath("/app/myPageCare/careModify.jsp");
		System.out.println("setPath 값 저장");
		result.setRedirect(false);
		return result;
	}
	
}
