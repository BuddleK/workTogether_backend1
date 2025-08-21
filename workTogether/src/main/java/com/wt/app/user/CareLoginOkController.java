package com.wt.app.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.dto.UsersLoginDTO;
import com.wt.app.careUsers.dao.CareUsersDAO;

public class CareLoginOkController implements Execute {

    @Override
    public Result Execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String usersId = request.getParameter("usersId");
        String usersPassword = request.getParameter("usersPassword");
        String remember = request.getParameter("remember");

        UsersLoginDTO dto = new UsersLoginDTO();
        dto.setUserId(usersId);
        dto.setUsersPassword(usersPassword);
        dto.setUserType('C');

        CareUsersDAO careUsersDAO = new CareUsersDAO();
        int usersNumber = careUsersDAO.login(dto); 

        Result result = new Result();
        result.setRedirect(true);

        if (usersNumber != -1) {
            // 세션 저장
            HttpSession session = request.getSession();
            session.setAttribute("usersNumber", usersNumber);
            session.setAttribute("usersType", 'C');
            session.setAttribute("usersId", usersId);

            // 아이디 저장 쿠키
			/*
			 * String ctxPath = request.getContextPath(); if
			 * ("on".equalsIgnoreCase(remember)) { Cookie idCookie = new
			 * Cookie("rememberId", usersId); idCookie.setPath(ctxPath == null ||
			 * ctxPath.isEmpty() ? "/" : ctxPath); idCookie.setMaxAge(60 * 60 * 24 * 7); //
			 * 7일 response.addCookie(idCookie); } else { Cookie idCookie = new
			 * Cookie("rememberId", ""); idCookie.setPath(ctxPath == null ||
			 * ctxPath.isEmpty() ? "/" : ctxPath); idCookie.setMaxAge(0); // 삭제
			 * response.addCookie(idCookie); }
			 */

            result.setPath(request.getContextPath() + "/app/login/login.jsp");

        } else {
            result.setPath(request.getContextPath() + "/care/login.us?login=fail");
        }

        return result;
    }
}
