package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionToDB {
	private final static String URL = "jdbc:mysql://localhost/EC";
	private final static String USER= "root";
	private final static String PASSWORD = "";
	
	// throwsをつけている場合は呼び出したところでcatchする必要がある
	public static Connection getConnection() throws SQLException {
	    Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);
	    return conn;
	}
}
