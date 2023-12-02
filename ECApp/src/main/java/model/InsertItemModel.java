package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.GeneralDao;
import db.ConnectionToDB;
import db.LoadJDBC;

public class InsertItemModel {
	private static final String INSERT_ITEM_SQL = "INSERT INTO items (item_name, price, file_name, category_id, sales_status) VALUES (?, ?, ?, ?, ?)";
	public static void insert(String itemName, int price, String filename, int categoryId, boolean salesStatus) {
		ArrayList<Object> paramLists = new ArrayList<Object>() {
			{ 
				add(itemName);
				add(price);
				add(filename);
				add(categoryId);
				add(salesStatus);
			}
		};
		LoadJDBC.LoadingJDBC();
        try (Connection conn = ConnectionToDB.getConnection()) {
        	GeneralDao.executeUpdate(conn, INSERT_ITEM_SQL, paramLists);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
	}
}
