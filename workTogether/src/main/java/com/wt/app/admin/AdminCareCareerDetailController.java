package com.wt.app.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;

public class AdminCareCareerDetailController implements Execute{

	@Override
	public Result Execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("==== AdminCareCareerDetailController 실행 ====");

        // 필수 파라미터: usersNumber (또는 modifyNumber를 사용할 계획이면 여기에 추가)
        String usersNumberStr = request.getParameter("usersNumber");
        if (usersNumberStr == null || usersNumberStr.isBlank()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "usersNumber 파라미터가 필요합니다.");
            return null;
        }

        int usersNumber;
        try {
            usersNumber = Integer.parseInt(usersNumberStr);
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "usersNumber 형식이 올바르지 않습니다.");
            return null;
        }


        // 일단 usersNumber만 바인딩해두고 뷰에서 활용
        request.setAttribute("usersNumber", usersNumber);

        Result result = new Result();
        // JSP 경로는 프로젝트 구조에 맞게 수정하세요.
        result.setPath("/app/admin/careCareerDetail.jsp");
        result.setRedirect(false);
        return result;
    }
}