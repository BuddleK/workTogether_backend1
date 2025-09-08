package com.wt.app.map;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.dto.MarkerDTO;
import com.wt.app.map.dao.MarkerDAO;

public class MapMarkerListOk implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("====MapMarkerListOk 실행====");
		MarkerDAO markerDAO = new MarkerDAO();
		Result result = new Result();
		
		List<MarkerDTO> markerList = markerDAO.getMarkers();
		request.setAttribute("markerList", markerList);
		
		System.out.println("서블릿에서 : " + markerList.get(0));
		
		result.setPath("/app/map/map.jsp");
		return result;
	}
	
	
}
