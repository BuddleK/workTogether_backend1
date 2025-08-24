package com.wt.app.careList;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.careList.dao.CareListDAO;
import com.wt.app.dto.CareListDTO;

public class CareListOkController implements Execute  {

	@Override
	public Result Execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("CareListOkController 실행");
		
		CareListDTO careListDTO = new CareListDTO();
		CareListDAO careListDAO = new CareListDAO();
		
		Result result = new Result();
		result.setPath("/app/careMember/careMember.jsp");
		return result;
	}

	
}
