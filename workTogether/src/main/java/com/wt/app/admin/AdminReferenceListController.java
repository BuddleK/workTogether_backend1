package com.wt.app.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.admin.dao.AdminDAO;
import com.wt.app.dto.AdminReferenceListDTO;

public class AdminReferenceListController implements Execute {

    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // DAO 호출
        AdminDAO adminDAO = new AdminDAO();
        List<AdminReferenceListDTO> questions = adminDAO.adminReferenceListSelect();
        
        request.setAttribute("questions", questions);

        Result result = new Result();
        result.setPath("/app/admin/qeustion.jsp");
        result.setRedirect(false);
        return result;
    }
}
