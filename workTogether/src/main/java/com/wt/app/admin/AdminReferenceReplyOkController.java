package com.wt.app.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.admin.dao.AdminDAO;
import com.wt.app.dto.AdminReferenceReplyDTO;

public class AdminReferenceReplyOkController implements Execute {

    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        Result result = new Result();
        
        String refNumStr = request.getParameter("referenceNumber");
        if(refNumStr == null || refNumStr.isEmpty()) {
            throw new RuntimeException("referenceNumber 파라미터가 비어 있습니다.");
        }
        int referenceNumber = Integer.parseInt(refNumStr);
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
