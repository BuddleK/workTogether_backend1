package com.wt.app.careMyPage;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.careMyPage.dao.CareMatchingDAO;
import com.wt.app.careMyPage.dao.CareProfileDAO;
import com.wt.app.dto.CareMarkDTO;
import com.wt.app.dto.CareMessageDTO;
import com.wt.app.dto.CareProfilePictureDTO;

public class CareMesseageController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Result result = new Result();
		
		//로그인한 사용자 번호 가져오기
		Integer usersNumber = (Integer) request.getSession().getAttribute("usersNumber");
		System.out.println("로그인 한 멤버 번호 : " + usersNumber);
		
		//프로필 사진 담아오기
		CareProfileDAO careProfileDAO = new CareProfileDAO();
		CareProfilePictureDTO careProfilePictureDTO = new CareProfilePictureDTO();
		careProfilePictureDTO = careProfileDAO.getProPic(usersNumber);
		request.setAttribute("profilePic", careProfilePictureDTO);
		
		CareMatchingDAO careMatchingDAO = new CareMatchingDAO();
		
		
		//List<CareMessageDTO> messageList = careMatchingDAO.getRM(usersNumber);
		
		//System.out.println("메세지 리스트 : " + messageList);
		
		
		
		String temp = request.getParameter("page");
		int page = (temp == null) ? 1 : Integer.valueOf(temp); // 페이지 번호 기본값 1로 설정하겠다
		int rowCount = 4; // 한 페이지당 게시글 수
		int pageCount = 4; // 페이지 버튼 수

		// 페이징 처리
		int startRow = (page - 1) * rowCount + 1; // 시작행(1, 11, 21, ..)
		int endRow = startRow + rowCount - 1; // 끝 행(10, 20, 30, ..)

		Map<String, Integer> pageMap = new HashMap<>();
		pageMap.put("startRow", startRow);
		pageMap.put("endRow", endRow);
		pageMap.put("usersNumber", usersNumber);

		// 게시글 목록 조회
		List<CareMessageDTO> rMessageList = careMatchingDAO.getRM(pageMap);
		request.setAttribute("rMessageList", rMessageList);

		int total = careMatchingDAO.totalGetRM(usersNumber);
		System.out.println("받은 쪽지 개수" + total);
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
		System.out.println("rMessageList : " + rMessageList);
		System.out.println("startPage : " + startPage + ", endPage : " + endPage + ", prev : " + prev + ", next : " + next);
		System.out.println("====================");

		result.setPath("/app/myPageCare/caresendMsg.jsp");
		result.setRedirect(false);
		return result;
	}

}
