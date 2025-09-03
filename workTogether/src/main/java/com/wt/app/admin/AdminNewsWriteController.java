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
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("==== AdminNewsWriteController 실행(작성 페이지 이동) ====");

		Result result = new Result();
	    result.setPath("/app/admin/newsBoardAdd.jsp"); // 실제 파일 경로
	    result.setRedirect(false);                     // forward
	    return result;
	}
}