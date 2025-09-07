package com.wt.app.normal.mypage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.dto.NormalHeartListDTO;
import com.wt.app.normal.mypage.dao.MyPageNormalDAO;

public class NormalHeartListDeleteOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Result result = new Result();

		System.out.println("하트 삭제 컨트롤러 진입");

		Gson gson = new Gson();
		
		NormalHeartListDTO dto = new NormalHeartListDTO();
		MyPageNormalDAO dao = new MyPageNormalDAO();
		
		
		BufferedReader reader = request.getReader();
		JsonObject jsonObject = JsonParser.parseString(reader.lines().collect(Collectors.joining())).getAsJsonObject();
		
		try {
        	dto.setHeartsNormalNumber(jsonObject.get("normalNumber").getAsInt());
        	dto.setCareNumber(jsonObject.get("careNumber").getAsInt());
            dao.deleteHeart(dto);

            response.setContentType("application/json; charset=utf-8");
            PrintWriter out = response.getWriter();
            out.print(gson.toJson(java.util.Map.of("status", "success")));
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            response.setContentType("application/json; charset=utf-8");
            response.getWriter().print(gson.toJson(java.util.Map.of("status", "fail")));
        }

		result.setPath("/myPageNormal/normalHeartList.mn");
		result.setRedirect(false);
		return result;
	}

}
