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

public class PostReportController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PostsDAO postsDAO = new PostsDAO();

	    Integer usersNumber = (Integer) request.getSession().getAttribute("usersNumber");
	    int postsUsersNumber = Integer.parseInt(request.getParameter("postsUsersNumber"));
	    int postNumber = Integer.parseInt(request.getParameter("postsNumber"));
	    String reportReason = request.getParameter("reportReason");
	    
	    response.setContentType("application/json; charset=UTF-8");
	    PrintWriter out = response.getWriter();

	    Map<String, Object> reportMap = new HashMap<>();
	    reportMap.put("postsNumber", postNumber);
	    reportMap.put("usersNumber", usersNumber);
	    reportMap.put("reportReason", reportReason);
	    
	    int reCount = postsDAO.checkReport(reportMap);
	    System.out.println("reportMap: " + reportMap);
	    if (reCount == 0) {
	        postsDAO.insertReport(reportMap);
	        postsDAO.updateReport(postNumber);
	        out.print("{\"result\":\"reported\"}");
	    } else {
	        out.print("{\"result\":\"already\"}");
	    }

	    out.close();
	    return null;
	}
	
}
