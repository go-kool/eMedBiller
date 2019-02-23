package com.cts.emedbiller.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cts.emedbiller.bean.AppException;
import com.cts.emedbiller.bean.Medicine;
import com.cts.emedbiller.dao.MedicineDao;

@WebServlet("/searchmedicine")
public class SearchMedicine extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SearchMedicine() {
        super();
       
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String error="";
		String forwardUrl = "viewmedicines.jsp";
		String search = request.getParameter("search");
		
		MedicineDao medicineDao=new MedicineDao();
		
		try {
			ArrayList<Medicine> medicines = medicineDao.getMedicine(search);
			request.setAttribute("medicines", medicines);
		} catch (AppException e) {
			e.printStackTrace();
			error="No Medicines found with that name!";
			forwardUrl = "home.jsp";
		}
		request.setAttribute("error", error);
		RequestDispatcher rd = request.getRequestDispatcher(forwardUrl);
		rd.forward(request, response);
	}
}
	


