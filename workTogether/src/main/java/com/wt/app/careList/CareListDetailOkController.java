package com.wt.app.careList;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.careList.dao.CareListCommentsDAO;
import com.wt.app.careList.dao.CareListDAO;
import com.wt.app.dto.CareListDTO;

public class CareListDetailOkController implements Execute  {

	@Override
	public Result Execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("CareListDetailOkController 실행");
		
		CareListDTO careListDTO = new CareListDTO();
		CareListDAO careListDAO = new CareListDAO();
		CareListCommentsDAO careListCommentsDAO = new CareListCommentsDAO();
		Result result = new Result();
		
		result.setPath("/app/careMember/careMemberDetail.jsp");
		result.setRedirect(false);
		
		return result;
	}

	
}
