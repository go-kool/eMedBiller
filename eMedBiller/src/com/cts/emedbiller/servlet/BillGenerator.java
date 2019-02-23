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

@WebServlet("/billgenerator")
public class BillGenerator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BillGenerator() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String error="";
		String forwardUrl="";
		MedicineDao medicineDao=new MedicineDao();
		try {
			ArrayList<Medicine> medicines=medicineDao.getMedicines();
			request.setAttribute("medicines", medicines);
			forwardUrl="billgenerator.jsp";
		} catch (AppException e) {
			error="Error while getting Medicines data";
			e.printStackTrace();
		}
		request.setAttribute("error", error);
		
		RequestDispatcher rd = request.getRequestDispatcher(forwardUrl);
		rd.forward(request, response);
		
	}

}
