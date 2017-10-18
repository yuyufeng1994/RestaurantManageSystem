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

import com.fbm.exception.DishStockNotEnoughException;
import com.fbm.service.DishService;
import com.fbm.service.TradeService;
import com.fbm.service.impl.DishServiceImpl;
import com.fbm.service.impl.TradeServiceImpl;
import com.fbm.vo.Dish;
import com.fbm.vo.Trade;
import com.fbm.vo.User;
import com.fbm.web.Cart;
import com.fbm.web.CartItem;
import com.fbm.web.DateSale;
import com.fbm.web.Page;
import com.google.gson.Gson;

public class TradeServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void changeState(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String result = "0";
		String idStr = request.getParameter("id");
		Long id = 1l;
		try {
			id = Long.parseLong(idStr);
		} catch (NumberFormatException e) {
		}
		
		String nowState = tradeService.changeState(id);
		
		// result = String.valueOf(nowState);
		if (nowState != null) {
			result = nowState;
		}
		out.write(result);
		out.close();
	}

	public void getTrade(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String tradeIdStr = request.getParameter("tradeId");
		String to_flag = request.getParameter("to_flag");
		Long tradeId = 201500003l;
		try {
			tradeId = Long.parseLong(tradeIdStr);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String pageNum = request.getParameter("pageNum");
		Trade trade = tradeService.getTrade(tradeId);
		Cart cart = tradeService.getTradeInfoToCart(tradeId);
		if (to_flag != null) {
			request.setAttribute("to_flag", to_flag);
		}
		request.setAttribute("trade", trade);
		request.setAttribute("cart", cart);
		request.getRequestDispatcher(
				"WEB-INF/jsp/trade/trade-info.jsp?pageNum=" + pageNum).forward(
				request, response);
	}

	public void addTrade(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			DishStockNotEnoughException {
		ServletContext servletContext = request.getSession()
				.getServletContext();
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		Cart cartStock = (Cart) servletContext.getAttribute("cartStock");
		User user = (User) session.getAttribute("user");
		String tableStr = request.getParameter("tableNum");
		if(cart.getTotalNumber()==0){
			response.sendRedirect("cartServlet?method=toCartUI");
			return;
		}
		Integer tableId = 1101;

		try {
			tableId = Integer.parseInt(tableStr);
		} catch (NumberFormatException e) {
		}
		tradeService.addTradeList(cart, user.getId(), tableId);

		for (CartItem c : cart.getItems()) {
			Integer oldQantity = cartStock.getItemNum(c.getDish().getId());
			cartStock.updateItemQuantity(c.getDish().getId(),
					oldQantity - c.getQuantity());
		}
		cart.clear();
		response.sendRedirect("tradeServlet?method=toTradeUI");

	}

	TradeService tradeService = new TradeServiceImpl();
	DishService dishService = new DishServiceImpl();

	public void toTradeUI(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String pageNoStr = request.getParameter("pageNo");
		String stateStr = request.getParameter("state");
		int pageNo = 1;
		int state = 4;
		try {
			pageNo = Integer.parseInt(pageNoStr);
			state = Integer.parseInt(stateStr);
		} catch (NumberFormatException e) {
			// e.printStackTrace();
		}
		Page<Trade> page = tradeService.getPage(pageNo, state);
		request.setAttribute("page", page);

		request.getRequestDispatcher("WEB-INF/jsp/trade/tradeIndex.jsp")
				.forward(request, response);
	}
	
	public void getTimeTrade(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		List<DateSale> list =tradeService.getMSales();
		PrintWriter out = response.getWriter();
		
		Gson gson = new Gson();
		String result = "";
		result = gson.toJson(list);
		out.print(result);
		
		out.close();

	}
	public void getRecentTrade(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		List<DateSale> list =tradeService.getDSales();
		PrintWriter out = response.getWriter();
		
		Gson gson = new Gson();
		String result = "";
		result = gson.toJson(list);
		out.print(result);
		
		out.close();

	}

	public void toTradeAllUI(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String pageNoStr = request.getParameter("pageNo");
		String stateStr = request.getParameter("state");
		int pageNo = 1;
		int state = 5;
		try {
			pageNo = Integer.parseInt(pageNoStr);
			state = Integer.parseInt(stateStr);
		} catch (NumberFormatException e) {
			// e.printStackTrace();
		}
		Page<Trade> page = tradeService.getPage(pageNo, state);
		request.setAttribute("page", page);

		request.getRequestDispatcher("WEB-INF/jsp/trade/tradeAll.jsp").forward(
				request, response);
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
