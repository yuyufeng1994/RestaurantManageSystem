package com.fbm.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.fbm.web.Cart;

public class MyServletContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent context) {
		
		

	}

	@Override
	public void contextInitialized(ServletContextEvent context) {
		ServletContext servletContext = context.getServletContext();
		Cart cartStock = new Cart();
		servletContext.setAttribute("cartStock", cartStock);

	}

}
