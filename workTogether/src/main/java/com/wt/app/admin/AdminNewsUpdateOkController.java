package com.wt.app.admin;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FilePart;
import com.oreilly.servlet.multipart.MultipartParser;
import com.oreilly.servlet.multipart.ParamPart;
import com.oreilly.servlet.multipart.Part;
import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.admin.dao.AdminDAO;
import com.wt.app.dto.AdminNewsBoardDTO;
import com.wt.app.dto.FileNoticeDTO;


public class AdminNewsUpdateOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("==== AdminNewsUpdateOkController 실행 ====");
		AdminDAO adminDAO = new AdminDAO(); // AdminDAO 객체 생성 (BoardDAO 대신)
		AdminNewsBoardDTO newsDTO = new AdminNewsBoardDTO(); // 뉴스 DTO (BoardDTO 대신)
		Result result = new Result();

		// 파일 업로드 경로 및 설정
		final String UPLOAD_PATH = request.getSession().getServletContext().getRealPath("/") + "upload"
				+ File.separator;
		final int FILE_SIZE = 1024 * 1024 * 5; // 5MB 고정

		// 업로드 폴더가 없으면 생성
		File dir = new File(UPLOAD_PATH);
		if (!dir.exists()) {
			dir.mkdirs();
		}

		// MultipartParser 실행 (폼 데이터 및 파일 파싱)
		MultipartParser parser = new MultipartParser(request, FILE_SIZE);
		parser.setEncoding("utf-8"); 
		System.out.println("MultipartParser 초기화 완료");

		int newsNumber = 0;
		boolean isFileUpload = false; 

		// 파일 및 텍스트 데이터 처리 (파라미터를 Part 객체로 하나씩 읽음)
		Part part;
		while ((part = parser.readNextPart()) != null) {
			System.out.println("Part 이름: " + part.getName() + ", 타입: " + part.getClass().getSimpleName());

			if (part.isParam()) { // 일반 텍스트 파라미터 처리
				ParamPart paramPart = (ParamPart) part;
				String paramName = paramPart.getName();
				String paramValue = paramPart.getStringValue(); // 값 가져오기

				System.out.println("파라미터: " + paramName + " = " + paramValue);

				// DTO에 값 설정 (HTML 폼의 name 속성과 맞춰주세요)
				if ("newsNumber".equals(paramName)) {
					newsNumber = Integer.parseInt(paramValue);
					newsDTO.setNewsNumber(newsNumber);
				} else if ("newsTitle".equals(paramName)) { 
					newsDTO.setNewsTitle(paramValue);
				} else if ("newsContent".equals(paramName)) {
					newsDTO.setNewsContent(paramValue);
				} else if ("newsLinkUrl".equals(paramName)) { 
					newsDTO.setNewsLinkUrl(paramValue);
				}
			} else if (part.isFile() && !isFileUpload) { 
				FilePart filePart = (FilePart) part;
				filePart.setRenamePolicy(new DefaultFileRenamePolicy()); 
				String fileOriginalName = filePart.getFileName();

				// 기존 파일 삭제 처리 (새 파일이 업로드될 경우)
				if (newsNumber != 0) { // newsNumber가 있을 때만
					List<FileNoticeDTO> existingFiles = (List<FileNoticeDTO>) adminDAO.selectFileNotice(newsNumber);																			// adminDAO.selectFileNotice
					if (existingFiles == null) {
						FileNoticeDTO singleExistingFile = adminDAO.selectFileNotice(newsNumber);
						if (singleExistingFile != null && singleExistingFile.getNoticeFilesPath() != null) {
							existingFiles = List.of(singleExistingFile);
						}
					}

					if (existingFiles != null) {
						for (FileNoticeDTO file : existingFiles) { // 기존 파일들을 순회하며 삭제
							File oldFile = new File(UPLOAD_PATH, file.getNoticeFilesPath());
																						
																				
							if (oldFile.exists()) {
								System.out.println("기존 물리 파일 삭제: " + oldFile.getAbsolutePath());
								oldFile.delete();
							}
						}
					}
					adminDAO.deleteFileNotice(newsNumber); 
				}

				//새로운 파일 업로드 및 DB 저장
				if (fileOriginalName != null) { 
					String newFileName = System.currentTimeMillis() + "_" + fileOriginalName;
					File newPhysicalFile = new File(UPLOAD_PATH, newFileName);
					filePart.writeTo(newPhysicalFile);

					if (newPhysicalFile.exists()) {
						System.out.println("새로운 파일 저장 완료: " + newPhysicalFile.getAbsolutePath());
					} else {
						System.out.println("새로운 파일 저장 실패: " + newPhysicalFile.getAbsolutePath());
					}

					// DB 저장 (FileNoticeDTO로 변경)
					FileNoticeDTO newFileDTO = new FileNoticeDTO();
					newFileDTO.setNoticeFilesName(fileOriginalName); 
					newFileDTO.setNoticeFilesPath("upload" + File.separator + newFileName); 
																							
					newFileDTO.setNoticeFilesSizeBytes(newPhysicalFile.length()); 
					newFileDTO.setNoticeFilesType(filePart.getContentType());

					adminDAO.insertFileNotice(newFileDTO); 
					newsDTO.setFilesNumber(newFileDTO.getNoticeFilesNumber());
					System.out.println("새로운 파일 DB 저장 완료: " + newFileDTO);

					isFileUpload = true;
				} else {
					System.out.println("업로드된 파일이 없습니다 (파일 선택하지 않음)");

				}
			}
		}

		// 게시글 업데이트 실행
		newsDTO.setAdminNumber((Integer) request.getSession().getAttribute("adminNumber"));
		adminDAO.updateNews(newsDTO);
		System.out.println("뉴스 수정 완료");

		// 수정 완료 후 리스트 페이지로 이동
		result.setPath(request.getContextPath() + "/admin/news/newsListOk.ad");
		result.setRedirect(true);

		return result;
	}
}