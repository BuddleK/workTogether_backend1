package com.wt.app.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.dto.FindIdDTO;
import com.wt.app.users.dao.UsersDAO;

public class FindIdOkController implements Execute {

    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        Result result = new Result();

        // 1) 파라미터 수집
        String usersName  = trimOrNull(request.getParameter("usersName"));
        String usersPhone = trimOrNull(request.getParameter("usersPhone"));
        String usersType  = trimOrNull(request.getParameter("usersType"));   // 'N' or 'C'
        // JSP에 name="authCode"로 들어옴(여분 대비 verificationCode도 체크)
        String inputCode  = trimOrNull(request.getParameter("authCode"));
        if (inputCode == null) {
            inputCode = trimOrNull(request.getParameter("verificationCode"));
        }

        // 2) 기본 유효성 체크
        if (usersName == null || usersPhone == null || usersType == null || inputCode == null) {
            request.setAttribute("findIdError", "입력값이 부족합니다. 다시 입력해 주세요.");
            preserveInputs(request, usersName, usersPhone, usersType);
            result.setRedirect(false);
            result.setPath("/app/login/findId.jsp");
            return result;
        }

        // 3) 휴대폰 인증 코드 검증(세션에 저장된 verificationCode와 비교)
        HttpSession session = request.getSession(false);
        String sessionCode = (session == null) ? null : (String) session.getAttribute("verificationCode");

        if (sessionCode == null || !sessionCode.equals(inputCode)) {
            request.setAttribute("findIdError", "휴대폰 인증을 먼저 완료해 주세요.");
            preserveInputs(request, usersName, usersPhone, usersType);
            result.setRedirect(false);
            result.setPath("/app/login/findId.jsp");
            return result;
        }

        // 일회성 사용 후 제거
        session.removeAttribute("verificationCode");

        // 4) DB 조회
        // 전화번호에 하이픈이 섞여 들어올 수 있으니 숫자만 남기도록 정규화(DAO 요구사항에 맞게 조정)
        String normalizedPhone = usersPhone.replaceAll("[^0-9]", "");

        FindIdDTO dto = new FindIdDTO();
        dto.setUsersName(usersName);
        dto.setUsersPhone(normalizedPhone);
        dto.setUsersType(usersType);

        UsersDAO usersDAO = new UsersDAO();
        String usersId = usersDAO.findUserIdByNamePhone(dto);

        // 5) 포워드
        if (usersId != null) {
            request.setAttribute("usersId", usersId);
            result.setRedirect(true);
            result.setPath("/app/login/findIdResult.jsp");
        } else {
            request.setAttribute("findIdError", "일치하는 회원 정보가 없습니다.");
            preserveInputs(request, usersName, usersPhone, usersType);
            result.setRedirect(false);
            result.setPath("/app/login/findIdResult.jsp");
        }

        return result;
    }

    /** null-safe trim */
    private String trimOrNull(String s) {
        if (s == null) return null;
        String t = s.trim();
        return t.isEmpty() ? null : t;
    }

    /** 입력값 유지(되돌아갈 때 기존 값 채워 넣기 용) */
    private void preserveInputs(HttpServletRequest request, String name, String phone, String type) {
        request.setAttribute("prevName",  name  == null ? "" : name);
        request.setAttribute("prevPhone", phone == null ? "" : phone);
        request.setAttribute("prevType",  type  == null ? "" : type);
    }
}
