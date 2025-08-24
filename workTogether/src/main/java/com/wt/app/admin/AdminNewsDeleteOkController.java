package com.wt.app.admin;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.admin.dao.AdminDAO;
import com.wt.app.dto.FileNoticeDTO;

public class AdminNewsDeleteOkController implements Execute{

		@Override
	    public Result Execute(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        System.out.println("==== AdminNewsDeleteOkController 실행 ====");

	        Result result = new Result();

	        // 1) 파라미터 검증
	        String newsNumberStr = request.getParameter("newsNumber");
	        if (newsNumberStr == null || newsNumberStr.trim().isEmpty()) {
	            System.out.println("삭제 실패: newsNumber 파라미터 없음");
	            result.setPath(request.getContextPath() + "/admin/news/newsListOk.ad");
	            result.setRedirect(true);
	            return result;
	        }

	        int newsNumber;
	        try {
	            newsNumber = Integer.parseInt(newsNumberStr);
	        } catch (NumberFormatException e) {
	            System.out.println("삭제 실패: newsNumber 파싱 오류 -> " + newsNumberStr);
	            result.setPath(request.getContextPath() + "/admin/news/newsListOk.ad");
	            result.setRedirect(true);
	            return result;
	        }

	        AdminDAO dao = new AdminDAO();

	        // 2) 첨부파일(공지 파일) 조회 → 물리 파일/DB 레코드 삭제
	        try {
	            FileNoticeDTO file = dao.selectNoticeFileByNews(newsNumber); // admin.fileNoticeSelect
	            if (file != null && file.getNoticeFilesPath() != null) {
	                // 물리 파일 삭제
	                String root = request.getServletContext().getRealPath("/");
	                File diskFile = new File(root, file.getNoticeFilesPath()); // 예: upload/abc.png
	                if (diskFile.exists()) {
	                    boolean deleted = diskFile.delete();
	                    System.out.println("물리 파일 삭제 " + (deleted ? "성공" : "실패") + " : " + diskFile.getAbsolutePath());
	                }
	                // 파일 메타 삭제
	                dao.deleteNoticeFileByNews(newsNumber); // admin.fileNoticeDelete
	            }

	            // 3) 뉴스 삭제
	            int deletedRows = dao.newsDelete(newsNumber); // admin.newsDelete
	            System.out.println("뉴스 삭제 결과 rows=" + deletedRows + ", newsNumber=" + newsNumber);

	        } catch (Exception e) {
	            // 운영 로그에 남기기
	            e.printStackTrace();
	            // 실패 시에도 목록으로 리다이렉트 (사용자 경험)
	        }

	        // 4) 목록으로 이동 (필요 시 page 유지)
	        String page = request.getParameter("page");
	        String to = request.getContextPath() + "/admin/news/newsListOk.ad";
	        if (page != null && !page.isEmpty()) {
	            to += "?page=" + page;
	        }
	        result.setPath(to);
	        result.setRedirect(true);
	        return result;
	    }
	}
