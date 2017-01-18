package com.carbox.filters;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.carbox.beans.LoginControlBean;

@WebFilter(urlPatterns = { "/advertise.xhtml", "/advertiseauction.xhtml", "/advertisenormal.xhtml", "/advertisephotosforauction.xhtml",
		"/advertisephotosfornormal.xhtml", "/auctionpage.xhtml"})
public class LoginFilter implements Filter {

	public LoginFilter() { }

	public void destroy() { }

	public void init(FilterConfig fConfig) throws ServletException { }
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		LoginControlBean loginControlBean = (LoginControlBean)((HttpServletRequest)request).getSession().getAttribute("loginControlBean");
		
		if (loginControlBean == null || loginControlBean.isLoggedIn()== false) {
			String contextPath = req.getContextPath();
			resp.sendRedirect(contextPath + "/login.xhtml");
		}
		
		chain.doFilter(request, response);
	}

	

}
