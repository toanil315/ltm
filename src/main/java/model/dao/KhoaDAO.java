package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.Khoa;
import model.bean.SinhVien;

public class KhoaDAO {
	public Connection connect;
	public KhoaDAO() {
		String url = "jdbc:mysql://localhost:3325/test888";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connect = DriverManager.getConnection(url, "root", "");
		}
		catch(Exception e) {
			System.out.println("error: " + e.toString());
		}
	}
	
	public ArrayList<Khoa> getListKhoa() {
		ArrayList<Khoa> listKhoa = new ArrayList<Khoa>();
		try {
			String sql = "Select * from khoa;";
			Statement statement = connect.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while(result.next()) {
				Khoa khoa = new Khoa();
				khoa.setIdKhoa(result.getString("IdKhoa"));
				khoa.setTenKhoa(result.getString("TenKhoa"));
				listKhoa.add(khoa);
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return listKhoa;
	}
}
