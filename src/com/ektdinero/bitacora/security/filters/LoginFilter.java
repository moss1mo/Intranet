package com.ektdinero.bitacora.security.filters;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ektdinero.bitacora.controllers.LoginController;


	public class LoginFilter implements Filter {
	 
	    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	        LoginController loginBean = (LoginController)((HttpServletRequest)request).getSession().getAttribute("loginController");

	        if (loginBean == null || !loginBean.isLoggedIn()) {
	            String contextPath = ((HttpServletRequest)request).getContextPath();
	            ((HttpServletResponse)response).sendRedirect(contextPath + "/public/tienda/compras.xhtml");
	        }
	         
	        chain.doFilter(request, response);
	             
	    }
	 
	    public void init(FilterConfig config) throws ServletException {

	    }
	 
	    public void destroy() {

	    }  
	     
	}

