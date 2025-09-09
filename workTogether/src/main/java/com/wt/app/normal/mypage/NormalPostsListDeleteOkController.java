package com.wt.app.normal.mypage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.normal.mypage.dao.MyPageNormalDAO;

public class NormalPostsListDeleteOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Result result = new Result();
		Gson gson = new Gson();
		MyPageNormalDAO dao =new MyPageNormalDAO();
		String matchNumberStr = request.getParameter("matchNumbers");
		if(matchNumberStr==null || matchNumberStr.isEmpty()) {
			response.setContentType("application/json; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print(gson.toJson(java.util.Map.of("status", "success")));
			out.close();
		
		} else {
			List<Integer> matchNumbers = new ArrayList<>();

			String[] nums = matchNumberStr.split(",");
			for (String num : nums) {
			    num = num.trim();
			    if (!num.isEmpty()) {
			        matchNumbers.add(Integer.parseInt(num));
			    }
			}
			
			for(int num: matchNumbers) {
				dao.normalPostsListDelete(num);
				response.setContentType("application/json; charset=utf-8");
				PrintWriter out = response.getWriter();
				out.print(gson.toJson(java.util.Map.of("status", "success")));
				out.close();
			}
		}
		
		
        return null;
	}

}
