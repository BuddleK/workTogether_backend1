package com.wt.app.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.admin.dao.AdminDAO;
import com.wt.app.dto.CareCareerRowDTO;

public class AdminCareCareerListController implements Execute {
	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("==== AdminCareCareerListController 실행 ====");

        Result result = new Result();
        AdminDAO dao = new AdminDAO();

        String pageParam = request.getParameter("page");
        int page = 1;
        try {
            if (pageParam != null && !pageParam.isBlank()) {
                page = Integer.parseInt(pageParam);
                if (page < 1) page = 1;
            }
        } catch (NumberFormatException ignore) { page = 1; }

        String column  = trimToNull(request.getParameter("column"));
        String keyword = trimToNull(request.getParameter("keyword"));

        final int ROW = 7;
        final int PAGE = 5;

        int startRow = (page - 1) * ROW + 1;
        int endRow   = page * ROW;

        int total = dao.careCareerCount(column, keyword);

        int realEndPage = (int)Math.ceil(total / (double)ROW);
        if (realEndPage == 0) realEndPage = 1;
        if (page > realEndPage) {
            page = realEndPage;
            startRow = (page - 1) * ROW + 1;
            endRow   = page * ROW;
        }

        List<CareCareerRowDTO> list = dao.careCareerListPaged(startRow, endRow, column, keyword);

        // 페이징 계산
        int endPage = (int)(Math.ceil(page / (double)PAGE) * PAGE);
        int startPage = endPage - (PAGE - 1);
        if (endPage > realEndPage) endPage = realEndPage;
        if (startPage < 1) startPage = 1;

        boolean prev = startPage > 1;
        boolean next = endPage < realEndPage;

        request.setAttribute("list", list);
        request.setAttribute("page", page);
        request.setAttribute("startPage", startPage);
        request.setAttribute("endPage", endPage);
        request.setAttribute("prev", prev);
        request.setAttribute("next", next);
        request.setAttribute("total", total);
        request.setAttribute("rowCount", ROW);

        request.setAttribute("column", column);
        request.setAttribute("keyword", keyword);

        result.setPath("/app/admin/careCareer.jsp");
        result.setRedirect(false);
        return result;
    }

    private String trimToNull(String s) {
        if (s == null) return null;
        s = s.trim();
        return s.isEmpty() ? null : s;
    }
}