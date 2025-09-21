package com.wt.app.careMyPage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.careMyPage.dao.CareMatchingDAO;

public class CareMatchingOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("============CareMatchingOkController=========");
		CareMatchingDAO careMatchingDAO = new CareMatchingDAO();
		Result result = new Result();

		HttpSession session = request.getSession();
		Integer usersNumber = (Integer) session.getAttribute("usersNumber");
		
//		 int matchingAdd = careMatchingDAO.matchingAdd(careMatchingDTO);
		
		
		System.out.println("hi");
		String inputNormal = request.getParameter("inputNormal");
		String inputDate = request.getParameter("inputDate");
		String inputTime = request.getParameter("inputTime");
		String inputPoint = request.getParameter("inputPoint");
		System.out.println(inputNormal);
		System.out.println(inputDate);
		System.out.println(inputTime);
		System.out.println(inputPoint);
		
		int normalNum = careMatchingDAO.searchId(inputNormal);
		String typeCheck = careMatchingDAO.searchType(normalNum);
		
		System.out.println("회원번호 : " + normalNum);
		System.out.println("타입 : " + typeCheck);


		Map<String, Object> insertMatchingMap = new HashMap<>();
		insertMatchingMap.put("usersNumber", usersNumber);
		insertMatchingMap.put("normalNumber", normalNum);
		insertMatchingMap.put("date", inputDate);
		insertMatchingMap.put("time", inputTime);
		insertMatchingMap.put("point", inputPoint);
		
		if(typeCheck.equals("N")) {
			System.out.println("일반");
			careMatchingDAO.insertMatching(insertMatchingMap);
		}else {
			System.out.println("일반 회원이 아님");
		}
		

		result.setPath("/myPageCare/careMatching.cp");
		result.setRedirect(true);
		return result;
	}

}
