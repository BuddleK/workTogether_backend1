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
import com.wt.app.admin.dao.AdminCareDAO;
import com.wt.app.dto.AdminCareSignupDTO;

public class AdminCareListController implements Execute {

	@Override
	public Result Execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("====AdminCareListController 실행====");

		Result result = new Result();

		AdminCareDAO adminCareDAO = new AdminCareDAO();

		String temp = request.getParameter("page");
		int page = (temp == null) ? 1 : Integer.parseInt(temp);
		int rowCount = 10;
		int pageCount = 5;

		int startRow = (page - 1) * rowCount + 1;
		int endRow = startRow + rowCount - 1;

		Map<String, Integer> pageMap = new HashMap<>();
		pageMap.put("startRow", startRow);
		pageMap.put("endRow", endRow);

		List<AdminCareSignupDTO> list = adminCareDAO.pendingListPaged(pageMap);
		int total = adminCareDAO.pendingCount();

		int realEndPage = (int) Math.ceil(total / (double) rowCount);
		int endPage = (int) (Math.ceil(page / (double) pageCount) * pageCount);
		int startPage = endPage - (pageCount - 1);
		endPage = Math.min(endPage, realEndPage);
		boolean prev = startPage > 1;
		boolean next = endPage < realEndPage;

		request.setAttribute("list", list);
		request.setAttribute("page", page);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("prev", prev);
		request.setAttribute("next", next);
		request.setAttribute("total", total);

		System.out.println("====페이징정보 확인====");
		System.out.println("pageMap : " + pageMap);
		System.out.println("list size : " + (list == null ? 0 : list.size()));
		System.out.println("startPage : " + startPage + ", endPage : " + endPage + ", prev : " + prev + ", next : " + next);

		// 이동 경로 (JSP 경로는 프로젝트 구조에 맞게)
		result.setPath("add/admin/careRequest.jsp");
		result.setRedirect(false);
		return result;
	}

}
