package com.wt.app.admin;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.admin.dao.AdminDAO;
import com.wt.app.dto.AdminNewsBannerDTO;

public class AdminNewsBannerInsertOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		AdminDAO adminDAO = new AdminDAO();

		String title = nv(request.getParameter("newsTitle"));
		String link = nv(request.getParameter("newsLinkUrl"));
		if (title.isEmpty() || link.isEmpty()) {
			request.setAttribute("error", "제목과 링크는 필수입니다.");
			Result r = new Result();
			r.setRedirect(false);
			r.setPath("/app/admin/bannerUpdate.jsp");
			return r;
		}

		Object adminAttr = request.getSession().getAttribute("adminNumber");
		if (adminAttr == null) {
			Result r = new Result();
			r.setPath(request.getContextPath() + "/admin/login.ad");
			r.setRedirect(true);
			return r;
		}
		int adminNum;
		try {
			adminNum = Integer.parseInt(String.valueOf(adminAttr));
		} catch (NumberFormatException e) {
			Result r = new Result();
			r.setPath(request.getContextPath() + "/admin/login.ad");
			r.setRedirect(true);
			return r;
		}

		// 최대 6개 정책
		int count = adminDAO.adminNewsBannerCountAll();
		int bannerId;
		if (count < 6) {
			AdminNewsBannerDTO dto = new AdminNewsBannerDTO();
			dto.setAdminNumber(adminNum);
			dto.setBannerTitle(title);
			dto.setBannerLinkUrl(link);
			bannerId = adminDAO.adminNewsBannerInsert(dto);
		} else {
			Integer oldestId = adminDAO.adminNewsBannerFindOldestId();
			bannerId = (oldestId != null) ? oldestId : 0;
			AdminNewsBannerDTO dto = new AdminNewsBannerDTO();
			dto.setBannerNewsNumber(bannerId);
			dto.setBannerTitle(title);
			dto.setBannerLinkUrl(link);
			adminDAO.adminNewsBannerReplace(dto);
		}

		// 파일 첨부(있으면만 저장)
		Part filePart = null;
		try {
			filePart = request.getPart("imageFile");
		} catch (Exception ignore) {
		}
		if (filePart != null && filePart.getSize() > 0) {
			String original = safeName(filePart.getSubmittedFileName());
			String ext = getExt(original);
			String uploadRoot = request.getServletContext().getRealPath("/assets/img/main/banner");
			File dir = new File(uploadRoot);
			if (!dir.exists())
				dir.mkdirs();
			String saveName = System.currentTimeMillis() + "_" + original;
			filePart.write(new File(dir, saveName).getAbsolutePath());
			String webPath = "/assets/img/main/banner/" + saveName;

			adminDAO.adminNewsBannerUpsertFile(bannerId, webPath, saveName, ext, filePart.getSize());
		}

		Result r = new Result();
		r.setPath(request.getContextPath() + "/admin/adminNewsBanner.ad");
		r.setRedirect(true);
		return r;
	}

	private String nv(String s) {
		return (s == null) ? "" : s.trim();
	}

	private String safeName(String s) {
		if (s == null)
			return "unnamed";
		int slash = Math.max(s.lastIndexOf('/'), s.lastIndexOf('\\'));
		return (slash >= 0) ? s.substring(slash + 1) : s;
	}

	private String getExt(String s) {
		int d = (s == null) ? -1 : s.lastIndexOf('.');
		return d >= 0 ? s.substring(d + 1) : "";
	}
}