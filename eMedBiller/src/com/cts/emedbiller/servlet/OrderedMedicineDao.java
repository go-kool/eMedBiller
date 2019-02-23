package com.cts.emedbiller.servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.cts.emedbiller.bean.AppException;
import com.cts.emedbiller.dao.ConnectionManager;

public class OrderedMedicineDao {
	public static final String INSERT_ORDERED_MEDICNES = "insert into medicalshop.orderedmedicines (om_or_id,om_md_id,om_units) values(?,?,?)";

	public void insertOrderedMeds(int medId, int units, int order_id) throws AppException {
		PreparedStatement statement = null;
		Connection connection = null;

		try {
			connection = ConnectionManager.getConnection();
			statement = connection.prepareStatement(INSERT_ORDERED_MEDICNES);
			statement.setInt(1, order_id);
			statement.setInt(2, medId);
			statement.setInt(3, units);
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
