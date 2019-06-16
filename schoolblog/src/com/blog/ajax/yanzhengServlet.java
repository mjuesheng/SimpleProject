package com.blog.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.yanzhengma.IdentityUtil;
@WebServlet("/yanzheng.html")
public class yanzhengServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		String code = request.getParameter("code");
		
		if(code.equals(request.getSession().getAttribute("code"))){
			out.print("{\"flag\": true,\"msg\":\"验证通过!\"}");
			request.getSession().setAttribute("flag", "1");
		}else{
			out.print("{\"flag\": false,\"msg\":\"验证码错误!\"}");
			request.getSession().setAttribute("flag", "0");
		}
		out.flush();
		out.close();
	}
}
