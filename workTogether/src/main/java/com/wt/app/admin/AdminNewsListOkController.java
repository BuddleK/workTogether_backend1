package com.wt.app.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.admin.dao.AdminDAO;
import com.wt.app.dto.AdminNewsBoardListDTO;

public class AdminNewsListOkController implements Execute{

	@Override
	public Result Execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("====AdminNewsListOkController 실행====");
		
		int ROW  = 7; // 한 페이지에 보여줄 게시글 수
	    int PAGE = 5; // 하단 페이지 번호 묶음 크기

		AdminDAO dao = new AdminDAO();
        Result result = new Result();

        // 1) page 파라미터 파싱
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

        // 2) 조회 범위 계산 (Oracle ROWNUM BETWEEN 용)
        int startRow = (page - 1) * ROW + 1;
        int endRow   = page * ROW;

        // 3) 목록/총개수 조회
        List<AdminNewsBoardListDTO> newsList = dao.newsSelectAll(startRow, endRow);
        int total = dao.newsGetTotal();

        // 4) 페이지네이션 계산
        int realEndPage = (int) Math.ceil(total / (double) ROW);              // 실제 마지막 페이지
        int endPage     = (int) (Math.ceil(page / (double) PAGE) * PAGE); // 현재 그룹 마지막
        int startPage   = endPage - (PAGE - 1);                                  // 현재 그룹 시작
        if (realEndPage == 0) { // 데이터 없을 때 UI 안정화
            startPage = 1;
            endPage = 1;
            page = 1;
        } else {
            if (endPage > realEndPage) endPage = realEndPage;
            if (startPage < 1) startPage = 1;
        }
        boolean prev = startPage > 1;
        boolean next = endPage < realEndPage;

        // 5) 뷰로 전달 (JSP에서 쓰는 키 이름)
        //    프로젝트마다 키 이름이 다를 수 있어 호환용으로 둘 다 세팅
        request.setAttribute("newsList", newsList); // 사용 중인 JSP가 이 키를 쓸 때
        request.setAttribute("list", newsList);     // 혹시 'list'로 사용하는 JSP 호환

        request.setAttribute("page", page);
        request.setAttribute("startPage", startPage);
        request.setAttribute("endPage", endPage);
        request.setAttribute("prev", prev);
        request.setAttribute("next", next);
        request.setAttribute("realEndPage", realEndPage);

        // 6) 포워드 경로
        result.setPath("/app/admin/news/newsList.jsp");
        result.setRedirect(false);
        return result;
	}

}
