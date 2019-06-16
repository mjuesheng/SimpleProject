package com.blog.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blog.jdbc.SelectID;
import com.blog.jdbc.loginImpl;

/**
 * Servlet implementation class upPsdServlet
 */
@WebServlet("/upPsdServlet")
public class upPsdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public upPsdServlet() {
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
		String username = (String) request.getSession().getAttribute("username");
		String psd = request.getParameter("oldpsd");
		String newpsd = request.getParameter("newpsd");
		//验证
		loginImpl imp = new loginImpl();
		Boolean is = imp.imp(username, psd,"1");
		if(is){
			Boolean is2 = imp.upPsd(SelectID.selectId(username), newpsd);
			if(is2){
				HttpSession session = request.getSession();
				session.invalidate();
				request.getSession().setAttribute("msg", "密码修改成功，请重新登录!");
				response.sendRedirect("login.jsp");
			}
		}else{
			request.getSession().setAttribute("msg", "密码错误，修改失败!");
			response.sendRedirect("msg.jsp");
		}
	}

}
