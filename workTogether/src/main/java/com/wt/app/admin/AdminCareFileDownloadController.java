package com.wt.app.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.admin.dao.AdminDAO;
import com.wt.app.dto.AdminFileDownloadDTO;

public class AdminCareFileDownloadController implements Execute {

	@Override
    public Result execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	 String type = request.getParameter("type");   // "LICENSE" | "ACCOUNT"
    	    String numStr = request.getParameter("fileNumber");
    	    if (type == null || numStr == null) { response.sendError(400); return null; }

    	    int fileNumber = Integer.parseInt(numStr);
    	    AdminDAO dao = new AdminDAO();
    	    AdminFileDownloadDTO dto =
    	        "LICENSE".equalsIgnoreCase(type) ? dao.fileDownloadLicense(fileNumber)
    	      : "ACCOUNT".equalsIgnoreCase(type) ? dao.fileDownloadAccount(fileNumber)
    	      : null;

    	    if (dto == null) { response.sendError(404); return null; }

    	    // 1) 웹경로 만들기 (file_path 가 폴더만 있을 수 있으므로 파일명/확장자 붙여줌)
    	    String basePath = dto.getFilePath();           // 예) "/assets/img/myPageCare/" 또는 "/uploads/care/xxxx.png"
    	    String name     = dto.getFileName();           // 예) "careLicense1" 또는 "xxxx.png"
    	    String ext      = dto.getFileType();           // 예) ".jpg" 또는 "jpg" 또는 null

    	    if (basePath == null || basePath.isEmpty()) { response.sendError(404); return null; }

    	    String webPath = basePath;

    	    // basePath가 폴더처럼 끝나면 파일명+확장자 조립
    	    boolean looksLikeDir = webPath.endsWith("/") || !webPath.contains(".");
    	    if (looksLikeDir) {
    	        if (!webPath.endsWith("/")) webPath += "/";
    	        if (name == null || name.isEmpty()) { response.sendError(404); return null; }

    	        // name에 확장자가 없다면 ext 붙이기
    	        String lowerName = name.toLowerCase();
    	        boolean nameHasExt = lowerName.endsWith(".jpg") || lowerName.endsWith(".jpeg") || lowerName.endsWith(".png");
    	        if (!nameHasExt) {
    	            String cleanExt = ext == null ? "" : ext.trim();
    	            if (!cleanExt.isEmpty() && !cleanExt.startsWith(".")) cleanExt = "." + cleanExt;
    	            // ext가 없으면 기본 jpg로
    	            if (cleanExt.isEmpty()) cleanExt = ".jpg";
    	            name = name + cleanExt;
    	        }
    	        webPath = webPath + name; // 최종 파일 경로
    	    }

    	    // 2) 실경로 변환 (WAR 외 경로면 null일 수 있으니 fallback)
    	    String realPath = request.getServletContext().getRealPath(webPath);
    	    if (realPath == null) realPath = webPath; // 절대경로나 OS 경로면 그대로 사용

    	    java.io.File f = new java.io.File(realPath);
    	    if (!f.exists() || !f.isFile()) { response.sendError(404); return null; }

    	    // 3) Content-Type (jpg/png만 사용)
    	    String downloadName = name != null ? name : f.getName();
    	    String lower = downloadName.toLowerCase();
    	    String contentType = "application/octet-stream";
    	    if (lower.endsWith(".jpg") || lower.endsWith(".jpeg")) contentType = "image/jpeg";
    	    else if (lower.endsWith(".png")) contentType = "image/png";
    	    response.setContentType(contentType);

    	    // 4) 저장창 헤더
    	    String encoded = java.net.URLEncoder.encode(downloadName, "UTF-8").replaceAll("\\+", "%20");
    	    response.setHeader("Content-Disposition",
    	        "attachment; filename=\"" + encoded + "\"; filename*=UTF-8''" + encoded);
    	    response.setContentLengthLong(f.length());

    	    try (java.io.BufferedInputStream in = new java.io.BufferedInputStream(new java.io.FileInputStream(f));
    	         java.io.BufferedOutputStream out = new java.io.BufferedOutputStream(response.getOutputStream())) {
    	        byte[] buf = new byte[8192];
    	        int len;
    	        while ((len = in.read(buf)) != -1) out.write(buf, 0, len);
    	        out.flush();
    	    }
    	    return null; // 직접 응답
    	}
}