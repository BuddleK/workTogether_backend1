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
		System.out.println("컨트롤러 진입");
		request.setCharacterEncoding("UTF-8");

		String usersId = request.getParameter("usersId");
		String usersPassword = request.getParameter("usersPassword");

		// DTO 세팅(생성자 없을 수 있으니 세터 사용)
		UsersLoginDTO usersLoginDTO = new UsersLoginDTO();
		usersLoginDTO.setUsersId(usersId);
		usersLoginDTO.setUsersPassword(usersPassword);

		// DAO 호출
		UsersDAO usersDAO = new UsersDAO();
		int loggedInUser = usersDAO.normalLogin(usersLoginDTO);
		
		// 결과 처리
		Result result = new Result();

		if (loggedInUser > 0) {
			HttpSession session = request.getSession();
			session.setAttribute("usersNumber", loggedInUser);
			
			System.out.println(session.getAttribute("usersNumber"));
			result.setRedirect(true);
			result.setPath(request.getContextPath() + "/mainOk.main"); // 로그인 성공 후 메인으로
		} else {
			System.out.println("유저 아이디가 없음");
			result.setRedirect(false);
			result.setPath("/app/login/loginNormal.jsp"); // 실패 시 로그인 화면
		}
		return result;
	}

}
