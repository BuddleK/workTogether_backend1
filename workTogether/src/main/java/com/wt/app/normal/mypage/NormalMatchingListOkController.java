package com.wt.app.normal.mypage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.dto.NormalMatchingDTO;
import com.wt.app.normal.mypage.dao.MyPageNormalDAO;

public class NormalMatchingListOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Result result = new Result();
System.out.println("들어옴22");
		
		MyPageNormalDAO dao = new MyPageNormalDAO();
		NormalMatchingDTO dto = new NormalMatchingDTO();
		Gson gson = new Gson();
		JsonArray matches = new JsonArray();
		
		
		HttpSession session = request.getSession();
		
		String monthStr = request.getParameter("month");
		System.out.println("컨트롤러에서 선택" +monthStr);
		
		
		String usersNumberStr = session.getAttribute("usersNumber")+"";
		int usersNumber = Integer.parseInt(usersNumberStr);
		
		if(monthStr == null) {
			dao.normalMatchingSearch(usersNumber).stream().map(gson::toJson).map(JsonParser::parseString).forEach(matches::add);
			response.setContentType("application/json; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print(matches.toString());
			out.close();
			
		} else {
			System.out.println("잘왔다");
			int month = Integer.parseInt(monthStr);
			Map<String, Integer> numbers = new HashMap<>();
			numbers.put("usersNumber", usersNumber);
			numbers.put("month", month);
			dao.monthNormalMatchingSearch(numbers).stream().map(gson::toJson).map(JsonParser::parseString).forEach(matches::add);
			response.setContentType("application/json; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print(matches.toString());
			out.close();
		}
		
		
		
		
		System.out.println("할수있따" + matches);
		
		
        return null;
	}
	
}
