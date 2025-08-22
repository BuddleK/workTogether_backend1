package com.wt.app.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.careUsers.dao.CareUsersDAO;

public class CareCheckIdOkController implements Execute{

	@Override
	public Result Execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CareUsersDAO careusersDAO = new CareUsersDAO();
		Result result = new Result();

		// 클라이언트에서 전달받은 usersId
		String usersId = request.getParameter("usersId");
		boolean isAvailable = careusersDAO.checkId(usersId);

		// JSON 형식 응답 설정
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		// JSON 응답 작성
		try (PrintWriter out = response.getWriter()) {
			out.print("{\"available\" : " + isAvailable + "}");
			out.flush();
		}

		// Result 객체 반환(JSON 응답 처리 후 페이지 이동 없음)
		result.setPath(null); // 페이지 이동이 없음을 명시
		result.setRedirect(false); // 리다이렉트 설정(false로 유지)
		return result;
	}

}
