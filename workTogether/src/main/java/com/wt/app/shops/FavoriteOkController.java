package com.wt.app.shops;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.dto.ShopsFavoritesActionDTO;
import com.wt.app.shops.dao.ShopsDAO;

public class FavoriteOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("메소드 시작");
		ShopsDAO shopsDAO = new ShopsDAO();
		Gson gson = new Gson();
		String shopsNumberStr = request.getParameter("shopsNumber") + "";
		HttpSession session = request.getSession();
		String usersNumberStr= session.getAttribute("usersNumber") + "";
		
		int isJim = -1;
		
		System.out.println(shopsNumberStr + "shopsNumberStr");
		System.out.println(usersNumberStr + "usersNumberStr");
		
		if (usersNumberStr == null || shopsNumberStr == null) {
			 response.getWriter().write(gson.toJson(Map.of(
			            "status", "fail",
			            "message", "로그인 정보 또는 가게 번호 누락"
			        )));
		} else {
			Integer shopsNumber = Integer.parseInt(shopsNumberStr);
			Integer usersNumber = Integer.parseInt(usersNumberStr) ;
			Map<String, Integer> numbers = new HashMap<>();
			numbers.put("usersNumber", usersNumber);
			numbers.put("shopsNumber", shopsNumber);
			isJim = shopsDAO.isJim(numbers);
		}
		
		
		System.out.println("isJim : " + isJim);
		
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().write(gson.toJson(Map.of( "status", "success", "isFavorite", isJim == 1)));
		
		return null;
	}
	
	

}