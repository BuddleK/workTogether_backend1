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
import com.wt.app.dto.AdminNewsBoardListDTO;
import com.wt.app.news.dao.AdminNewsDAO;

public class AdminNewsListOkController implements Execute{

	@Override
	public Result Execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("====AdminNewsListOkController 실행====");

        AdminNewsDAO newsDAO = new AdminNewsDAO();
        Result result = new Result();

        // 페이지 파라미터 처리
        String temp = request.getParameter("page");
        int page = (temp == null) ? 1 : Integer.parseInt(temp); // 기본 1페이지
        int rowCount = 10; // 한 페이지당 뉴스 수
        int pageCount = 5; // 페이지 버튼 수

        // 페이징 계산
        int startRow = (page - 1) * rowCount + 1; // 1, 11, 21, ...
        int endRow   = startRow + rowCount - 1;   // 10, 20, 30, ...

        Map<String, Integer> pageMap = new HashMap<>();
        pageMap.put("startRow", startRow);
        pageMap.put("endRow", endRow);

        // 뉴스 목록 조회
        List<AdminNewsBoardListDTO> newsList = newsDAO.selectAll(pageMap);
        request.setAttribute("newsList", newsList);

        // 전체 개수 및 페이지네이션 계산
        int total = newsDAO.getTotal();
        int realEndPage = (int)Math.ceil(total / (double)rowCount); // 실제 마지막 페이지
        int endPage = (int)(Math.ceil(page / (double)pageCount) * pageCount); // 현재 그룹 마지막
        int startPage = endPage - (pageCount - 1); // 현재 그룹 시작

        // endPage 보정
        endPage = Math.min(endPage, realEndPage);

        boolean prev = startPage > 1;
        boolean next = endPage < realEndPage;

        // 뷰에 전달
        request.setAttribute("page", page);
        request.setAttribute("startPage", startPage);
        request.setAttribute("endPage", endPage);
        request.setAttribute("prev", prev);
        request.setAttribute("next", next);

        System.out.println("====페이징정보 확인====");
        System.out.println("pageMap : " + pageMap);
        System.out.println("newsList : " + newsList);
        System.out.println("startPage : " + startPage + ", endPage : " + endPage + ", prev : " + prev + ", next : " + next);
        System.out.println("====================");

        // 이동 경로
        result.setPath("/app/admin/newsList.jsp");
        result.setRedirect(false);

        return result;
	}

}
