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

public class AdminLoginOkController implements Execute {
    @Override
    public Result Execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

		
		AdminLoginDTO adminDTO = new AdminLoginDTO();
		AdminDAO adminDAO = new AdminDAO();
		int adminNumber = 1;
		Result result = new Result();
		String path = null;
		
		String adminId = request.getParameter("adminId"); //아이디 저장 처리할 때 재사용
	    String adminPassword = request.getParameter("adminPassword");
	    String remember = request.getParameter("remember");
	    HttpSession session = request.getSession(); //++++++세션저장
		
		adminDTO.setAdminId(request.getParameter("adminId"));
        adminDTO.setAdminPassword(request.getParameter("adminPassword"));
        
        
        adminNumber = adminDAO.login(adminDTO);
        
        if (adminNumber != -1) {
            // 로그인 성공 → 세션 저장 후 관리자 화면으로
        	path = "/app/admin/userManager.ad";
            session.setAttribute("adminNumber", adminNumber);
            System.out.println("세션값 : " + adminNumber);
            
          
        } else {
        	 path = "/admin/adminlogin.ad";
        	System.out.println(adminNumber);
        }

        // 로그인 성공: 세션 저장
        HttpSession session = request.getSession();
        session.setAttribute("adminNumber", adminNumber);
        String adminName = adminDAO.getAdminName(adminNumber);
        session.setAttribute("adminName", adminName);

        // 이동 (예: 관리자 메인)
        result.setPath(request.getContextPath() + "/admin/main.ad");
        result.setRedirect(true);
        return result;
    }
}
