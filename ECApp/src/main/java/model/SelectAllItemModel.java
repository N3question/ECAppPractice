package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.ItemBeans;
import dao.GeneralDao;
import db.ConnectionToDB;
import db.LoadJDBC;

public class SelectAllItemModel {
	private static final String SELECT_ITEM_SQL = "SELECT items.*, c.category_name FROM items JOIN categories AS c ON items.category_id = c.category_id";
	public static ArrayList<ItemBeans> selectAll() {
		ArrayList<ItemBeans> IList = new ArrayList<>();
		ArrayList<Object> paramLists = new ArrayList<Object>() {{ }};
		LoadJDBC.LoadingJDBC();
		try (Connection conn = ConnectionToDB.getConnection()) {
			ResultSet result = GeneralDao.executeQuery(conn, SELECT_ITEM_SQL, paramLists);
            
            while (result.next()) {
                int itemId = result.getInt("item_id");
                String itemName = result.getString("item_name");
                int price = result.getInt("price");
                String fileName = result.getString("file_name");
                int categoryId = result.getInt("category_id");
                String categoryName = result.getString("category_name");
                boolean salesStatus = result.getBoolean("sales_status");
                
                ItemBeans IBeans = new ItemBeans(itemId, itemName, price, fileName, categoryId, categoryName, salesStatus);
                IList.add(IBeans);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
		return IList;
	}
}
