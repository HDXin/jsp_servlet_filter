package com.atguigu.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class LoginFilter
 */
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
    	System.out.println("loginFilter...");
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {

		System.out.println("loginFilter destory...");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		if(name == null || "".equals(name) || pass == null || "".equals(pass)){
			String message = "用户名或密码不正确！";
			request.setAttribute("message", message);
			String path = "/login.jsp";
			RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
			requestDispatcher.forward(request, response);
		}else{
			// pass the request along the filter chain
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {

		System.out.println("loginFilter init...");
	}

}
