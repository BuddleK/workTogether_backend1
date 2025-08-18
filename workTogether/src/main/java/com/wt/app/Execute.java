package com.wt.app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Execute {
	public Result Execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
