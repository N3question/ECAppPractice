package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.PublicUserBeans;
import dao.GeneralDao;
import db.ConnectionToDB;
import db.LoadJDBC;

public class SelectAllUserIdModel {
	private static final String SELECT_USERID_SQL = "SELECT user_id FROM public_users";
	public static ArrayList<PublicUserBeans> selectAll() {
		ArrayList<PublicUserBeans> UList = new ArrayList<>();
		ArrayList<Object> paramLists = new ArrayList<Object>() {{ }};
		LoadJDBC.LoadingJDBC();
		try (Connection conn = ConnectionToDB.getConnection()) {
			ResultSet result = GeneralDao.executeQuery(conn, SELECT_USERID_SQL, paramLists);
            
            while (result.next()) {
                int userId = result.getInt("user_id");
                PublicUserBeans IBeans = new PublicUserBeans(userId);
                UList.add(IBeans);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
		return UList;
	}
}
