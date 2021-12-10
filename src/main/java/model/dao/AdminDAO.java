package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAO {
	public Connection connect;
	
	public AdminDAO() {
		String url = "jdbc:mysql://localhost:3325/dulieu";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connect = DriverManager.getConnection(url, "root", "");
		}
		catch(Exception e) {
			System.out.println("error: " + e.toString());
		}
	}
	
	public boolean checkLogin(String userName, String password) {
		try {
			String sql = "Select * from admin where UserName=? and Password=?";
			PreparedStatement preparedStatement = connect.prepareStatement(sql);
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, password);
			ResultSet result = preparedStatement.executeQuery();
			if(result.next()) {
				return true;
			}
			else {
				return false;
			}
			
		}	
		catch(SQLException e) {
			System.out.println("error: " + e.toString());
		}
		catch(Exception e) {
			System.out.println("error: " + e.toString());
		}
		return false;
	}
}

