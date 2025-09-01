package com.wt.app.comment;

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
import com.wt.app.comment.dao.CommentDAO;
import com.wt.app.dto.CommentDTO;

public class CommentUpdateOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CommentDAO commentDAO = new CommentDAO();
		Gson gson = new Gson();
		
		try {
			BufferedReader reader = request.getReader();
			String body = reader.lines().collect(Collectors.joining());
			JsonObject json = JsonParser.parseString(body).getAsJsonObject();
			
			int commentsNumber = json.get("commentsNumber").getAsInt();
			String commentsContent= json.get("commentsContent").getAsString();
			
			CommentDTO commentDTO = new CommentDTO();
			commentDTO.setCommentsNumber(commentsNumber);
			commentDTO.setCommentsContent(commentsContent);
			
			commentDAO.update(commentDTO);
			
			response.setContentType("application/json; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print(gson.toJson(java.util.Map.of("status", "success")));
			out.close();
		}catch(Exception e) {
			e.printStackTrace();
			response.setContentType("application/json; charset=utf-8");
			response.getWriter().print(gson.toJson(java.util.Map.of("status", "fail")));
		}
		
		return null;
	}
	
}
