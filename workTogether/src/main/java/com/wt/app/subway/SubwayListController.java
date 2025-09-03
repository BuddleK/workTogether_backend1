package com.wt.app.subway;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.dto.FilesStationsDTO;
import com.wt.app.dto.GetSubwayLineDTO;
import com.wt.app.dto.SubwayStationDTO;
import com.wt.app.subway.dao.SubwayDAO;

public class SubwayListController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response) {
		SubwayDAO subwayDAO = new SubwayDAO();
		Result result = new Result();
		
		String lineNumber = request.getParameter("lineNumber");
		if (lineNumber == null || lineNumber.isEmpty()) {
		    lineNumber = "0"; // 전체
		}
		
		//호선 가져오기
		List<GetSubwayLineDTO> lines = subwayDAO.subwayLineSearch();
		request.setAttribute("lines", lines);
		
		//알맞는 이미지 가져오기
		List<SubwayStationDTO> imgStations = subwayDAO.subwayStationImgSearch(lineNumber);
		request.setAttribute("imgStations", imgStations);

		//역 명 가져오기
		List<SubwayStationDTO> stations = subwayDAO.subwayStationSearch(lineNumber);
		request.setAttribute("stations", stations);
		
		result.setPath("/app/subwayLine/subway.jsp");
		result.setRedirect(false);
		return result;
	}
	
}
