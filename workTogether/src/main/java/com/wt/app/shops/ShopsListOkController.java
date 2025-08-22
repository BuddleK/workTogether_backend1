package com.wt.app.shops;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.dto.ShopsListDTO;
import com.wt.app.shops.dao.ShopsDAO;

public class ShopsListOkController implements Execute {

	@Override
	public Result Execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("====shopsListOkController 실행====");

		ShopsDAO shopsDAO = new ShopsDAO();
		Result result = new Result();

		

		String tmp = request.getParameter("pg");
		int pg = (tmp == null) ? 1 : Integer.valueOf(tmp);
		int rowCnt = 4;
		int pgCnt = 4;

		int startRow = (pg - 1) * rowCnt + 1;
		int endRow = startRow + rowCnt - 1;

		Map<String, Integer> pageMap = new HashMap<>();
		pageMap.put("startRow", startRow);
		pageMap.put("endRow", endRow);
		
		// 게시글 목록 조회
				List<ShopsListDTO> shopsList = shopsDAO.shopSelectAll(pageMap);
				request.setAttribute("shopsList", shopsList);

		int total = shopsDAO.getTotal();
		int realEndPage = (int) Math.ceil(total / (double) rowCnt);
		int endPage = (int) (Math.ceil(pg / (double) pgCnt) * pgCnt);
		int startPage = endPage - (pgCnt - 1);

		endPage = Math.min(endPage, realEndPage);

		// prev, next 버튼 활성화 여부 확인
		boolean prev = startPage > 1;
		boolean next = endPage < realEndPage;

		request.setAttribute("page", pg);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("prev", prev);
		request.setAttribute("next", next);

		System.out.println("====페이징정보 확인====");
		System.out.println("pageMap : " + pageMap);
		System.out.println("shopsList : " + shopsList);
		System.out.println(
				"startPage : " + startPage + ", endPage : " + endPage + ", prev : " + prev + ", next : " + next);
		System.out.println("====================");

		result.setPath("/app/restaurant/restaurant.jsp");
		result.setRedirect(false);

		return result;

	}

}
