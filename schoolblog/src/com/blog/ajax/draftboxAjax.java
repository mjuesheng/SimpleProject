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
import com.blog.jdbc.draftboxImp;
import com.blog.jdbc.messageImpl;

/**
 * Servlet implementation class drafboxAjax
 */
@WebServlet("/draftboxAjax")
public class draftboxAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public draftboxAjax() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/json; charset=utf-8");
	
		String t =request.getParameter("t");
		String username = (String) request.getSession().getAttribute("username");
		System.out.println("ajax.draftboxajax--t值:"+t);          //查看获取的id值       
		draftboxImp m = new draftboxImp();
		List list = m.SelectMessage(t,username);
				
		JSONArray json = new JSONArray();
		megSubBean mb;
		for (int i = 0; i < list.size(); i++) {
			mb =  (megSubBean) list.get(i);
			Map map = new HashMap();
			map.put("draftId", mb.getMessageId());
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
