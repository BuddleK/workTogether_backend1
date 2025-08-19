package com.wt.app.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.dto.UserDTO;
import com.wt.app.user.dao.UserDAO;

public class UserLoginOkController implements Execute {
	@Override
	public Result Execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
        Result result = new Result();

        String userId = request.getParameter("userId");
        String userPw = request.getParameter("userPw");

        UserDAO dao = new UserDAO();
        UserDTO user = dao.login(userId, userPw);

        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("userNumber", user.getUserNumber());
            session.setAttribute("userId", user.getUserId());
            session.setAttribute("userName", user.getUserName());

            result.setPath(request.getContextPath() + "/main.jsp");
            result.setRedirect(true);
        } else {
            request.setAttribute("loginError", "아이디 또는 비밀번호가 일치하지 않습니다.");
            result.setPath("/app/user/login.jsp");
            result.setRedirect(false);
        }

        return result;
	}
}