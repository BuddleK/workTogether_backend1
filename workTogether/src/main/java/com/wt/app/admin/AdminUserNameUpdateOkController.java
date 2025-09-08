package com.wt.app.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.admin.dao.AdminDAO;
import com.wt.app.dto.AdminUserManagerDTO;

public class AdminUserNameUpdateOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
		Result result = new Result();
        AdminDAO adminDAO = new AdminDAO();
		
        int usersNumber = Integer.parseInt(request.getParameter("usersNumber"));
        String usersName = request.getParameter("usersName");
        
        AdminUserManagerDTO adminUserManagerDTO = new AdminUserManagerDTO();
        adminUserManagerDTO.setusersNumber(usersNumber);
        adminUserManagerDTO.setusersName(usersName);
        
        adminDAO.adminUserNameUpdate(adminUserManagerDTO);
        
		result.setPath("/admin/adminUserDetail.ad");
		result.setRedirect(false);
		return result;
	}

}
