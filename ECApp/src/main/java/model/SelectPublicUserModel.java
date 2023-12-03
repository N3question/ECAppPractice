package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.PublicUserBeans;
import dao.GeneralDao;
import db.ConnectionToDB;
import db.LoadJDBC;
import hash.Hash;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class SelectPublicUserModel {
	private static final String SELECT_PUBLIC_USER_SQL = "SELECT * FROM public_users WHERE user_name = ? AND password = ?";
	public static void select(String userName, String userPassword, HttpServletRequest request) {
		String hashedPassword = Hash.hashingPassword(userPassword);
		ArrayList<Object> paramLists = new ArrayList<Object>() {
			{ 
				add(userName);
				add(hashedPassword);
			}
		};
		PublicUserBeans PUBeans = null;
		LoadJDBC.LoadingJDBC();
		try (Connection conn = ConnectionToDB.getConnection()) {
			ResultSet result = GeneralDao.executeQuery(conn, SELECT_PUBLIC_USER_SQL, paramLists);
            
			while(result.next()) {
				int user_id = result.getInt("user_id");
				String user_name = result.getString("user_name");
            	PUBeans = new PublicUserBeans(user_id, user_name);
            }
			
			HttpSession session = request.getSession();
            session.setAttribute("PUBeans", PUBeans);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
	}
}
