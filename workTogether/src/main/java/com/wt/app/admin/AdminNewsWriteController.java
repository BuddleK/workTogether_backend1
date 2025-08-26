package com.wt.app.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.admin.dao.AdminDAO;

public class AdminNewsWriteController implements Execute {

	@Override
	public Result Execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("==== AdminNewsWriteController 실행(작성 페이지 이동) ====");

		AdminDAO adminDAO = new AdminDAO(); // AdminDAO 객체는 일단 유지 (향후 다른 관리자 관련 기능 추가 대비)
		Result result = new Result();
		HttpSession session = request.getSession();

		Integer adminNumber = (Integer) session.getAttribute("adminNumber");
		
		//디비에 저장될건 필요 할 수 잇음
		request.setAttribute("adminNumber", adminNumber);

		//뉴스 작성 포워드
		result.setPath("/admin/news/newsBoardAdd.jsp");
		result.setRedirect(false);
		return result;
	}
}