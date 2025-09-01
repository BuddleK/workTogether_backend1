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
		
		//careUser가 빈 문자열이거나 null인경우 => db에 존재하지 않는 경우
		//null 값을 대비해 String 변수로 저장
				String careUsersNumberstr = request.getParameter("usersNumber");
				if(careUsersNumberstr == null || careUsersNumberstr.trim().isEmpty()){
					System.out.println("usersNumber 값이 없습니다");
					result.setPath("/app/careMember/careMember.jsp"); //게시글 목록 페이지로 리다이렉트
					result.setRedirect(true);
					return result;
				}
				
				// userNumber의 값을 int userNumber로 저장
				int usersNumber = Integer.parseInt(careUsersNumberstr);
				CareListDAO careListDAO = new CareListDAO();
				CareListCommentsDAO careListCommentsDAO = new CareListCommentsDAO();
				//DB에서 게시글 가져오기
				//-> 가져온 데이터 careListDTO 선언 후 저장
				CareListDTO careListDTO = careListDAO.selectDetail(usersNumber);
				//게시글이 존재하지 않을 경우 처리
				//ex) 리스트에 존재해서 유저가 접속하려고 클릭 했는데 그 순간에 회원이 삭제되어 리스트가 존재하지 않는 경우
				if(careListDTO == null) {
					System.out.println("존재하지 않는 돌봄입니다. " + usersNumber);
					result.setPath("/app/careMember/careMember.jsp");
					//리스트 페이지로 다시 복귀
					result.setRedirect(true);
					return result;
				}
				
				//불러온 정보 console로 확인
				System.out.println(careListDTO);
				
				//setAttribute를 이용하여 jsp 파일에서 jstl로 정보 불러오기 위해 사용
				request.setAttribute("care", careListDTO);
		
				//result에 경로 저장 및 리다이렉트 상태 저장
		result.setPath("/app/careMember/careMemberDetail.jsp");
		result.setRedirect(false);
		
		return result;
	}

	
}
