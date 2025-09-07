package com.wt.app.normal.mypage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
		System.out.println("오케이 컨트롤러 진입");
		MyPageNormalDAO myPageNormalDAO = new MyPageNormalDAO();
		Result result = new Result();
		
		HttpSession session = request.getSession();
		String usersPassword = request.getParameter("usersPassword");
		String usersNumber = session.getAttribute("usersNumber") + "";
		 
		
        Map<String, String> numbers = new HashMap<>();
        numbers.put("usersNumber", usersNumber);
        numbers.put("usersPassword", usersPassword);
		
		boolean isSuccess = myPageNormalDAO.checkPw(numbers);
		System.out.println(isSuccess);
		
		String path = null;
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		if(isSuccess) {
			path = "/myPageNormal/normalModify.mn";
			System.out.println("2세션값 : " + usersNumber);
		}else {
			path = "/app/myPageNormal/normalPwCheck.jsp";
		    request.setAttribute("errorMsg", "일치하지 않는 비밀번호 입니다");
		}
		
		result.setRedirect(true);
		result.setPath(path);
        return result;
	}
	
}
