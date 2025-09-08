package com.wt.app.normal.mypage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.dto.NormalPostsListDTO;
import com.wt.app.normal.mypage.dao.MyPageNormalDAO;

public class NormalPostsListController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Result result = new Result();
		
		MyPageNormalDAO dao = new MyPageNormalDAO();
		Gson gson = new Gson();
		JsonArray posts = new JsonArray();
		
		
		HttpSession session = request.getSession();
		Integer normalNumber = (Integer)session.getAttribute("usersNumber");
		
		dao.normalPostsListSearch(normalNumber).stream().map(gson::toJson).map(JsonParser::parseString).forEach(posts::add);
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(posts.toString());
		out.close();
		

        return null;
	}
	
}
