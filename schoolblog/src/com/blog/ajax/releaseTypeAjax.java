package com.blog.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.omg.IOP.Encoding;

import com.blog.javabean.megSubBean;
import com.blog.jdbc.messageImpl;
import com.common.until.Logger;

/**
 * Servlet implementation class releaseTypeAjax
 */
@WebServlet("/releaseTypeAjax")
public class releaseTypeAjax extends HttpServlet {

    public releaseTypeAjax() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		
		
		String t = request.getParameter("t");
		String ty = request.getParameter("type");
		ty =new String(ty.getBytes("ISO-8859-1"),"UTF-8");
		messageImpl m = new messageImpl();
		List list = m.SelectMessage(t,"",ty); 
		
		//日志写入   --记录用户访问类型
		String username = (String) request.getSession().getAttribute("username");
		if(username != null && username.length()!= 0){
			Logger log = new Logger(username);	
			log.log(ty);
		}
				
		request.setAttribute("list", list);
		request.getRequestDispatcher("/typeDoc.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
