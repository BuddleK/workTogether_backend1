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
	public Result Execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("==== AdminNewsUpdateController 실행 ====");

		Result result = new Result();

		// 1) 파라미터 검증
		String newsNumberStr = request.getParameter("newsNumber");
		if (newsNumberStr == null || newsNumberStr.trim().isEmpty()) {
			System.out.println("수정 페이지 이동 실패: newsNumber 파라미터 없음");
			result.setPath(request.getContextPath() + "/admin/news/newsListOk.ad");
			result.setRedirect(true);
			return result;
		}

		int newsNumber;
		try {
			newsNumber = Integer.parseInt(newsNumberStr);
		} catch (NumberFormatException e) {
			System.out.println("수정 페이지 이동 실패: newsNumber 파싱 오류 -> " + newsNumberStr);
			result.setPath(request.getContextPath() + "/admin/news/newsListOk.ad");
			result.setRedirect(true);
			return result;
		}

		// 2) DB 조회
		AdminDAO dao = new AdminDAO();
		AdminNewsBoardDTO news = dao.newsSelectOne(newsNumber);
		if (news == null) {
			System.out.println("수정 페이지 이동 실패: 존재하지 않는 뉴스. newsNumber=" + newsNumber);
			result.setPath(request.getContextPath() + "/admin/news/newsListOk.ad");
			result.setRedirect(true);
			return result;
		}

		// (선택) 첨부 파일 조회 (tbl_files_notice 기준)
		FileNoticeDTO file = dao.selectNoticeFileByNews(newsNumber); // 없으면 null

		// 3) 수정 권한 체크(작성자 본인 여부; 화면에서 버튼 노출 제어용)
		Integer loginAdminNumber = (Integer) request.getSession().getAttribute("adminNumber");
		boolean mine = Objects.equals(loginAdminNumber, news.getAdminNumber());

		// 4) 바인딩 후 수정 폼으로 이동
		request.setAttribute("news", news);
		request.setAttribute("file", file);
		request.setAttribute("mine", mine);

		// ※ 프로젝트 구조에 맞게 경로 조정
		result.setPath("/app/admin/newsBoardUpdate.jsp");
		result.setRedirect(false);
		return result;
	}
}