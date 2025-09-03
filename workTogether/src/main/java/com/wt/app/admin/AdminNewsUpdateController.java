package com.wt.app.admin;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.admin.dao.AdminDAO;
import com.wt.app.dto.AdminNewsBoardDTO;
import com.wt.app.dto.FileNoticeDTO;

public class AdminNewsUpdateController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("==== AdminNewsUpdateController 실행 ====");

		request.setCharacterEncoding("UTF-8");
		Result result = new Result();
		AdminDAO adminDAO = new AdminDAO();

		// 파라미터 유효성 검증
		String newsNumberStr = request.getParameter("newsNumber");
		if (newsNumberStr == null || newsNumberStr.trim().isEmpty()) {
			System.out.println("수정 페이지 이동 실패: newsNumber 파라미터 누락");
			result.setRedirect(true);
			result.setPath(request.getContextPath() + "/admin/news/newsListOk.ad");
			return result;
		}

		int newsNumber;
		try {
			newsNumber = Integer.parseInt(newsNumberStr);
		} catch (NumberFormatException e) {
			System.out.println("수정 페이지 이동 실패: newsNumber 형식 오류 -> " + newsNumberStr);
			result.setRedirect(true);
			result.setPath(request.getContextPath() + "/admin/news/newsListOk.ad");
			return result;
		}

		// 뉴스 조회
		AdminNewsBoardDTO news = adminDAO.select(newsNumber);
		if (news == null) {
			System.out.println("수정 페이지 이동 실패: 존재하지 않는 뉴스 #" + newsNumber);
			result.setRedirect(true);
			result.setPath(request.getContextPath() + "/admin/news/newsListOk.ad");
			return result;
		}

		// 권한 체크(필요 시)
		Integer loginAdminNumber = (Integer) request.getSession().getAttribute("adminNumber");
		boolean mine = Objects.equals(loginAdminNumber, news.getAdminNumber());

		// JSP 바인딩
		request.setAttribute("news", news);
		request.setAttribute("mine", mine);

		// 목록으로 돌아갈 때 사용할 page 파라미터 유지
		String page = request.getParameter("page");
		if (page != null && !page.isEmpty()) {
			request.setAttribute("page", page);
		}

		// 실제 JSP 경로로 forward!
		result.setRedirect(false);
		result.setPath("/app/admin/newsBoardUpdate.jsp");
		return result;
	}
}