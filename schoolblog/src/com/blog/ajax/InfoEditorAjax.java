package com.blog.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.blog.javabean.PersonBean;
import com.blog.jdbc.InfoEditorImp;
import com.blog.jdbc.operationImp;

@WebServlet("/InfoEditorAjax")
public class InfoEditorAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public InfoEditorAjax() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/json; charset=utf-8");
		
		Map map = new HashMap();
		/*   
		 *   t=0   获取信息
		 *   t=1   信息保存
		 *        
		 */
		String t = request.getParameter("t");
		String username = (String) request.getSession().getAttribute("username");
		
		String infoId = null;
		//  0 : 查询              1： 修改
		if(t.equals("0")){
			map = InfoEditorImp.getInfo(username);
			JSONArray json = new JSONArray();
			json.put(map);
			PrintWriter out = response.getWriter();
			out.println(json.toString());
			out.flush();
			out.close();
		}else{
			infoId = InfoEditorImp.getInfoId(username);
			System.out.println(infoId);
			String name = request.getParameter("nicheng");
			String sex = request.getParameter("sex");
			String introduce = request.getParameter("introduce");
			String blood = request.getParameter("blood");
			String emialInfo = request.getParameter("emialInfo");
			String phoneInfo = request.getParameter("phoneInfo");
			String birthday = request.getParameter("birthday");
			PersonBean person =new  PersonBean(name,introduce, sex, blood, emialInfo, phoneInfo, birthday);
			Boolean a = InfoEditorImp.saveInfo(infoId,person);
			if(a){
				String msg = "设置成功!";
				
				//保存历史记录
				operationImp operImp = new operationImp();
				String operName = "用户操作";
				String ty = "修改个人资料";
				operImp.saveOperation((String)request.getSession().getAttribute("username"), operName, ty);
				
				request.getSession().setAttribute("megMsg", msg);
				response.sendRedirect("msgInfo.jsp");
			}else{
				String msg = "设置失败!";
				request.getSession().setAttribute("megMsg", msg);
				response.sendRedirect("msgInfo.jsp");
			}
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
