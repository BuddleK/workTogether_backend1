package com.wt.app.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.dto.CareSignDTO;
import com.wt.app.users.dao.CareUsersDAO;

public class CareJoinOkController implements Execute {

	private static Long toLongOrNull(String s) {
		return (s == null || s.isEmpty()) ? null : Long.parseLong(s);
	}

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
        Result result = new Result();

        try {
            CareSignDTO dto = new CareSignDTO();

            dto.setUsersId(request.getParameter("usersId"));
            dto.setUsersPassword(request.getParameter("usersPassword"));
            dto.setUsersType("C");
            dto.setUsersName(request.getParameter("usersName"));
            dto.setUsersEmail(request.getParameter("usersEmail"));
            dto.setUsersPhone(request.getParameter("usersPhone"));
            dto.setUsersPostsalCode(request.getParameter("usersPostsalCode"));
            dto.setUsersAddressLine1(request.getParameter("usersAddressLine1"));
            dto.setUsersAddressLine2(request.getParameter("usersAddressLine2"));

            dto.setCareIntroText(request.getParameter("careIntroText"));
            dto.setCareAccept("W");

            String licenseType = request.getParameter("licenseType");
            String licenseName = request.getParameter("licenseName");
            String licensePath = request.getParameter("licensePath");
            if (licenseType == null || licenseType.trim().isEmpty()
             || licenseName == null || licenseName.trim().isEmpty()
             || licensePath == null || licensePath.trim().isEmpty()) {
                throw new IllegalArgumentException("자격증 파일(형식/이름/경로)은 필수입니다.");
            }
            dto.setLicenseType(licenseType);
            dto.setLicenseName(licenseName);
            dto.setLicensePath(licensePath);
            dto.setLicenseSizeBytes(toLongOrNull(request.getParameter("licenseSizeBytes")));

            String accountType = request.getParameter("accountType");
            String accountName = request.getParameter("accountName");
            String accountPath = request.getParameter("accountPath");
            if (accountType == null || accountType.trim().isEmpty()
             || accountName == null || accountName.trim().isEmpty()
             || accountPath == null || accountPath.trim().isEmpty()) {
                throw new IllegalArgumentException("통장 사본 파일(형식/이름/경로)은 필수입니다.");
            }
            dto.setAccountType(accountType);
            dto.setAccountName(accountName);
            dto.setAccountPath(accountPath);
            dto.setAccountSizeBytes(toLongOrNull(request.getParameter("accountSizeBytes")));

            String profileType = request.getParameter("profileType");
            String profileName = request.getParameter("profileName");
            String profilePath = request.getParameter("profilePath");
            if (profileType == null || profileType.trim().isEmpty()
             || profileName == null || profileName.trim().isEmpty()
             || profilePath == null || profilePath.trim().isEmpty()) {
                dto.setProfileType(null);
                dto.setProfileName(null);
                dto.setProfilePath(null);
                dto.setProfileSizeBytes(null);
            } else {
                dto.setProfileType(profileType);
                dto.setProfileName(profileName);
                dto.setProfilePath(profilePath);
                dto.setProfileSizeBytes(toLongOrNull(request.getParameter("profileSizeBytes")));
            }

            new CareUsersDAO().sign(dto);

            result.setRedirect(true);
            result.setPath(request.getContextPath() + "/mainOk.main");
            return result;

        } catch (Exception e) {
            e.printStackTrace();
            result.setRedirect(true);
            result.setPath(request.getContextPath() + "/app/sign/signCare.jsp?error=join");
            return result;
        }
    }
}