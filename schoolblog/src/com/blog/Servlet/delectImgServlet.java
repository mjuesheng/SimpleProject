package com.blog.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.jdbc.DbUtils;

@WebServlet("/delectImgServlet")

public class delectImgServlet extends HttpServlet {

	ResultSet res;
	PreparedStatement ps=null; 
	String sql=null;
	String imgId;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		imgId = (String) request.getParameter("imgId");
		Connection connection = DbUtils.getConnection();
		sql = "delete from t_user_img where imgId=?";
		int tag=0;
		try {
			ps=connection.prepareStatement(sql);
			ps.setString(1, imgId);
			if(ps.executeUpdate()>0?true:false){
				tag = 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtils.close(connection, ps, null);
		}
		if(tag == 0){
			String msg = "Í¼Æ¬É¾³ýÊ§°Ü!";
			request.getSession().setAttribute("megMsg", msg);
			response.sendRedirect("msgInfo.jsp");
		}
		if(tag == 1){
			String msg = "Í¼Æ¬É¾³ý³É¹¦!";
			request.getSession().setAttribute("megMsg", msg);
			response.sendRedirect("msgInfo.jsp");
		}
	}
}
