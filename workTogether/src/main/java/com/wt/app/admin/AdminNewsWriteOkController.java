package com.wt.app.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.admin.dao.AdminDAO;
import com.wt.app.dto.AdminNewsBoardDTO;

public class AdminNewsWriteOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
        Result result = new Result();

        String newsTitle = request.getParameter("newsTitle");
        String newsLinkUrl = request.getParameter("newsLinkUrl");

        Integer adminNumber = (Integer) request.getSession().getAttribute("adminNumber");
        if (adminNumber == null) {
            try {
                adminNumber = Integer.valueOf(request.getParameter("adminNumber"));
            } catch (Exception ignore) { adminNumber = null; }
        }

        if (adminNumber == null || newsTitle == null || newsTitle.trim().isEmpty()) {
            result.setRedirect(true);
            result.setPath(request.getContextPath() + "/admin/news/newsListOk.ad");
            return result;
        }

        AdminNewsBoardDTO dto = new AdminNewsBoardDTO();
        dto.setAdminNumber(adminNumber);
        dto.setNewsTitle(newsTitle);
        dto.setNewsLinkUrl(newsLinkUrl);

        AdminDAO adminDAO = new AdminDAO();
        adminDAO.insertNews(dto);

        result.setRedirect(true);
        result.setPath(request.getContextPath() + "/admin/news/newsListOk.ad");
        return result;
    }
}