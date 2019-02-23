package com.cts.emedbiller.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cts.emedbiller.bean.AppException;
import com.cts.emedbiller.bean.User;

public class UserDao {
	public User getUser(String userName) throws AppException {
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		Connection connection = null;
		User user = null;

		try {
			connection = ConnectionManager.getConnection();
			String query = "select * from user where us_username=?";
			statement = connection.prepareStatement(query);
			statement.setString(1, userName);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				user = new User();
				user.setId(resultSet.getInt("us_id"));
				user.setUserName(resultSet.getString("us_username"));
				user.setPassword(resultSet.getString("us_password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("Error when getting user data.\n" + e.getMessage());
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
		return user;
	}

}
