package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.If;

import model.bo.AdminBO;

@WebServlet("/AdminController")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mode = request.getParameter("mode");
		String action = request.getParameter("action");
		AdminBO adminBO = new AdminBO();
		if(action != null) {
			switch (action) {
				case "login": {
					String userName = request.getParameter("userName");
					String password = request.getParameter("password");
					String destination = "/Login.jsp";
					String error = "tai khoan hoac mat khau khong dung!!!";
					if(adminBO.checkLogin(userName, password)) {
						String temp = "logined";
						HttpSession session = request.getSession();
						session.setAttribute("status", temp);
						destination = "/SVController?mode=show";	
						error = null;
					}
					request.setAttribute("error", error);
					RequestDispatcher dispatch = getServletContext().getRequestDispatcher(destination);
					dispatch.forward(request, response);
					return;
				}
			}
		}
	}
}

