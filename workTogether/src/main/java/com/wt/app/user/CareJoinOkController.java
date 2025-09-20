package com.wt.app.user;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.*;
import java.util.concurrent.ThreadLocalRandom;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.dto.CareSignDTO;
import com.wt.app.users.dao.CareUsersDAO;

public class CareJoinOkController implements Execute {

	private static final String UPLOAD_WEB_DIR = "/upload";
	private static final String DIR_LICENSE = UPLOAD_WEB_DIR + "/license";
	private static final String DIR_PASSBOOK = UPLOAD_WEB_DIR + "/passbook";
	private static final String DIR_PROFILE = UPLOAD_WEB_DIR + "/profile";

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

			// 무조건 프로젝트의 /src/main/webapp/upload 를 사용 (실행시 실제 경로로 변환)
			Path baseFs = Paths.get(request.getServletContext().getRealPath(UPLOAD_WEB_DIR));
			Path fsLicense = baseFs.resolve("license");
			Path fsPassbook = baseFs.resolve("passbook");
			Path fsProfile = baseFs.resolve("profile");
			Files.createDirectories(fsLicense);
			Files.createDirectories(fsPassbook);
			Files.createDirectories(fsProfile);

			Part licensePart = request.getPart("licenseFile");
			if (!hasFile(licensePart))
				throw new IllegalArgumentException("자격증 파일은 필수입니다.");
			String licFileName = saveImage(licensePart, fsLicense);
			dto.setLicensePath(DIR_LICENSE + "/" + licFileName);
			dto.setLicenseName(getBaseName(licensePart));
			dto.setLicenseType(getExtFromFileName(licFileName));
			dto.setLicenseSizeBytes(licensePart.getSize());

			Part accountPart = request.getPart("accountFile");
			if (!hasFile(accountPart))
				throw new IllegalArgumentException("통장 사본 파일은 필수입니다.");
			String accFileName = saveImage(accountPart, fsPassbook);
			dto.setAccountPath(DIR_PASSBOOK + "/" + accFileName);
			dto.setAccountName(getBaseName(accountPart));
			dto.setAccountType(getExtFromFileName(accFileName));
			dto.setAccountSizeBytes(accountPart.getSize());

			Part profilePart = request.getPart("profileFile");
			if (hasFile(profilePart)) {
				String proFileName = saveImage(profilePart, fsProfile);
				dto.setProfilePath(DIR_PROFILE + "/" + proFileName);
				dto.setProfileName(getBaseName(profilePart));
				dto.setProfileType(getExtFromFileName(proFileName));
				dto.setProfileSizeBytes(profilePart.getSize());
			} else {
				dto.setProfilePath(null);
				dto.setProfileName(null);
				dto.setProfileType(null);
				dto.setProfileSizeBytes(null);
			}

			new CareUsersDAO().sign(dto);

			request.getSession().setAttribute("careJoinSuccess", "1");
			result.setRedirect(true);
			result.setPath(request.getContextPath() + "/mainOk.main"); // 메인
			return result;

		} catch (Exception e) {
			e.printStackTrace();
			result.setRedirect(true);
			result.setPath(request.getContextPath() + "/app/sign/signCare.jsp?error=join");
			return result;
		}
	}

	private boolean hasFile(Part p) {
		return p != null && p.getSize() > 0;
	}

	private String saveImage(Part part, Path fsDir) throws IOException {
		String submitted = part.getSubmittedFileName();
		if (submitted != null)
			submitted = Paths.get(submitted).getFileName().toString();

		String ext = getExtension(submitted).toLowerCase();
		if ("jpeg".equals(ext))
			ext = "jpg";
		if (!(ext.equals("jpg") || ext.equals("png"))) {
			throw new IllegalArgumentException("이미지 파일(jpg/png)만 업로드 가능합니다.");
		}

		String base = sanitizeBaseName(submitted);
		String unique = System.nanoTime() + "_" + ThreadLocalRandom.current().nextInt(1000, 9999);
		String saved = base + "_" + unique + "." + ext;

		Path dest = fsDir.resolve(saved);
		try (InputStream in = part.getInputStream()) {
			Files.copy(in, dest, StandardCopyOption.REPLACE_EXISTING);
		}
		return saved;
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
		n = Paths.get(n).getFileName().toString();
		int dot = n.lastIndexOf('.');
		return (dot > 0) ? n.substring(0, dot) : n;
	}

	private String getExtFromFileName(String fileName) {
		int dot = fileName.lastIndexOf('.');
		return (dot > -1 && dot < fileName.length() - 1) ? fileName.substring(dot + 1) : "";
	}

	private String sanitizeBaseName(String filename) {
		String base = (filename == null) ? "file" : filename;
		int dot = base.lastIndexOf('.');
		if (dot > 0)
			base = base.substring(0, dot);
		base = base.replaceAll("[^0-9A-Za-z가-힣._-]", "_");
		if (base.isBlank())
			base = "file";
		if (base.length() > 40)
			base = base.substring(0, 40);
		return base;
	}
}
