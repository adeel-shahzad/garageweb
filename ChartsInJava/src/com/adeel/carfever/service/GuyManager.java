package com.adeel.carfever.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GuyManager {

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public boolean saveGuy() throws SQLException {
		try (Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/carfever", "root", "root")) {

		}
		return true;
	}

}
