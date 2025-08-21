package com.wt.app.careUsers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.dto.CareSignDTO;
import com.wt.app.careUsers.dao.CareUsersDAO;

public class CareJoinOkController implements Execute {

    @Override
    public Result Execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("Care JoinOkController 진입");
        request.setCharacterEncoding("UTF-8");

        String usersName = request.getParameter("usersName");
        String usersEmail = request.getParameter("usersEmail");
        String usersPhone = request.getParameter("usersPhone");
        String usersPostsalCode = request.getParameter("usersPostsalCode");
        String usersAddressLine1 = request.getParameter("usersAddressLine1");
        String usersAddressLine2 = request.getParameter("usersAddressLine2");
        String careIntroText = request.getParameter("careIntroText");
        String careCertificateFilesNum= request.getParameter("careCertificateFilesNum");
        String carePassbookFilesNum   = request.getParameter("carePassbookFilesNum");
        String careProfilesPhotoNumber= request.getParameter("careProfilesPhotoNumber");
        String careAccept             = request.getParameter("careAccept");
        String usersNumberParam       = request.getParameter("usersNumber");

        CareSignDTO dto = new CareSignDTO();
        dto.setUsersName(usersName);
        dto.setUsersEmail(usersEmail);
        dto.setUsersPhone(usersPhone);
        dto.setUsersPostsalCode(usersPostsalCode);
        dto.setUsersAddressLine1(usersAddressLine1);
        dto.setUsersAddressLine2(usersAddressLine2);
        dto.setCareIntroText(careIntroText);
        dto.setCareCertificateFilesNum(careCertificateFilesNum);
        dto.setCarePassbookFilesNum(carePassbookFilesNum);
        dto.setCareProfilesPhotoNumber(careProfilesPhotoNumber);
        dto.setCareAccept(careAccept == null || careAccept.trim().isEmpty() ? "N" : careAccept.trim());

        if (usersNumberParam != null && !usersNumberParam.isEmpty()) {
            try {
                dto.setUsersNumber(Integer.parseInt(usersNumberParam));
            } catch (NumberFormatException e) {
                System.out.println("[Care] usersNumber 파싱 실패: " + usersNumberParam);
            }
        }

        CareUsersDAO careUsersDAO = new CareUsersDAO();
        careUsersDAO.sign(dto);

        Result result = new Result();
        result.setRedirect(true);
        result.setPath(request.getContextPath() + "/care/login.us?join=success");
        return result;
    }
}

