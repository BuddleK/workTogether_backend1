package com.wt.app.normal.mypage;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.dto.NormalModifyDTO;
import com.wt.app.normal.mypage.dao.MyPageNormalDAO;

public class NormalModifyOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("유저 정보 변경");
		Result result = new Result();
		MyPageNormalDAO dao = new MyPageNormalDAO();
		NormalModifyDTO dto = new NormalModifyDTO();
		HttpSession session = request.getSession();
		String usersNumber = session.getAttribute("usersNumber") + "";
		
		String usersPostsalCode=request.getParameter("usersPostsalCode");
		String usersAddressLine1=request.getParameter("usersAddressLine1");
		String usersAddressLine2=request.getParameter("usersAddressLine2");
		String usersEmail = request.getParameter("usersEmail");
		String usersPhone=request.getParameter("usersPhone");
		String usersPassword=request.getParameter("usersPassword");
		
		dto.setUsersPostsalCode(usersPostsalCode);
		dto.setUsersAddressLine1(usersAddressLine1);
		dto.setUsersAddressLine2(usersAddressLine2);
		dto.setUsersPhone(usersPhone);
		dto.setUsersPassword(usersPassword);
		dto.setUsersEmail(usersEmail);
		dto.setUsersNumber(Integer.parseInt(usersNumber));
		
		System.out.println(dto);
		System.out.println("이메일" + usersEmail);
		
		System.out.println("유저 정보 변경 완료");
		
		try {
			dao.normalModify(dto);
			request.setAttribute("normal", dto);
			result.setPath("/myPageNormal/normalModify.mn");
			request.setAttribute("success", "success");
			result.setRedirect(false);
		}catch(SQLException e) {
			if("email_dup".equals(e.getMessage())) {
				request.setAttribute("err", "email_dup");
			}
			 request.setAttribute("normal", dto);
	            result.setPath("/myPageNormal/normalModify.mn");
	            result.setRedirect(false);
		}

		
		return result;
	}

}
