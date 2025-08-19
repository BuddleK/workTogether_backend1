package com.wt.app.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Result;
import com.wt.app.user.dao.UserDAO;

public class UserFindPwCheckController {

    public Result execute(HttpServletRequest request, HttpServletResponse response) {
        Result result = new Result();
        UserDAO dao = new UserDAO();

        String userId            = request.getParameter("userId");
        String newPassword       = request.getParameter("newPassword");
        String newPasswordConfirm= request.getParameter("newPasswordConfirm");

        if (isBlank(userId) || isBlank(newPassword) || isBlank(newPasswordConfirm)) {
            request.setAttribute("error", "아이디와 새 비밀번호를 모두 입력해 주세요.");
            result.setPath("/app/login/modifyPassword.jsp");
            result.setRedirect(false);
            return result;
        }

        if (!newPassword.equals(newPasswordConfirm)) {
            request.setAttribute("error", "새 비밀번호가 일치하지 않습니다.");
            result.setPath("/app/login/modifyPassword.jsp");
            result.setRedirect(false);
            return result;
        }
        if (newPassword.length() < 8) {
            request.setAttribute("error", "비밀번호는 8자 이상이어야 합니다.");
            result.setPath("/app/login/modifyPassword.jsp");
            result.setRedirect(false);
            return result;
        }

        int updated = dao.updatePasswordById(userId, newPassword);
        if (updated == 1) {
            request.setAttribute("msg", "비밀번호가 변경되었습니다. 새 비밀번호로 로그인하세요.");
            result.setPath(request.getContextPath() + "/login/login.us");
            result.setRedirect(true);
        } else {
            request.setAttribute("error", "비밀번호 변경에 실패했습니다. 정보를 다시 확인해 주세요.");
            result.setPath("/app/login/modifyPassword.jsp");
            result.setRedirect(false);
        }

        return result;
    }

    private boolean isBlank(String s){ return s == null || s.trim().isEmpty(); }
}
