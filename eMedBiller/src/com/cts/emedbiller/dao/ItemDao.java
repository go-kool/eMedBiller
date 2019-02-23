package com.cts.emedbiller.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cts.emedbiller.bean.AppException;
import com.cts.emedbiller.bean.Item;

public class ItemDao {
	public static final String GET_ALL_ITEMS = "SELECT * FROM medicalshop.item";

	public ArrayList<Item> getItems() throws AppException {
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		Connection connection = null;

		ArrayList<Item> items = new ArrayList<Item>();
		Item item = null;
		try {
			connection = ConnectionManager.getConnection();
			statement = connection.prepareStatement(GET_ALL_ITEMS);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				item = new Item();
				item.setId(resultSet.getInt("it_id"));
				item.setType(resultSet.getString("it_type"));
				items.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("Error while getting items data.\n" + e.getMessage());
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
				throw new AppException("Error when closing connection.\n" + e.getMessage());
			}
		}
		return items;
	}

}
