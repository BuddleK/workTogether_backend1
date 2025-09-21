package com.wt.app.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.admin.dao.AdminDAO;
import com.wt.app.dto.AdminNoticeListDTO;

public class AdminNoticeUpdateController implements Execute {

    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Result result = new Result();
        
        HttpSession session = request.getSession();
        Integer adminNumber = (Integer) session.getAttribute("adminNumber");
        
        if (adminNumber == null) {
            result.setPath("/admin/login.ad");
            result.setRedirect(true);
            return result;
        }
        
        // 수정할 공지사항 번호를 파라미터로 받아옴
        String strNoticeNumber = request.getParameter("noticeNumber");
        if (strNoticeNumber == null || strNoticeNumber.isEmpty()) {
            result.setPath("/admin/adminNotice.ad"); // 번호 없으면 목록으로
            result.setRedirect(true);
            return result;
        }
        
        int noticeNumber = Integer.valueOf(strNoticeNumber);

        // DAO로 공지사항 조회
        AdminDAO adminDAO = new AdminDAO();
        AdminNoticeListDTO notice = adminDAO.adminNoticeDetailSearch(noticeNumber);
        
        request.setAttribute("notice", notice);
        
        result.setPath("/app/admin/noticeDetail.jsp");
        result.setRedirect(false);
        
        return result;
    }
}
