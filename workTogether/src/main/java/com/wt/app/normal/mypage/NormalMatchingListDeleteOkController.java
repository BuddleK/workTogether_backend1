package com.wt.app.normal.mypage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.reflection.SystemMetaObject;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.dto.NormalMatchingDTO;
import com.wt.app.normal.mypage.dao.MyPageNormalDAO;

public class NormalMatchingListDeleteOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("딜컨");

		MyPageNormalDAO dao = new MyPageNormalDAO();
		Gson gson = new Gson();

		int matchNumber = Integer.parseInt(request.getParameter("matchNumber"));
		System.out.println("매치넘버" + matchNumber);

		dao.matchDelete(matchNumber);

		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(gson.toJson(java.util.Map.of("status", "success")));
		out.close();

		return null;
	}

}
