package com.wt.app.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.admin.dao.AdminDAO;
import com.wt.app.dto.AdminLoginDTO;

public class AdminLoginOkController implements Execute{

	@Override
	public Result Execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				
		AdminDAO adminDAO = new AdminDAO();
		AdminLoginDTO adminDTO = new AdminLoginDTO();
		Result result = new Result();
		
		request.setCharacterEncoding("UTF-8");
		
		adminDTO.setAdminId(request.getParameter("adminId"));
        adminDTO.setAdminPassword(request.getParameter("adminPassword"));
        
        
        int adminNumber = adminDAO.login(adminDTO);
        
        if (adminNumber > 0) {
            // 로그인 성공 → 세션 저장 후 관리자 화면으로
            HttpSession session = request.getSession();
            session.setAttribute("adminNumber", adminNumber);
            session.setAttribute("adminId", adminDTO.getAdminId());

            result.setRedirect(true);
            // 메인 없이 바로 관리자 로그인 후 JSP로 이동
            result.setPath(request.getContextPath() + "/app/admin/userManager.jsp");
        } else {
            // 로그인 실패 → 로그인 페이지로 리다이렉트
            result.setRedirect(true);
            result.setPath(request.getContextPath() + "/admin/login.ad?error=1");
        }

        return result;
	}
	
	 
}
