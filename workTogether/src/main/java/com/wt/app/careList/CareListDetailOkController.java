package com.wt.app.careList;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.careList.dao.CareListCommentsDAO;
import com.wt.app.careList.dao.CareListDAO;
import com.wt.app.dto.CareListDTO;
import com.wt.app.dto.ShopsListDTO;
import com.wt.app.shops.dao.ShopsListDAO;

public class CareListDetailOkController implements Execute  {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("CareListDetailOkController 실행");
		
		
		Result result = new Result();
		
		//shopsNumber가 빈 문자열이거나 null인경우
				String careUsersNumberstr = request.getParameter("usersNumber");
				if(careUsersNumberstr == null || careUsersNumberstr.trim().isEmpty()){
					System.out.println("usersNumber 값이 없습니다");
					result.setPath("/app/careMember/careMember.jsp"); //게시글 목록 페이지로 리다이렉트
					result.setRedirect(true);
					return result;
				}
				
				int usersNumber = Integer.parseInt(careUsersNumberstr);
				
//				FileDAO fileDAO = new FileDAO();
				CareListDAO careListDAO = new CareListDAO();
				CareListCommentsDAO careListCommentsDAO = new CareListCommentsDAO();
				//DB에서 게시글 가져오기
				CareListDTO careListDTO = careListDAO.selectDetail(usersNumber);
				
				//게시글이 존재하지 않을 경우 처리
				if(careListDTO == null) {
					System.out.println("존재하지 않는 돌봄입니다. " + usersNumber);
					result.setPath("/app/careMember/careMember.jsp");
					result.setRedirect(true);
					return result;
				}
				
				System.out.println(careListDTO);
				request.setAttribute("care", careListDTO);
		
				
		result.setPath("/app/careMember/careMemberDetail.jsp");
		result.setRedirect(false);
		
		return result;
	}

	
}
