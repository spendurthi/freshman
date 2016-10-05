package com.fgtway.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FgtWayFilter implements Filter {
 
	@Override
	public void destroy() {		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
        HttpServletResponse response = (HttpServletResponse) arg1;
		HttpSession session = request.getSession(false);
        if (session== null || session.isNew()){
        	String nextJSP = "/index.jsp";
        	session = request.getSession(true);
        	RequestDispatcher dispatcher = session.getServletContext().getRequestDispatcher(nextJSP);
        	dispatcher.forward(request,response);
        	return;
        }else{
        	chain.doFilter(request, response);
        }
		
	}
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
