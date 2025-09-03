package com.wt.app.admin;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.admin.dao.AdminDAO;
import com.wt.app.dto.AdminCareSignupDTO;

public class AdminCareListController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("====AdminCareListController 실행====");

		request.setCharacterEncoding("UTF-8");
        Result result = new Result();
        AdminDAO dao = new AdminDAO();

        int page = 1;
        String temp = request.getParameter("page");
        try { if (temp != null && !temp.isEmpty()) page = Integer.parseInt(temp); } catch (Exception ignore) {}
        if (page < 1) page = 1;

        int rowCount = 7;   // 한 페이지당 행 수
        int pageCount = 5;  // 페이징 블록 크기

        int total = dao.carePendingCount(); // ★ 매퍼가 'W' 기준으로 카운트하도록 수정되어 있어야 함
        int realEndPage = Math.max(1, (int)Math.ceil(total / (double)rowCount));
        if (page > realEndPage) page = realEndPage;

        int startRow = (page - 1) * rowCount + 1;
        int endRow   = startRow + rowCount - 1;

        Map<String, Integer> pageMap = new HashMap<>();
        pageMap.put("startRow", startRow);
        pageMap.put("endRow", endRow);

        List<AdminCareSignupDTO> list = dao.pendingListPaged(pageMap);

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

        System.out.println("pageMap : " + pageMap);
        System.out.println("list size : " + (list == null ? 0 : list.size()));
        System.out.println("startPage : " + startPage + ", endPage : " + endPage + ", prev : " + prev + ", next : " + next);

        result.setPath("/app/admin/careRequest.jsp"); // 여기에 렌더링
        result.setRedirect(false);
        return result;
    }
}