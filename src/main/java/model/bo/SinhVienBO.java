package model.bo;

import java.util.ArrayList;

import model.bean.SinhVien;
import model.dao.SinhVienDAO;

public class SinhVienBO {
	SinhVienDAO sinhVienDAO = new SinhVienDAO();
	public ArrayList<SinhVien> getListSV() {
		return sinhVienDAO.getListSV();
	}
	
	public ArrayList<SinhVien> getListSVByKhoa(String idKhoa) {
		return sinhVienDAO.getListSVByKhoa(idKhoa);
	}
	
	public SinhVien getSinhVien(String id) {
		return sinhVienDAO.getSinhVien(id);
	}
	
	public void addSV(String idSV, String hoTen, String gioiTinh, String idKhoa) {
		sinhVienDAO.addSV(idSV, hoTen, gioiTinh, idKhoa);
	}
	
	public void updateSV(String idSV, String hoTen, String gioiTinh, String idKhoa) {
		sinhVienDAO.updateSV(idSV, hoTen, gioiTinh, idKhoa);
	}
	
	public void deleteSV(String id) {
		sinhVienDAO.deleteSV(id);
	}
}
