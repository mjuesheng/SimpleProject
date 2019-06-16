package com.blog.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class loginFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("--------------����������----------------");
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest) arg0;  
		HttpServletResponse response = (HttpServletResponse) arg1;  
		System.out.println("--------------������ִ��----------------");
		String username = (String) request.getSession().getAttribute("username");
		if(username==null || "".equals(username)){
			request.getSession().setAttribute("msg", "���ȵ�¼!");
			request.getRequestDispatcher("/login.jsp").forward(request,response);
		}else{
			chain.doFilter(request, response);  
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("--------------���˳�ʼ��----------------");
	}

}
