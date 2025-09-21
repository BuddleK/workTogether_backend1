package com.wt.app.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.admin.dao.AdminDAO;
import com.wt.app.dto.AdminNoticeListDTO;

public class AdminNoticeInsertOkController implements Execute {

    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        AdminDAO adminDAO = new AdminDAO();
        Result result = new Result();

        Integer adminNumber = (Integer) request.getSession().getAttribute("adminNumber");

        if (adminNumber == null) {
            System.out.println("로그인된 관리자가 없습니다");
            response.sendRedirect("/admin/login.ad");
            return null;
        }

        AdminNoticeListDTO adminNoticeListDTO = new AdminNoticeListDTO();
        adminNoticeListDTO.setNoticeTitle(request.getParameter("noticeTitle"));
        adminNoticeListDTO.setNoticeContent(request.getParameter("noticeContent"));
        adminNoticeListDTO.setAdminNumber(adminNumber);
        System.out.println("게시글 추가 - adminNoticeListDTO : " + adminNoticeListDTO);

        int noticeNumber = adminDAO.adminNoticeListInsert(adminNoticeListDTO);
        System.out.println("생성된 게시글 번호 : " + noticeNumber);

        result.setPath(request.getContextPath() + "/admin/adminNotice.ad");
        result.setRedirect(true);

        return result;
    }
}
