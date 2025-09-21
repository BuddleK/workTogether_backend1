package com.wt.app.subway;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.dto.GetSubwayLineDTO;
import com.wt.app.dto.SubwayStationDTO;
import com.wt.app.subway.dao.SubwayDAO;

public class SubwayListController implements Execute {

    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response) {
        SubwayDAO subwayDAO = new SubwayDAO();
        Result result = new Result();

        // 파라미터 → int (기본: 0 = 전체)
        String lineNumberParam = request.getParameter("lineNumber");
        int lineNumber = 0;
        try {
            if (lineNumberParam != null && !lineNumberParam.isEmpty()) {
                lineNumber = Integer.parseInt(lineNumberParam);
            }
        } catch (NumberFormatException ignore) {
            lineNumber = 0;
        }

        List<GetSubwayLineDTO> lines = subwayDAO.subwayLineSearch();
        request.setAttribute("lines", lines);

        List<SubwayStationDTO> imgStations = subwayDAO.subwayStationImgSearch(lineNumber);
        request.setAttribute("imgStations", imgStations);

        List<SubwayStationDTO> stations = subwayDAO.subwayStationSearch(lineNumber);
        request.setAttribute("stations", stations);

        request.setAttribute("lineNumber", String.valueOf(lineNumber));

        result.setPath("/app/subwayLine/subway.jsp");
        result.setRedirect(false);
        return result;
    }
}
