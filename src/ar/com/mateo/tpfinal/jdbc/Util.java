package ar.com.mateo.tpfinal.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Util {
	private static Connection c;

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		if (c == null) {
			Class.forName("com.mysql.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/SONY", "root", "root");
		}
		return c;
	}

	public static Statement createStatement() throws ClassNotFoundException, SQLException {
		return getConnection().createStatement();
	}

	public static PreparedStatement prepareStatement(String sql) throws ClassNotFoundException, SQLException {
		return getConnection().prepareStatement(sql);

	}

}
