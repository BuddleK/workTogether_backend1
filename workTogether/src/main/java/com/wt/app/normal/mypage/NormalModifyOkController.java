package com.wt.app.normal.mypage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wt.app.Execute;
import com.wt.app.Result;
import com.wt.app.dto.NormalModifyDTO;
import com.wt.app.normal.mypage.dao.MyPageNormalDAO;

public class NormalModifyOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MyPageNormalDAO myPageNormalDAO = new MyPageNormalDAO();
		Result result = new Result();
		NormalModifyDTO normalModifyDTO = new NormalModifyDTO();

//		normalModifyDTO = myPageNormalDAO.normalModify(normalModifyDTO);
//		request.setAttribute("ModifyUser", normalModifyDTO);

		result.setPath("/admin/normalModifyOk.mn");
		result.setRedirect(false);
		return result;
	}

}
