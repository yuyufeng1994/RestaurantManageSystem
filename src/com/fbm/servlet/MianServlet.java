package com.fbm.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fbm.service.DishService;
import com.fbm.service.TradeService;
import com.fbm.service.UserService;
import com.fbm.service.impl.DishServiceImpl;
import com.fbm.service.impl.TradeServiceImpl;
import com.fbm.service.impl.UserServiceImpl;
import com.fbm.util.Captcha;
import com.fbm.util.ImageUtils;
import com.fbm.vo.Dish;
import com.fbm.vo.Trade;
import com.fbm.vo.User;
import com.fbm.web.Page;

public class MianServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void loginCheck(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String idStr = request.getParameter("id");
		String password = request.getParameter("password");
		String validation = request.getParameter("validation");
		HttpSession session = request.getSession();

		if (idStr == null || password == null || validation == null) {
			response.sendRedirect("index.jsp?message=error");
			return;
		}
		Long id = 1l;
		try {
			id = Long.parseLong(idStr);
		} catch (NumberFormatException e) {
		}
		String result = "0";
		PrintWriter out = response.getWriter();
		boolean b = userService.checkUserPassword(id, password);

		String imgStr = (String) session.getAttribute("imgStr");
		if (!imgStr.equalsIgnoreCase(validation)) {
			result = "1";
		}

		if (b && result.equals("0")) {

			User user = userService.getUserById(id);
			session.setAttribute("user", user);
			result = "2";
		}

		// response.sendRedirect("mianServlet?method=toIndexUI");
		out.write(result);
		out.close();
	}

	UserService userService = new UserServiceImpl();
	TradeService tradeService = new TradeServiceImpl();

	public void toIndexUI(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user == null) {
			response.sendRedirect("index.jsp");
			return;
		}
		DishService dishService = new DishServiceImpl();
		Page<Dish> page = dishService.getPage(1, "sale desc", null);
		request.setAttribute("top_sale", page.getList());
		Page<Trade> pageTrade = tradeService.getPage(1, 5);

		request.setAttribute("pageTrade", pageTrade);
		request.getRequestDispatcher("WEB-INF/jsp/main/index.jsp").forward(
				request, response);
	}

	public void getRadomPic(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		// 千万注意，像此类图片一定禁止浏览器缓存
		response.setIntHeader("expires", 0);
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");

		response.setHeader("content-type", "image/jpeg");

		Captcha captcha = new ImageUtils(120, 26, 4);// png格式验证码

		captcha.out(response.getOutputStream());

		String imgStr = captcha.getStr();
		session.setAttribute("imgStr", imgStr);
		// System.out.println(session.getAttribute("imgStr"));
		// ImageUtils.outputImage(response.getOutputStream());
		// FileOutputStream out = new FileOutputStream("c:\\1.jpg");
		// ImageUtils.outputImage(out);
		// out.close();
	}

	public void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		if (session.getAttribute("user") != null) {
			response.sendRedirect("mianServlet?method=toIndexUI");
		} else {
			response.sendRedirect("index.jsp");
		}

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
