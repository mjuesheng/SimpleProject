package com.blog.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.jdbc.messageImpl;
import com.blog.jdbc.operationImp;
@WebServlet("/delectReleaseServlet")
public class delectReleaseServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		
		int id = Integer.parseInt(request.getParameter("id"));
		String msg;
		switch (id) {
		case 0: 
			messageImpl imp = new messageImpl();
			String messageId = request.getParameter("messageId");
			Boolean succ = imp.delectMessage(messageId);    //获取一个值判断是否删除成功
			if(succ){
				msg = "删除成功!";
				
				//保存历史记录
				operationImp operImp = new operationImp();
				String operName = "文本操作";
				String type = "删除文章:"+messageId;
				operImp.saveOperation((String)request.getSession().getAttribute("username"), operName, type);
				
				request.getSession().setAttribute("megMsg", msg);
				response.sendRedirect("msgInfo.jsp");
				
			}else{
				msg = "删除失败!";
				request.setAttribute("msg", msg);
				request.getSession().setAttribute("megMsg", msg);
				response.sendRedirect("msgInfo.jsp");
			}
			break;
		default:
			break;
		}
	}

}
