package com.wt.app.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.admin.dao.AdminCareDAO;
import com.wt.app.dto.AdminCareFileDTO;
import com.wt.app.dto.AdminCareSignupDTO;

public class AdminCareDetailController implements Execute {

	@Override
	public Result Execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("==== AdminCareDetailController 실행 ====");
		Result result = new Result();

		AdminCareDAO dao = new AdminCareDAO();

		String usersNumberStr = request.getParameter("usersNumber");
		if (usersNumberStr == null) {
			System.out.println("[Detail] usersNumber 파라미터 없음");
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}
		int usersNumber = Integer.parseInt(usersNumberStr);

		AdminCareSignupDTO item = dao.signupOne(usersNumber);
		if (item == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}

		AdminCareFileDTO license = null;
		AdminCareFileDTO account = null;

		if (item.getCareCertificateFilesNum() > 0) {
			license = dao.fileLicense(item.getCareCertificateFilesNum());
		}
		if (item.getCarePassbookFilesNum() > 0) {
			account = dao.fileAccount(item.getCarePassbookFilesNum());
		}

		request.setAttribute("item", item);

		if (license != null) {
			request.setAttribute("licenseFileName", license.getFileName());
			request.setAttribute("licenseDownloadUrl", request.getContextPath()
					+ "/admin/care/fileDownload.ad?type=LICENSE&fileNumber=" + license.getFileNumber());
		}
		if (account != null) {
			request.setAttribute("accountFileName", account.getFileName());
			request.setAttribute("accountDownloadUrl", request.getContextPath()
					+ "/admin/care/fileDownload.ad?type=ACCOUNT&fileNumber=" + account.getFileNumber());
		}

		// 승인/반려 버튼 액션 URL
		request.setAttribute("approveAction",
				request.getContextPath() + "/admin/care/approve.ad?usersNumber=" + usersNumber);
		request.setAttribute("rejectAction",
				request.getContextPath() + "/admin/care/reject.ad?usersNumber=" + usersNumber);
		request.setAttribute("rejectAllAction",
				request.getContextPath() + "/admin/care/rejectAll.ad?usersNumber=" + usersNumber);

		result.setPath("/app/admin/careRequestDetail.jsp");
		result.setRedirect(false);
		System.out.println("==== 상세 포워드 → " + result.getPath() + " ====");
		return result;
	}
}