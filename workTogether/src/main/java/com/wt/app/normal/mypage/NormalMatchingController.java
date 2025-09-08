package com.wt.app.normal.mypage;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.dto.NormalMatchingDTO;
import com.wt.app.normal.mypage.dao.MyPageNormalDAO;

public class NormalMatchingController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Result result = new Result();
		
		result.setPath("/app/myPageNormal/normalMatching.jsp");
        result.setRedirect(false);
        return result;
	}
	
}
