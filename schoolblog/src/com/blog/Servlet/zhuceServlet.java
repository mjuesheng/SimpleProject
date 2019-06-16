package com.blog.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.javabean.PersonBean;
import com.blog.jdbc.zhuceImp;
@WebServlet("/zhuceServlet")
public class zhuceServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		
		//获取表单内容
		String  email = request.getParameter("eml");
		String telphone = request.getParameter("phone");
		String username = request.getParameter("username");
		String name = request.getParameter("name");
		String psd = request.getParameter("psd");
		
		if(zhuceImp.checkUsername(username)){
			PersonBean person = new PersonBean();
			person.setEmail(email);
			person.setPhone(telphone);
			person.setUsername(username);
			person.setName(name);
			person.setPassword(psd);
			if(zhuceImp.SaveUserInformation(person)){
				request.setAttribute("msg", "注册成功");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		}else{
			request.setAttribute("msg", "用户名已存在");
			request.getRequestDispatcher("/zhuce.jsp").forward(request, response);
		}
	}

}
