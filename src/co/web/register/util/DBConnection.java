package co.web.register.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

	static String driver = "com.mysql.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/votingsystem";
	static String username = "root";
	static String password = "admin";

	static Connection connection = null;

	private static void getConnection() {
		try {

			Class.forName(driver);

			connection = DriverManager.getConnection(url, username, password);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public static Connection getInstance() {

		if (connection == null) {
			getConnection();

		}

		return connection;
	}
	
	public static void closeConnection(Connection conn, Statement stmnt, ResultSet rs) {

		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		if (stmnt != null) {
			try {
				stmnt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		
	}
}
