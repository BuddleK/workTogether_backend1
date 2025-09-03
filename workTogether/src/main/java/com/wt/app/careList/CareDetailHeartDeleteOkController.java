package com.wt.app.careList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
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

public class CareDetailHeartDeleteOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("딜리트 컨트롤러 진입");
		
        Gson gson = new Gson();
        CareHeartDAO dao = new CareHeartDAO();
        CareHeartDTO dto = new CareHeartDTO();
        BufferedReader reader = request.getReader();
        JsonObject jsonObject = JsonParser.parseString(reader.lines().collect(Collectors.joining())).getAsJsonObject();
        
        try {
        	dto.setHeartsNormalNumber(jsonObject.get("normalNumber").getAsInt());
    		dto.setHeartsCareNumber(jsonObject.get("careNumber").getAsInt());
            dao.delete(dto);

            response.setContentType("application/json; charset=utf-8");
            PrintWriter out = response.getWriter();
            out.print(gson.toJson(java.util.Map.of("status", "success")));
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            response.setContentType("application/json; charset=utf-8");
            response.getWriter().print(gson.toJson(java.util.Map.of("status", "fail")));
        }
        
		return null;
	}

	
}
