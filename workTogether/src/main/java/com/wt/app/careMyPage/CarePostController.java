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
import com.wt.app.careMyPage.dao.CarePostDAO;
import com.wt.app.careMyPage.dao.CareProfileDAO;
import com.wt.app.dto.CarePostDTO;
import com.wt.app.dto.CareProfilePictureDTO;
import com.wt.app.dto.PostsListDTO;

public class CarePostController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("=========CarePostController=========");
		Result result = new Result();
		
		//로그인한 사용자 번호 가져오기
		Integer usersNumber = (Integer) request.getSession().getAttribute("usersNumber");
		System.out.println("로그인 한 멤버 번호 : " + usersNumber);
		
		//프로필 사진 담아오기
		CareProfileDAO careProfileDAO = new CareProfileDAO();
		CareProfilePictureDTO careProfilePictureDTO = new CareProfilePictureDTO();
		careProfilePictureDTO = careProfileDAO.getProPic(usersNumber);
		request.setAttribute("profilePic", careProfilePictureDTO);
		
		CarePostDAO carePostDAO = new CarePostDAO();
		CarePostDTO carePostDTO = new CarePostDTO();
		
		//방금 선택한 페이지
		String temp = request.getParameter("page");
		//선택한 페이지 번호가 null이면 1을 넣어줌
		int page = (temp == null) ? 1 : Integer.valueOf(temp);
		//보여줄 행 수
		int rowCount = 4;
		//보여줄 페이지 숫자 수
		int pageCount = 4;
		
		//시작 행 번호
		int startRow = (page - 1) * rowCount + 1;
		//끝 행 번호
		int endRow = startRow + rowCount - 1;
		
		Map<String, Integer> pageMap = new HashMap<>();
		pageMap.put("startRow", startRow);
		pageMap.put("endRow", endRow);
		pageMap.put("usersNumber", usersNumber);
		
		List<CarePostDTO> postsList = carePostDAO.postAll(pageMap);
		request.setAttribute("postsList", postsList);
		
		System.out.println("개인게시글 : "  + postsList);
		
		int total = carePostDAO.postTotal(usersNumber);
		System.out.println("총 개수 : " + total);
		int realEndPage = (int) Math.ceil(total / (double) rowCount);
		int endPage = (int) (Math.ceil(page/(double) pageCount) * pageCount);
		int startPage = endPage - (pageCount - 1);
		
		endPage = Math.min(endPage, realEndPage);
		
		boolean prev = startPage > 1;
		boolean next = endPage < realEndPage;
		
		request.setAttribute("page", page);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("prev", prev);
		request.setAttribute("next", next);
		
		System.out.println("====페이징정보 확인====");
		System.out.println("pageMap : " + pageMap);
		System.out.println("postsList : " + postsList);
		System.out.println("startPage : " + startPage + ", endPage : " + endPage + ", prev : " + prev + ", next : " + next);
		System.out.println("====================");
		

		result.setPath("/app/myPageCare/carePost.jsp");
		result.setRedirect(false);
		return result;
	}

}
