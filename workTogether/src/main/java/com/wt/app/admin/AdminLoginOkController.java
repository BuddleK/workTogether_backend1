package com.wt.app.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.admin.dao.AdminDAO;
import com.wt.app.dto.AdminLoginDTO;

public class AdminLoginOkController implements Execute {
    @Override
    public Result Execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String adminId = request.getParameter("adminId");            // ★ JSP name과 동일
        String adminPassword = request.getParameter("adminPassword"); // ★ JSP name과 동일

        AdminDAO adminDAO = new AdminDAO();
        AdminLoginDTO dto = new AdminLoginDTO();
        dto.setAdminId(adminId);
        dto.setAdminPassword(adminPassword);

        Integer adminNumber = adminDAO.login(dto); // 일치 없으면 null

        Result result = new Result();
        if (adminNumber == null) {
            // 로그인 실패: 다시 로그인 페이지로
            request.setAttribute("loginError", "아이디 또는 비밀번호가 올바르지 않습니다.");
            result.setPath("/app/admin/adminLogin.jsp");
            result.setRedirect(false);
            return result;
        }

        // 로그인 성공: 세션 저장
        HttpSession session = request.getSession();
        session.setAttribute("adminNumber", adminNumber);
        String adminName = adminDAO.getAdminName(adminNumber);
        session.setAttribute("adminName", adminName);

        // 이동 (예: 관리자 메인)
        result.setPath(request.getContextPath() + "/admin/main.ad");
        result.setRedirect(true);
        return result;
    }
}
