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
		AdminDAO adminDAO = new AdminDAO(); 
		AdminNewsBoardDTO newsDTO = new AdminNewsBoardDTO();
		Result result = new Result();
		FileNoticeDTO fileDTO = new FileNoticeDTO();

		// 로그인한 관리자 정보 가져오기
		Integer adminNumber = (Integer) request.getSession().getAttribute("adminNumber");

		// 로그인 안 되어 있으면 로그인 페이지로 돌리기
		if (adminNumber == null) {
			System.out.println("오류 : 로그인된 관리자가 없습니다");
			response.sendRedirect("login.jsp"); 
			return null; 
		}

		// 파일 업로드 환경 설정
		final String UPLOAD_PATH = request.getSession().getServletContext().getRealPath("/") + "upload"
				+ File.separator;
		final int FILE_SIZE = 1024 * 1024 * 5; // 5MB 고정
		System.out.println("파일 업로드 경로 : " + UPLOAD_PATH);

		// MultipartRequest를 이용한 데이터 파싱 (파일 자동 저장 및 폼 파라미터 추출)
		MultipartRequest multipartRequest = new MultipartRequest(request, UPLOAD_PATH, FILE_SIZE, "utf-8",
				new DefaultFileRenamePolicy());

		// 게시글 정보 설정
		newsDTO.setNewsTitle(multipartRequest.getParameter("newsTitle"));
		newsDTO.setNewsContent(multipartRequest.getParameter("newsContent"));
		newsDTO.setNewsLinkUrl(multipartRequest.getParameter("newsLinkUrl")); 
		newsDTO.setAdminNumber(adminNumber);
		System.out.println("뉴스 게시글 추가 - AdminNewsBoardDTO : " + newsDTO);

		// 게시글 추가 (newsNumber를 받음)
		int newsNumber = adminDAO.insertNews(newsDTO); /
		System.out.println("생성된 뉴스 게시글 번호 : " + newsNumber);

		// 파일 업로드 처리 (파일이 있다면 DB에 정보 저장 및 PK 연결)
		// <input type="file"> 필드들의 name 속성을 가져옴
		Enumeration<String> fileNames = multipartRequest.getFileNames();
		while (fileNames.hasMoreElements()) { // 다음 파일 필드가 있다면
			String name = fileNames.nextElement(); // 파일 필드의 name을 가져옴
			String fileSystemName = multipartRequest.getFilesystemName(name); // 서버에 저장된 파일명
			String fileOriginalName = multipartRequest.getOriginalFileName(name); // 원본 파일명
			String contentType = multipartRequest.getContentType(name); // 파일 종류 (MIME 타입)

			if (fileSystemName == null) { // 사용자가 파일을 선택하지 않았다면 건너뜀
				continue;
			}

			// 파일 정보 DTO 채움 (FileNoticeDTO)
			fileDTO.setNoticeFilesName(fileOriginalName);
			fileDTO.setNoticeFilesType(contentType); 
			fileDTO.setNoticeFilesPath("upload" + File.separator + fileSystemName); // 예: "upload/abc.jpg"

			System.out.println("업로드 된 파일 정보 : " + fileDTO);
			adminDAO.insertFileNotice(fileDTO);
		}

		newsDTO.setFilesNumber(fileDTO.getNoticeFilesNumber()); 
		result.setPath(request.getContextPath() + "/admin/news/newsListOk.ad"); 
		result.setRedirect(false);

		return result;
	}
}