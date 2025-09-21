package com.wt.app.shops;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.shops.dao.ShopsDAO;

public class CancleFavoriteOKController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println("삭제 시작");
		ShopsDAO dao = new ShopsDAO();
		Gson gson = new Gson();

		HttpSession session = request.getSession();
		String usersNumberStr = session.getAttribute("usersNumber") + "";
		String shopsNumberStr = request.getParameter("shopsNumber");
		
		System.out.println("usersNumberStr "+usersNumberStr);
		System.out.println("shopsNumberStr "+shopsNumberStr);
		
		if (usersNumberStr == null || "null".equals(usersNumberStr) || shopsNumberStr == null) {
			System.out.println("뭐하나 null임");
            response.getWriter().write(gson.toJson(Map.of(
                "status", "fail",
                "message", "로그인 정보 또는 가게 번호 누락"
            )));
            return null;
        }

        int usersNumber = Integer.parseInt(usersNumberStr);
        int shopsNumber = Integer.parseInt(shopsNumberStr);
	    Map<String, Integer> numbers = new HashMap<>();
	    numbers.put("usersNumber", usersNumber);
	    numbers.put("shopsNumber", shopsNumber);

        dao.deleteJim(numbers); // 찜 삭제

        response.setContentType("application/json; charset=utf-8");
        response.getWriter().write(gson.toJson(Map.of("status", "success")));
        return null;
	}
}
