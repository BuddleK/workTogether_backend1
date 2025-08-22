package com.wt.app.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;

public class UsersLoginController implements Execute{

	@Override
	public Result Execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("ㅎ헤ㅔ헤헤헤헿");
		// TODO Auto-generated method stub
		Result result = new Result();
		Cookie[] cookies = request.getCookies();
		
		if (cookies != null) {
	         for (Cookie cookie : cookies) {
	        	 //쿠키 배열이 여러개 있을 수 있으니 for-each문으로 하나씩 꺼낸다
	            if (cookie.getName().equals("usersId")) {
	            	//쿠키마다 이름이 존재하는데 memberId라는 이름을 가진 쿠키를 찾는다
	               request.setAttribute("usersId", cookie.getValue());
	               //찾은 memberId 쿠키의 값을 request속성에 넣어준다
	               //${memberId} 형태로 꺼내 쓸 수가 있다
	            }
	         }
	      }
		result.setPath("/app/login/login.jsp");
		result.setRedirect(false);
		return result;
	}

}
