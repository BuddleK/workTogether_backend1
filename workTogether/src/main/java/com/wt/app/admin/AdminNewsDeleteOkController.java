package com.wt.app.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.admin.dao.AdminDAO;

public class AdminNewsDeleteOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("==== AdminNewsDeleteOkController 실행 ====");
		request.setCharacterEncoding("UTF-8");
		Result result = new Result();
		String newsNumberStr = request.getParameter("newsNumber");
		String page = request.getParameter("page");

		try {
			int newsNumber = Integer.parseInt(newsNumberStr);
			new AdminDAO().deleteNews(newsNumber); // 1이면 삭제 성공
		} catch (Exception e) {
			// 로그만 남기고 목록으로 보냄
			System.out.println("뉴스 삭제 중 오류: " + e.getMessage());
		}

		String to = request.getContextPath() + "/admin/news/newsListOk.ad";
		if (page != null && !page.isEmpty()) {
			to += "?page=" + page;
		}
		result.setRedirect(true);
		result.setPath(to);
		return result;
	}
}