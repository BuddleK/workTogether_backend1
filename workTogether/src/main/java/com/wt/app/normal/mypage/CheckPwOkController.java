package com.wt.app.normal.mypage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.normal.mypage.dao.MyPageNormalDAO;

public class CheckPwOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MyPageNormalDAO myPageNormalDAO = new MyPageNormalDAO();
		Result result = new Result();
		
		int usersNumber = 0;
		HttpSession session = request.getSession();
		String usersPassword = request.getParameter("usersPassword");
		boolean isSuccess = myPageNormalDAO.checkPw(usersPassword);
		
		String path = null;
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		if(isSuccess) {
			path = "/myPageNormal/normalModify.mn";
			session.setAttribute("usersNumber", usersNumber);
			System.out.println("세션값 : " + usersNumber);
		}else {
			path = "/app/myPageNormal/normalPwCheck.jsp";
		    request.setAttribute("errorMsg", "일치하지 않는 비밀번호 입니다");
		}
		
		result.setRedirect(true);
		result.setPath(path);
        return result;
	}
	
}
