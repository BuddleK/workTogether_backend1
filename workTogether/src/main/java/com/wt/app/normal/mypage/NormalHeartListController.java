package com.wt.app.normal.mypage;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.dto.NormalHeartListDTO;
import com.wt.app.normal.mypage.dao.MyPageNormalDAO;

public class NormalHeartListController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Result result = new Result();
		System.out.println("하트페이지 진입");

		NormalHeartListDTO dto = new NormalHeartListDTO();
		MyPageNormalDAO dao = new MyPageNormalDAO();
		HttpSession session = request.getSession();
		
		Integer normalUsersNumberStr = (Integer) session.getAttribute("usersNumber");
		
		
		String tmp = request.getParameter("page");
		int page = (tmp == null) ? 1 : Integer.valueOf(tmp);
		int rowCount = 3;
		int pageCount = 4;

		int startRow = (page - 1) * rowCount + 1;
		int endRow = startRow + rowCount - 1;

		Map<String, Integer> pageMap = new HashMap<>();
		pageMap.put("startRow", startRow);
		pageMap.put("endRow", endRow);
		pageMap.put("normalNumber", normalUsersNumberStr);
		
		//리스트 조회
		List<NormalHeartListDTO> heartList = dao.selectHeart(pageMap);
		request.setAttribute("heartList", heartList);
		
		int total = dao.heartTotal(normalUsersNumberStr);
		int realEndPage = (int) Math.ceil(total / (double) rowCount);
		int endPage = (int) (Math.ceil(page / (double) pageCount) * pageCount);
		int startPage = endPage - (pageCount - 1);

		endPage = Math.min(endPage, realEndPage);

		boolean prev = startPage > 1;
		boolean next = endPage < realEndPage;
		
		System.out.println(heartList);
		System.out.println("전체 갯수 : " + total);
		
		result.setPath("/app/myPageNormal/normalheart.jsp");
        result.setRedirect(false);
        return result;
	}

}
