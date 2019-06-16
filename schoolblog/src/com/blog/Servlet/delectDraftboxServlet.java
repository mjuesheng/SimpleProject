package com.blog.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.jdbc.draftboxImp;
import com.blog.jdbc.messageImpl;
import com.blog.jdbc.operationImp;

/**
 * Servlet implementation class delectDraftboxServlet
 */
@WebServlet("/delectDraftboxServlet")
public class delectDraftboxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public delectDraftboxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		
		int id = Integer.parseInt(request.getParameter("id"));
		String msg;
		switch (id) {
		case 0: 
			draftboxImp imp = new draftboxImp();
			String draftId = request.getParameter("draftId");
			Boolean succ = imp.delectMessage(draftId);    //获取一个值判断是否删除成功
			if(succ){
				msg = "删除成功!";
				
				//保存历史记录
				operationImp operImp = new operationImp();
				String operName = "文本操作";
				String type = "删除草稿:"+draftId;
				operImp.saveOperation((String)request.getSession().getAttribute("username"), operName, type);
				
				request.getSession().setAttribute("megMsg", msg);
				response.sendRedirect("msgInfo.jsp");
				
			}else{
				msg = "删除失败!";
				request.setAttribute("msg", msg);
				request.getSession().setAttribute("megMsg", msg);
				response.sendRedirect("msgInfo.jsp");
			}
			break;
		default:
			break;
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
