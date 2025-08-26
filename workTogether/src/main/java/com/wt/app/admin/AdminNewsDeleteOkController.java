package com.wt.app.admin;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.admin.dao.AdminDAO;
import com.wt.app.dto.FileNoticeDTO;

public class AdminNewsDeleteOkController implements Execute{

		@Override
	    public Result execute(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        System.out.println("==== AdminNewsDeleteOkController 실행 ====");
	        Result result = new Result();
			AdminDAO adminDAO = new AdminDAO();

			// 1) newsNumber 파라미터 유효성 검증
			String newsNumberStr = request.getParameter("newsNumber");
			if (newsNumberStr == null || newsNumberStr.trim().isEmpty()) {
				System.out.println("삭제 실패: newsNumber 파라미터가 없거나 비어 있습니다.");
				result.setPath(request.getContextPath() + "/admin/news/newsListOk.ad");
				result.setRedirect(true);
				return result;
			}

			int newsNumber;
			try {
				newsNumber = Integer.parseInt(newsNumberStr); //문자열을 정수로 변환
			} catch (NumberFormatException e) {
				System.out.println("삭제 실패: newsNumber 파싱 오류. 숫자 형식이 아닙니다 -> " + newsNumberStr);
				result.setPath(request.getContextPath() + "/admin/news/newsListOk.ad");
				result.setRedirect(true);
				return result;
			}

			try {
				// 뉴스 본문 삭제
				int deletedRows = adminDAO.deleteNews(newsNumber); 
				System.out.println("뉴스 삭제 결과: " + deletedRows + "행 삭제됨. 뉴스 번호=" + newsNumber);

			} catch (Exception e) {
				System.err.println("뉴스 삭제 중 오류 발생: ");
				e.printStackTrace(); 
	            result.setPath(request.getContextPath() + "/admin/news/newsListOk.ad");
	            result.setRedirect(true);
	            return result;
			}

			// 삭제 완료 후 목록으로 이동
			String page = request.getParameter("page"); 
			String redirectPath = request.getContextPath() + "/admin/news/newsListOk.ad";
			if (page != null && !page.isEmpty()) {
				redirectPath += "?page=" + page;
			}
			result.setPath(redirectPath);
			result.setRedirect(true); 

			System.out.println("==== AdminNewsDeleteOkController 처리 완료 ====");
			return result;
		}
	}