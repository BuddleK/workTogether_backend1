package com.wt.app.careMyPage;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.careMyPage.dao.CareMarkDAO;

public class CareMarkDeleteController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("======CareMarkDeleteController======");
		System.out.println("삭제~");
		CareMarkDAO careMarkDAO = new CareMarkDAO();
		Result result = new Result();
		
		// 삭제할 찜 번호 가져오기
		BufferedReader br = request.getReader();
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = br.readLine()) != null) {
		    sb.append(line);
		}
		String body = sb.toString();

		try {
		    // 문자열을 JSONObject로 파싱
		    JSONParser parser = new JSONParser();
		    JSONObject json = (JSONObject) parser.parse(body);

		    // 배열 꺼내기 (형변환 필요)
		    JSONArray numbers = (JSONArray) json.get("favoriteNumbers");

		    for (Object o : numbers) {
		    	String num = (String) o;
		        System.out.println("삭제할 번호: " + num);
		        
		        // DB 삭제~~~~~~~~
				careMarkDAO.delMark(Integer.parseInt(num));
		        
		    }

		} catch (ParseException e) {
		    e.printStackTrace();
		}
		
		result.setPath("/myPageCare/careMark.cp");
		//result.setRedirect(false);
		return result;
	}
	
}
