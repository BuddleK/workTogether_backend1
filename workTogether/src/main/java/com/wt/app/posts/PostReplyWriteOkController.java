package com.wt.app.posts;

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
import com.wt.app.dto.PostReplyDTO;
import com.wt.app.posts.dao.PostReplyDAO;

public class PostReplyWriteOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		PostReplyDTO postReplyDTO = new PostReplyDTO();
		PostReplyDAO postReplyDAO = new PostReplyDAO();
		System.out.println("세션에 저장된 멤버" + session.getAttribute("usersNumber"));

		request.setCharacterEncoding("utf-8");

		// json 응답
		Gson gson = new Gson();
//		Map<String, Object> responseMap = new HashMap<>();

		// Json 데이터 읽기
		BufferedReader reader = request.getReader();
		JsonObject jsonObject = JsonParser.parseString(reader.lines().collect(Collectors.joining())).getAsJsonObject();

		// 필수 파라미터 확인
		if (!jsonObject.has("postsNumber") || !jsonObject.has("usersNumber") || !jsonObject.has("replyContent")) {
			
			response.setContentType("application/json; charset=utf-8");
			response.getWriter().write(gson.toJson(Map.of("status", "fail", "message", "필수 데이터가 없습니다")));
			return null;
		}

		// DTO 설정
		postReplyDTO.setPostsNumber(jsonObject.get("postsNumber").getAsInt());
		postReplyDTO.setUsersNumber(jsonObject.get("usersNumber").getAsInt());
		postReplyDTO.setReplyContent(jsonObject.get("replyContent").getAsString());

		System.out.println("postReplyDTO 확인 :" + postReplyDTO);

		// DB 저장
		postReplyDAO.insert(postReplyDTO);
		System.out.println("댓글 작성완료 :" + postReplyDTO);

		// JSON 응답
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().write(gson.toJson(Map.of("status", "success", "message", "댓글이 성공적으로 저장되었습니다")));
		return null;
	}
	
}
