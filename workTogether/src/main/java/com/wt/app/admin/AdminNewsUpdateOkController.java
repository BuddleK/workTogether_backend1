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
		 request.setCharacterEncoding("UTF-8");
	        Result result = new Result();

	        // 파라미터
	        String numStr     = request.getParameter("newsNumber");
	        String newsTitle  = request.getParameter("newsTitle");
	        String newsLink   = request.getParameter("newsLinkUrl");
	        String page       = request.getParameter("page"); // 목록 복귀시 사용(선택)

	        // 기본 검증
	        if (numStr == null || numStr.isEmpty() || newsTitle == null || newsTitle.trim().isEmpty()) {
	            result.setRedirect(true);
	            result.setPath(request.getContextPath() + "/admin/news/newsListOk.ad");
	            return result;
	        }

	        int newsNumber;
	        try {
	            newsNumber = Integer.parseInt(numStr);
	        } catch (NumberFormatException e) {
	            result.setRedirect(true);
	            result.setPath(request.getContextPath() + "/admin/news/newsListOk.ad");
	            return result;
	        }

	        // DTO 구성 (content, filesNumber 없음!)
	        AdminNewsBoardDTO dto = new AdminNewsBoardDTO();
	        dto.setNewsNumber(newsNumber);
	        dto.setNewsTitle(newsTitle);
	        dto.setNewsLinkUrl(newsLink);

	        // 업데이트
	        new AdminDAO().updateNews(dto);

	        // 수정 후 상세로 이동(또는 목록으로 바꾸고 싶으면 아래 경로 변경)
	        String to = request.getContextPath() + "/admin/news/newsListOk.ad";
	        if (page != null && !page.isEmpty()) {
	            to += "?page=" + page;
	        }
	        result.setRedirect(true);
	        result.setPath(to);
	        return result;
	    }
	}