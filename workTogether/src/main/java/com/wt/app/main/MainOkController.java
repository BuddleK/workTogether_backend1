package com.wt.app.main;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.dto.MainDTO;
import com.wt.app.main.dao.MainDAO;

public class MainOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MainDAO mainDAO = new MainDAO();
		Result result = new Result();
		
		//배너 뉴스 조회
		List<MainDTO> mainBanner = mainDAO.newsBanner();
		request.setAttribute("mainBanner", mainBanner);
		
		//찜 많은 가게 4개 조회
		List<MainDTO> mainShop = mainDAO.shops();
		request.setAttribute("mainShop", mainShop);
				
				
		//게시글 최신순 4개 조회
		List<MainDTO> mainPost = mainDAO.post();
		request.setAttribute("mainPost", mainPost);
				
		//하트많은 돌봄회원 4명 조회
		List<MainDTO> mainHeart = mainDAO.care();
		request.setAttribute("mainHeart", mainHeart);
				
				
		//지도마커 조회
		
		result.setPath("/app/Main.jsp");
		result.setRedirect(false);
		return result;
	}
	
}
