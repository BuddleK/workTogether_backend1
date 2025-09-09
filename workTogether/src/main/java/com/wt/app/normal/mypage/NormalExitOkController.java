package com.wt.app.normal.mypage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.normal.mypage.dao.MyPageNormalDAO;

public class NormalExitOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Result result = new Result();
		System.out.println("탈퇴 들어옴");
		HttpSession session = request.getSession();
		MyPageNormalDAO dao = new MyPageNormalDAO();
		Integer usersNumber = (Integer)session.getAttribute("usersNumber");
//		dao.normalExit(usersNumber);
		session.invalidate();
		result.setPath("/");
        result.setRedirect(true);
        return result;
	}
	
}
