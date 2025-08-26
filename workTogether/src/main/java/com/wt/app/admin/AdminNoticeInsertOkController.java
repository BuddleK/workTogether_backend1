package com.wt.app.admin;

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
import com.wt.app.admin.dao.AdminTwoDAO;
import com.wt.app.dto.AdminNoticeListDTO;
import com.wt.app.dto.FileNoticeDTO;

public class AdminNoticeInsertOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		AdminTwoDAO adminTwoDAO = new AdminTwoDAO();
		Result result = new Result();
		
		FileNoticeDTO fileNoticeDTO = new FileNoticeDTO();
		FileNoticeDAO fileNoticeDAO = new FileNoticeDAO();
		
		Integer adminNumber = (Integer)request.getSession().getAttribute("adminNumber");
		
		if(adminNumber == null) {
			System.out.println("로그인된 관리자가 없습니다");
			response.sendRedirect("adminLogin.jsp");
			return null;
		}

		final String UPLOAD_PATH = request.getSession().getServletContext().getRealPath("/") + "upload/";
		final int FILE_SIZE = 1024 * 1024 * 5; //5MB
		MultipartRequest multipartRequest = new MultipartRequest(request, UPLOAD_PATH, FILE_SIZE, "utf-8", new DefaultFileRenamePolicy());
		
		
		AdminNoticeListDTO adminNoticeListDTO = new AdminNoticeListDTO();
		adminNoticeListDTO.setNoticeTitle(multipartRequest.getParameter("noticeTitle"));
		adminNoticeListDTO.setNoticeContent("noticeContent");
		System.out.println("게시글 추가 - adminNoticeListDTO : " + adminNoticeListDTO);
		
		int noticeNumber = adminTwoDAO.adminNoticeListInsert(adminNoticeListDTO);
		System.out.println("생성된 게시글 번호 : " + noticeNumber);
		
		Enumeration<String> fileNames = multipartRequest.getFileNames();
		while(fileNames.hasMoreElements()) {
			String name = fileNames.nextElement();
			String noticeFilesName = multipartRequest.getFilesystemName(name);
			String fileOriginalName = multipartRequest.getOriginalFileName(name);
			
			if(noticeFilesName == null) {
				continue;
			}
			
			fileNoticeDTO.setNoticeFilesName(noticeFilesName);
			fileNoticeDTO.setNoticeNumber(noticeNumber);
			
			System.out.println("업로드 된 파일 정보 : " + fileNoticeDTO);
			fileNoticeDAO.insert(fileNoticeDTO);
		}
		
		result.setPath("/admin/adminNoticeInsertOk.ad");
		result.setRedirect(false);
		
		return result;
	}
	
}
