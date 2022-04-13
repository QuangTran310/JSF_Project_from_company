package com.demo.resources.accessing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ResourcesAccessing {
	
	private static final String URL = "jdbc:postgresql://localhost:5432/demo";

	private static final String USER = "postgres";

	private static final String PASSWORD = "31101997";
	
	private Connection c;
	
	public Connection getConnection() {
		try {
			c = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
}
