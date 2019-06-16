package com.blog.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.jdbc.loginImpl;
import com.blog.jdbc.messageImpl;

@WebServlet("/login.html")
public class loginServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		String user = request.getParameter("userName");
		String psd = request.getParameter("password");
		String flag = (String) request.getSession().getAttribute("flag");
		loginImpl imp = new loginImpl();
		messageImpl megIm = new messageImpl();
		int releaseNum = megIm.releaseNum(user);
		int draftNum = megIm.DraftNum(user);
		Boolean is = imp.imp(user, psd,flag);
		if(is){
			request.getSession().setAttribute("username",user );
			request.getSession().setAttribute("password", psd);
			request.getSession().setAttribute("releaseNum", releaseNum);
			request.getSession().setAttribute("draftNum", draftNum);
			response.sendRedirect("index.jsp");
		}else{
			request.getSession().setAttribute("msg", "用户名或密码错误!");
			request.getRequestDispatcher("/login.jsp").forward(request,response);
		}
	}	
}
