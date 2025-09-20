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

public class NormalReceiveDeleteOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("삭제 들어옴 ");
		
		MyPageNormalDAO dao = new MyPageNormalDAO();
		Gson gson = new Gson();
		
		
		String markCheckStr = request.getParameter("mark_check");
		
		System.out.println(markCheckStr);
		
		if(markCheckStr==null || markCheckStr.isEmpty()) {
			response.setContentType("application/json; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print(gson.toJson(java.util.Map.of("status", "success")));
			out.close();
			
			System.out.println(gson.toJson(java.util.Map.of("status", "success")));
		
		} else {
			List<Integer> markNumbers = new ArrayList<>();

			String[] nums = markCheckStr.split(",");
			for (String num : nums) {
			    num = num.trim();
			    if (!num.isEmpty()) {
			    	markNumbers.add(Integer.parseInt(num));
			    }
			}
			
			for(int num: markNumbers) {
				System.out.println("삭제번호"+num);
				dao.deleteMsg(num);
				response.setContentType("application/json; charset=utf-8");
				PrintWriter out = response.getWriter();
				out.print(gson.toJson(java.util.Map.of("status", "success")));
				out.close();
			}
		}
		
		
		
		

        return null;
	}
	
}
