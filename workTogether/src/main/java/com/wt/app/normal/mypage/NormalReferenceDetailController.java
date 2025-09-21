package com.wt.app.normal.mypage;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.dto.NormalReferenceListDTO;
import com.wt.app.dto.NormalReferenceReplyDTO;
import com.wt.app.normal.mypage.dao.MyPageNormalDAO;

public class NormalReferenceDetailController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("문의 디테일 컨 진");
		Result result = new Result();

		MyPageNormalDAO dao = new MyPageNormalDAO();

		HttpSession session = request.getSession();
		String usersNumberStr = session.getAttribute("usersNumber") + "";
		int usersNumber = Integer.parseInt(usersNumberStr);

		String referenceNumberStr = request.getParameter("referenceNumber");
		int referenceNumber = 0;

		referenceNumber = Integer.parseInt(referenceNumberStr);
		
		List<NormalReferenceListDTO> detailList = dao.refDetail(referenceNumber);
		
		request.setAttribute("detailList", detailList);

		List<NormalReferenceReplyDTO> detailReply = dao.refDetailReply(referenceNumber);
		
		request.setAttribute("detailReply", detailReply);
		

		System.out.println(detailList);
		System.out.println(detailReply);
		
		result.setPath("/app/myPageNormal/normalReferenceDetail.jsp");
		result.setRedirect(false);
		return result;
	}

}
