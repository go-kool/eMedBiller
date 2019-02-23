package com.cts.emedbiller.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.cts.emedbiller.bean.AppException;

public class ConnectionManager {
	public static Connection getConnection() throws AppException {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new AppException("Error when loading JDBC driver.\n" + e.getMessage());
		}
		try {
			connection = DriverManager.getConnection("jdbc:mysql://192.168.1.9:3306/medicalshop", "root", "root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

}
