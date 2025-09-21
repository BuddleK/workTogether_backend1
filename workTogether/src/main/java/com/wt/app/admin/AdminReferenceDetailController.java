package com.wt.app.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.admin.dao.AdminDAO;
import com.wt.app.dto.AdminReferenceListDTO;

public class AdminReferenceDetailController implements Execute {
    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int referenceNumber = Integer.parseInt(request.getParameter("referenceNumber"));

        AdminDAO adminDAO = new AdminDAO();
        AdminReferenceListDTO question = adminDAO.adminReferenceDetail(referenceNumber);

        request.setAttribute("question", question);

        Result result = new Result();
        result.setPath("/app/admin/questionDetail.jsp");
        result.setRedirect(false);
        return result;
    }
}

