package com.fbm.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fbm.service.MessageService;
import com.fbm.service.UserService;
import com.fbm.service.impl.MessageServiceImpl;
import com.fbm.service.impl.UserServiceImpl;
import com.fbm.vo.Message;
import com.fbm.vo.User;
import com.fbm.web.Page;
import com.google.gson.Gson;

public class MessageServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void getChatMessageNum(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		long num = messageService.getMessageNum(user.getId());
		session.setAttribute("messageNum", num);
		String result = num + "";
		PrintWriter out = response.getWriter();
		out.write(result);
		out.close();
	}

	public void getChatMessage(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String idStr = request.getParameter("id");
		Long id = 1l;
		try {
			id = Long.parseLong(idStr);
		} catch (NumberFormatException e) {
		}
		// String context = request.getParameter("context");
		User user = (User) session.getAttribute("user");
		// id = messageService.sendMessage(id,user.getId(),context);

		Message message = messageService.getMessage(user.getId(), id);
		String result = "";
		Gson gson = new Gson();
		if (message != null) {
			result = gson.toJson(message);
		}

		PrintWriter out = response.getWriter();
		out.write(result);
		out.close();
	}

	public void sendMessage(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String idStr = request.getParameter("id");
		String context = request.getParameter("context");
		if (idStr.equals("all")) {
			messageService.sendMessageToAll(user.getId(), context);
			PrintWriter out = response.getWriter();
			Message message = new Message();
			message.setDateStr("");
			message.setUserFrom(user);
			message.setContext("发送给所有人成功!");
			Gson gson = new Gson();
			String result = gson.toJson(message);
			out.write(result);
			out.close();
		} else {
			Long id = 1l;
			try {
				id = Long.parseLong(idStr);
			} catch (NumberFormatException e) {
			}

			id = messageService.sendMessage(id, user.getId(), context);
			Message message = messageService.getBackMessageById(id);
			String result = "";
			Gson gson = new Gson();
			result = gson.toJson(message);
			PrintWriter out = response.getWriter();
			out.write(result);
			out.close();
		}

	}

	public void toMessageContext(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String idStr = request.getParameter("id");
		Long id = 1l;
		String pageNo = request.getParameter("pageNo");
		try {
			id = Long.parseLong(idStr);
		} catch (NumberFormatException e) {
		}
		Message message = messageService.getMessageById(id);
		request.setAttribute("message", message);
		request.getRequestDispatcher(
				"WEB-INF/jsp/message/messageContext.jsp?pageNo=" + pageNo)
				.forward(request, response);

	}

	UserService userService = new UserServiceImpl();
	MessageService messageService = new MessageServiceImpl();

	public void getMessageFrame(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int n = 1;
		String nStr = request.getParameter("pageNo");
		try {
			n = Integer.parseInt(nStr);
		} catch (NumberFormatException e) {
		}
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		Page<Message> page = messageService.getMessageList(n, user.getId());
		request.setAttribute("page", page);
		request.getRequestDispatcher("WEB-INF/jsp/message/messageFrame.jsp")
				.forward(request, response);
	}

	public void toMessageUI(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		List<User> list = userService.getUserList();
		request.setAttribute("userList", list);
		request.getRequestDispatcher("WEB-INF/jsp/message/messageIndex.jsp")
				.forward(request, response);
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
