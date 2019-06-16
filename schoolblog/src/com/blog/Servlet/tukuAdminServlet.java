package com.blog.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.jdbc.SelectID;
import com.blog.jdbc.imgUrlImp;

/**
 * Servlet implementation class tukuAdminServlet
 */
@WebServlet("/tukuAdminServlet")
public class tukuAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public tukuAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String username = (String) request.getSession().getAttribute("username");
		String imgId = request.getParameter("imgId");
		String userId = SelectID.selectId(username);
		if(imgUrlImp.imgChange(imgId,userId)){
			System.out.println("Servlet.tukuAdminServlet:…Ë÷√≥…π¶!");
			response.sendRedirect("PersonalAdmin.jsp");
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
