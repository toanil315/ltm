package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.SinhVien;

public class SinhVienDAO {
public Connection connect;
	
	public SinhVienDAO() {
		String url = "jdbc:mysql://localhost:3325/test888";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connect = DriverManager.getConnection(url, "root", "");
		}
		catch(Exception e) {
			System.out.println("error: " + e.toString());
		}
	}
	
	public ArrayList<SinhVien> getListSV() {
		ArrayList<SinhVien> listNV = new ArrayList<SinhVien>();
		try {
			String sql = "Select * from sinhvien;";
			Statement statement = connect.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while(result.next()) {
				SinhVien sv = new SinhVien();
				sv.setIdSV(result.getString("IdSV"));
				sv.setHoTen(result.getString("HoTen"));
				sv.setGioiTinh(result.getString("GioiTinh"));
				sv.setIdKhoa(result.getString("IdKhoa"));
				listNV.add(sv);
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return listNV;
	}
	
	public ArrayList<SinhVien> getListSVByKhoa(String idKhoa) {
		ArrayList<SinhVien> listSV = new ArrayList<SinhVien>();
		try {
			String sql = "Select * from sinhvien where IdKhoa=? ;";
			PreparedStatement preStatement = connect.prepareStatement(sql);
			preStatement.setString(1, idKhoa);
			ResultSet result = preStatement.executeQuery();
			while(result.next()) {
				SinhVien nv = new SinhVien();
				nv.setIdSV(result.getString("IdSV"));
				nv.setHoTen(result.getString("HoTen"));
				nv.setGioiTinh(result.getString("GioiTinh"));
				nv.setIdKhoa(result.getString("IdKhoa"));
				listSV.add(nv);
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return listSV;
	}
	
	public SinhVien getSinhVien(String id) {
		SinhVien nv = new SinhVien();
		try {
			String sql = "Select * from sinhvien where IdSV=? ;";
			PreparedStatement preStatement = connect.prepareStatement(sql);
			preStatement.setString(1, id);
			ResultSet result = preStatement.executeQuery();
			while(result.next()) {
				nv.setIdSV(result.getString("IdSV"));
				nv.setHoTen(result.getString("HoTen"));
				nv.setGioiTinh(result.getString("GioiTinh"));
				nv.setIdKhoa(result.getString("IdKhoa"));
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return nv;
	}
	
	public void addSV(String idSV, String hoTen, String gioiTinh, String idKhoa) {
		try {
			String sql = "Insert Into sinhvien(IdSV, HoTen, GioiTinh, IdKhoa) Values(?, ?, ?, ?) ;";
			PreparedStatement preStatement = connect.prepareStatement(sql);
			preStatement.setString(1, idSV);
			preStatement.setString(2, hoTen);
			preStatement.setString(3, gioiTinh);
			preStatement.setString(4, idKhoa);
			preStatement.executeUpdate();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void updateSV(String idSV, String hoTen, String gioiTinh, String idKhoa) {
		try {
			String sql = "Update sinhvien Set HoTen = ?, GioiTinh = ?, IdKhoa = ? Where IdSV = ?  ;";
			PreparedStatement preStatement = connect.prepareStatement(sql);
			preStatement.setString(1, hoTen);
			preStatement.setString(2, gioiTinh);
			preStatement.setString(3, idKhoa);
			preStatement.setString(4, idSV);
			preStatement.executeUpdate();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void deleteSV(String id) {
		try {
			String sql = "Delete From sinhvien Where IdSV = ? ;";
			PreparedStatement preStatement = connect.prepareStatement(sql);
			preStatement.setString(1, id);
			preStatement.executeUpdate();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
