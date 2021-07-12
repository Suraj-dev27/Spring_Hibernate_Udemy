package com.ssd.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {

		//
		String jdbcUrl = "jdbc:mysql://localhost:3307/hb-01-one-to-one-uni?useSSL=false&serverTimezone=UTC";
		String user = "root";
		String pass = "Suraj@2708$1997";

		try {
			System.out.println("Connecting to database: " + jdbcUrl);

			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);

			System.out.println(myConn);

			/*
			 * PreparedStatement myStmt = myConn.prepareStatement(
			 * "insert into student (first_name, last_name, email) values ('suraj', 'dalvi', 'ssd@gmail.com')"
			 * );
			 * 
			 * myStmt.execute();
			 */
			System.out.println("Connection successful!!!");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
