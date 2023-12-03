package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.ItemBeans;
import dao.GeneralDao;
import db.ConnectionToDB;
import db.LoadJDBC;

public class SelectItemModel {
	private static final String SELECT_ITEM_SQL = "SELECT * FROM items WHERE item_id = ?";
	public static ItemBeans select(int itemId) {
		ArrayList<Object> paramLists = new ArrayList<Object>() {
			{ 
				add(itemId);
			}
		};
		LoadJDBC.LoadingJDBC();
		ItemBeans IBeans = null;
		try (Connection conn = ConnectionToDB.getConnection()) {
			ResultSet result = GeneralDao.executeQuery(conn, SELECT_ITEM_SQL, paramLists);
            
			while(result.next()) {
				int item_id = result.getInt("item_id");
				String item_name = result.getString("item_name");
				int price = result.getInt("price");
				String file_name = result.getString("file_name");
				int category_id = result.getInt("category_id");
				String category_name = result.getString("category_name");
				boolean sales_status = result.getBoolean("sales_status");
				IBeans = new ItemBeans(item_id, item_name, price, file_name, category_id, category_name, sales_status);
            }
			
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
		return IBeans;
	}
}
