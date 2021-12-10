package model.bo;

import model.dao.AdminDAO;

public class AdminBO {
	AdminDAO adminDAO = new AdminDAO();
	
	public boolean checkLogin(String userName, String password) {
		return adminDAO.checkLogin(userName, password);
	}
	
}
