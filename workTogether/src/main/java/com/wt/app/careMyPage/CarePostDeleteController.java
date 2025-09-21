package com.wt.app.careMyPage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.posts.dao.PostsDAO;

public class CarePostDeleteController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("=========CarePostDeleteController=========");
		Result result = new Result();
		
		String postsNumbersJson = request.getParameter("postsNumbers");
		Gson gson = new Gson();
		String[] postsNumbers = gson.fromJson(postsNumbersJson, String[].class);
		
		PostsDAO postsDAO = new PostsDAO();
		
        //받아온 게시물 번호들로 삭제
        for (String postNumber : postsNumbers) {
            System.out.println(postNumber);  // 각 게시물 번호 출력
            postsDAO.delete(Integer.parseInt(postNumber));
        }
		
		result.setPath("/myPageCare/carePost.cp");
		result.setRedirect(false);
		return result;
	}
	
}
