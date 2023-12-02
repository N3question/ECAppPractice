package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class GeneralDao {
	public static void setParams(PreparedStatement statement, List<Object> params) 
	       throws SQLException {
		for (int i = 0; i < params.size(); i++) {
			statement.setObject(i + 1, params.get(i));
		}
	}
	
	public static ResultSet executeQuery(Connection conn, String sql, List<Object> params) 
		   throws SQLException {
		PreparedStatement statement = conn.prepareStatement(sql);
		setParams(statement, params);
		return statement.executeQuery();
	}
	
	public static void executeUpdate(Connection conn, String sql, List<Object> params)
		   throws SQLException {
		PreparedStatement statement = conn.prepareStatement(sql);
		setParams(statement, params);
		statement.executeUpdate();
	}
}
