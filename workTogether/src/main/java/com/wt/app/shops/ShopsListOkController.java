package com.wt.app.shops;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.dto.ShopsListDTO;
import com.wt.app.shops.dao.ShopsDAO;

public class ShopsListOkController implements Execute{

	@Override
	public Result Execute(HttpServletRequest request, HttpServletResponse response) {
	System.out.println("====shopsListOkController 실행====");
	
	
	ShopsDAO shopsDAO = new ShopsDAO();
	Result result = new Result();
	
	// 게시글 목록 조회
	List<ShopsListDTO> shopsList = shopsDAO.shopSelectAll();
	request.setAttribute("shopsList", shopsList);
	
	result.setPath("/app/restaurant/restaurant.jsp");
	result.setRedirect(false);
	
	return result;
	
	
	}

}
