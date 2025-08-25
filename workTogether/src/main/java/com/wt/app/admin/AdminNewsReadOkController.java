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

public class AdminNewsReadOkController implements Execute {

	@Override
	public Result Execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Result result = new Result();
		AdminDAO adminDAO = new AdminDAO();

		//newsNumber가 빈 문자열이거나 null인경우
		String newsNumberStr = request.getParameter("newsNumber");
		// 파라미터가 없거나 비어있으면 목록 페이지로 리다이렉트 (이전 BoardReadOkController와 유사)
		if (newsNumberStr == null || newsNumberStr.trim().isEmpty()) {
			System.out.println("newsNumber 값이 없어 뉴스 목록으로 이동합니다.");
			result.setPath("/admin/news/newsList.jsp");
			result.setRedirect(true);
			return result;
		}

		int newsNumber = 0;
		
		//숫자를 변환할 수 없는 문자열 입력시 예외처리로 프로그램은 돌아감
		try {
			newsNumber = Integer.parseInt(newsNumberStr);
		} catch (NumberFormatException e) {
			System.err.println("잘못된 뉴스 번호 형식: " + newsNumberStr + ". 뉴스 목록으로 이동합니다.");
			result.setPath("/admin/news/newsList.jsp");
			result.setRedirect(true);
			return result;
		}

		//DB에서 뉴스 상세 정보 가져오기
		AdminNewsBoardDTO newsDetail = adminDAO.select(newsNumber);

		//뉴스 게시글이 존재하지 않을 경우 처리
		if (newsDetail == null) {
			System.out.println("존재하지 않는 뉴스 번호입니다: " + newsNumber + ". 뉴스 목록으로 이동합니다.");
			result.setPath("/admin/news/newsList.jsp");
			result.setRedirect(true);
			return result;
		}

		//첨부파일 가져오기 (파일은 하나만, 없어도 괜찮음)
		FileNoticeDTO fileDetail = adminDAO.selectFileNotice(newsNumber);
		System.out.println("뉴스 첨부파일: " + (fileDetail != null ? fileDetail.getNoticeFilesName() : "없음"));

		request.setAttribute("newsDetail", newsDetail);
		request.setAttribute("fileDetail", fileDetail);

		result.setPath("//admin/news/newsRead.jsp");
		result.setRedirect(false);
		return result;
	}

}
