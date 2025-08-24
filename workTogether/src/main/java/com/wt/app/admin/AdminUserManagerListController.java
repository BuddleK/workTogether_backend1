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
import com.wt.app.admin.dao.AdminTwoDAO;
import com.wt.app.dto.AdminUserManagerDTO;

public class AdminUserManagerListController implements Execute {

	@Override
	public Result Execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AdminTwoDAO adminTwoDAO = new AdminTwoDAO();
		Result result = new Result();

		String temp = request.getParameter("paging");
		int page = (temp == null) ? 1 : Integer.valueOf(temp);
		int rowCount = 7;
		int pageCount = 5;

		int startRow = (page - 1) * rowCount + 1; // 시작행(1, 11, 21, ..)
		int endRow = startRow + rowCount - 1; // 끝 행(10, 20, 30, ..)

		Map<String, Integer> pageMap = new HashMap<>();
		pageMap.put("startRow", startRow);
		pageMap.put("endRow", endRow);

		List<AdminUserManagerDTO> userlist = adminTwoDAO.adminUserManager(pageMap);
		request.setAttribute("userList", userlist);

		int total = adminTwoDAO.getUserTotal();
		int realEndPage = (int) Math.ceil(total / (double) rowCount); // 실제 마지막 페이지(전체 게시글 기준으로 계산)
		int endPage = (int) (Math.ceil(page / (double) pageCount) * pageCount); // 현재 페이지 그룹에서의 마지막 페이지
		int startPage = endPage - (pageCount - 1); // 현재 페이지 그룹에서의 첫 페이지

		// endPage가 실제 존재하는 마지막 페이지보다 크면 조정
		endPage = Math.min(endPage, realEndPage);

		boolean prev = startPage > 1;
		boolean next = endPage < realEndPage;

		request.setAttribute("paging", page);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("prev", prev);
		request.setAttribute("next", next);

		result.setPath("/admin/notice.jsp");
		result.setRedirect(false);

		return result;
	}

}
