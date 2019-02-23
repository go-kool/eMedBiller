package com.cts.emedbiller.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.cts.emedbiller.bean.AppException;
import com.cts.emedbiller.bean.Medicine;
import com.cts.emedbiller.bean.Order;
import com.cts.emedbiller.dao.ConnectionManager;

public class OrderDao {
	public static final String GET_ALL_BILLS = "SELECT * FROM medicalshop.order";
	public static final String GET_BILL = "SELECT * FROM medicalshop.order where or_id = ?";
	public static final String GET_BILLS_BETWEEN_DATES = "SELECT * FROM medicalshop.order where (or_date between ? and ?)";
	public static final String INSERT_BILL = "INSERT INTO medicalshop.order (or_us_id, or_date, or_pat_name, or_doc_name, or_price) VALUES (?, ?, ?, ?, ?)";
	public static final String GET_RECENT_ORDER = "select max(or_id) from medicalshop.order";

	public List<Order> getOrders() throws AppException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<Order> orders = new ArrayList<Order>();
		try {
			connection = ConnectionManager.getConnection();
			statement = connection.prepareStatement(GET_ALL_BILLS);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Order order = new Order();
				order.setId(resultSet.getInt("OR_ID"));
				order.setDate(resultSet.getDate("OR_DATE"));
				order.setDoctorName(resultSet.getString("OR_DOC_NAME"));
				order.setPatientName(resultSet.getString("OR_PAT_NAME"));
				order.setPrice(resultSet.getFloat("OR_PRICE"));
				orders.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("Error while getting the user data.\n" + e.getMessage());
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();

				}
				if (statement != null) {

					statement.close();

				}
				if (connection != null) {

					connection.close();

				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new AppException("Error while the closing connection.\n" + e.getMessage());
			}

		}
		return orders;

	}

	public Order getOrder(int id) throws AppException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Order order = null;

		try {
			connection = ConnectionManager.getConnection();
			statement = connection.prepareStatement(GET_BILL);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();

			if (resultSet.next()) {
				order = new Order();
				order.setId(resultSet.getInt("OR_ID"));
				order.setDate(resultSet.getDate("OR_DATE"));
				order.setDoctorName(resultSet.getString("OR_DOC_NAME"));
				order.setPatientName(resultSet.getString("OR_PAT_NAME"));
				order.setPrice(resultSet.getFloat("OR_PRICE"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("Error while getting the bill data.\n" + e.getMessage());
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();

				}
				if (statement != null) {

					statement.close();

				}
				if (connection != null) {

					connection.close();

				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new AppException("Error while the closing connection.\n" + e.getMessage());
			}

		}
		return order;

	}

	public List<Order> getOrdersFromDates(String fromDate, String toDate) throws AppException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<Order> orders = new ArrayList<Order>();
		try {
			connection = ConnectionManager.getConnection();
			statement = connection.prepareStatement(GET_BILLS_BETWEEN_DATES);
			statement.setString(1, fromDate);
			statement.setString(2, toDate);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Order order = new Order();
				order.setId(resultSet.getInt("OR_ID"));
				order.setDate(resultSet.getDate("OR_DATE"));
				order.setDoctorName(resultSet.getString("OR_DOC_NAME"));
				order.setPatientName(resultSet.getString("OR_PAT_NAME"));
				order.setPrice(resultSet.getFloat("OR_PRICE"));
				orders.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("Error while getting the bill data.\n" + e.getMessage());
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();

				}
				if (statement != null) {

					statement.close();

				}
				if (connection != null) {

					connection.close();

				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new AppException("Error while the closing connection.\n" + e.getMessage());
			}

		}
		return orders;
	}

	public int getRecentOrder() throws AppException {
		int orderId = 0;
		PreparedStatement statement = null;
		Connection connection = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionManager.getConnection();
			statement = connection.prepareStatement(GET_RECENT_ORDER);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				orderId = resultSet.getInt("max(or_id)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("Error while getting the bill data.\n" + e.getMessage());
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();

				}
				if (statement != null) {

					statement.close();

				}
				if (connection != null) {

					connection.close();

				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new AppException("Error while the closing connection.\n" + e.getMessage());
			}

		}

		return orderId;
	}

	public void insertBill(Order order) throws AppException {

		PreparedStatement statement = null;
		Connection connection = null;

		try {
			connection = ConnectionManager.getConnection();
			statement = connection.prepareStatement(INSERT_BILL);

			statement.setInt(1, order.getUser().getId());
			Date date = new Date(order.getDate().getTime());
			statement.setDate(2, date);
			statement.setString(3, order.getPatientName());
			statement.setString(4, order.getDoctorName());
			statement.setFloat(5, order.getPrice());
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("Error while inserting bill data.\n" + e.getMessage());
		} finally {
			try {

				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new AppException("Error when closing connection.\n" + e.getMessage());
			}
		}

	}
	
	public void getBill(Order order) throws AppException {

		PreparedStatement statement = null;
		Connection connection = null;

		try {
			connection = ConnectionManager.getConnection();
			statement = connection.prepareStatement(INSERT_BILL);

			statement.setInt(1, order.getUser().getId());
			Date date = new Date(order.getDate().getTime());
			statement.setDate(2, date);
			statement.setString(3, order.getPatientName());
			statement.setString(4, order.getDoctorName());
			statement.setFloat(5, order.getPrice());
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("Error while inserting bill data.\n" + e.getMessage());
		} finally {
			try {

				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new AppException("Error when closing connection.\n" + e.getMessage());
			}
		}

	}
}
