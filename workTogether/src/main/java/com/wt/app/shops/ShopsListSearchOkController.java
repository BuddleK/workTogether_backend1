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

public class ShopsListSearchOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("====shopsListOkController 실행====");

		ShopsDAO shopsDAO = new ShopsDAO();
		Result result = new Result();

		String shopsLegalDong = request.getParameter("legalDong");
		shopsLegalDong = shopsLegalDong.replaceAll(" ", "");
		System.out.println("동" + shopsLegalDong);
		
		List<ShopsListDTO> adminDongList = shopsDAO.adminDongSelect(); 
		request.setAttribute("adminDongList", adminDongList);

		// 선택된 지역 번호 계산
		int leNum = 0;
		for(int i = 0; i < adminDongList.size(); i++) {
		    if(adminDongList.get(i).getShopsAdminDong().equals(shopsLegalDong)) {
		        leNum = i;
		        break;
		    }
		}
		request.setAttribute("leNum", leNum);

		String tmp = request.getParameter("page");
		int page = (tmp == null) ? 1 : Integer.valueOf(tmp);
		int rowCount = 4;
		int pageCount = 4;

		int startRow = (page - 1) * rowCount + 1;
		int endRow = startRow + rowCount - 1;
		
		String startRowStr= startRow +"";
		String endRowStr= endRow +"";

		Map<String, String> pageMap = new HashMap<>();
		pageMap.put("startRow", startRowStr);
		pageMap.put("endRow", endRowStr);
		pageMap.put("shopsLegalDong", shopsLegalDong);
		
		// 게시글 목록 조회
		List<ShopsListDTO> shopsListDong = shopsDAO.shopSelectDongAll(pageMap);
		request.setAttribute("shopsList", shopsListDong);

		int total = shopsDAO.getDongTotal();
		int realEndPage = (int) Math.ceil(total / (double) rowCount);
		int endPage = (int) (Math.ceil(page / (double) pageCount) * pageCount);
		int startPage = endPage - (pageCount - 1);

		endPage = Math.min(endPage, realEndPage);

		// prev, next 버튼 활성화 여부 확인
		boolean prev = startPage > 1;
		boolean next = endPage < realEndPage;

		request.setAttribute("page", page);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("prev", prev);
		request.setAttribute("next", next);

		System.out.println("====페이징정보 확인====");
		System.out.println("pageMap : " + pageMap);
		System.out.println("shopsListDODODONG : " + shopsListDong);
		System.out.println(
				"startPage : " + startPage + ", endPage : " + endPage + ", prev : " + prev + ", next : " + next);
		System.out.println("====================");
		
		
		//법정 동명 전부 가져오기
		request.setAttribute("adminDongList", adminDongList);

		result.setPath("/app/restaurant/restaurantDong.jsp");
		result.setRedirect(false);

		return result;

	}

}
