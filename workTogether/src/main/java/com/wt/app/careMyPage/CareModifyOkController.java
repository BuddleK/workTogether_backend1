package com.wt.app.careMyPage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.careMyPage.dao.CareModifyDAO;
import com.wt.app.dto.CareModifyDTO;

public class CareModifyOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("========CareModify오케이Controller 진입========");
		CareModifyDAO careModifyDAO = new CareModifyDAO();
		CareModifyDTO originalCareModifyDTO = new CareModifyDTO();
		CareModifyDTO updatedCareModifyDTO = new CareModifyDTO();
		Result result = new Result();
		
		//로그인한 사용자 번호 가져오기
		Integer usersNumber = (Integer) request.getSession().getAttribute("usersNumber");
		System.out.println("로그인 한 멤버 번호 : " + usersNumber);
		
		//원래 개인정보 담아오기
		originalCareModifyDTO = careModifyDAO.getInfo(usersNumber);

		String postal = request.getParameter("usersPostsalCode");
		String addr1 = request.getParameter("usersAddressLine1");
		String addr2 = request.getParameter("usersAddressLine2");
		String phone = request.getParameter("usersPhone");
		//String email = request.getParameter("usersEmail");
		String passwd = request.getParameter("password");

		System.out.println("잘 들어왔나 postal : " + postal);
		System.out.println("잘 들어왔나 addr1 : " + addr1);
		System.out.println("잘 들어왔나 addr2 : " + addr2);
		System.out.println("잘 들어왔나 phone : " + phone);
		//System.out.println("잘 들어왔나 email : " + email);
		System.out.println("잘 들어왔나 passwd : " + passwd);
		
		
		updatedCareModifyDTO.setUsersNumber(usersNumber);
		
		// 주소 넣기넣기
		updatedCareModifyDTO.setUsersPostsalCode(postal);
		updatedCareModifyDTO.setUsersAddressLine1(addr1);
		updatedCareModifyDTO.setUsersAddressLine2(addr2);
		
		//전화번호 넣기
		updatedCareModifyDTO.setUsersPhone(phone);
		
		//이메일 넣기 (취소 예정
		//updatedCareModifyDTO.setUsersEmail(email);
		
		//비밀번호 넣기
		updatedCareModifyDTO.setUsersPassword(passwd);
		
		System.out.println("updatedCareModifyDTO 출력 : " + updatedCareModifyDTO);
		
		careModifyDAO.modAddress(updatedCareModifyDTO);
		careModifyDAO.modPhone(updatedCareModifyDTO);
		

		/* 이메일 수정에 필요한 분기(취소 예정)
		 * if(careModifyDAO.checkEmail(email) != 0) { System.out.println(email +
		 * "은 있음!"); }else { System.out.println(email + "없다! 이메일 수정!");
		 * careModifyDAO.modEmail(updatedCareModifyDTO); }
		 */
		
		System.out.println("비밀번호 길이 : " + passwd.length());
		if(passwd.length() != 0) {
			System.out.println("비밀번호 수정 필요");
			careModifyDAO.modPassword(updatedCareModifyDTO);
		}

		result.setPath("/myPageCare/careModify.cp");
		result.setRedirect(true);
		return result;
	}

}
