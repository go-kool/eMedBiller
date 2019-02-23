package com.cts.emedbiller.servlet;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cts.emedbiller.bean.AppException;
import com.cts.emedbiller.bean.Order;
import com.cts.emedbiller.bean.User;
import com.cts.emedbiller.dao.OrderDao;
import com.cts.emedbiller.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import java.util.List;

public class Authenticate extends HttpServlet {

	

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String error="";
		String forwardUrl = "login.jsp";
		try {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			UserDao dao = new UserDao();
			User user = dao.getUser(username);

			if (user != null && user.getPassword().equals(password)) {
				
				HttpSession session = request.getSession();
				
				OrderDao orderDao=new OrderDao();
				List<Order> orders= orderDao.getOrders();
				session.setAttribute("user", user);
				session.setAttribute("bills", orders);
				
				forwardUrl = "home.jsp";
			}	else{
				error="Invalid Credentials!";
				request.setAttribute("userName", username);
			}
		} catch (AppException e) {
			e.printStackTrace();
			error="System error!\nPlease try after some time or contact Administrator.";
			forwardUrl = "login.jsp";
		}
		request.setAttribute("error", error);
		RequestDispatcher rd = request.getRequestDispatcher(forwardUrl);
		rd.forward(request, response);
	}
}