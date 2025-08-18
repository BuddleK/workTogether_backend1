package com.wt.app.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.user.dao.UserDAO;
import com.wt.app.dto.UserDTO;

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
        UserDTO user = dao.login(userId, userPw); // DB에서 로그인 시도

        if (user != null) {
            // 로그인 성공 → 세션 저장
            HttpSession session = request.getSession();
            session.setAttribute("userNumber", user.getUserNumber());
            session.setAttribute("userId", user.getUserId());
            session.setAttribute("userName", user.getUserName());

            // 홈이나 마이페이지 등 원하는 곳으로 리다이렉트
            result.setPath(request.getContextPath() + "/index.jsp");
            result.setRedirect(true);
        } else {
            // 로그인 실패 → 다시 로그인 페이지
            request.setAttribute("loginError", "아이디 또는 비밀번호가 일치하지 않습니다.");
            result.setPath("/app/user/login.jsp");
            result.setRedirect(false);
        }

        return result;
		return null;
	}
}