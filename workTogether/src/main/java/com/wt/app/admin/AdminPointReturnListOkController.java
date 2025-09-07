package com.wt.app.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.admin.dao.AdminDAO;
import com.wt.app.dto.CarePointreturnDTO;

public class AdminPointReturnListOkController implements Execute {

    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("====AdminPointReturnListOkController 실행====");

        request.setCharacterEncoding("UTF-8");
        Result result = new Result();
        AdminDAO dao = new AdminDAO();

        int page = 1;
        String temp = request.getParameter("page");
        if (temp != null && !temp.isEmpty()) {
            try { page = Integer.parseInt(temp); } catch (Exception ignore) {}
        }
        if (page < 1) page = 1;

        String status = request.getParameter("status");

        int rowCount = 7;
        int pageCount = 5;

        int total = dao.pointReturnCount(status);
        int realEndPage = Math.max(1, (int)Math.ceil(total / (double)rowCount));
        if (page > realEndPage) page = realEndPage;

        int startRow = (page - 1) * rowCount + 1;
        int endRow   = startRow + rowCount - 1;

        List<CarePointreturnDTO> list = dao.pointReturnListPaged(startRow, endRow, status);

        int endPage = (int)(Math.ceil(page / (double)pageCount) * pageCount);
        int startPage = endPage - (pageCount - 1);
        endPage = Math.min(endPage, realEndPage);
        if (startPage < 1) startPage = 1;

        boolean prev = startPage > 1;
        boolean next = endPage < realEndPage;

        request.setAttribute("list", list);
        request.setAttribute("page", page);
        request.setAttribute("startPage", startPage);
        request.setAttribute("endPage", endPage);
        request.setAttribute("prev", prev);
        request.setAttribute("next", next);
        request.setAttribute("rowCount", rowCount);
        request.setAttribute("total", total);
        request.setAttribute("status", status);
        request.setAttribute("realEndPage", realEndPage);
        request.setAttribute("pageCount", pageCount);

        System.out.println("status : " + status);
        System.out.println("list size : " + (list == null ? 0 : list.size()));
        System.out.println("startPage : " + startPage + ", endPage : " + endPage + ", prev : " + prev + ", next : " + next);

        result.setPath("/app/admin/refund.jsp");
        result.setRedirect(false);
        return result;
    }
}
