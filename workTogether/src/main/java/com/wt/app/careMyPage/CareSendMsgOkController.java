package com.wt.app.careMyPage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.careList.dao.CareListDAO;
import com.wt.app.dto.MessageSRDTO;

public class CareSendMsgOkController implements Execute {
	
	//대기

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("CareListModalOkController 진입");
		request.setCharacterEncoding("UTF-8");
		
		Result result = new Result();
		
		//로그인 정보 파악
		Integer normalNubmer = (Integer)request.getSession().getAttribute("usersNumber");
		
		
		
		if(normalNubmer == null) {
			System.out.println("로그인 정보 없음");
			result.setPath("/app/login/loginNormal.jsp");
			return result;
		}
		
		
		
		String careNumber = request.getParameter("careNumber");
		String messageContent = request.getParameter("message");
		
		System.out.println("돌봄넘버 " + careNumber);
		System.out.println("메세지 내용 " + messageContent);
		System.out.println("일반넘버 " + normalNubmer);
		MessageSRDTO dto = new MessageSRDTO();
		
		dto.setCareNumber(Integer.parseInt(careNumber));
		dto.setMessageContents(messageContent);
		dto.setNormalNumber(normalNubmer);
		
		CareListDAO dao = new CareListDAO();
		
		dao.sendMsg(dto);
		
		result.setPath("/myPageCare/careMsgList.mn");//		
		result.setRedirect(false);
		
		return result;
	}
	
}
