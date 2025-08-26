package com.wt.app.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.dto.CareSignDTO;
import com.wt.app.users.dao.CareUsersDAO;

public class CareJoinOkController implements Execute {

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
        String careIntroText = request.getParameter("careIntroText");
        String usersNumberParam = request.getParameter("usersNumber");

        String certParam = request.getParameter("careCertificateFilesNum");
        String passParam = request.getParameter("carePassbookFilesNum");
        String profParam = request.getParameter("careProfilesPhotoNumber");

        CareSignDTO caresignDTO = new CareSignDTO();
        caresignDTO.setUsersName(usersName);
        caresignDTO.setUsersEmail(usersEmail);
        caresignDTO.setUsersPhone(usersPhone);
        caresignDTO.setUsersPostsalCode(usersPostsalCode);
        caresignDTO.setUsersAddressLine1(usersAddressLine1);
        caresignDTO.setUsersAddressLine2(usersAddressLine2);
        caresignDTO.setCareIntroText(careIntroText);

        if (usersNumberParam != null && !usersNumberParam.isEmpty()) {
            try {
            	caresignDTO.setUsersNumber(Integer.parseInt(usersNumberParam)); // int 사용
            } catch (NumberFormatException e) {
                System.out.println("Care usersNumber 파싱 실패: " + usersNumberParam);
            }
        }

        if (certParam != null && !certParam.isEmpty()) {
            try { 
            	caresignDTO.setCareCertificateFilesNum(Long.parseLong(certParam)); 
            	}
            catch (NumberFormatException e) { 
            	System.out.println("cert 파싱 실패: " + certParam); 
            	}
        }
        
        if (passParam != null && !passParam.isEmpty()) {
            try { caresignDTO.setCarePassbookFilesNum(Long.parseLong(passParam)); }
            catch (NumberFormatException e) { System.out.println("pass 파싱 실패: " + passParam); }
        }
        if (profParam != null && !profParam.isEmpty()) {
            try { caresignDTO.setCareProfilesPhotoNumber(Long.parseLong(profParam)); }
            catch (NumberFormatException e) { System.out.println("prof 파싱 실패: " + profParam); }
        }

        new CareUsersDAO().sign(caresignDTO); // 매퍼: careUsers.join

        Result result = new Result();
        result.setRedirect(true);
        result.setPath(request.getContextPath() + "/users/login.us");
        return result;
    }
}

