package com.wt.app.comment;

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
import com.wt.app.comment.dao.CommentDAO;

public class CommentListOkController implements Execute{
	
	
	@Override
	public Result Execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int caresNumber = Integer.valueOf(request.getParameter("careNumber"));
		
		CommentDAO commentDAO = new CommentDAO();
		Gson gson = new Gson();
		JsonArray comments = new JsonArray();

		commentDAO.selectAll(caresNumber).stream().map(gson::toJson).map(JsonParser::parseString).forEach(comments::add);

		System.out.println(comments.toString());

		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(comments.toString());
		out.close();

		return null;
	}

	
}
