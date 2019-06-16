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

import com.blog.javabean.megSubBean;
import com.blog.jdbc.messageImpl;
@WebServlet("/releaseAjax")
public class releaseAjax extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/json; charset=utf-8");
		
		String username = (String) request.getSession().getAttribute("username");
		String t =request.getParameter("t");
		messageImpl m = new messageImpl();
		List list = m.SelectMessage(t,username,null);
		megSubBean mb;
		JSONArray json = new JSONArray();
		for (int i = 0; i < list.size(); i++) {
			mb =  (megSubBean) list.get(i);
			Map map = new HashMap();
			map.put("releaseId", mb.getMessageId());
			map.put("username", mb.getUsername());
			map.put("title", mb.getTitle());
			map.put("discuss", mb.getDiscuss());
			map.put("date", mb.getDate());
			map.put("size", list.size());
			json.put(map);
		}
		PrintWriter out = response.getWriter();
		out.print(json.toString());
		out.flush();
		out.close();
	}
}
