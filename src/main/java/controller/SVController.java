package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Khoa;
import model.bean.SinhVien;
import model.bo.KhoaBO;
import model.bo.SinhVienBO;


@WebServlet("/SVController")
public class SVController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mode = request.getParameter("mode");
		String action = request.getParameter("action");
		SinhVienBO sinhVienBO = new SinhVienBO();
		KhoaBO khoaBO = new KhoaBO();
		HttpSession session=request.getSession(false);  
		String status = (String)session.getAttribute("status");
		if(mode != null) {
			switch (mode) {
				case "show": {
					ArrayList<SinhVien> listSV = sinhVienBO.getListSV();
					ArrayList<Khoa> listKhoa = khoaBO.getListKhoa();
					request.setAttribute("listSV", listSV);
					request.setAttribute("listKhoa", listKhoa);
					String destination = "/ListSV.jsp";
					RequestDispatcher dispatch = getServletContext().getRequestDispatcher(destination);
					dispatch.forward(request, response);
					return;
				}
				case "viewListSV": {
					String idKhoa = request.getParameter("idKhoa");
					ArrayList<SinhVien> listSV = sinhVienBO.getListSVByKhoa(idKhoa);
					ArrayList<Khoa> listKhoa = khoaBO.getListKhoa();
					request.setAttribute("listSV", listSV);
					request.setAttribute("listKhoa", listKhoa);
					String destination = "/ListSV.jsp";
					RequestDispatcher dispatch = getServletContext().getRequestDispatcher(destination);
					dispatch.forward(request, response);
					return;
				}
				case "add": {
					String destination = null;
					if(status != null && status.equals("logined")) {
						destination = "/AddSV.jsp";
					}
					else destination = "/Login.jsp";
					RequestDispatcher dispatch = getServletContext().getRequestDispatcher(destination);
					dispatch.forward(request, response);
					return;
				}
				case "update": {
					String destination = null;
					if(status != null && status.equals("logined")) {
						String idUpdate = request.getParameter("idUpdate");
						SinhVien nv = sinhVienBO.getSinhVien(idUpdate); 
						request.setAttribute("svUpdate", nv);
						destination = "/UpdateSV.jsp";
					}
					else destination = "/Login.jsp";
					RequestDispatcher dispatch = getServletContext().getRequestDispatcher(destination);
					dispatch.forward(request, response);
					return;
				}
				case "delete": {
					String destination = null;
					if(status != null && status.equals("logined")) {
						String idDelete = request.getParameter("idDelete");
						SinhVien nv = sinhVienBO.getSinhVien(idDelete); 
						request.setAttribute("svDelete", nv);
						destination = "/DeleteSV.jsp";
					}
					else destination = "/Login.jsp";
					RequestDispatcher dispatch = getServletContext().getRequestDispatcher(destination);
					dispatch.forward(request, response);
					return;
				}
				case "search": {
					String destination = "/SearchNV.jsp";
					RequestDispatcher dispatch = getServletContext().getRequestDispatcher(destination);
					dispatch.forward(request, response);
					return;
				}
			}
		}
		if(action != null) {
			switch (action) {
			case "add": {
				String idSV = request.getParameter("idSV");
				String hoten = request.getParameter("hoten");
				String gioitinh = request.getParameter("gioitinh");
				String idKhoa = request.getParameter("idKhoa");
				sinhVienBO.addSV(idSV, hoten, gioitinh, idKhoa);
				String destination = "/SVController?mode=show";
				RequestDispatcher dispatch = getServletContext().getRequestDispatcher(destination);
				dispatch.forward(request, response);
				return;
			}
			case "update": {
				String idSV = request.getParameter("idSV");
				String hoten = request.getParameter("hoten");
				String gioitinh = request.getParameter("gioitinh");
				String idKhoa = request.getParameter("idKhoa");
				sinhVienBO.updateSV(idSV, hoten, gioitinh, idKhoa);
				String destination = "/SVController?mode=show";
				RequestDispatcher dispatch = getServletContext().getRequestDispatcher(destination);
				dispatch.forward(request, response);
				return;
			}
			case "delete": {
				String destination = null;
				if(status != null && status.equals("logined")) {
					String idDelete = request.getParameter("idDelete");
					sinhVienBO.deleteSV(idDelete);
					destination = "/SVController?mode=show";
				}
				else destination = "/Login.jsp";
				RequestDispatcher dispatch = getServletContext().getRequestDispatcher(destination);
				dispatch.forward(request, response);
				return;
			}
			
			case "showNvInPB": {
				
			}
			
			}
			
		}
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

