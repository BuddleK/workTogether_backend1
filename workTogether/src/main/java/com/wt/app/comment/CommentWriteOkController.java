package com.wt.app.comment;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;
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
import com.wt.app.comment.dao.CommentDAO;
import com.wt.app.dto.CommentDTO;

public class CommentWriteOkController implements Execute{

	@Override
	public Result Execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		CommentDTO commentDTO = new CommentDTO();
		CommentDAO commentDAO = new CommentDAO();
		System.out.println("세션 값 : " + session.getAttribute("normalNumber"));
		
		request.setCharacterEncoding("utf-8");
		
		Gson gson = new Gson();
		
		BufferedReader reader = request.getReader();
		JsonObject jsonObject = JsonParser.parseString(reader.lines().collect(Collectors.joining())).getAsJsonObject();
		
		if(!jsonObject.has("normalNumber") || !jsonObject.has("careNumber") || !jsonObject.has("commentsContent")) {
			
			response.setContentType("application/json; charset=utf-8");
			response.getWriter().write(gson.toJson(Map.of("status", "fail", "message", "필수 데이터가 없습니다")));
			return null;
		}
		
		commentDTO.setCareNumber(jsonObject.get("careNumber").getAsInt());
		commentDTO.setNormalNumber(jsonObject.get("normalNumber").getAsInt());
		commentDTO.setCommentsContent(jsonObject.get("commentsContent").getAsString());
		
		System.out.println("commentDTO는 : " + commentDTO);
		
		commentDAO.insert(commentDTO);
		System.out.println("작성 완료 후기" + commentDTO);
		
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().write(gson.toJson(Map.of("status", "success", "message", "후기 작성 성공")));
		
		return null;
	}

}
