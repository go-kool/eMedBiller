package com.cts.emedbiller.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cts.emedbiller.bean.AppException;
import com.cts.emedbiller.bean.Item;
import com.cts.emedbiller.bean.Medicine;
import com.cts.emedbiller.dao.MedicineDao;

/**
 * Servlet implementation class ModifyMedicine modifyMedicine
 */
@WebServlet("/modifymedicine")
public class ModifyMedicine extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModifyMedicine() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String forwardUrl = "modifymedicine.jsp";
		String error = "";
		Medicine medicine = new Medicine();
		medicine.setId(Integer.parseInt(request.getParameter("medicineId")));
		medicine.setName(request.getParameter("medicineName"));
		Item item = new Item();
		item.setId(Integer.parseInt(request.getParameter("medicineType")));
		medicine.setCostPrice((Float.parseFloat(request.getParameter("cp"))));
		medicine.setSellingPrice(Float.parseFloat(request.getParameter("sp")));
		medicine.setItemsPerStrip(Integer.parseInt(request.getParameter("items")));
		medicine.setStrips(Integer.parseInt(request.getParameter("strips")));
		medicine.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		medicine.setItem(item);
		MedicineDao medicineDao = new MedicineDao();

		try {
			medicineDao.updateMedicine(medicine);
			

		} catch (AppException e) {
			error = "System Error. Please retry or contact system administrator.";
			e.printStackTrace();
		}
		request.setAttribute("error", error);
		request.setAttribute("success", "Medicine details saved successfully.");
		RequestDispatcher rd = request.getRequestDispatcher(forwardUrl);
		rd.forward(request, response);
	}

}
