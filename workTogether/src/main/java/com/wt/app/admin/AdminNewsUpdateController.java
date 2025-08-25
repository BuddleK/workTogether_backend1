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
		AdminDAO adminDAO = new AdminDAO(); // AdminDAO 객체 생성

		//파라미터 유효성 검증
		String newsNumberStr = request.getParameter("newsNumber");
		if (newsNumberStr == null || newsNumberStr.trim().isEmpty()) {
			System.out.println("수정 페이지 이동 실패: newsNumber 파라미터가 없거나 비어 있습니다.");
			result.setPath(request.getContextPath() + "/admin/news/newsListOk.ad");
			result.setRedirect(true);
			return result;
		}

		int newsNumber;
		try {
			newsNumber = Integer.parseInt(newsNumberStr); //문자열 정수로 변환
		} catch (NumberFormatException e) {
			System.out.println("수정 페이지 이동 실패: newsNumber 파싱 오류. 숫자 형식이 아닙니다 -> " + newsNumberStr);
			result.setPath(request.getContextPath() + "/admin/news/newsListOk.ad");
			result.setRedirect(true);
			return result;
		}

		// DB에서 뉴스 정보 조회
		AdminNewsBoardDTO news = adminDAO.select(newsNumber); // newsSelectOne 대신
		if (news == null) {
			System.out.println("수정 페이지 이동 실패: 존재하지 않는 뉴스. newsNumber=" + newsNumber);
			result.setPath(request.getContextPath() + "/admin/news/newsListOk.ad");
			result.setRedirect(true);
			return result;
		}

		// 첨부 파일 조회 (tbl_files_notice 기준)
		FileNoticeDTO file = adminDAO.selectFileNotice(newsNumber);
		System.out.println("뉴스 ID: " + newsNumber + "의 파일 정보: " + (file != null ? file.getNoticeFilesName() : "없음"));

		// 수정 권한 체크 
		Integer loginAdminNumber = (Integer) request.getSession().getAttribute("adminNumber");
		boolean mine = Objects.equals(loginAdminNumber, news.getAdminNumber());
		System.out.println("로그인 관리자 ID: " + loginAdminNumber + ", 뉴스 작성자 ID: " + news.getAdminNumber() + ", 수정 권한(본인): " + mine);


		// JSP로 데이터 바인딩
		request.setAttribute("news", news); 
		request.setAttribute("file", file);
		request.setAttribute("mine", mine);
		
		//수정 폼으로 이동
		result.setPath("/admin/news/newsBoardUpdate.jsp"); // 수정 페이지 JSP 경로
		result.setRedirect(false);
		return result;
	}
}