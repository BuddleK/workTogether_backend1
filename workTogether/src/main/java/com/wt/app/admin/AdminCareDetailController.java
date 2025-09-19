package com.wt.app.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.admin.dao.AdminDAO;
import com.wt.app.dto.AdminCareFileDTO;
import com.wt.app.dto.AdminCareSignupDTO;

public class AdminCareDetailController implements Execute {

	private static String normExt(String ext) {
		if (ext == null)
			return "";
		ext = ext.trim();
		if (ext.isEmpty())
			return "";
		return ext.startsWith(".") ? ext : "." + ext;
	}

	private static String leadingSlash(String p) {
		if (p == null || p.isEmpty())
			return "";
		return p.startsWith("/") ? p : "/" + p;
	}

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("==== AdminCareDetailController 실행 ====");
		Result result = new Result();
		AdminDAO dao = new AdminDAO();

		String usersNumberStr = request.getParameter("usersNumber");
		if (usersNumberStr == null || usersNumberStr.trim().isEmpty()) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}

		final int usersNumber;
		try {
			usersNumber = Integer.parseInt(usersNumberStr.trim());
		} catch (NumberFormatException e) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}

		AdminCareSignupDTO item = dao.careSignupOne(usersNumber);
		if (item == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}

		// 파일 메타
		AdminCareFileDTO license = null;
		AdminCareFileDTO account = null;

		Integer certNum = item.getCareCertificateFilesNum();
		if (certNum != null && certNum > 0)
			license = dao.careFileLicense(certNum);

		Integer passbookNum = item.getCarePassbookFilesNum();
		if (passbookNum != null && passbookNum > 0)
			account = dao.careFileAccount(passbookNum);

		request.setAttribute("item", item);

		String ctx = request.getContextPath();

		// 자격증
		if (license != null) {
			String name = license.getFileName();
			String ext = normExt(license.getFileType());
			if (name != null && !name.toLowerCase().endsWith(ext))
				name = name + ext;

			String path = leadingSlash(license.getFilePath()); // DB 경로 그대로 사용
			request.setAttribute("licenseFileName", name);
			request.setAttribute("licenseFileNumber", license.getFileNumber());
			request.setAttribute("licenseDownloadUrl", ctx + path); // ★ 서블릿 대신 정적 경로
		}

		// 통장사본
		if (account != null) {
			String name = account.getFileName();
			String ext = normExt(account.getFileType());
			if (name != null && !name.toLowerCase().endsWith(ext))
				name = name + ext;

			String path = leadingSlash(account.getFilePath()); // DB 경로 그대로 사용
			request.setAttribute("accountFileName", name);
			request.setAttribute("accountFileNumber", account.getFileNumber());
			request.setAttribute("accountDownloadUrl", ctx + path); // ★ 서블릿 대신 정적 경로
		}

		// 버튼 액션
		request.setAttribute("usersNumber", usersNumber);
		request.setAttribute("approveAction", ctx + "/admin/care/approve.ad?usersNumber=" + usersNumber);
		request.setAttribute("rejectAction", ctx + "/admin/care/reject.ad?usersNumber=" + usersNumber);
		request.setAttribute("rejectAllAction", ctx + "/admin/care/rejectAll.ad?usersNumber=" + usersNumber);

		result.setPath("/app/admin/careRequestDetail.jsp");
		result.setRedirect(false);
		return result;
	}
}
