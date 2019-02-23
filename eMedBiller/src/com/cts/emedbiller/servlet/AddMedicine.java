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
import com.cts.emedbiller.dao.ItemDao;
import com.cts.emedbiller.dao.MedicineDao;

@WebServlet("/addMedicine")
public class AddMedicine extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public AddMedicine() {
        super();
        
    }


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forwardUrl="addmedicine.jsp";
		String error="";
		Medicine medicine=new Medicine();
		medicine.setName(request.getParameter("medicineName"));
		Item item=new Item();
		item.setId(Integer.parseInt(request.getParameter("medicineType")));
		medicine.setCostPrice((Float.parseFloat(request.getParameter("cp"))));
		medicine.setSellingPrice(Float.parseFloat(request.getParameter("sp")));
		medicine.setItemsPerStrip(Integer.parseInt(request.getParameter("items")));
		medicine.setStrips(Integer.parseInt(request.getParameter("strips")));
		medicine.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		medicine.setItem(item);
		MedicineDao medicineDao=new MedicineDao();
		
		try {
			medicineDao.insertMedicine(medicine);
			
		} catch (AppException e) {
			error = "System Error. Please retry or contact system administrator.";
			e.printStackTrace();
		}
		request.setAttribute("error", error);
		request.setAttribute("success", "Medicine added Sucessfully!");
		RequestDispatcher rd = request.getRequestDispatcher(forwardUrl);
		rd.forward(request, response);
	}
	

}
