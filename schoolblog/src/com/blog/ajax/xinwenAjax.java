package com.blog.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.common.until.newsGet;

/**
 * Servlet implementation class xinwenAjax
 */
@WebServlet("/xinwenAjax")
public class xinwenAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public xinwenAjax() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/json");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		List list  = new ArrayList();
		newsGet n = new newsGet();
		list = n.readFile();
		JSONArray json = new JSONArray();
		int i =0;
		while(i<list.size()){
			Map map = new HashMap(); 
			try{
				map.put("title", list.get(i));
				i++;
				map.put("imgUrl", list.get(i));
				i++;
				map.put("newsUrl", list.get(i));
				i++;
			}catch(Exception e){
				System.out.println(e);
			}
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
