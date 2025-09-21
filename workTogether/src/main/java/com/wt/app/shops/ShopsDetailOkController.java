package com.wt.app.shops;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.example.app.dto.FileDTO;
import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.dto.ShopsFavoritesActionDTO;
import com.wt.app.dto.ShopsListDTO;
import com.wt.app.shops.dao.ShopsDAO;
import com.wt.app.shops.dao.ShopsListDAO;

public class ShopsDetailOkController implements Execute{
	
	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			Result result = new Result();
			
		
		//shopsNumber가 빈 문자열이거나 null인경우
		String shopsNumberStr = request.getParameter("shopsNumber");
		if(shopsNumberStr == null || shopsNumberStr.trim().isEmpty()){
			System.out.println("shopsNumber 값이 없습니다");
			result.setPath("/app/restaurant/restaurant.jsp"); //게시글 목록 페이지로 리다이렉트
			result.setRedirect(true);
			return result;
		}
		
		int shopsNumber = Integer.parseInt(shopsNumberStr);
		
		ShopsListDAO shopsListDAO = new ShopsListDAO();
//		FileDAO fileDAO = new FileDAO();

		//DB에서 게시글 가져오기
		ShopsListDTO shopsListDTO = shopsListDAO.select(shopsNumber);
		
		//게시글이 존재하지 않을 경우 처리
		if(shopsListDTO == null) {
			System.out.println("존재하지 않는 게시글입니다. " + shopsNumber);
			result.setPath("/app/restaurant/restaurant.jsp");
			result.setRedirect(true);
			return result;
		}
		
		//찜한 상태 가져오기
		ShopsFavoritesActionDTO jimDTO = new ShopsFavoritesActionDTO();
		ShopsDAO shopsDAO = new ShopsDAO();
		String usersNumberStr = request.getParameter("usersNumber");
		if(usersNumberStr == null || usersNumberStr.trim().isEmpty()){
			usersNumberStr = 0 + "";
		}
		int usersNumber = Integer.parseInt(usersNumberStr);
		
		int isJim = shopsDAO.selectFavorite(usersNumber,shopsNumber);
		System.out.println(isJim);
		request.setAttribute("isJim", isJim);
		
		
		System.out.println(shopsListDTO);
		System.out.println(shopsListDTO.getShopsName());
		request.setAttribute("shops", shopsListDTO);
		result.setPath("/app/restaurant/restaurantDetail.jsp");
		result.setRedirect(false);		
		
		return result;
	}
	
}
