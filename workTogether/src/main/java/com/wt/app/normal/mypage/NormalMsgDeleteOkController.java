package com.wt.app.normal.mypage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.normal.mypage.dao.MyPageNormalDAO;

public class NormalMsgDeleteOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Result result = new Result();
		System.out.println(" 들어옴 ");
		
		MyPageNormalDAO dao = new MyPageNormalDAO();
		
		String[] checks = request.getParameterValues("mark_check");

		if (checks != null) { // 체크된 값이 있을 때만 처리
		    for (String favNumStr : checks) {
		        if(favNumStr != null && !favNumStr.isEmpty()) { // null/빈 문자열 체크
		            int favoritesNumber = Integer.parseInt(favNumStr);
		            
		            System.out.println(favoritesNumber);
		            dao.normalfavoriteListDelete(favoritesNumber);
		        }
		    }
		} 
		

		result.setPath("/myPageNormal/normalfavoriteList.mn");
        result.setRedirect(false);
        return result;
	}
	
}
