package com.blog.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.blog.jdbc.messageImpl;
import com.blog.jdbc.operationImp;

/**
 * Servlet implementation class messageUpdateAjax
 */
@WebServlet("/messageUpdateAjax")
public class messageUpdateAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public messageUpdateAjax() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/json; charset=utf-8");

		operationImp operImp = new operationImp();
		
		String id = request.getParameter("id");
		String type= request.getParameter("type");
		messageImpl m = new messageImpl();
		JSONArray json = new JSONArray();
		if(type.equals("release")){
			Map map = m.getReleaseById(id);
			json.put(map);
			//保存历史记录
			String operName = "文本操作";
			String ty = "修改已发布文章："+map.get("title");
			operImp.saveOperation((String)request.getSession().getAttribute("username"), operName, ty);
			
		}else{
			Map map = m.getDraftById(id);
			json.put(map);
			//保存历史记录
			String operName = "文本操作";
			String ty = "修改草稿文章："+map.get("title");
			operImp.saveOperation((String)request.getSession().getAttribute("username"), operName, ty);
			
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
