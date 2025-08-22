package com.wt.app.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;

public class UsersLoginController implements Execute {

    @Override
    public Result Execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("ㅎ헤ㅔ헤헤헤헿");
        Result result = new Result();
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("usersId")) {
                    request.setAttribute("usersId", cookie.getValue());
                }
            }
        }

        result.setPath("/app/login/login.jsp");
        result.setRedirect(false);
        return result;
    }
}
