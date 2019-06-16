package com.blog.Servlet;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import com.blog.yanzhengma.IdentityUtil;


@WebServlet("/Identity.html")
public class IdentityServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("image/png");
		String code=IdentityUtil.getRandomString();
		System.out.println(code);
		System.out.println(this.getServletConfig().getServletContext().getRealPath("/"));
		request.getSession().setAttribute("code", code);
		BufferedImage image=IdentityUtil.getBufferedImage(code);
		ServletOutputStream out=response.getOutputStream();
		JPEGImageEncoder encoder=JPEGCodec.createJPEGEncoder(out);
		encoder.encode(image);
		out.flush();
	}

}