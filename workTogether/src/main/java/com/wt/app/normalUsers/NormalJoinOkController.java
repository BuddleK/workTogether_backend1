package com.wt.app.normalUsers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.dto.NormalSignDTO;
import com.wt.app.normalUsers.dao.NormalUsersDAO;

public class NormalJoinOkController implements Execute {

    @Override
    public Result Execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("Normal JoinOkController 진입");
        request.setCharacterEncoding("UTF-8");

        String usersName = request.getParameter("usersName");
        String usersEmail = request.getParameter("usersEmail");
        String usersPhone = request.getParameter("usersPhone");
        String usersPostsalCode = request.getParameter("usersPostsalCode");
        String usersAddressLine1 = request.getParameter("usersAddressLine1");
        String usersAddressLine2 = request.getParameter("usersAddressLine2");
        String normalUsersLevel = request.getParameter("normalUsersLevel");
        String usersNumberParam = request.getParameter("usersNumber");

        NormalSignDTO dto = new NormalSignDTO();
        dto.setUsersName(usersName);
        dto.setUsersEmail(usersEmail);
        dto.setUsersPhone(usersPhone);
        dto.setUsersPostsalCode(usersPostsalCode);
        dto.setUsersAddressLine1(usersAddressLine1);
        dto.setUsersAddressLine2(usersAddressLine2);

        if (normalUsersLevel != null && !normalUsersLevel.isEmpty()) {
            dto.setNormalUsersLevel(normalUsersLevel.trim().charAt(0));
        }

        if (usersNumberParam != null && !usersNumberParam.isEmpty()) {
            try {
                dto.setUsersNumber(Integer.parseInt(usersNumberParam));
            } catch (NumberFormatException e) {
                System.out.println("[Normal] usersNumber 파싱 실패: " + usersNumberParam);
            }
        }

        NormalUsersDAO normalUsersDAO = new NormalUsersDAO();
        normalUsersDAO.sign(dto);

        Result result = new Result();
        result.setRedirect(true);
        result.setPath(request.getContextPath() + "/normal/login.us?join=success");
        return result;
    }
}
