package com.wt.app.admin;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.admin.dao.AdminDAO;
import com.wt.app.dto.AdminNewsBoardDTO;
import com.wt.app.dto.FileNoticeDTO;

public class AdminNewsReadOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
        Result result = new Result();
        AdminDAO adminDAO = new AdminDAO();

        String newsNumberStr = request.getParameter("newsNumber");
        if (newsNumberStr == null || newsNumberStr.trim().isEmpty()) {
            result.setRedirect(true);
            result.setPath(request.getContextPath() + "/admin/news/newsListOk.ad");
            return result;
        }

        int newsNumber;
        try {
            newsNumber = Integer.parseInt(newsNumberStr);
        } catch (NumberFormatException e) {
            result.setRedirect(true);
            result.setPath(request.getContextPath() + "/admin/news/newsListOk.ad");
            return result;
        }

        AdminNewsBoardDTO news;
        try {
            news = adminDAO.select(newsNumber);
        } catch (Exception e) {
            result.setRedirect(true);
            result.setPath(request.getContextPath() + "/admin/news/newsListOk.ad");
            return result;
        }

        if (news == null) {
            result.setRedirect(true);
            result.setPath(request.getContextPath() + "/admin/news/newsListOk.ad");
            return result;
        }

        String page = request.getParameter("page");
        if (page != null && !page.isEmpty()) {
            request.setAttribute("page", page);
        }

        request.setAttribute("news", news);
        result.setRedirect(false);
        result.setPath("/app/admin/newsBoardDetail.jsp");
        return result;
    }
}