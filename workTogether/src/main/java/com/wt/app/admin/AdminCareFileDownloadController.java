package com.wt.app.admin;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.admin.dao.AdminDAO;
import com.wt.app.dto.AdminCareFileDTO;

public class AdminCareFileDownloadController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        System.out.println("==== AdminCareFileDownloadController 실행 ====");
        
        String type = request.getParameter("type");          // LICENSE | ACCOUNT
        String num  = request.getParameter("fileNumber");    // 파일 PK

        if (type == null || num == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "type 또는 fileNumber 가 없습니다.");
            return null;
        }

        int fileNumber;
        try {
            fileNumber = Integer.parseInt(num);
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "fileNumber 형식 오류");
            return null;
        }

        AdminDAO dao = new AdminDAO();
        AdminCareFileDTO fileInfo = null;

        if ("LICENSE".equalsIgnoreCase(type)) {
            fileInfo = dao.careFileLicense(fileNumber);
        } else if ("ACCOUNT".equalsIgnoreCase(type)) {
            fileInfo = dao.careFileAccount(fileNumber);
        } else {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "허용되지 않는 파일 타입입니다.");
            return null;
        }

        if (fileInfo == null || fileInfo.getFilePath() == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "파일 정보를 찾을 수 없습니다.");
            return null;
        }

        File file = new File(fileInfo.getFilePath());
        if (!file.exists() || !file.isFile()) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "파일이 존재하지 않습니다.");
            return null;
        }

        response.reset();
        String contentType = (fileInfo.getFileType() == null || fileInfo.getFileType().isEmpty())
                ? "application/octet-stream" : fileInfo.getFileType();
        response.setContentType(contentType);
        response.setHeader("Content-Length", String.valueOf(file.length()));

        String downloadName = (fileInfo.getFileName() == null || fileInfo.getFileName().isEmpty())
                ? file.getName() : fileInfo.getFileName();
        String encoded = URLEncoder.encode(downloadName, StandardCharsets.UTF_8.toString()).replace("+", "%20");
        response.setHeader("Content-Disposition",
                "attachment; filename=\"" + encoded + "\"; filename*=UTF-8''" + encoded);

        final int BUFFER_SIZE = 8192;
        try (InputStream in = new FileInputStream(file);
             OutputStream out = response.getOutputStream()) {
            byte[] buffer = new byte[BUFFER_SIZE];
            int len;
            while ((len = in.read(buffer)) != -1) {
                out.write(buffer, 0, len);
            }
            out.flush();
        }

        // 스트림 응답
        return null;
    }
}