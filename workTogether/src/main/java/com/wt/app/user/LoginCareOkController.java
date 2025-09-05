package com.wt.app.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.dto.UsersLoginDTO;
import com.wt.app.users.dao.UsersDAO;

public class LoginCareOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("돌봄 로그인 컨트롤러 진입");
		request.setCharacterEncoding("UTF-8");

		String usersId = request.getParameter("usersId");
		String usersPassword = request.getParameter("usersPassword");

		// DTO 세팅(생성자 없을 수 있으니 세터 사용)
		UsersLoginDTO usersLoginDTO = new UsersLoginDTO();
		usersLoginDTO.setUsersId(usersId);
		usersLoginDTO.setUsersPassword(usersPassword);

		UsersDAO usersDAO = new UsersDAO();
		int loggedInUser = usersDAO.careLogin(usersLoginDTO);
		String usersType = usersDAO.careLoginType(usersLoginDTO);
		
		
		Result result = new Result();

		// 결과 처리
		if (loggedInUser > 0) {
			HttpSession session = request.getSession();
			session.setAttribute("usersNumber", loggedInUser);
			session.setAttribute("usersType", usersType);
			System.out.println(session.getAttribute("usersNumber"));
			result.setRedirect(true);
			result.setPath(request.getContextPath() + "/mainOk.main"); // 로그인 성공 후 메인으로
		} else {
			System.out.println("유저 아이디가 없음");
			result.setRedirect(false);
			result.setPath("/app/login/loginCare.jsp"); // 실패 시 로그인 화면
		}
		return result;
	}

}
