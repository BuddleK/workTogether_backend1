package com.wt.app.careList;

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
import com.wt.app.careList.dao.CareHeartDAO;
import com.wt.app.dto.CareHeartDTO;

public class CareDetailHeartAddOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		CareHeartDTO dto = new CareHeartDTO();
		CareHeartDAO dao = new CareHeartDAO();

		Gson gson = new Gson();

		BufferedReader reader = request.getReader();
		JsonObject jsonObject = JsonParser.parseString(reader.lines().collect(Collectors.joining())).getAsJsonObject();
		
//		System.out.println("no"+jsonObject.get("normalNumber").getAsInt());
//		System.out.println("ca" +jsonObject.get("careNumber").getAsInt());

		if (!jsonObject.has("normalNumber") || !jsonObject.has("careNumber")) {
			response.setContentType("application/json; charset=utf-8");
			response.getWriter().write(gson.toJson(Map.of("status", "fail", "message", "필수 데이터가 없습니다")));
			return null;
		}

		dto.setHeartsNormalNumber(jsonObject.get("normalNumber").getAsInt());
		dto.setHeartsCareNumber(jsonObject.get("careNumber").getAsInt());
		System.out.println(dto);

		dao.addHeart(dto);
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().write(gson.toJson(Map.of("status", "success")));

		return null;
	}

}
