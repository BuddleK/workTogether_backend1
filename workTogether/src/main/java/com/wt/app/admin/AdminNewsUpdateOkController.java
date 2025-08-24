package com.wt.app.admin;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.admin.dao.AdminDAO;
import com.wt.app.dto.AdminNewsBoardDTO;
import com.wt.app.dto.FileNoticeDTO;

public class AdminNewsUpdateOkController implements Execute {

	@Override
	public Result Execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("==== AdminNewsUpdateOkController 실행 ====");
		Result result = new Result();

		// 0) 로그인 확인 (선택: 필요 시 강제)
		Integer loginAdminNumber = (Integer) request.getSession().getAttribute("adminNumber");
		if (loginAdminNumber == null) {
			// 데모/개발 편의용
			loginAdminNumber = 1;
			request.getSession().setAttribute("adminNumber", loginAdminNumber);
		}

		// 1) 업로드 설정
		final String UPLOAD_DIR = "upload";
		final String ROOT_PATH = request.getServletContext().getRealPath("/");
		final String UPLOAD_PATH = ROOT_PATH + UPLOAD_DIR + File.separator;
		final int FILE_SIZE = 1024 * 1024 * 5; // 5MB

		File dir = new File(UPLOAD_PATH);
		if (!dir.exists()) {
			boolean made = dir.mkdirs();
			System.out.println("업로드 경로 생성: " + made + " / " + UPLOAD_PATH);
		}

		// 2) multipart 파싱
		MultipartRequest mr = new MultipartRequest(request, UPLOAD_PATH, FILE_SIZE, "utf-8",
				new DefaultFileRenamePolicy());

		// 3) 파라미터 추출
		String newsNumberStr = mr.getParameter("newsNumber");
		if (newsNumberStr == null || newsNumberStr.trim().isEmpty()) {
			System.out.println("수정 실패: newsNumber 없음");
			result.setPath(request.getContextPath() + "/admin/news/newsListOk.ad");
			result.setRedirect(true);
			return result;
		}

		int newsNumber;
		try {
			newsNumber = Integer.parseInt(newsNumberStr);
		} catch (NumberFormatException e) {
			System.out.println("수정 실패: newsNumber 파싱 오류 -> " + newsNumberStr);
			result.setPath(request.getContextPath() + "/admin/news/newsListOk.ad");
			result.setRedirect(true);
			return result;
		}

		String title = mr.getParameter("title");
		String content = mr.getParameter("content");
		String link = mr.getParameter("link");
		String deleteFileFlag = mr.getParameter("deleteFile"); // 체크박스(on/true 등)

		AdminDAO dao = new AdminDAO();

		// 4) 기존 뉴스/파일 조회
		AdminNewsBoardDTO origin = dao.newsSelectOne(newsNumber);
		if (origin == null) {
			System.out.println("수정 실패: 존재하지 않는 뉴스. newsNumber=" + newsNumber);
			result.setPath(request.getContextPath() + "/admin/news/newsListOk.ad");
			result.setRedirect(true);
			return result;
		}

		// (선택) 작성자 본인 확인
		if (!Objects.equals(loginAdminNumber, origin.getAdminNumber())) {
			System.out.println("수정 실패: 작성자 불일치. login=" + loginAdminNumber + ", owner=" + origin.getAdminNumber());
			result.setPath(request.getContextPath() + "/admin/news/newsListOk.ad");
			result.setRedirect(true);
			return result;
		}

		FileNoticeDTO oldFile = dao.selectNoticeFileByNews(newsNumber); // 없을 수 있음
		Integer filesNumber = origin.getFilesNumber(); // 기본은 기존 값 유지

		// 5) 파일 업로드 검사 (첫 번째 파일만 처리)
		boolean hasNewFile = false;
		String uploadedSystemName = null;
		String uploadedOriginalName = null;
		String uploadedContentType = null;
		long uploadedSize = 0L;

		Enumeration<?> fns = mr.getFileNames();
		if (fns != null && fns.hasMoreElements()) {
			String inputName = (String) fns.nextElement();
			String sysName = mr.getFilesystemName(inputName); // 서버 저장 파일명
			if (sysName != null) {
				hasNewFile = true;
				uploadedSystemName = sysName;
				uploadedOriginalName = mr.getOriginalFileName(inputName);
				uploadedContentType = mr.getContentType(inputName);
				File saved = new File(UPLOAD_PATH, sysName);
				uploadedSize = saved.exists() ? saved.length() : 0L;
			}
		}

		// 6) 파일 처리 분기: 신규 업로드 / 삭제 / 유지
		if (hasNewFile) {
			// 6-1) 신규 파일 INSERT (tbl_files_notice)
			FileNoticeDTO newFile = new FileNoticeDTO();
			newFile.setNoticeFilesType(uploadedContentType);
			newFile.setNoticeFilesName(uploadedOriginalName);
			newFile.setNoticeFilesPath(UPLOAD_DIR + "/" + uploadedSystemName); // 웹 경로 저장
			newFile.setNoticeFilesSizeBytes(uploadedSize);

			int newFilesNumber = dao.insertNoticeFile(newFile);
			filesNumber = newFilesNumber;

			// 6-2) 기존 파일 삭제(DB + 물리)
			if (oldFile != null && oldFile.getNoticeFilesPath() != null) {
				// DB 삭제
				dao.deleteNoticeFileByNews(newsNumber);
				// 물리 파일 삭제
				File disk = new File(ROOT_PATH, oldFile.getNoticeFilesPath());
				if (disk.exists()) {
					boolean del = disk.delete();
					System.out.println("기존 물리 파일 삭제 " + (del ? "성공" : "실패") + " : " + disk.getAbsolutePath());
				}
			}
		} else if (deleteFileFlag != null && !deleteFileFlag.isEmpty()) {
			// 6-3) '첨부 삭제' 체크된 경우
			if (oldFile != null) {
				dao.deleteNoticeFileByNews(newsNumber); // DB 삭제
				File disk = new File(ROOT_PATH, oldFile.getNoticeFilesPath());
				if (disk.exists()) {
					boolean del = disk.delete();
					System.out.println("첨부 삭제(체크) 물리 파일 삭제 " + (del ? "성공" : "실패") + " : " + disk.getAbsolutePath());
				}
				filesNumber = null; // 뉴스 파일 참조 제거
			}
		} else {
			// 6-4) 유지: filesNumber는 기존 값 그대로
		}

		// 7) 뉴스 UPDATE
		AdminNewsBoardDTO upd = new AdminNewsBoardDTO();
		upd.setNewsNumber(newsNumber);
		upd.setAdminNumber(loginAdminNumber); // 매퍼 where절에 admin_number 포함 시 필요
		upd.setNewsTitle(title);
		upd.setNewsContent(content);
		upd.setNewsLinkUrl(link);
		upd.setFilesNumber(filesNumber); // 신규/삭제/유지 결과 반영

		int updated = dao.newsUpdate(upd);
		System.out.println("뉴스 수정 결과 rows=" + updated + ", newsNumber=" + newsNumber + ", filesNumber=" + filesNumber);

		// 8) 상세보기로 이동
		String to = request.getContextPath() + "/admin/news/newsReadOk.ad?newsNumber=" + newsNumber;
		result.setPath(to);
		result.setRedirect(true);
		return result;
	}
}