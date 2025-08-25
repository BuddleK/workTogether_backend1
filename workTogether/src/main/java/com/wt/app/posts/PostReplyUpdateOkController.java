package com.wt.app.posts;

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
import com.wt.app.dto.PostReplyDTO;
import com.wt.app.posts.dao.PostReplyDAO;

public class PostReplyUpdateOkController implements Execute {

	@Override
	public Result Execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PostReplyDAO dao = new PostReplyDAO();
        Gson gson = new Gson();

        try {
            BufferedReader reader = request.getReader();
            String body = reader.lines().collect(Collectors.joining());
            JsonObject json = JsonParser.parseString(body).getAsJsonObject();

            int replyNumber = json.get("replyNumber").getAsInt();
            String replyContent = json.get("replyContent").getAsString();

            PostReplyDTO dto = new PostReplyDTO();
            dto.setReplyNumber(replyNumber);
            dto.setReplyContent(replyContent);

            dao.update(dto);

            response.setContentType("application/json; charset=utf-8");
            PrintWriter out = response.getWriter();
            out.print(gson.toJson(java.util.Map.of("status", "success")));
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            response.setContentType("application/json; charset=utf-8");
            response.getWriter().print(gson.toJson(java.util.Map.of("status", "fail")));
        }
        
		return null;
	}
	
}
