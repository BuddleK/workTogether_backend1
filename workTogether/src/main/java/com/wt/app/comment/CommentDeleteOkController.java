package com.wt.app.comment;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.comment.dao.CommentDAO;

public class CommentDeleteOkController implements Execute{

    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        CommentDAO dao = new CommentDAO();
        Gson gson = new Gson();
        
        try {
            int commentsNumber = Integer.parseInt(request.getParameter("commentsNumber"));
            int normalNumber = Integer.parseInt(request.getParameter("normalNumber"));
            
            Map<String, Integer> numbers = new HashMap<>();
            numbers.put("commentsNumber", commentsNumber);
            numbers.put("normalNumber", normalNumber);
            
            dao.delete(numbers);

            response.setContentType("application/json; charset=utf-8");
            PrintWriter out = response.getWriter();
            out.print(gson.toJson(java.util.Map.of("status", "success")));
            out.close();
            
        } catch (Exception e) {
            e.printStackTrace();
            response.setContentType("application/json; charset=utf-8");
            response.getWriter().print(gson.toJson(java.util.Map.of("status", "fail")));
        }
        return null;
    }
    
}
