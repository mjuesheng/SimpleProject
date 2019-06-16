package com.blog.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.javabean.imgUrlBean;
import com.blog.javabean.megSubBean;
import com.blog.jdbc.imgUrlImp;
import com.blog.jdbc.messageImpl;

@WebServlet("/imgAjax")
public class imgAjax extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		String username = (String) request.getSession().getAttribute("username");
		String text = null;  
		imgUrlBean imgurlbean;
		imgUrlImp imgurlimp = new imgUrlImp();
		List list = imgurlimp.getImgUrl(username);
		System.out.println("ajax.imgAjax : list.size-"+list.size());
		//往前台传一个字符串 
		for (int i = 0; i < list.size(); i++) {
			imgurlbean =  (imgUrlBean) list.get(i);
			System.out.println("ajax.imgAjax : 图片地址-"+imgurlbean.getUrl());
			text = imgurlbean.getUrl();
		}
		out.println(text);
		out.flush();
		out.close();
	}
}
