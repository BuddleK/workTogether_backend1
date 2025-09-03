package com.wt.app.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.admin.dao.AdminDAO;
import com.wt.app.dto.AdminNewsBoardDTO;
import com.wt.app.dto.FileNoticeDTO;
import com.wt.app.dto.FilesLicenseDTO;

public class AdminNewsWriteOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("==== AdminNewsWriteOkController 실행 ====");
		AdminDAO adminDAO = new AdminDAO();
		AdminNewsBoardDTO newsDTO = new AdminNewsBoardDTO();
		Result result = new Result();
		
		// 1. 로그인한 관리자 정보 가져오기
		Integer adminNumber = (Integer)request.getSession().getAttribute("adminNumber");

		// 로그인 안 되어 있으면 로그인 페이지로 리다이렉트 (Result 객체 사용 방식으로 변경)
		if(adminNumber == null) {
			System.out.println("오류 : 로그인된 관리자가 없습니다");
			result.setPath("/admin/login.jsp");
			result.setRedirect(true);
			return result;
		}
		
		newsDTO.setNewsTitle(request.getParameter("newsTitle")); 
		newsDTO.setNewsContent(request.getParameter("newsContent"));
		newsDTO.setNewsLinkUrl(request.getParameter("newsLinkUrl")); 
		newsDTO.setAdminNumber(adminNumber);
		
		System.out.println("뉴스 게시글 추가 - AdminNewsBoardDTO : " + newsDTO);
		
		// 3. 게시글 DB 추가
		try {
		    int newsNumber = adminDAO.insertNews(newsDTO); 
		    System.out.println("생성된 뉴스 게시글 번호 : " + newsNumber);
		} catch (Exception e) {
		    request.setAttribute("errorMsg", "뉴스 게시글 DB 추가 중 오류 발생."); // JSP로 에러 메시지 전달
		    result.setPath("/admin/news/newsWrite.ad"); // 다시 작성 페이지로 (포워드)
		    result.setRedirect(false);
		    return result;
		}
		
		// 모든 작업 완료 후 뉴스 목록 페이지로 이동
		result.setPath(request.getContextPath() + "/admin/news/newsListOk.ad"); 
		result.setRedirect(true);
		
		return result;
	}
}