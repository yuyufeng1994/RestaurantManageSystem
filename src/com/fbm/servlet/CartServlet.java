package com.fbm.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fbm.service.DishService;
import com.fbm.service.impl.DishServiceImpl;
import com.fbm.vo.Dish;
import com.fbm.web.Cart;
import com.fbm.web.CartItem;
import com.google.gson.Gson;

public class CartServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	public void tableNumChange(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String tableNum = request.getParameter("tableNum");
		HttpSession session = request.getSession();
		session.setAttribute("tableNum", tableNum);
	}

	public void cancel(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		ServletContext servletContext = request.getSession()
				.getServletContext();
		Cart cartStock = (Cart) servletContext.getAttribute("cartStock");
		if(cart != null && cartStock!=null){
			for(CartItem c:cart.getItems()){
				Integer old = c.getQuantity();
				cartStock.updateItemQuantity(c.getDish().getId(), old-c.getQuantity());
			}
		}
		cart.clear();
		response.sendRedirect("bookServlet?method=toIndexUI");
	}

	public void cartItemChange(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Gson gson = new Gson();
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		ServletContext servletContext = request.getSession()
				.getServletContext();
		Cart cartStock = (Cart) servletContext.getAttribute("cartStock");
		String idStr = request.getParameter("id");
		String value = request.getParameter("value");
		Long id = null;
		String result = "";
		ChangeResult cr = new ChangeResult();
		try {
			id = Long.parseLong(idStr);
		} catch (NumberFormatException e) {
		}
		if ((value.trim()).equals("+")) {
			// 获取未付款正在购物车中的数目
			Integer stockNum = cartStock.getItemNum(id);

			if (dishService.checkStock(id, stockNum)) {
				Integer oldNum = cart.getItemNum(id);
				cart.updateItemQuantity(id, oldNum + 1);
				Integer oldStockNum = cartStock.getItemNum(id);
				cartStock.updateItemQuantity(id, oldStockNum + 1);
				cr.num = cart.getItemNum(id);
				cr.totalMoney = cart.getTotalMoney();
				result = "1";
			} else {

			}

		}
		if ((value.trim()).equals("-")) {
			Integer oldNum = cart.getItemNum(id);
			if (oldNum > 0) {
				cart.updateItemQuantity(id, oldNum - 1);
				Integer oldStockNum = cartStock.getItemNum(id);
				cartStock.updateItemQuantity(id, oldStockNum - 1);
				cr.num = cart.getItemNum(id);
				cr.totalMoney = cart.getTotalMoney();
				cr.totalNumber = cart.getTotalNumber();
				result = "1";
				// result = String.valueOf(now);
			} else {
				cr.num = cart.getItemNum(id);
			}

		}

		PrintWriter out = response.getWriter();
		// System.out.println(gson.toJson(cart));
		// System.out.println(result);
		if (result.equals("1")) {
			result = gson.toJson(cr);
		} else {
			result = "0";
		}
		out.write(result);
		out.close();

	}

	class ChangeResult {
		int num;
		int totalNumber;
		float totalMoney;
	}

	public void toCartUI(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("WEB-INF/jsp/cart/cart.jsp").forward(
				request, response);
	}

	public void cartItemDelete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		ServletContext servletContext = request.getSession()
				.getServletContext();
		Cart cartStock = (Cart) servletContext.getAttribute("cartStock");
		String idStr = request.getParameter("id");
		Long id = null;
		try {
			id = Long.parseLong(idStr);
		} catch (NumberFormatException e) {
		}
		Integer quantity = cart.getItemNum(id);
		cart.removeItem(id);
		Integer ApplocationQuantity = cartStock.getItemNum(id);
		cartStock.updateItemQuantity(id, ApplocationQuantity - quantity);
		response.sendRedirect("cartServlet?method=toCartUI");

	}

	public void nowCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		Gson gson = new Gson();
		PrintWriter out = response.getWriter();
		String result = "";
		result = gson.toJson(cart.getItems());
		out.write(result);
		out.close();
	}

	DishService dishService = new DishServiceImpl();

	public void addToCart(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ServletContext servletContext = request.getSession()
				.getServletContext();
		HttpSession session = request.getSession();
		String idStr = request.getParameter("id");
		Long id = null;
		Cart cart = (Cart) session.getAttribute("cart");
		Cart cartStock = (Cart) servletContext.getAttribute("cartStock");

		if (cart == null) {
			cart = new Cart();
			session.setAttribute("cart", cart);
		}
		String result = "false";
		PrintWriter out = response.getWriter();
		try {
			id = Long.parseLong(idStr);

			Dish dish = dishService.getDishById(id);

			// 获取未付款正在购物车中的数目
			Integer stockNum = cartStock.getItemNum(id);

			if (dishService.checkStock(id, stockNum)) {
				result = "true";
				cartStock.addDish(dish);
				cart.addDish(dish);
			}

		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		if (result.equals("true")) {
			result = cart.getTotalNumber() + "";
		}

		out.write(result);
		out.close();

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String methodName = request.getParameter("method");
		try {
			Method method = getClass().getDeclaredMethod(methodName,
					HttpServletRequest.class, HttpServletResponse.class);
			method.setAccessible(true);
			method.invoke(this, request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
