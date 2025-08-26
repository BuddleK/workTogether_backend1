package com.wt.app.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.dto.UsersDTO;
import com.wt.app.dto.UsersLoginDTO;
import com.wt.app.users.dao.UsersDAO;

public class LoginNormalOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String usersId = request.getParameter("usersId");
		String usersPassword = request.getParameter("usersPassword");

		// DTO 세팅(생성자 없을 수 있으니 세터 사용)
		UsersDTO usersDTO = new UsersDTO();
		usersDTO.setUsersId(usersId);
		usersDTO.setUsersPassword(usersPassword);

		// DAO 호출
		UsersDTO user = new UsersDAO().normalLogin(usersDTO);
		System.out.println(user);
		// 결과 처리
		Result result = new Result();
		if (user.getUsersNumber() != null) {
			HttpSession session = request.getSession();
			session.setAttribute("usersNumber", user.getUsersNumber());

			result.setRedirect(true);
			result.setPath(request.getContextPath() + "/"); // 로그인 성공 후 메인으로
		} else {
			request.setAttribute("loginError", "아이디 또는 비밀번호를 확인해주세요.");
			result.setRedirect(false);
			result.setPath("/app/login/login.jsp"); // 실패 시 로그인 화면
		}
		return result;
	}

}
