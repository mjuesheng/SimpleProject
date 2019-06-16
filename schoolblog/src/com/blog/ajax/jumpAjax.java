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

import com.blog.javabean.historyBean;
import com.blog.javabean.megSubBean;
import com.blog.jdbc.SelectID;
import com.blog.jdbc.jumpImp;

/**
 * Servlet implementation class jumpAjax
 */
@WebServlet("/jumpAjax")
public class jumpAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public jumpAjax() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String page = request.getParameter("page");
		jumpImp imp = new jumpImp();
		List list = imp.selectInfo(SelectID.selectId((String)request.getSession().getAttribute("username")), page);
		JSONArray json = new JSONArray();
		historyBean history;
		for (int i = 0; i < list.size(); i++) {
			history =  (historyBean) list.get(i);
			Map map = new HashMap();
			map.put("upTime",history.getUpTime());
			map.put("operName",history.getOperName());
			map.put("type",history.getType());
			map.put("size", list.size());
			map.put("count", history.getCount());
			json.put(map);
		}
		PrintWriter out = response.getWriter();
		out.print(json.toString());
		out.flush();
		out.close();
	}

}
