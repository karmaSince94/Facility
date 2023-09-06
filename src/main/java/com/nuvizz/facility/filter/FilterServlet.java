package com.nuvizz.facility.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class FilterServlet
 */
public class FilterServlet implements Filter {

    /**
     * Default constructor. 
     */
    public FilterServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	{
		// TODO Auto-generated method stub
		// place your code here
		System.out.println("inside filter");
		HttpServletRequest req = (HttpServletRequest) request;
		
		
		String url = ((HttpServletRequest) request).getRequestURL().toString();
		System.out.println("url = " + url);

		if (url.equals("http://localhost:8080/Facility/welcome.do")) 
		{
			chain.doFilter(request, response);
		}
		else
		{
			HttpSession session = ((HttpServletRequest) request).getSession(false);

			if (session == null) 
			{
				request.getRequestDispatcher("/WEB-INF/jsp/Login.jsp").forward(request, response);
			}
			else
			{
				chain.doFilter(request, response);
			}
		}
		
		/*
		 * if (session.getAttribute("fromdb") != null) {
		 * System.out.println("Entered success block");
		 * req.getRequestDispatcher("Dashboard.jsp").forward(request, response);
		 * } else { System.out.println("Entered login block");
		 * req.getRequestDispatcher("Login.jsp").forward(request, response); }
		 */


		
		// pass the request along the filter chain
		//chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
