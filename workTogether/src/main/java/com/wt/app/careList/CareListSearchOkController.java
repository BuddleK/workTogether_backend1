package com.wt.app.careList;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.careList.dao.CareListDAO;
import com.wt.app.dto.CareListDTO;

public class CareListSearchOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("CareListOkController 실행");

		CareListDTO careListDTO = new CareListDTO();
		CareListDAO careListDAO = new CareListDAO();

		String tmp = request.getParameter("page");
		
		String option = request.getParameter("option");
		String content = request.getParameter("content");
		
		int page = (tmp == null) ? 1 : Integer.valueOf(tmp);
		int rowCount = 4;
		int pageCount = 4;

		int startRow = (page - 1) * rowCount + 1;
		int endRow = startRow + rowCount - 1;
		
		String startRowStr = startRow+"";
		String endRowStr = endRow+"";

		Map<String, String> pageMap = new HashMap<>();
		pageMap.put("startRow", startRowStr);
		pageMap.put("endRow", endRowStr);
		pageMap.put("option", option);
		pageMap.put("content", content);

		// 전체 리스트 조회
		List<CareListDTO> careList = careListDAO.searchAll(pageMap);
		request.setAttribute("careList", careList);

		int total = careListDAO.getTotal();
		int realEndPage = (int) Math.ceil(total / (double) rowCount);
		int endPage = (int) (Math.ceil(page / (double) pageCount) * pageCount);
		int startPage = endPage - (pageCount - 1);

		endPage = Math.min(endPage, realEndPage);

		boolean prev = startPage > 1;
		boolean next = endPage < realEndPage;

		System.out.println(total);
		request.setAttribute("page", page);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("prev", prev);
		request.setAttribute("next", next);

		Result result = new Result();
		result.setPath("/app/careMember/careMember.jsp?search=${content}");
		return result;
	}
	
}
