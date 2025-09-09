package com.wt.app.user;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.dto.CareSignDTO;
import com.wt.app.users.dao.CareUsersDAO;

public class CareJoinOkController implements Execute {

	// webapp 기준 고정 폴더 (WAR 안)
	private static final String BASE_WEB_DIR = "/uploads/care";
	private static final String DIR_LICENSE = BASE_WEB_DIR + "/license";
	private static final String DIR_PASSBOOK = BASE_WEB_DIR + "/passbook";
	private static final String DIR_PROFILE = BASE_WEB_DIR + "/profile";

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		Result result = new Result();

		try {
			CareSignDTO dto = new CareSignDTO();

			// 1) 기본 회원 정보
			dto.setUsersId(request.getParameter("usersId"));
			dto.setUsersPassword(request.getParameter("usersPassword"));
			dto.setUsersType("C");
			dto.setUsersName(request.getParameter("usersName"));
			dto.setUsersEmail(request.getParameter("usersEmail"));
			dto.setUsersPhone(request.getParameter("usersPhone"));
			dto.setUsersPostsalCode(request.getParameter("usersPostsalCode"));
			dto.setUsersAddressLine1(request.getParameter("usersAddressLine1"));
			dto.setUsersAddressLine2(request.getParameter("usersAddressLine2"));

			// 2) 돌봄 상세
			dto.setCareIntroText(request.getParameter("careIntroText"));
			dto.setCareAccept("W"); // 대기

			// 3) 업로드 디렉토리 준비 (webapp 실제 경로)
			String realLicense = ensureDir(request, DIR_LICENSE);
			String realPass = ensureDir(request, DIR_PASSBOOK);
			String realProfile = ensureDir(request, DIR_PROFILE);

			// 4) 파일 처리 (jpg/png만)
			// (1) 자격증 (필수)
			Part licensePart = request.getPart("licenseFile");
			if (licensePart == null || licensePart.getSize() <= 0) {
				throw new IllegalArgumentException("자격증 파일은 필수입니다.");
			}
			String licWebPath = saveImage(licensePart, realLicense, DIR_LICENSE);
			dto.setLicensePath(licWebPath);
			dto.setLicenseName(getBaseName(licensePart)); // DB 칼럼 설계에 맞게
			dto.setLicenseType(getExtFromSavedPath(licWebPath)); // "jpg" 또는 "png"
			dto.setLicenseSizeBytes(licensePart.getSize());

			// (2) 통장 사본 (필수)
			Part accountPart = request.getPart("accountFile");
			if (accountPart == null || accountPart.getSize() <= 0) {
				throw new IllegalArgumentException("통장 사본 파일은 필수입니다.");
			}
			String accWebPath = saveImage(accountPart, realPass, DIR_PASSBOOK);
			dto.setAccountPath(accWebPath);
			dto.setAccountName(getBaseName(accountPart));
			dto.setAccountType(getExtFromSavedPath(accWebPath));
			dto.setAccountSizeBytes(accountPart.getSize());

			// (3) 프로필 (선택)
			Part profilePart = request.getPart("profileFile");
			if (profilePart != null && profilePart.getSize() > 0) {
				String proWebPath = saveImage(profilePart, realProfile, DIR_PROFILE);
				dto.setProfilePath(proWebPath);
				dto.setProfileName(getBaseName(profilePart));
				dto.setProfileType(getExtFromSavedPath(proWebPath));
				dto.setProfileSizeBytes(profilePart.getSize());
			} else {
				dto.setProfilePath(null);
				dto.setProfileName(null);
				dto.setProfileType(null);
				dto.setProfileSizeBytes(null);
			}

			// 5) 저장
			new CareUsersDAO().sign(dto);

			// 6) 성공
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

	/* ===== 유틸 ===== */

	// web 경로를 실제 경로로 바꿔 폴더 생성 후 실제 경로 반환
	private String ensureDir(HttpServletRequest req, String webDir) {
		String real = req.getServletContext().getRealPath(webDir);
		if (real == null)
			throw new IllegalStateException("realPath null: " + webDir);
		java.io.File d = new java.io.File(real);
		if (!d.exists())
			d.mkdirs();
		return real;
	}

	// jpg/png만 저장, 고유 파일명 생성, 저장 후 web 경로 반환
	private String saveImage(Part part, String realDir, String webDir) throws IOException {
		String submitted = part.getSubmittedFileName();
		String ext = getExtension(submitted).toLowerCase();

		if (!("jpg".equals(ext) || "jpeg".equals(ext) || "png".equals(ext))) {
			throw new IllegalArgumentException("이미지 파일(jpg/png)만 업로드 가능합니다.");
		}
		if ("jpeg".equals(ext))
			ext = "jpg"; // 정규화

		String saved = System.currentTimeMillis() + "_" + Math.abs(submitted.hashCode()) + "." + ext;
		Path dest = Paths.get(realDir, saved);
		try (InputStream in = part.getInputStream()) {
			Files.copy(in, dest, StandardCopyOption.REPLACE_EXISTING);
		}
		// DB에는 web 경로 저장
		return webDir + "/" + saved;
	}

	private String getExtension(String filename) {
		if (filename == null)
			return "";
		int dot = filename.lastIndexOf('.');
		return (dot > -1 && dot < filename.length() - 1) ? filename.substring(dot + 1) : "";
	}

	private String getBaseName(Part part) {
		String n = part.getSubmittedFileName();
		if (n == null)
			return "";
		int dot = n.lastIndexOf('.');
		return (dot > 0) ? n.substring(0, dot) : n;
	}

	private String getExtFromSavedPath(String webPath) {
		int dot = webPath.lastIndexOf('.');
		return (dot > -1 && dot < webPath.length() - 1) ? webPath.substring(dot + 1) : "";
	}
}