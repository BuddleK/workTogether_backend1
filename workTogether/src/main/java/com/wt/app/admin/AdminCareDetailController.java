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

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("==== AdminCareDetailController 실행 ====");
		Result result = new Result();

		AdminDAO dao = new AdminDAO();

		// 1) 파라미터 확인
		String usersNumberStr = request.getParameter("usersNumber");
		if (usersNumberStr == null || usersNumberStr.trim().isEmpty()) {
			System.out.println("[Detail] usersNumber 파라미터 없음");
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}
		int usersNumber = Integer.parseInt(usersNumberStr);

		// 2) 단건 조회
		AdminCareSignupDTO item = dao.careSignupOne(usersNumber);
		if (item == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}

		// 3) 첨부파일 메타 조회 (null 안전)
		AdminCareFileDTO license = null;
		AdminCareFileDTO account = null;

		Integer certNum = item.getCareCertificateFilesNum();
		if (certNum != null && certNum > 0) {
			license = dao.careFileLicense(certNum);
		}

		Integer passbookNum = item.getCarePassbookFilesNum();
		if (passbookNum != null && passbookNum > 0) {
			account = dao.careFileAccount(passbookNum);
		}

		// 4) 바인딩
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

		// 5) 액션 URL
		request.setAttribute("usersNumber", usersNumber);
		request.setAttribute("approveAction",
				request.getContextPath() + "/admin/care/approve.ad?usersNumber=" + usersNumber);
		request.setAttribute("rejectAction",
				request.getContextPath() + "/admin/care/reject.ad?usersNumber=" + usersNumber);
		request.setAttribute("rejectAllAction",
				request.getContextPath() + "/admin/care/rejectAll.ad?usersNumber=" + usersNumber);

		// 6) 포워드
		result.setPath("/app/admin/careRequestDetail.jsp");
		result.setRedirect(false);
		return result;
	}
}