package com.wt.app.news;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.dto.AdminNewsBoardDTO;
import com.wt.app.news.dao.AdminNewsDAO;

public class AdminNewsReadOkController implements Execute{

	@Override
	public Result Execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 Result result = new Result();

	        // 1) 파라미터 체크
	        String newsNumberStr = request.getParameter("newsNumber");
	        if (newsNumberStr == null || newsNumberStr.trim().isEmpty()) {
	            System.out.println("newsNumber 값이 없습니다.");
	            result.setPath("/admin/news/newsListOk.ad");
	            result.setRedirect(true);
	            return result;
	        }

	        int newsNumber = Integer.parseInt(newsNumberStr);

	        // 2) DB 조회
	        AdminNewsDAO newsDAO = new AdminNewsDAO();
	        AdminNewsBoardDTO news = newsDAO.select(newsNumber);

	        if (news == null) {
	            System.out.println("존재하지 않는 뉴스입니다. newsNumber=" + newsNumber);
	            result.setPath("/admin/news/newsListOk.ad");
	            result.setRedirect(true);
	            return result;
	        }

	        // 3) 로그인 관리자와 글 작성자 비교 (수정/삭제 버튼 노출 제어용)
	        Integer loginAdminNumber = (Integer) request.getSession().getAttribute("adminNumber");
	        boolean mine = Objects.equals(loginAdminNumber, news.getAdminNumber());

	        // 4) 바인딩 및 이동
	        request.setAttribute("news", news);
	        request.setAttribute("mine", mine);

	        result.setPath("/app/admin/newsBoadDetail.jsp");
	        result.setRedirect(false);
	        return result;
	}

}
