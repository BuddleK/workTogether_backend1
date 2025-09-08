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
import com.wt.app.dto.MessageSRDTO;
import com.wt.app.normal.mypage.dao.MyPageNormalDAO;

public class NormalMsgListOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Result result = new Result();
		System.out.println("쪽지 리스트 페이지 들옴(받은 쪽지)");
		
		MessageSRDTO dto = new MessageSRDTO();
		MyPageNormalDAO dao = new MyPageNormalDAO();
		HttpSession session = request.getSession();
		Integer normalNumber = (Integer)session.getAttribute("usersNumber");
		
		String tmp = request.getParameter("page");
		int page = (tmp == null) ? 1 : Integer.valueOf(tmp);
		int rowCount = 8;
		int pageCount = 4;

		int startRow = (page - 1) * rowCount + 1;
		int endRow = startRow + rowCount - 1;

		Map<String, Integer> pageMap = new HashMap<>();
		pageMap.put("startRow", startRow);
		pageMap.put("endRow", endRow);
		pageMap.put("normalNumber", normalNumber);
		
		List<MessageSRDTO> msgList = dao.selectAllMsg(pageMap);
		request.setAttribute("msgList", msgList);
		
		int usersNumber = normalNumber;
		
		int total = dao.getMsgTotal(usersNumber);
		int realEndPage = (int) Math.ceil(total / (double) rowCount);
		int endPage = (int) (Math.ceil(page / (double) pageCount) * pageCount);
		int startPage = endPage - (pageCount - 1);

		endPage = Math.min(endPage, realEndPage);

		boolean prev = startPage > 1;
		boolean next = endPage < realEndPage;
		request.setAttribute("page", page);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("prev", prev);
		request.setAttribute("next", next);
		System.out.println(msgList);
		
		result.setPath("/app/myPageNormal/normalsendMsg.jsp");
        result.setRedirect(false);
        return result;
	}
	
}
