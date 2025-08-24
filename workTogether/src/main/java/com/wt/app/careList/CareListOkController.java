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

public class CareListOkController implements Execute  {

	@Override
	public Result Execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("CareListOkController 실행");
		
		CareListDTO careListDTO = new CareListDTO();
		CareListDAO careListDAO = new CareListDAO();
		
		String tmp = request.getParameter("page");
		int page = (tmp == null) ? 1 : Integer.valueOf(tmp);
		int rowCount = 4;
		int pageCount = 4;

		int startRow = (page - 1) * rowCount + 1;
		int endRow = startRow + rowCount - 1;

		Map<String, Integer> pageMap = new HashMap<>();
		pageMap.put("startRow", startRow);
		pageMap.put("endRow", endRow);
		
		// 전체 리스트 조회
		List<CareListDTO> careList = careListDAO.selectAll(pageMap);
		request.setAttribute("careList", careList);
		
		int total = careListDAO.getTotal();
		int realEndPage = (int)Math.ceil(total/ (double)rowCount);
		int endPage = (int) (Math.ceil(page / (double) pageCount) * pageCount);
		int startPage = endPage - (pageCount -  1);
		
		endPage = Math.min(endPage, realEndPage);
		
		boolean prev= startPage>1;
		boolean next = endPage < realEndPage;
		
		Result result = new Result();
		result.setPath("/app/careMember/careMember.jsp");
		return result;
	}

	
}
