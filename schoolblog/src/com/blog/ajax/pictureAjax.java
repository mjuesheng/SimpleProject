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
import org.json.JSONObject;

import com.blog.javabean.imgUrlBean;
import com.blog.javabean.megSubBean;
import com.blog.jdbc.imgUrlImp;

/**
 * Servlet implementation class pictureAjax
 */
@WebServlet("/pictureAjax")
public class pictureAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pictureAjax() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("static-access")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/json; charset=utf-8");

		PrintWriter out = response.getWriter();
		String username = (String) request.getSession().getAttribute("username");
		String text = null;  
		imgUrlBean imgurlbean;
		imgUrlImp imgurlimp = new imgUrlImp();
		List list = imgurlimp.getPictureUrl(username);

		JSONArray JsonArray = new JSONArray(); 
		for (int i = 0; i < list.size(); i++) {
			Map map = new HashMap();
			imgurlbean =  (imgUrlBean) list.get(i);
			map.put("imgId",imgurlbean.getId());
			map.put("url", imgurlbean.getUrl());
			map.put("size", list.size());
			JsonArray.put(map);
		}
		System.out.println("ajax.pictureAjax:"+JsonArray.toString());
		out.println(JsonArray.toString());
		out.flush();
		out.close();
	}

}
