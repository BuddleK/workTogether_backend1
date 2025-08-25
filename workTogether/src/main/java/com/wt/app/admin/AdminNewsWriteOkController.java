package com.wt.app.admin;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.FileNotice.dao.FileNoticeDAO;
import com.wt.app.admin.dao.AdminDAO;
import com.wt.app.dto.AdminNewsBoardDTO;
import com.wt.app.dto.FileNoticeDTO;
import com.wt.app.dto.FilesLicenseDTO;

public class AdminNewsWriteOkController implements Execute {

	@Override
	public Result Execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("==== AdminNewsWriteOkController 실행 ====");
		Result result = new Result();

		// 1) 로그인 관리자 확인
		/*
		 * Integer adminNumber = (Integer)
		 * request.getSession().getAttribute("adminNumber"); if (adminNumber == null) {
		 * System.out.println("오류: 로그인된 관리자가 없습니다");
		 * result.setPath("/app/admin/login.jsp"); result.setRedirect(false); return
		 * result; }
		 */

		Integer adminNumber = (Integer) request.getSession().getAttribute("adminNumber");
		if (adminNumber == null) {
			adminNumber = 1;
			request.getSession().setAttribute("adminNumber", adminNumber);
			System.out.println("adminNumber=" + adminNumber);
		}
		// 2) 업로드 경로/설정
		final String UPLOAD_DIR = "upload";
		final String UPLOAD_PATH = request.getServletContext().getRealPath("/") + UPLOAD_DIR + File.separator;
		final int FILE_SIZE = 1024 * 1024 * 5; // 5MB

		File dir = new File(UPLOAD_PATH);
		if (!dir.exists()) {
			boolean made = dir.mkdirs();
			System.out.println("업로드 경로 생성: " + made + " / " + UPLOAD_PATH);
		}

		// 3) multipart 파싱 (파일 저장 + 파라미터 추출)
		MultipartRequest mr = new MultipartRequest(request, UPLOAD_PATH, FILE_SIZE, "utf-8",
				new DefaultFileRenamePolicy());

		// 4) 뉴스 DTO 채움
		AdminNewsBoardDTO newsDTO = new AdminNewsBoardDTO();
		newsDTO.setAdminNumber(adminNumber);
		newsDTO.setNewsTitle(mr.getParameter("title"));
		newsDTO.setNewsContent(mr.getParameter("content"));
		newsDTO.setNewsLinkUrl(mr.getParameter("link"));

		// 5) 파일 1개만 처리해서 tbl_files_notice 저장 → PK 받아서 newsDTO에 연결
		Integer filesNumber = null;

		Enumeration<?> fileNames = mr.getFileNames();
		if (fileNames.hasMoreElements()) {
			String inputName = (String) fileNames.nextElement();
			String fileSystemName = mr.getFilesystemName(inputName); // 서버 저장 파일명
			String fileOriginalName = mr.getOriginalFileName(inputName); // 원본 파일명
			String contentType = mr.getContentType(inputName); // MIME 타입

			if (fileSystemName != null) {
				File saved = new File(UPLOAD_PATH, fileSystemName);
				long sizeBytes = saved.exists() ? saved.length() : 0L;
				String webPath = UPLOAD_DIR + "/" + fileSystemName; // DB에는 웹 경로 저장

				// 파일 DTO 채워서 INSERT
				FileNoticeDTO fileDTO = new FileNoticeDTO();
				fileDTO.setNoticeFilesType(contentType);
				fileDTO.setNoticeFilesName(fileOriginalName);
				fileDTO.setNoticeFilesPath(webPath);
				fileDTO.setNoticeFilesSizeBytes(sizeBytes);

				AdminDAO adminDAO = new AdminDAO();
				adminDAO.insertNoticeFile(fileDTO);

				filesNumber = fileDTO.getNoticeFilesNumber();
				System.out.println("업로드 된 파일 정보 : " + fileDTO);
			}
		}

		newsDTO.setFilesNumber(filesNumber);

		// 6) 뉴스 INSERT
		AdminDAO newsDAO = new AdminDAO();
		int newsNumber = newsDAO.insertNews(newsDTO);
		System.out.println("뉴스 등록 완료, newsNumber=" + newsNumber + ", filesNumber=" + filesNumber);

		// 7) 목록으로 이동
		result.setPath(request.getContextPath() + "/admin/news/newsListOk.ad");
		result.setRedirect(true);
		return result;
	}
}