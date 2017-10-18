package com.fbm.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fbm.util.LoginUtils;
import com.fbm.vo.User;

public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest sreq, ServletResponse sresp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) sreq;
		HttpServletResponse response = (HttpServletResponse) sresp;
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");

		String url = req.getRequestURI();
		String urlfoot = url.substring(url.lastIndexOf("/") + 1);
		

		for (String s : LoginUtils.getAcessLists()) {
			if(urlfoot.equals(s)){
				if(user == null){
					response.sendRedirect("index.jsp");
					return;
				}
			}
		}

		// if(user == null && (!urlfoot.equals("index.jsp")) &&
		// (!urlfoot.equals("mianServlet"))){
		// response.sendRedirect("index.jsp");
		//
		// }else{
		// chain.doFilter(sreq, sresp);
		// }

		// if(user == null){
		// response.sendRedirect("index.jsp");
		// }else{
		// chain.doFilter(sreq, sresp);
		// }
		// response.sendRedirect("index.jsp");
		// http://localhost:8080/fbm/index.jsp
		chain.doFilter(sreq, sresp);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
