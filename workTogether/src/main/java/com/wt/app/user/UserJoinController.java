package com.wt.app.user;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.user.dao.UserDAO;

public class UserJoinController implements Execute {
	@Override
	public Result Execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

        request.setCharacterEncoding("UTF-8");

        UserDAO dao = new UserDAO();
        com.wt.app.dto.UserDTO dto = new com.wt.app.dto.UserDTO();
        Result result = new Result();

        String userType = request.getParameter("userType");
        String userId = request.getParameter("userId");
        String userPassword = request.getParameter("userPassword");
        String userName = request.getParameter("userName");
        String userEmail = request.getParameter("userEmail");
        String userPhone = request.getParameter("userPhone");
        String userPostalCode = request.getParameter("userPostalCode");
        String userAddressLine1 = request.getParameter("userAddressLine1");
        String userAddressLine2 = request.getParameter("userAddressLine2");

        
        
        
        
        
        if (isBlank(userType) || isBlank(userId) || isBlank(userPassword) || isBlank(userName)
                || isBlank(userEmail) || isBlank(userPhone)
                || isBlank(userPostalCode) || isBlank(userAddressLine1) || isBlank(userAddressLine2)) {
            request.setAttribute("error", "필수 항목을 모두 입력해 주세요.");
            result.setPath("/app/login/login.jsp");
            result.setRedirect(false);
            return result;
        }
       
        
        
        if (!("N".equals(userType) || "C".equals(userType))) {
            request.setAttribute("error", "회원 유형이 올바르지 않습니다.");
            result.setPath("/app/login/login.jsp");
            result.setRedirect(false);
            return result;
        }

        

        
        if (dao.countByUserId(userId) > 0) {
            request.setAttribute("error", "이미 사용 중인 아이디입니다.");
            result.setPath("/app/login/login.jsp");
            result.setRedirect(false);
            return result;
        }
  
        
        
        
        
        
        if (dao.countByEmail(userEmail) > 0) {
            request.setAttribute("error", "이미 사용 중인 이메일입니다.");
            result.setPath("/app/login/login.jsp");
            result.setRedirect(false);
            return result;
        }

        dto.setUserType(userType);
        dto.setUserId(userId);
        dto.setUserPassword(userPassword);
        dto.setUserName(userName);
        dto.setUserEmail(userEmail);
        dto.setUserPhone(userPhone);
        dto.setUserPostalCode(userPostalCode);
        dto.setUserAddressLine1(userAddressLine1);
        dto.setUserAddressLine2(userAddressLine2);

        int userNo = dao.insertUser(dto);
    
        
        if (userNo <= 0) {
            request.setAttribute("error", "회원가입에 실패했습니다. 다시 시도해 주세요.");
            result.setPath("/app/login/login.jsp");
            result.setRedirect(false);
            return result;
        }

        if ("N".equals(userType)) {
            dao.insertNormal(userNo, "4");
            result.setPath(request.getContextPath() + "/user/login.us");
            result.setRedirect(true);
        } else {
            result.setPath(request.getContextPath() + "/care/prepare.us?userNo=" + userNo);
            result.setRedirect(true);
        }

        return result;
    }

    private boolean isBlank(String s) {
        return s == null || s.trim().isEmpty();
    }

}