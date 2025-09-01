package com.wt.app.subway;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.dto.SubwayStationDTO;
import com.wt.app.subway.dao.SubwayDAO;

public class SubwayDetailController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SubwayDAO subwayDAO = new SubwayDAO();
		Result result = new Result();
		
		String stationId = request.getParameter("stationId");
		System.out.println("선택한 역 ID: " + stationId);
		
		List<SubwayStationDTO> stations = subwayDAO.subwayStationSearch();
		request.setAttribute("stations", stations);
		
		result.setPath("/app/subwayLine/gangnam.jsp");
        result.setRedirect(false);
        return result;
	}
	
}
