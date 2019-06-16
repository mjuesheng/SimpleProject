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

/**
 * Servlet implementation class indexAjax
 */
@WebServlet("/indexAjax")
public class indexAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public indexAjax() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		/response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		
		JSONArray JsonArray = new JSONArray(); 
		megSubBean meg;
		String t = request.getParameter("t");
		System.out.println("Servlet.indexServlet:t="+t);
		if(t!=null){
			messageImpl imp = new messageImpl();
			List list = imp.SelectMessage(t,null,null);
			Map map = new HashMap();
			for(int i=0;i<list.size();i++){
				meg =  (megSubBean) list.get(i);
				map.put("messageId", meg.getMessageId());
				map.put("author", meg.getUsername());
				map.put("date", meg.getDate());
				map.put("textType", meg.getTextType());
				map.put("title", meg.getTitle());
				map.put("size", list.size());
				map.put("readNum", meg.getReadNum());
				JsonArray.put(map);
			}
			PrintWriter out = response.getWriter();
			out.println(JsonArray.toString());
			out.flush();
			out.close();
		}else{
			System.out.println("Servlet.indexServlet:tÎª¿ÕÖµ£¡");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
