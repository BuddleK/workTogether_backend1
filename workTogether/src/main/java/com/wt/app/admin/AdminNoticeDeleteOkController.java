package com.wt.app.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.admin.dao.AdminDAO;

public class AdminNoticeDeleteOkController implements Execute {

    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String strNoticeNumber = request.getParameter("noticeNumber");
        if (strNoticeNumber != null && !strNoticeNumber.isEmpty()) {
            int noticeNumber = Integer.valueOf(strNoticeNumber);

            AdminDAO adminDAO = new AdminDAO();
            adminDAO.adminNoticeListDelete(noticeNumber);
        }

        Result result = new Result();
        result.setPath(request.getContextPath() + "/admin/adminNotice.ad"); // 목록으로
        result.setRedirect(true);

        return result;
    }
}
