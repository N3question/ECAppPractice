package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.CategoryBeans;
import dao.GeneralDao;
import db.ConnectionToDB;
import db.LoadJDBC;

public class SelectCategoryModel {
	private static final String SELECT_CATEGORY_SQL = "SELECT * FROM categories";
	public static ArrayList<CategoryBeans> selectAll() {
		ArrayList<CategoryBeans> CList = new ArrayList<>();
		ArrayList<Object> paramLists = new ArrayList<Object>() {{ }};
		LoadJDBC.LoadingJDBC();
		try (Connection conn = ConnectionToDB.getConnection()) {
			ResultSet result = GeneralDao.executeQuery(conn, SELECT_CATEGORY_SQL, paramLists);
            
            while (result.next()) {
                int categoryId = result.getInt("category_id");
                String categoryName = result.getString("category_name");
                
                CategoryBeans CBeans = new CategoryBeans(categoryId, categoryName);
                CList.add(CBeans);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
		return CList;
	}
}
