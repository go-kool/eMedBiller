package com.cts.emedbiller.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cts.emedbiller.bean.AppException;
import com.cts.emedbiller.bean.Medicine;
import com.cts.emedbiller.bean.Order;
import com.cts.emedbiller.bean.OrderedMedicine;
import com.cts.emedbiller.bean.User;
import com.cts.emedbiller.dao.OrderDao;

/**
 * Servlet implementation class CreateBill
 */
@WebServlet("/createbill")
public class CreateBill extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateBill() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.
	 * HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.
	 * HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String error = "";
		Order order = new Order();
		OrderedMedicine orderedMedicines = new OrderedMedicine();

		HttpSession session = request.getSession(false);
		User user = new User();
		order.setPatientName(request.getParameter("patientName"));
		order.setDoctorName(request.getParameter("doctorName"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			order.setDate(sdf.parse(request.getParameter("date")));
		} catch (ParseException e) {
			error = "Invalid date format";
			RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
			rd.forward(request, response);
			e.printStackTrace();
		}
		String[] quantitiesArray = request.getParameterValues("medicineQuantity");
		String[] pricesArray = request.getParameterValues("price");
		String[] medicineIdsArray = request.getParameterValues("medicineId");
		String[] medicinesArray = request.getParameterValues("medicineName");
		ArrayList<Float> priceList = new ArrayList<Float>();
		ArrayList<Integer> quantityList = new ArrayList<Integer>();
		ArrayList<Integer> medicineIdList = new ArrayList<Integer>();
		for (String unit : quantitiesArray) {
			quantityList.add(Integer.parseInt(unit));
		}
		for (String priceString : pricesArray) {
			priceList.add(Float.parseFloat(priceString));
		}
		for (String medId : medicineIdsArray) {
			medicineIdList.add(Integer.parseInt(medId));
		}
		float price = 0;
		for (Float amount : priceList) {
			price = price + amount;
		}
		order.setPrice(price);
		User currentUser = (User) request.getSession().getAttribute("user");
		order.setUser(currentUser);
		OrderDao orderDao = new OrderDao();

		try {
			orderDao.insertBill(order);
		} catch (AppException e) {
			e.printStackTrace();
		}
		OrderedMedicineDao orderedMedsDao = new OrderedMedicineDao();

		for (int i = 0; i < medicineIdList.size(); i++) {

			int medId = medicineIdList.get(i);
			int units = quantityList.get(i);
			int order_id = 0;

			try {
				order_id = orderDao.getRecentOrder();

				orderedMedsDao.insertOrderedMeds(medId, units, order_id);
			} catch (AppException e) {
				error = "Error while creating a bill.";
				e.printStackTrace();
			}
			request.setAttribute("orderId", order_id);
			request.setAttribute("order", order);
			request.setAttribute("medicines", medicinesArray);
			request.setAttribute("units", quantityList);
			request.setAttribute("prices", priceList);
			RequestDispatcher rd = request.getRequestDispatcher("generatedbill.jsp");
			rd.forward(request, response);
		}

	}

}
