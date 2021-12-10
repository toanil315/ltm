package model.bo;

import java.util.ArrayList;

import model.bean.Khoa;
import model.dao.KhoaDAO;

public class KhoaBO {
	KhoaDAO khoaDAO = new KhoaDAO();
	public ArrayList<Khoa> getListKhoa() {
		return khoaDAO.getListKhoa();
	}
}
