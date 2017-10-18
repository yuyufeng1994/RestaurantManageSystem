package com.fbm.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.fbm.service.MessageService;
import com.fbm.service.impl.MessageServiceImpl;
import com.fbm.vo.User;
import com.fbm.web.Cart;
import com.fbm.web.CartItem;

public class MySessionListener implements HttpSessionListener {

	public void sessionCreated(HttpSessionEvent sessionEvent) {
		HttpSession session = sessionEvent.getSession();
		Cart cart = new Cart();
		session.setAttribute("cart", cart);
		User user = (User) session.getAttribute("user");
		MessageService messageService = new MessageServiceImpl();
		Long num = 0l;
		try {
			num = messageService.getMessageNum(user.getId());
		} catch (Exception e) {}
		session.setAttribute("messageNum", num);
		
	}

	public void sessionDestroyed(HttpSessionEvent sessionEvent) {
		//System.out.println("MySessionListener.sessionDestroyed()");
		ServletContext servletContext = sessionEvent.getSession().getServletContext();
		HttpSession session = sessionEvent.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		Cart cartStock = (Cart) servletContext.getAttribute("cartStock");
		
		if(cart != null && cartStock!=null){
			for(CartItem c:cart.getItems()){
				Integer old = c.getQuantity();
				cartStock.updateItemQuantity(c.getDish().getId(), old-c.getQuantity());
			}
		}
		
	}

}
