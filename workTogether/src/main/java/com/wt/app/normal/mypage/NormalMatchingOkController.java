package com.wt.app.normal.mypage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.dto.NormalMatchingDTO;
import com.wt.app.normal.mypage.dao.MyPageNormalDAO;

public class NormalMatchingOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Result result = new Result();
		System.out.println("매칭 수락 페이지");
		
		MyPageNormalDAO dao = new MyPageNormalDAO();
		Gson gson = new Gson();
		int matchNumber = Integer.parseInt(request.getParameter("matchNumber"));
		System.out.println("매치넘버" + matchNumber);
		
		//매칭 완료 누를 시 => 일반 회원 포인트 차감, 돌봄 회원 포인트 증감, 이용완료 표시
		dao.okMatch(matchNumber);
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(gson.toJson(java.util.Map.of("status", "success")));
		out.close();
		
		
        return null;
	}
	
}
