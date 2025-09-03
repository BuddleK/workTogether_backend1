package com.wt.app.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.dto.UpdatePwDTO;
import com.wt.app.users.dao.UsersDAO;

public class UpdatePwOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

        String usersId     = request.getParameter("usersId"); 
        String newPassword = request.getParameter("newPassword");

        UpdatePwDTO dto = new UpdatePwDTO();
        dto.setUsersId(usersId);
        dto.setNewPassword(newPassword);

        int updated = new UsersDAO().updatePasswordByUsersId(dto);

        Result result = new Result();
        if (updated > 0) {
            result.setRedirect(true);
            result.setPath(request.getContextPath() + "/");
        } else {
            request.setAttribute("updatePwError", "비밀번호 변경에 실패했습니다.");
            result.setRedirect(false);
            result.setPath("/app/login/modifyPassword.jsp");
        }
        return result;
	}

}
