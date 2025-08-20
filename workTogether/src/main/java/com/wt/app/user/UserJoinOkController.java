package com.wt.app.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Result;
import com.wt.app.dto.UserDTO;
import com.wt.app.user.dao.UserDAO;

public class UserJoinOkController {

    public Result execute(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");

        UserDAO userDAO = new UserDAO();
        UserDTO userDTO = new UserDTO();
        Result result = new Result();

        String userId = request.getParameter("userId");
        String userPw = request.getParameter("userPw");
        String userName = request.getParameter("userName");
        String userPhone = request.getParameter("userPhone");
        String userEmail = request.getParameter("userEmail");
        String userType = request.getParameter("userType"); 
        userDTO.setUserId(userId);
        userDTO.setUserPassword(userPw);
        userDTO.setUserName(userName);
        userDTO.setUserPhone(userPhone);
        userDTO.setUserEmail(userEmail);
        userDTO.setUserType(userType);

        int userNumber = userDAO.insertUser(userDTO);

        if ("normal".equalsIgnoreCase(userType)) {
            String level = request.getParameter("normalLevel"); 
            userDAO.insertNormal(userNumber, level);
        } else if ("care".equalsIgnoreCase(userType)) {
           
        }

        result.setPath(request.getContextPath() + "/app/user/login.jsp");
        result.setRedirect(true);

        return result;
    }
}
