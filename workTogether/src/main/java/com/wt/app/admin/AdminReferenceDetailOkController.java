package com.wt.app.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.admin.dao.AdminDAO;
import com.wt.app.dto.AdminReferenceReplyDTO;

public class AdminReferenceDetailOkController implements Execute {

    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        Result result = new Result();

        // JSP에서 넘어온 파라미터 받기
        int referenceNumber = Integer.parseInt(request.getParameter("referenceNumber"));
        int adminNumber = (Integer) request.getSession().getAttribute("adminNumber"); // 세션에서 가져오기
        String replyContent = request.getParameter("replyContent");

        // DTO에 담기
        AdminReferenceReplyDTO replyDTO = new AdminReferenceReplyDTO();
        replyDTO.setReferenceNumber(referenceNumber);
        replyDTO.setAdminNumber(adminNumber);
        replyDTO.setReplyContent(replyContent);

        AdminDAO adminDAO = new AdminDAO();
        adminDAO.insertReply(replyDTO);

        // 등록 후 상세 페이지로 redirect
        result.setPath("/admin/adminReferenceList.ad");
        result.setRedirect(true);

        return result;
    }
}
