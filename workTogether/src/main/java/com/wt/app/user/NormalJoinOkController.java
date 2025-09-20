package com.wt.app.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.dto.NormalSignDTO;
import com.wt.app.dto.UsersDTO;
import com.wt.app.users.dao.NormalUsersDAO;
import com.wt.app.users.dao.UsersDAO;

public class NormalJoinOkController implements Execute {

    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	request.setCharacterEncoding("UTF-8");
        Result result = new Result();

        try {
            String usersId = request.getParameter("usersId");
            String usersPassword = request.getParameter("usersPassword");
            String usersName = request.getParameter("usersName");
            String usersEmail = request.getParameter("usersEmail");
            String usersPhone = request.getParameter("usersPhone");
            String usersPostsalCode = request.getParameter("usersPostsalCode");
            String usersAddressLine1 = request.getParameter("usersAddressLine1");
            String usersAddressLine2 = request.getParameter("usersAddressLine2");

            UsersDTO usersDTO = new UsersDTO();
            usersDTO.setUsersId(usersId);
            usersDTO.setUsersPassword(usersPassword);
            usersDTO.setUsersType("N");
            usersDTO.setUsersName(usersName);
            usersDTO.setUsersEmail(usersEmail);
            usersDTO.setUsersPhone(usersPhone);
            usersDTO.setUsersPostsalCode(usersPostsalCode);
            usersDTO.setUsersAddressLine1(usersAddressLine1);
            usersDTO.setUsersAddressLine2(usersAddressLine2);

            long usersNumber = new UsersDAO().join(usersDTO);
            if (usersNumber <= 0) throw new IllegalStateException("join failed");

            NormalSignDTO normalsignDTO = new NormalSignDTO();
            normalsignDTO.setUsersNumber(usersNumber);
            normalsignDTO.setUsersName(usersName);
            normalsignDTO.setUsersEmail(usersEmail);
            normalsignDTO.setUsersPhone(usersPhone);
            normalsignDTO.setUsersPostsalCode(usersPostsalCode);
            normalsignDTO.setUsersAddressLine1(usersAddressLine1);
            normalsignDTO.setUsersAddressLine2(usersAddressLine2);

            String levelParam = request.getParameter("normalUsersLevel");
            normalsignDTO.setNormalUsersLevel(
                levelParam != null && !levelParam.isBlank() ? levelParam : "1"
            );

            new NormalUsersDAO().sign(normalsignDTO);

            result.setRedirect(true);
            result.setPath(request.getContextPath() + "/users/nomalLogin.us?joined=1");
            return result;

        } catch (Exception e) {
            e.printStackTrace();
            result.setRedirect(true);
            result.setPath(request.getContextPath() + "/app/sign/signNormal.jsp?error=join");
            return result;
        }
    }
}