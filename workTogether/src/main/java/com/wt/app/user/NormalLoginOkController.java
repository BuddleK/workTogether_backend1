package com.wt.app.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.dto.UsersLoginDTO;
import com.wt.app.normalUsers.dao.NormalUsersDAO;

public class NormalLoginOkController implements Execute {

    @Override
    public Result Execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        // 1) 파라미터 수집
        String usersId = request.getParameter("usersId");
        String usersPassword = request.getParameter("usersPassword");
        String remember = request.getParameter("remember");

        // 2) DTO 구성
        UsersLoginDTO dto = new UsersLoginDTO();
        dto.setUserId(usersId);
        dto.setUsersPassword(usersPassword);
        dto.setUserType('N'); // 일반회원 고정

        NormalUsersDAO normalUsersDAO = new NormalUsersDAO();
        int usersNumber = normalUsersDAO.login(dto);

        Result result = new Result();
        result.setRedirect(true);

        if (usersNumber != -1) {
            HttpSession session = request.getSession();
            session.setAttribute("usersNumber", usersNumber);
            session.setAttribute("usersType", 'N');
            session.setAttribute("usersId", usersId);

            
            result.setPath("/app/login/login.jsp");

        } else {
            result.setPath("/normal/login.us?login=fail");
        }

        return result;
    }
    
    
}
