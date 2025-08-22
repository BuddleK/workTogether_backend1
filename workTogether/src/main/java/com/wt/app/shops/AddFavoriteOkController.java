package com.wt.app.shops;

import java.io.BufferedReader;
import java.io.IOException;
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

public class AddFavoriteOkController implements Execute{

	@Override
	public Result Execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		ShopsFavoritesActionDTO shopsFavoritesActionDTO = new ShopsFavoritesActionDTO();
		ShopsDAO shopsDAO = new ShopsDAO();
		
		
		Gson gson = new Gson();
		
		BufferedReader reader = request.getReader();
		JsonObject jsonObject = JsonParser.parseString(reader.lines().collect(Collectors.joining())).getAsJsonObject();
		
		if (!jsonObject.has("shopsNumber") || !jsonObject.has("usersNumber")) {
			
			response.setContentType("application/json; charset=utf-8");
			response.getWriter().write(gson.toJson(Map.of("status", "fail", "message", "필수 데이터가 없습니다")));
			return null;
		}
		
		shopsFavoritesActionDTO.setUserNumber(jsonObject.get("usersNumber").getAsInt());
		shopsFavoritesActionDTO.setFavoritesShopsNumber(jsonObject.get("shopsNumber").getAsInt());
		
		System.out.println("DTO : " + shopsFavoritesActionDTO);
		shopsDAO.addFavorites(shopsFavoritesActionDTO);
		System.out.println("완료");
		
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().write(gson.toJson(Map.of("status", "success", "message", "성공")));
		
		return null;
	}
	
	

}
