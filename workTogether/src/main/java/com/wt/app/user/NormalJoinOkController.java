package com.wt.app.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.dto.NormalSignDTO;
import com.wt.app.users.dao.NormalUsersDAO;

public class NormalJoinOkController implements Execute {

    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String usersName = request.getParameter("usersName");
        String usersEmail = request.getParameter("usersEmail");
        String usersPhone = request.getParameter("usersPhone");
        String usersPostsalCode = request.getParameter("usersPostsalCode");
        String usersAddressLine1 = request.getParameter("usersAddressLine1");
        String usersAddressLine2 = request.getParameter("usersAddressLine2");
        String normalUsersLevel = request.getParameter("normalUsersLevel");
        String usersNumberParam = request.getParameter("usersNumber");

        NormalSignDTO normalsignDTO = new NormalSignDTO();
        normalsignDTO.setUsersName(usersName);
        normalsignDTO.setUsersEmail(usersEmail);
        normalsignDTO.setUsersPhone(usersPhone);
        normalsignDTO.setUsersPostsalCode(usersPostsalCode);
        normalsignDTO.setUsersAddressLine1(usersAddressLine1);
        normalsignDTO.setUsersAddressLine2(usersAddressLine2);

        if (normalUsersLevel != null && !normalUsersLevel.isEmpty()) {
        	normalsignDTO.setNormalUsersLevel(normalUsersLevel.trim());
        }

        if (usersNumberParam != null && !usersNumberParam.isEmpty()) {
            try {
            	normalsignDTO.setUsersNumber(Integer.parseInt(usersNumberParam));
            } catch (NumberFormatException e) {
                System.out.println("Normal usersNumber 파싱 실패: " + usersNumberParam);
            }
        }

        new NormalUsersDAO().sign(normalsignDTO); 

        Result result = new Result();
        result.setRedirect(true);
        result.setPath(request.getContextPath() + "/users/login.us");
        return result;
    }
}
