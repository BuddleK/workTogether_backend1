package com.wt.app.admin;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.admin.dao.AdminDAO;
import com.wt.app.dto.AdminFileDownloadDTO;

public class AdminCareFileDownloadController implements Execute {

	// 웹루트 기준 고정 폴더 (/workTogether/src/main/webapp/upload -> 런타임에선 /upload 로 매핑됨)
	private static final String UPLOAD_WEB_DIR = "/upload";

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String kind = request.getParameter("kind"); // license | account
		String noStr = request.getParameter("no"); // 파일 PK
		if (kind == null || noStr == null) {
			response.sendError(400);
			return null;
		}

		final int no;
		try {
			no = Integer.parseInt(noStr);
		} catch (NumberFormatException e) {
			response.sendError(400);
			return null;
		}

		AdminDAO dao = new AdminDAO();
		AdminFileDownloadDTO dto = "license".equalsIgnoreCase(kind) ? dao.fileDownloadLicense(no)
				: "account".equalsIgnoreCase(kind) ? dao.fileDownloadAccount(no) : null;

		if (dto == null) {
			response.sendError(404);
			return null;
		}

		String path = dto.getFilePath(); // 보통 "/upload/license" 또는 "/upload/passbook" (혹은 파일까지 포함)
		String name = dto.getFileName(); // 확장자 없는 베이스명일 수 있음
		String ext = dto.getFileType(); // "jpg" | "png" | ".jpg" 등

		if (path == null || path.isBlank()) {
			response.sendError(404);
			return null;
		}

		// /upload 기준으로 강제 정규화
		if (!path.startsWith("/"))
			path = "/" + path;
		if (!path.startsWith(UPLOAD_WEB_DIR)) {
			// DB에 엉뚱한 경로가 있으면 kind로 하위폴더를 강제 지정
			path = UPLOAD_WEB_DIR + ("license".equalsIgnoreCase(kind) ? "/license" : "/passbook");
		}

		// 파일명 붙이기 (path가 폴더로 끝나는 경우)
		String lower = path.toLowerCase();
		boolean pathHasFile = lower.endsWith(".jpg") || lower.endsWith(".jpeg") || lower.endsWith(".png");
		if (!pathHasFile) {
			if (name == null || name.isBlank()) {
				response.sendError(404);
				return null;
			}
			if (!path.endsWith("/"))
				path += "/";
			String e = (ext == null ? "" : ext.trim());
			if (e.startsWith("."))
				e = e.substring(1);
			if (e.isEmpty())
				e = "jpg";
			path = path + name + "." + e;
		}

		// 웹경로 -> 실경로
		String real = request.getServletContext().getRealPath(path);
		File file = (real != null) ? new File(real) : new File(path);

		// 디버그 로그
		System.out.println("[DOWNLOAD] kind=" + kind + ", no=" + no);
		System.out.println("[DOWNLOAD] webPath=" + path);
		System.out.println("[DOWNLOAD] realPath=" + real);
		System.out.println("[DOWNLOAD] exists=" + file.exists());

		if (!file.exists() || !file.isFile()) {
			response.sendError(404);
			return null;
		}

		// 콘텐츠 타입
		String fname = file.getName().toLowerCase();
		String ct = "application/octet-stream";
		if (fname.endsWith(".jpg") || fname.endsWith(".jpeg"))
			ct = "image/jpeg";
		else if (fname.endsWith(".png"))
			ct = "image/png";
		response.setContentType(ct);

		// 다운로드 헤더
		String downloadName = file.getName();
		String encoded = java.net.URLEncoder.encode(downloadName, java.nio.charset.StandardCharsets.UTF_8.name())
				.replace("+", "%20");
		response.setHeader("Content-Disposition", "attachment; filename=\"" + encoded + "\"; filename*=UTF-8''" + encoded);
		response.setContentLengthLong(file.length());

		try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
				BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream())) {
			byte[] buf = new byte[8192];
			int len;
			while ((len = in.read(buf)) != -1)
				out.write(buf, 0, len);
			out.flush();
		}
		return null; // 직접 응답
	}
}
