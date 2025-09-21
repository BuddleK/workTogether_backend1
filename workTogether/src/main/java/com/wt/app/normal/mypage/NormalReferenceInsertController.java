package com.wt.app.normal.mypage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.dto.NormalModifyDTO;
import com.wt.app.dto.NormalReferenceListDTO;
import com.wt.app.normal.mypage.dao.MyPageNormalDAO;

public class NormalReferenceInsertController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Result result = new Result();
		
		MyPageNormalDAO dao = new MyPageNormalDAO();
		NormalReferenceListDTO dto = new NormalReferenceListDTO();

		HttpSession session = request.getSession();
		String usersNumberStr = session.getAttribute("usersNumber") + "";
		int usersNumber = Integer.parseInt(usersNumberStr);
		
		List<NormalModifyDTO> list = dao.normalSearch(usersNumberStr);
		
		
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < list.size(); i++) {
		    sb.append(list.get(i).getUsersName());
		    if (i < list.size() - 1) {
		        sb.append(", ");  // 이름 사이 쉼표 추가
		    }
		}

		String userName = sb.toString();
		System.out.println("이름 " + userName);
		LocalDate today = LocalDate.now();
		request.setAttribute("userName", userName);
		request.setAttribute("today", today);
		

		result.setPath("/app/myPageNormal/normalReferenceUp.jsp");
        result.setRedirect(false);
        return result;
	}

}
