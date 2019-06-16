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
import com.blog.jdbc.NavigationBarImp;
import com.blog.jdbc.messageImpl;

/**
 * Servlet implementation class NavigationBarAjax
 */
@WebServlet("/NavigationBarAjax")
public class NavigationBarAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NavigationBarAjax() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		NavigationBarImp imp = new NavigationBarImp();
		List list = imp.getInfo();
		String name;
		JSONArray json = new JSONArray();
		for (int i = 0; i < list.size(); i++) {
			name =  (String) list.get(i);
			Map map = new HashMap();
			map.put("name", name);
			map.put("size", list.size());
			json.put(map);
		}
		PrintWriter out = response.getWriter();
		out.print(json.toString());
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
