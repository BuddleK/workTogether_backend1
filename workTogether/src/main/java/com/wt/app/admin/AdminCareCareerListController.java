package com.wt.app.admin;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;

public class AdminCareCareerListController implements Execute{
	@Override
	public Result Execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("==== AdminCareCareerListController 실행 ====");

        Result result = new Result();

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

        // 1페이지당 10개, 페이지 번호 묶음 5개(원하면 변경)
        final int ROW  = 10;
        final int PAGE = 5;

        // ROWNUM BETWEEN 용 범위 (컨트롤러에서 계산, DAO/매퍼에서 사용)
        int startRow = (page - 1) * ROW + 1;
        int endRow   = page * ROW;

        // TODO: DAO 연결되면 주석 해제하고 실제 목록/총개수 조회
        // AdminDAO dao = new AdminDAO();
        // List<CareCareerDTO> list = dao.careCareerList(startRow, endRow);
        // int total = dao.careCareerTotal();

        List<?> list = Collections.emptyList(); // 임시 빈 목록(컴파일/실행 안전)
        int total = 0;                          // 임시 총 개수

        // 페이징 계산
        int realEndPage = (int)Math.ceil(total / (double)ROW);
        int endPage     = (int)(Math.ceil(page / (double)PAGE) * PAGE);
        int startPage   = endPage - (PAGE - 1);
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

        // 포워드 경로 (JSP 파일 위치에 맞게 조정)
        result.setPath("/app/admin/careCareerList.jsp");
        result.setRedirect(false);
        return result;
    }

}