package com.wt.app.admin;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.admin.dao.AdminDAO;
import com.wt.app.dto.AdminReportListDTO;

public class AdminReportListOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("==============AdminReportListOkController 진입============");
		
		
		Result result = new Result();
		String temp = request.getParameter("page");
		int page = (temp == null) ? 1 : Integer.valueOf(temp); // 페이지 번호 기본값 1로 설정하겠다
		int rowCount = 4; // 한 페이지당 게시글 수
		int pageCount = 4; // 페이지 버튼 수

		// 페이징 처리
		int startRow = (page - 1) * rowCount + 1; // 시작행(1, 11, 21, ..)
		int endRow = startRow + rowCount - 1; // 끝 행(10, 20, 30, ..)

		Map<String, Object> pageMap = new HashMap<>();
		pageMap.put("startRow", startRow);
		pageMap.put("endRow", endRow);
		
		//postsNumber가 빈 문자열이거나 null인 경우
		String postsNumberStr = request.getParameter("postsNumber");
		if(postsNumberStr == null || postsNumberStr.trim().isEmpty()) {
			System.out.println("postsNumber 값이 없습니다.");
			result.setPath("/admin/adminReportList.ad"); //신고글 목록 페이지로 리다이렉트
			result.setRedirect(true);
			return result;
		}
		
		int postsNumber = Integer.parseInt(request.getParameter("postsNumber"));
		
		AdminDAO adminDAO = new AdminDAO();
		List<AdminReportListDTO> reportList = adminDAO.reportDetail(postsNumber);
		request.setAttribute("adminReportList", reportList);
		request.setAttribute("postsNumber", postsNumber);
		//DB에서 게시글 가져오기
		List<AdminReportListDTO> adminDTO = adminDAO.reportDetail(postsNumber);
		System.out.println(adminDTO);
		System.out.println("postsNumber=" + postsNumber);
		//게시글이 존재하지 않을 경우 처리
		if(adminDTO == null) {
			System.out.println("존재하지 않는 게시글입니다. " + postsNumber);
			result.setPath("/admin/adminReportList.ad");
			result.setRedirect(true);
			return result;
		}
		int total = adminDAO.reportTotal();
		int realEndPage = (int) Math.ceil(total / (double) rowCount); // 실제 마지막 페이지(전체 게시글 기준으로 계산)
		int endPage = (int) (Math.ceil(page / (double) pageCount) * pageCount); // 현재 페이지 그룹에서의 마지막 페이지
		int startPage = endPage - (pageCount - 1); // 현재 페이지 그룹에서의 첫 페이지

		// endPage가 실제 존재하는 마지막 페이지보다 크면 조정
		endPage = Math.min(endPage, realEndPage);

		// prev, next 버튼 활성화 여부 확인
		boolean prev = startPage > 1;
		boolean next = endPage < realEndPage;

		request.setAttribute("page", page);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("prev", prev);
		request.setAttribute("next", next);
		
		System.out.println("====페이징정보 확인====");
		System.out.println("pageMap : " + pageMap);
		System.out.println("reportList : " + reportList);
		System.out.println("startPage : " + startPage + ", endPage : " + endPage + ", prev : " + prev + ", next : " + next);
		System.out.println("====================");
		
		request.setAttribute("adminReportList", adminDTO);
		result.setPath("/app/admin/reportDetail.jsp");
	    result.setRedirect(false);
	    return result;
	}
	

}
