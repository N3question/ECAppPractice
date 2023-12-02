package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.AdminUserBeans;
import dao.GeneralDao;
import db.ConnectionToDB;
import db.LoadJDBC;
import hash.Hash;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class SelectAdminUserModel {
	private static final String SELECT_ADMIN_USER_SQL = "SELECT * FROM admin_users WHERE admin_name = ? AND admin_password = ?";
	public static void select(String adminName, String adminPassword, HttpServletRequest request) {
		String hashedPassword = Hash.hashingPassword(adminPassword);
		ArrayList<Object> paramLists = new ArrayList<Object>() {
			{ 
				add(adminName);
				add(hashedPassword);
			}
		};
		AdminUserBeans adminBeans = null;
		LoadJDBC.LoadingJDBC();
		try (Connection conn = ConnectionToDB.getConnection()) {
			ResultSet result = GeneralDao.executeQuery(conn, SELECT_ADMIN_USER_SQL, paramLists);
            
			while(result.next()) {
				int admin_id = result.getInt("admin_id");
            	String admin_name = result.getString("admin_name");
            	adminBeans = new AdminUserBeans(admin_id, admin_name);
            }
			
			HttpSession session = request.getSession();
            session.setAttribute("adminBeans", adminBeans);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
	}
}
