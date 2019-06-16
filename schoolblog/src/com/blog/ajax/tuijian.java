package com.blog.ajax;
/**
 * 
 * ÎÄÕÂÍÆ¼ö
 * @author Administrator
 *
 */
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
import com.blog.jdbc.IntererstingImp;

@WebServlet("/tuijian")
public class tuijian extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public tuijian() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		IntererstingImp imp = new IntererstingImp();
		String username =(String) request.getSession().getAttribute("username");
		List list = imp.tuijian(username);
		megSubBean mb;
		JSONArray json = new JSONArray();
		for (int i = 0; i < list.size(); i++) {
			mb =  (megSubBean) list.get(i);
			Map map = new HashMap();
			map.put("releaseId", mb.getMessageId());
			map.put("username", mb.getUsername());
			map.put("title", mb.getTitle());
			map.put("readNum", mb.getReadNum());
			map.put("type", mb.getTextType());
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
		
		doGet(request, response);
	}

}
