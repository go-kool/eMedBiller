package com.cts.emedbiller.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cts.emedbiller.bean.AppException;
import com.cts.emedbiller.dao.ItemDao;
import com.cts.emedbiller.dao.MedicineDao;

/**
 * Servlet implementation class EditMedicine
 */
@WebServlet("/showmedicine")
public class ShowMedicine extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ShowMedicine() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int medicineId = Integer.parseInt(request.getParameter("id"));
		MedicineDao medicineDao=new MedicineDao();
		ItemDao itemDao=new ItemDao();
		try {
			request.setAttribute("medicine", medicineDao.getMedicine(medicineId));
			request.setAttribute("items", itemDao.getItems());
		} catch (AppException e) {
			
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("modifymedicine.jsp");
		rd.forward(request, response);
	}

	

}
