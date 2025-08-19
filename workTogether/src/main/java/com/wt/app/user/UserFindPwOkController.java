package com.wt.app.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Result;
import com.wt.app.user.dao.UserDAO;

public class UserFindPwOkController {

    public Result execute(HttpServletRequest request, HttpServletResponse response) {
        Result result = new Result();
        UserDAO dao = new UserDAO();

        String userName  = request.getParameter("userName");
        String userPhone = request.getParameter("userPhone");
        String userType  = request.getParameter("userType");

        // 1) 간단 검증
        if (isBlank(userName) || isBlank(userPhone) || isBlank(userType)) {
            request.setAttribute("error", "이름/휴대전화/회원유형을 모두 입력해 주세요.");
            result.setPath("/app/user/findId.jsp");
            result.setRedirect(false);
            return result;
        }
        if (!("N".equals(userType) || "C".equals(userType))) {
            request.setAttribute("error", "회원유형이 올바르지 않습니다.");
            result.setPath("/app/user/findId.jsp");
            result.setRedirect(false);
            return result;
        }

        String userId = dao.findUserIdByNamePhoneType(userName, userPhone, userType);

        if (userId == null) {
            request.setAttribute("error", "일치하는 정보가 없습니다.");
        } else {
            request.setAttribute("foundId", userId);
        }

        result.setPath("/app/user/findId.jsp");
        result.setRedirect(false);
        return result;
    }

    private boolean isBlank(String s) { return s == null || s.trim().isEmpty(); }
}
