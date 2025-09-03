package com.wt.app.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.dto.CareSignDTO;
import com.wt.app.dto.UsersDTO;
import com.wt.app.users.dao.CareUsersDAO;
import com.wt.app.users.dao.UsersDAO;

public class CareJoinOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		Result result = new Result();

		try {
			// 공통 파라미터
			String usersId = request.getParameter("usersId");
			String usersPassword = request.getParameter("usersPassword");
			String usersName = request.getParameter("usersName");
			String usersEmail = request.getParameter("usersEmail");
			String usersPhone = request.getParameter("usersPhone");
			String usersPostsalCode = request.getParameter("usersPostsalCode");
			String usersAddressLine1 = request.getParameter("usersAddressLine1");
			String usersAddressLine2 = request.getParameter("usersAddressLine2");

			// 돌봄 상세 파라미터
			String careIntroText = request.getParameter("careIntroText");
			String certParam = request.getParameter("careCertificateFilesNum");
			String passParam = request.getParameter("carePassbookFilesNum");
			String profParam = request.getParameter("careProfilesPhotoNumber");

			// 1) 공통 users INSERT → PK(long) 획득
			UsersDTO userDTO = new UsersDTO();
			userDTO.setUsersId(usersId);
			userDTO.setUsersPassword(usersPassword);
			userDTO.setUsersType("C");
			userDTO.setUsersName(usersName);
			userDTO.setUsersEmail(usersEmail);
			userDTO.setUsersPhone(usersPhone);
			userDTO.setUsersPostsalCode(usersPostsalCode);
			userDTO.setUsersAddressLine1(usersAddressLine1);
			userDTO.setUsersAddressLine2(usersAddressLine2);

			long usersNumber = new UsersDAO().join(userDTO);

			// 2) 돌봄 상세 INSERT (필요한 최소값만 세팅)
			CareSignDTO caresignDTO = new CareSignDTO();
			caresignDTO.setUsersNumber(usersNumber);
			caresignDTO.setCareIntroText(careIntroText);
			caresignDTO.setCareAccept("W"); // 대기 상태 기본값

			Long cert = null, pass = null, prof = null;
			
			if (certParam != null && !certParam.isEmpty())
				caresignDTO.setCareCertificateFilesNum(Long.parseLong(certParam));
			if (passParam != null && !passParam.isEmpty())
				caresignDTO.setCarePassbookFilesNum(Long.parseLong(passParam));
			if (profParam != null && !profParam.isEmpty())
				caresignDTO.setCareProfilesPhotoNumber(Long.parseLong(profParam));

			if (cert == null) cert = 0L;
			if (pass == null) pass = 0L;
			
			new CareUsersDAO().sign(caresignDTO);
			// 성공 → 로그인
			result.setRedirect(true);
			result.setPath(request.getContextPath() + "/");
			return result;

		} catch (Exception e) {
		    e.printStackTrace(); // ★ 원인 확인 필수
			result.setRedirect(true);
			result.setPath(request.getContextPath() + "/app/sign/signCare.jsp?error=join");
			return result;
		}
	}
}
