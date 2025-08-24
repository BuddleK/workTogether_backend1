package com.wt.app.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.admin.dao.AdminCareDAO;
import com.wt.app.dto.AdminCareFileDTO;

public class AdminCareFileController implements Execute {

	@Override
	public Result Execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("==== AdminCareFileController 실행 ====");

		String type = request.getParameter("type");
		String num = request.getParameter("fileNumber");

		if (type == null || num == null) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "필수 파라미터가 없습니다.");
			return null;
		}

		int fileNumber;
		try {
			fileNumber = Integer.parseInt(num);
		} catch (NumberFormatException e) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "fileNumber 형식 오류");
			return null;
		}

		AdminCareDAO adminCareDAO = new AdminCareDAO();
		AdminCareFileDTO fileInfo = null;

		switch (type.toUpperCase()) {
		case "LICENSE":
			fileInfo = adminCareDAO.fileLicense(fileNumber);
			break;
		case "ACCOUNT":
			fileInfo = adminCareDAO.fileAccount(fileNumber);
			break;
		case "PROFILE":
			fileInfo = adminCareDAO.fileProfile(fileNumber);
			break;
		default:
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "허용되지 않는 type 값입니다.");
			return null;
		}

		if (fileInfo == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND, "파일 정보를 찾을 수 없습니다.");
			return null;
		}

		// Gson을 이용해 바로 JSON 직렬화 지피티로 도움 ...
		response.setContentType("application/json; charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			out.print(new Gson().toJson(fileInfo));
		}

		return null;
	}
}