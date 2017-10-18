package com.fbm.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fbm.service.DishService;
import com.fbm.service.impl.DishServiceImpl;
import com.fbm.util.UUIDUtil;
import com.fbm.vo.Dish;
import com.fbm.web.DishTipForSearch;
import com.fbm.web.DishTypeSale;
import com.fbm.web.Page;
import com.google.gson.Gson;

public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}
	public void getDishList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String keyword = request.getParameter("keyword");
		String result = "";
		keyword = keyword.trim();
		if(keyword.equals("")){
			
		}else{
			
		
		List<Dish> allDishlist = new ArrayList<Dish>();
		
		allDishlist = dishService.getAllDishList(keyword);
		
		List<DishTipForSearch> tipList = new ArrayList<DishTipForSearch>();
		if(allDishlist!=null){
			for(Dish d:allDishlist){
				DishTipForSearch dt = new DishTipForSearch();
				dt.setTitle(d.getName());
				tipList.add(dt);
			}
			
		}
		
		Gson gson = new Gson();
		result = gson.toJson(tipList);
		}
	//	result = "{data:"+result+"}";
		//System.out.println(result);
		PrintWriter out = response.getWriter();
		out.write(result);
		out.close();
	}
	
	public void stockChange(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String idStr = request.getParameter("id").trim();
		String stockStr = request.getParameter("stock").trim();
		Integer stock = 10;
		Long id = 1l;
		PrintWriter out = response.getWriter();
		String stockNow = "1";
		try {
			stock = Integer.parseInt(stockStr);
			id = Long.parseLong(idStr);
		} catch (NumberFormatException e) {
			stockNow = "2";
		}
		

		try {
			dishService.changeStock(id, stock);
		} catch (Exception e) {
			stockNow = "2";
		}

		out.write(stockNow);
		out.close();

	}


	
	public void itemDelete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String idStr = request.getParameter("id");
		String pageNum = request.getParameter("pageNum");
		Long id = null;
		try {
			id = Long.parseLong(idStr);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		try {
			dishService.deleteBook(id);
		} catch (Exception e) {
		}
		response.sendRedirect("bookServlet?method=itemManageUI&pageNum="
				+ pageNum);

	}

	public void itemEdit(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String idStr = request.getParameter("id");
		String pageNum = request.getParameter("pageNum");
		Long id = 1l;
		try {
			id = Long.parseLong(idStr);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String name = request.getParameter("name");
		Integer type_id = 1;
		String typeIdStr = request.getParameter("type_id");
		Float price = 10.5F;
		String priceStr = request.getParameter("price");
		String picture = request.getParameter("picture");
		
		Long sale = 0l;
		Integer stock = 10;
		String description = request.getParameter("description");
		try {
			type_id = Integer.parseInt(typeIdStr);
			price = Float.parseFloat(priceStr);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Dish dish = dishService.getDishById(id);
		sale = dish.getSale();
		stock =dish.getStock();
		dishService.eidtBook(id, name, type_id, price, picture, sale, stock,
				description);
		response.sendRedirect("bookServlet?method=itemManageUI&pageNum="
				+ pageNum);
	}

	public void itemEditUI(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String idStr = request.getParameter("id");
		Long id = 1l;
		try {
			id = Long.parseLong(idStr);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Dish dish = dishService.getDishById(id);
		request.setAttribute("dishType", dishService.getDishList());
		request.setAttribute("dish", dish);
		request.getRequestDispatcher("WEB-INF/jsp/book/book-add.jsp").forward(
				request, response);
	}

	public void addDish(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		Integer type_id = 1;
		String typeIdStr = request.getParameter("type_id");
		Float price = 10.5F;
		String priceStr = request.getParameter("price");
		String picture = request.getParameter("picture");
		Long sale = 0l;
		Integer stock = 10;
		String description = request.getParameter("description");
		try {
			type_id = Integer.parseInt(typeIdStr);
			price = Float.parseFloat(priceStr);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		dishService.addBook(name, type_id, price, picture, sale, stock,
				description);
		response.sendRedirect("bookServlet?method=itemManageUI");
	}

	public void itemAddUI(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("dishType", dishService.getDishList());
		request.setAttribute("UUID", UUIDUtil.getUUID());
		request.getRequestDispatcher("WEB-INF/jsp/book/book-add.jsp").forward(
				request, response);
	}

	public void itemManageUI(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String pageNumStr = request.getParameter("pageNum");
		int pageNum = 1;
		try {
			pageNum = Integer.parseInt(pageNumStr);
		} catch (NumberFormatException e) {

		}
		Page<Dish> page = dishService.getPage(pageNum, "id desc", "");
		request.setAttribute("dishType", dishService.getDishList());
		request.setAttribute("page", page);
		request.getRequestDispatcher("WEB-INF/jsp/book/itemManege.jsp")
				.forward(request, response);
	}

	public void searchDish(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String likeStr = request.getParameter("likeStr");
		// likeStr = new String(likeStr.getBytes("iso-8859-1"), "utf-8");
		likeStr = likeStr.trim();
		HttpSession session = request.getSession();
		if (likeStr != null) {
			session.setAttribute("bookLikeStr", likeStr);
		} else {
			session.removeAttribute("bookLikeStr");
		}
		// session.setAttribute("bookLikeStr", likeStr);
		response.sendRedirect("bookServlet?method=toIndexUI");
	}

	public void setSortAttr(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String conditionStr = request.getParameter("bookCondition");
		String condition = null;
		if ("2".equals(conditionStr)) {
			condition = "sale desc";

		} else if ("3".equals(conditionStr)) {
			condition = "price desc";

		} else {
			condition = "";

		}

		session.setAttribute("bookCondition", condition);
		response.sendRedirect("bookServlet?method=toIndexUI");

	}

	public void getMoreList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		String pageNumStr = request.getParameter("pageNum");
		int pageNum = 1;
		try {
			pageNum = Integer.parseInt(pageNumStr);
		} catch (NumberFormatException e) {

		}

		String condition = null;
		String likeStr = null;
		HttpSession session = request.getSession();

		try {
			condition = (String) session.getAttribute("bookCondition");
			likeStr = (String) session.getAttribute("bookLikeStr");
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (condition == null || ("".trim()).equals(condition)) {
			condition = "id desc";
		}
		if (likeStr == null) {
			likeStr = "";
		}
		Page<Dish> page = dishService.getPage(pageNum, condition, likeStr);
		Gson gson = new Gson();
		String json = gson.toJson(page);
		PrintWriter out = response.getWriter();
		
		out.write(json);
		out.close();

	}

	DishService dishService = new DishServiceImpl();

	public void toIndexUI(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int n = 1;
		String condition = null;
		String likeStr = null;
		HttpSession session = request.getSession();

		try {
			condition = (String) session.getAttribute("bookCondition");
			likeStr = (String) session.getAttribute("bookLikeStr");
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (condition == null || ("".trim()).equals(condition)) {
			condition = "id desc";
		}
		if (likeStr == null) {
			likeStr = "";
		}

		Page<Dish> page = dishService.getPage(n, condition, likeStr);
		request.setAttribute("dishType", dishService.getDishList());
		request.setAttribute("page", page);
		request.getRequestDispatcher("WEB-INF/jsp/book/book.jsp").forward(
				request, response);
	}
	
	public void getSaleDishType(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		List<DishTypeSale> list =dishService.getDishTypeSales();
		PrintWriter out = response.getWriter();
		
		Gson gson = new Gson();
		String result = "";
		result = gson.toJson(list);
		out.print(result);
		
		out.close();

	}
	
	public void getTopSaleDish(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Page<Dish> page = dishService.getPage(1, "sale desc", null);
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		String result = "";
		result = gson.toJson(page.getList());
		out.print(result);
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
