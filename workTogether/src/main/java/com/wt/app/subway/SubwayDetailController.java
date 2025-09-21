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

public class SubwayDetailController implements Execute {

    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        SubwayDAO subwayDAO = new SubwayDAO();
        Result result = new Result();

        String stationId = request.getParameter("stationId");
        System.out.println("선택한 역 ID: " + stationId);

        int stationIdInt = 0;
        try {
            stationIdInt = Integer.parseInt(stationId);
        } catch (NumberFormatException e) {
            stationIdInt = 0; // 숫자 변환 실패 시 기본값
        }

        List<SubwayStationDTO> stations = subwayDAO.subwayDetailSearch(stationIdInt);
        if (stations == null || stations.isEmpty()) {
            result.setPath(request.getContextPath() + "/subway/subwayList.sw");
            result.setRedirect(true);
            return result;
        }

        SubwayStationDTO station = stations.get(0);
        request.setAttribute("station", station);
        request.setAttribute("lat", station.getLatitude());
        request.setAttribute("lng", station.getLongitude());

        String fileName = mapStationName(station.getStationsName());
        String viewPath = "/app/subwayLine/" + fileName + ".jsp";

        result.setPath(viewPath);
        result.setRedirect(false);
        return result;
    }

    // 역 이름을 JSP 파일명으로 변환 (기존 영문 이름은 그대로 유지)
    private String mapStationName(String stationName) {
        switch (stationName) {
        case "강남":
            return "gangnam";
        case "교대":
            return "gyudae";
        case "서초":
            return "seacho";
        case "방배":
            return "bangbae";
        case "사당":
            return "sadang";
        case "신사":
            return "shinsa";
        case "잠원":
            return "jameone";
        case "고속터미널":
            return "gosukterminner";
        case "남부터미널":
            return "nambuterminer";
        case "양재":
            return "yangjae";
        case "동작":
            return "dongjack";
        case "총신대입구":
            return "chungshindae";
        case "내방":
            return "nebang";
        case "반포":
            return "banpo";
        case "논현":
            return "nonehyune";
        case "구반포":
            return "gubanpo";
        case "신반포":
            return "shinbanpo";
        case "사평":
            return "sapeung";
        case "신논현":
            return "sinnonehyun";
        case "양재시민의숲":
            return "yangjeaforest";
        case "청계산입구":
            return "chunggyae";
        default:
            return "gangnam";
        }
    }
}
