package com.wt.app.careMyPage;

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
import com.wt.app.careMyPage.dao.CareMSGDAO2;

public class CareMsgGetListJsOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("쪽지 리스트 페이지 들옴(받은 쪽지)sjjsjsjsj");

		CareMSGDAO2 dao = new CareMSGDAO2();
		HttpSession session = request.getSession();
		Integer normalNumber = (Integer) session.getAttribute("usersNumber");
		Gson gson = new Gson();
		JsonArray msgs = new JsonArray();

		
		String tmp = request.getParameter("page");
		int page = (tmp == null) ? 1 : Integer.valueOf(tmp);
		int rowCount = 8;

		int startRow = (page - 1) * rowCount + 1;
		int endRow = startRow + rowCount - 1;

		Map<String, Integer> pageMap = new HashMap<>();
		pageMap.put("startRow", startRow);
		pageMap.put("endRow", endRow);
		pageMap.put("normalNumber", normalNumber);

		
		dao.selectAllMsg(pageMap).stream().map(gson::toJson).map(JsonParser::parseString).forEach(msgs::add);
		
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		System.out.println("막전");
		System.out.println(msgs.toString());
		out.print(msgs.toString());
		out.close();


		return null;
	}

}
