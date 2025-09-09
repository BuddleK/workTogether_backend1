package com.wt.app.posts;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.posts.dao.PostsDAO;

public class PostReportCancelController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PostsDAO postsDAO = new PostsDAO();

        // 세션에서 usersNumber 가져오기
        Integer usersNumber = (Integer) request.getSession().getAttribute("usersNumber");
        int postsNumber = Integer.parseInt(request.getParameter("postsNumber"));

        response.setContentType("application/json; charset=UTF-8");
        PrintWriter out = response.getWriter();

        Map<String, Object> reportMap = new HashMap<>();
        reportMap.put("postsNumber", postsNumber);
        reportMap.put("usersNumber", usersNumber);
        
        System.out.println("usersNumber: " + usersNumber);
        System.out.println("postsNumber: " + postsNumber);

        int deleteCount = postsDAO.deleteReport(reportMap);

        if (deleteCount > 0) {
            out.print("{\"result\":\"success\"}");
        } else {
            out.print("{\"result\":\"fail\"}");
        }

        out.close();
        return null;
	}
	

}
