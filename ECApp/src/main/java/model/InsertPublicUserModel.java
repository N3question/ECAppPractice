package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.PublicUserBeans;
import dao.GeneralDao;
import db.ConnectionToDB;
import db.LoadJDBC;
import hash.Hash;

public class InsertPublicUserModel {
	private static final String INSERT_USER_SQL = "INSERT INTO public_users (user_name, password) VALUES (?, ?)";
	public static void insert(PublicUserBeans publicUserBeans) {
		String hashedPassword = Hash.hashingPassword(publicUserBeans.getPassword());
		ArrayList<Object> paramLists = new ArrayList<Object>() {
			{ 
				add(publicUserBeans.getUserName());
				add(hashedPassword);
			}
		};
		LoadJDBC.LoadingJDBC();
        try (Connection conn = ConnectionToDB.getConnection()) {
        	GeneralDao.executeUpdate(conn, INSERT_USER_SQL, paramLists);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
	}
}
