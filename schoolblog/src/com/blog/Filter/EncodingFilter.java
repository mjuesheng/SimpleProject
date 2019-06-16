package com.blog.Filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class EncodingFilter
 */
@WebFilter("/EncodingFilter")
public class EncodingFilter implements Filter {

	String encoding=null;

    public EncodingFilter() {
        // TODO Auto-generated constructor stub
    }


	public void destroy() {
		// TODO Auto-generated method stub
		 encoding=null;
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 将请求和响应强制转换成Http形式
		        if(encoding!=null){
		        //设置request字符编码
		            request.setCharacterEncoding(encoding);
		         //设置response字符编码
		            response.setContentType("text/html;charset="+encoding);
		        }
		     //传递给下一个过滤器
		        chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		 encoding=fConfig.getInitParameter("encoding");
	}

}
