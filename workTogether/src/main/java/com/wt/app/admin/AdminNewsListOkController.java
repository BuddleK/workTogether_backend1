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
import com.wt.app.dto.AdminNewsBoardListDTO;


public class AdminNewsListOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("====AdminNewsListOkController 실행====");

		AdminDAO adminDAO = new AdminDAO();
		Result result = new Result();

		int page = 1;
		String temp = request.getParameter("page");
		try {
            if (temp != null && !temp.isEmpty()) {
                page = Integer.parseInt(temp);
            }
        } catch (NumberFormatException ignore) {
            page = 1;
        }
        if (page < 1) page = 1;
        
		int rowCount = 7; // 한 페이지당 게시글 수
		int pageCount = 5;// 페이지 버튼 수

		int total = adminDAO.getNewsTotal();
        int realEndPage = (int)Math.ceil(total / (double)rowCount);
        if (realEndPage == 0) {
            // 게시글 0개인 첫 로드
            realEndPage = 1;  // UI 페이징 표시용
        }
        if (page > realEndPage) page = realEndPage;

		// 페이징 처리 시작/끝 행 계산
		int startRow = (page - 1) * rowCount + 1;
		int endRow = startRow + rowCount - 1;

		Map<String, Integer> pageMap = new HashMap<>();
		pageMap.put("startRow", startRow);
		pageMap.put("endRow", endRow);


		List<AdminNewsBoardListDTO> newsList = adminDAO.selectAll(pageMap);
		request.setAttribute("newsList", newsList);
		
		
		int endPage = (int) (Math.ceil(page / (double) pageCount) * pageCount);// 현재 페이지 그룹에서의 마지막 페이지
		int startPage = endPage - (pageCount - 1);// 현재 페이지 그룹에서의 첫 페이지

		// endPage가 실제 존재하는 마지막 페이지보다 크면 조정
		 endPage = Math.min(endPage, (int)Math.ceil(total / (double)rowCount));
	        if (endPage < 1) endPage = 1;
	        if (startPage < 1) startPage = 1;

		boolean prev = startPage > 1;
		boolean next = endPage < realEndPage;

		request.setAttribute("page", page);
        request.setAttribute("startPage", startPage);
        request.setAttribute("endPage", endPage);
        request.setAttribute("prev", prev);
        request.setAttribute("next", next);
        request.setAttribute("rowCount", rowCount);
        request.setAttribute("total", total);

        System.out.println("====페이징정보 확인====");
        System.out.println("pageMap : " + pageMap);
        System.out.println("newsList size : " + (newsList != null ? newsList.size() : 0));
        System.out.println("total : " + total + ", realEndPage : " + (int)Math.ceil(total / (double)rowCount));
        System.out.println("startPage : " + startPage + ", endPage : " + endPage + ", prev : " + prev + ", next : " + next);
        System.out.println("====================");

		result.setPath("/app/admin/newsBoard.jsp");
        result.setRedirect(false);
        return result;
	}

}
