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
import com.wt.app.dto.NormalReferenceListDTO;
import com.wt.app.normal.mypage.dao.MyPageNormalDAO;

public class NormalReferenceListController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Result result = new Result();
		
		MyPageNormalDAO dao = new MyPageNormalDAO();
		HttpSession session = request.getSession();
		String usersNumberStr = session.getAttribute("usersNumber") + "";
		int usersNumber = Integer.parseInt(usersNumberStr);
		String tmp = request.getParameter("page");
		int page = (tmp == null) ? 1 : Integer.valueOf(tmp);
		int rowCount = 4;
		int pageCount = 4;

		int startRow = (page - 1) * rowCount + 1;
		int endRow = startRow + rowCount - 1;

		Map<String, Integer> pageMap = new HashMap<>();
		pageMap.put("startRow", startRow);
		pageMap.put("endRow", endRow);
		pageMap.put("usersNumber", usersNumber);
		
		int total = dao.totalReference(usersNumber);
		int realEndPage = (int) Math.ceil(total / (double) rowCount);
		if (realEndPage == 0) {
		    realEndPage = 1;
		}
		int endPage = (int) (Math.ceil(page / (double) pageCount) * pageCount);
		int startPage = endPage - (pageCount - 1);
		if (startPage < 1) {
		    startPage = 1;
		}

		endPage = Math.min(endPage, realEndPage);
		
		boolean prev = startPage > 1;
		boolean next = endPage < realEndPage;

		request.setAttribute("page", page);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("prev", prev);
		request.setAttribute("next", next);
		
		System.out.println("total " + total);
		System.out.println("page " + page);
		System.out.println("startPage " + startPage);
		System.out.println("endPage " + endPage);
		System.out.println("prev " + prev);
		System.out.println("next " + next);
		
		List<NormalReferenceListDTO> referenceList = dao.normalReferenceListAll(pageMap);
		System.out.println(referenceList);
		request.setAttribute("referenceList", referenceList);

		result.setPath("/app/myPageNormal/normalReference.jsp");
        result.setRedirect(false);
        return result;
	}
	

}
