package com.cts.emedbiller.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cts.emedbiller.bean.AppException;
import com.cts.emedbiller.bean.Medicine;
import com.cts.emedbiller.bean.Order;
import com.cts.emedbiller.dao.MedicineDao;
import com.cts.emedbiller.dao.OrderDao;

/**
 * Servlet implementation class ViewBill
 */
@WebServlet("/viewbills")
public class ViewBills extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewBills() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String error="";
		String forwardUrl = "viewbills.jsp";		

		OrderDao orderDao=new OrderDao();
		
		
		
		
		try {
			List<Order> orders= orderDao.getOrders();
			request.setAttribute("bills", orders);
		} catch (AppException e) {
			e.printStackTrace();
			error="No Bills found";
			forwardUrl = "home.jsp";
		}
		request.setAttribute("error", error);
		RequestDispatcher rd = request.getRequestDispatcher(forwardUrl);
		rd.forward(request, response);
	}

	

}
