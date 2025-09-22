package com.wt.app.careMyPage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.careMyPage.dao.CareMSGDAO2;

public class CareReceiveOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("쪽지 각 컨텐츠");

		CareMSGDAO2 dao = new CareMSGDAO2();
		Gson gson = new Gson();
		JsonArray msgs = new JsonArray();
		
		String msgNumberStr = request.getParameter("msgNumber");
		int msgNumber = Integer.parseInt(msgNumberStr);
		System.out.println(msgNumber);
		
		dao.getMsgReceiveContent(msgNumber).stream().map(gson::toJson).map(JsonParser::parseString).forEach(msgs::add);
		
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		System.out.println("ㅁㅅㅈ 가져오기");
		System.out.println(msgs.toString());
		out.print(msgs.toString());
		out.close();


		return null;
	}

}
