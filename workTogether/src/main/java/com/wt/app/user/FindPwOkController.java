package com.wt.app.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.dto.FindPwDTO;
import com.wt.app.users.dao.UsersDAO;

public class FindPwOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

        FindPwDTO dto = new FindPwDTO();
        dto.setUsersId(request.getParameter("usersId"));
        dto.setUsersName(request.getParameter("usersName"));
        dto.setUsersPhone(request.getParameter("usersPhone"));
        dto.setUsersType(request.getParameter("usersType")); // 'N'/'C' or null

        Long usersNumber = new UsersDAO().verifyForPwReset(dto);

        Result result = new Result();
        if (usersNumber != null) {
            request.setAttribute("usersId", dto.getUsersId()); // 수정 페이지에서 사용
            result.setRedirect(false);
            result.setPath("/app/login/modifyPassword.jsp");
        } else {
            request.setAttribute("findPwError", "입력하신 정보와 일치하는 회원이 없습니다.");
            result.setRedirect(false);
            result.setPath("/app/login/findPassword.jsp");
        }
        return result;
	}

}
