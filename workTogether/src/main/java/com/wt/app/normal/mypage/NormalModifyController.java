package com.wt.app.normal.mypage;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.dto.NormalModifyDTO;
import com.wt.app.normal.mypage.dao.MyPageNormalDAO;

public class NormalModifyController implements Execute  {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Result result = new Result();
		
		NormalModifyDTO dto = new NormalModifyDTO();
		MyPageNormalDAO dao = new MyPageNormalDAO();
		
		
		HttpSession session = request.getSession();

		String usersNumber = session.getAttribute("usersNumber") + "";
		
		List<NormalModifyDTO> list = dao.normalSearch(usersNumber);
		
		dto = list.get(0);
		
		System.out.println(dto);
		
		request.setAttribute("normal", dto);
		
		result.setPath("/app/myPageNormal/normalModify.jsp");
		result.setRedirect(false);
		return result;
	}
	
}
