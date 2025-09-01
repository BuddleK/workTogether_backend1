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

public class AdminCareCareerListController implements Execute{
	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("==== AdminCareCareerListController 1 실행 ====");

        Result result = new Result();
        System.out.println("1");

        // 페이지 파라미터
        String temp = request.getParameter("page");
        int page = 1;
        try {
            if (temp != null && !temp.isBlank()) {
                page = Integer.parseInt(temp);
                if (page < 1) page = 1;
            }
        } catch (NumberFormatException ignore) {
            page = 1;
        }

        // 1페이지당 7개, 밑에 번호 5개
        final int ROW  = 7;
        final int PAGE = 5;

        // ROWNUM BETWEEN 용 범위 (컨트롤러에서 계산, DAO/매퍼에서 사용)
        int startRow = (page - 1) * ROW + 1;
        int endRow   = page * ROW;


        List<CareCareerRowDTO> list = new ArrayList<>();        
        CareCareerRowDTO row1 = new CareCareerRowDTO();
        row1.setNumber(1);
        row1.setName("가나다");
        row1.setUserId("abc123");
        row1.setDate("2025-08-09");
        row1.setStatus("승인");
        list.add(row1);
		int total = list.size();

		// 페이지 계산
		int realEndPage = (int) Math.ceil(total / (double) ROW);
		int endPage = (int) (Math.ceil(page / (double) PAGE) * PAGE);
		int startPage = endPage - (PAGE - 1);
        if (realEndPage == 0) {
            startPage = 1; endPage = 1; page = 1;
        } else if (endPage > realEndPage) {
            endPage = realEndPage;
        }
        boolean prev = startPage > 1;
        boolean next = endPage < realEndPage;

        // 뷰에 전달
        request.setAttribute("list", list);
        request.setAttribute("page", page);
        request.setAttribute("startPage", startPage);
        request.setAttribute("endPage", endPage);
        request.setAttribute("prev", prev);
        request.setAttribute("next", next);
        request.setAttribute("total", total);
        request.setAttribute("rowCount", ROW);

        // 포워드 경로 
        result.setPath("/app/admin/careCareerDetailUpdate.jsp");
        result.setRedirect(false);
        return result;
    }

}