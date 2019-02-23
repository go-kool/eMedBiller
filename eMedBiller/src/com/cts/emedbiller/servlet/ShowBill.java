package com.cts.emedbiller.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cts.emedbiller.dao.OrderDao;

@WebServlet("/showbill")
public class ShowBill extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int orderId = Integer.parseInt(request.getParameter("id"));
		OrderDao order=new OrderDao();
		String error="";
		try{
			
		}catch(Exception e){
			e.printStackTrace();
			error = "System Error! Please contact Administrator."; 
		}
		
	}

}
