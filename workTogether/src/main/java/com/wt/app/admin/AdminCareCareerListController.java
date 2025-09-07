package com.wt.app.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.dto.CareCareerRowDTO;

public class AdminCareCareerListController implements Execute {
	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("==== AdminCareCareerListController 1 실행 ====");

		Result result = new Result();

		// 페이지 파라미터
		String temp = request.getParameter("page");
		int page = 1;
		try {
			if (temp != null && !temp.isBlank()) {
				page = Integer.parseInt(temp);
				if (page < 1)
					page = 1;
			}
		} catch (NumberFormatException ignore) {
			page = 1;
		}

		final int ROW = 7;
		final int PAGE = 5;

		int startRow = (page - 1) * ROW + 1;
		int endRow = page * ROW;

		List<CareCareerRowDTO> list = new ArrayList<>();

		int total = list.size(); // 0

		int realEndPage = (int) Math.ceil(total / (double) ROW);
		int endPage = (int) (Math.ceil(page / (double) PAGE) * PAGE);
		int startPage = endPage - (PAGE - 1);

		if (realEndPage == 0) {
			startPage = 1;
			endPage = 1;
			page = 1;
		} else if (endPage > realEndPage) {
			endPage = realEndPage;
		}

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

		result.setPath("/app/admin/careCareer.jsp");
		result.setRedirect(false);
		return result;
	}
}