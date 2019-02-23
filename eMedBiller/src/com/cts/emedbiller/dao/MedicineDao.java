package com.cts.emedbiller.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.cts.emedbiller.bean.AppException;
import com.cts.emedbiller.bean.Item;
import com.cts.emedbiller.bean.Medicine;

public class MedicineDao {
	public static final String GET_ALL_MEDICINES = "select * from medicine, item where medicine.md_it_id = item.it_id";
	public static final String SEARCH_MEDICINE = "select * from medicine,item where medicine.md_it_id=item.it_id and medicine.md_name=?";
	public static final String ADD_MEDICINES = "INSERT INTO medicalshop.medicine (md_name, md_cp, md_sp, md_it_id, md_items, md_strips, md_quantity) VALUES (?, ?, ?, ?, ?, ?, ?)";
	public static final String GET_MEDICINE = "select * from medicine,item where medicine.md_it_id=item.it_id and medicine.md_id=?";
	public static final String UPDATE_MEDICINE = "UPDATE medicalshop.medicine SET md_name=?, md_cp=?, md_sp=?, md_it_id=?, md_items=?, md_strips=?, md_quantity=? WHERE md_id=?";
	

	public ArrayList<Medicine> getMedicine(String search) throws AppException {
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		Connection connection = null;
		Medicine medicine = null;
		Item item = null;
		ArrayList<Medicine> medicines = new ArrayList<Medicine>();

		try {
			connection = ConnectionManager.getConnection();
			statement = connection.prepareStatement(SEARCH_MEDICINE);
			statement.setString(1, search);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				medicine = new Medicine();
				medicine.setId(resultSet.getInt("md_id"));
				medicine.setName(resultSet.getString("md_name"));
				medicine.setCostPrice(resultSet.getFloat("md_cp"));
				medicine.setSellingPrice(resultSet.getFloat("md_sp"));
				medicine.setItemsPerStrip(resultSet.getInt("md_items"));
				medicine.setStrips(resultSet.getInt("md_strips"));
				medicine.setQuantity(resultSet.getInt("md_quantity"));
				item = new Item();
				item.setId(resultSet.getInt("it_id"));
				item.setType(resultSet.getString("it_type"));
				medicine.setItem(item);
				medicines.add(medicine);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("Error while getting medicines data.\n" + e.getMessage());
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
		return medicines;
	}

	public void insertMedicine(Medicine medicine) throws AppException {

		PreparedStatement statement = null;
		Connection connection = null;

		try {
			connection = ConnectionManager.getConnection();
			statement = connection.prepareStatement(ADD_MEDICINES);
			statement.setString(1, medicine.getName());
			statement.setFloat(2, medicine.getCostPrice());
			statement.setFloat(3, medicine.getSellingPrice());
			statement.setInt(4, medicine.getItem().getId());
			statement.setInt(5, medicine.getItemsPerStrip());
			statement.setInt(6, medicine.getStrips());
			statement.setInt(7, medicine.getQuantity());
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("Error while inserting medicine data.\n" + e.getMessage());
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

	public ArrayList<Medicine> getMedicines() throws AppException {
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		Connection connection = null;
		Medicine medicine = null;
		Item item = null;
		ArrayList<Medicine> medicines = new ArrayList<Medicine>();

		try {
			connection = ConnectionManager.getConnection();
			statement = connection.prepareStatement(GET_ALL_MEDICINES);

			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				medicine = new Medicine();
				medicine.setId(resultSet.getInt("md_id"));
				medicine.setName(resultSet.getString("md_name"));
				medicine.setCostPrice(resultSet.getFloat("md_cp"));
				medicine.setSellingPrice(resultSet.getFloat("md_sp"));
				medicine.setItemsPerStrip(resultSet.getInt("md_items"));
				medicine.setStrips(resultSet.getInt("md_strips"));
				medicine.setQuantity(resultSet.getInt("md_quantity"));
				item = new Item();
				item.setId(resultSet.getInt("it_id"));
				item.setType(resultSet.getString("it_type"));
				medicine.setItem(item);
				medicines.add(medicine);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("Error while getting medicines data.\n" + e.getMessage());
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
		return medicines;
	}

	public Medicine getMedicine(int id) throws AppException {
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		Connection connection = null;
		Medicine medicine = null;
		Item item = null;
		try {
			connection = ConnectionManager.getConnection();
			statement = connection.prepareStatement(GET_MEDICINE);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				medicine = new Medicine();
				medicine.setId(resultSet.getInt("md_id"));
				medicine.setName(resultSet.getString("md_name"));
				medicine.setCostPrice(resultSet.getFloat("md_cp"));
				medicine.setSellingPrice(resultSet.getFloat("md_sp"));
				medicine.setItemsPerStrip(resultSet.getInt("md_items"));
				medicine.setStrips(resultSet.getInt("md_strips"));
				medicine.setQuantity(resultSet.getInt("md_quantity"));
				item = new Item();
				item.setId(resultSet.getInt("it_id"));
				item.setType(resultSet.getString("it_type"));
				medicine.setItem(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("Error while getting medicines data.\n" + e.getMessage());
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
		return medicine;
	}

	public void updateMedicine(Medicine medicine) throws AppException {
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = ConnectionManager.getConnection();
			statement = connection.prepareStatement(UPDATE_MEDICINE);
			statement.setString(1, medicine.getName());
			statement.setFloat(2, medicine.getCostPrice());
			statement.setFloat(3, medicine.getSellingPrice());
			statement.setInt(4, medicine.getItem().getId());
			statement.setInt(5, medicine.getItemsPerStrip());
			statement.setInt(6, medicine.getStrips());
			statement.setInt(7, medicine.getQuantity());
			statement.setInt(8, medicine.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("Error when updating medicine. " + e.getMessage());
		} finally {
			try {

				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new AppException("Error when closing connection. " + e.getMessage());
			}
		}
	}

	
}