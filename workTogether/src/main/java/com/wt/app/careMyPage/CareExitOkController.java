package com.wt.app.careMyPage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.careMyPage.dao.CareExitDAO;

public class CareExitOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CareExitDAO careExitDAO = new CareExitDAO();
		Result result = new Result();

		// 로그인 한 회원 정보 가져오기
		Integer usersNumber = (Integer) request.getSession().getAttribute("usersNumber");

		careExitDAO.delCareProExit(usersNumber);
		careExitDAO.delCareExit(usersNumber);
		
		request.getSession().removeAttribute("usersNumber");

		result.setPath("/mainOk.main");
		result.setRedirect(true);
		return result;
	}

}
