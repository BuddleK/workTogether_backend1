package com.wt.app.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.users.dao.UsersDAO;

public class CheckIdOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UsersDAO usersDAO = new UsersDAO();
		Result result = new Result();

		// 클라이언트에서 전달받은 usersId
		String usersId = request.getParameter("usersId");
		boolean isAvailable = usersDAO.checkId(usersId);

		// JSON 형식 응답 설정
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		// JSON 응답 작성
		try (PrintWriter out = response.getWriter()) {
			out.print("{\"available\" : " + isAvailable + "}");
			out.flush();
		}

		// 직접 응답했으므로 페이지 이동 없음
		result.setPath(null);
		result.setRedirect(false);
		return result;
	}

}
