package com.wt.app.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.dto.CareSignDTO;
import com.wt.app.dto.UsersDTO;
import com.wt.app.users.dao.CareUsersDAO;
import com.wt.app.users.dao.UsersDAO;

public class CareJoinOkController implements Execute {

    private static Long toLongOrNull(String s) {
        return (s == null || s.isEmpty()) ? null : Long.parseLong(s);
    }

    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        Result result = new Result();

        try {
            // 공통 파라미터
            String usersId = request.getParameter("usersId");
            String usersPassword = request.getParameter("usersPassword");
            String usersName = request.getParameter("usersName");
            String usersEmail = request.getParameter("usersEmail");
            String usersPhone = request.getParameter("usersPhone");
            String usersPostsalCode = request.getParameter("usersPostsalCode");
            String usersAddressLine1 = request.getParameter("usersAddressLine1");
            String usersAddressLine2 = request.getParameter("usersAddressLine2");

            // 돌봄 상세 파라미터
            String careIntroText = request.getParameter("careIntroText");
            Long cert = toLongOrNull(request.getParameter("careCertificateFilesNum"));
            Long pass = toLongOrNull(request.getParameter("carePassbookFilesNum"));
            Long prof = toLongOrNull(request.getParameter("careProfilesPhotoNumber"));

            // 1) 공통 users INSERT → PK(long) 획득
            UsersDTO userDTO = new UsersDTO();
            userDTO.setUsersId(usersId);
            userDTO.setUsersPassword(usersPassword);
            userDTO.setUsersType("C");
            userDTO.setUsersName(usersName);
            userDTO.setUsersEmail(usersEmail);
            userDTO.setUsersPhone(usersPhone);
            userDTO.setUsersPostsalCode(usersPostsalCode);
            userDTO.setUsersAddressLine1(usersAddressLine1);
            userDTO.setUsersAddressLine2(usersAddressLine2);

            long usersNumber = new UsersDAO().join(userDTO);

            // 2) 돌봄 상세 INSERT (NULL 방지 기본값 적용)
            CareSignDTO caresignDTO = new CareSignDTO();
            caresignDTO.setUsersNumber(usersNumber);
            caresignDTO.setCareIntroText(careIntroText);
            caresignDTO.setCareAccept("W"); // 승인 대기 기본값

            caresignDTO.setCareCertificateFilesNum(cert != null ? cert : 0L);
            caresignDTO.setCarePassbookFilesNum(pass != null ? pass : 0L);
            caresignDTO.setCareProfilesPhotoNumber(prof != null ? prof : 0L);

            new CareUsersDAO().sign(caresignDTO);

            // 성공 → 메인 페이지로 이동
            result.setRedirect(true);
            result.setPath(request.getContextPath() + "/mainOk.main");
            return result;

        } catch (Exception e) {
            e.printStackTrace(); // 원인 로그 확인
            result.setRedirect(true);
            result.setPath(request.getContextPath() + "/app/sign/signCare.jsp?error=join");
            return result;
        }
    }
}
