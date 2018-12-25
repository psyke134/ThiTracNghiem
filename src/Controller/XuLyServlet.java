package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import BEAN.NguoiDungBEAN;
import DAO.*;
/**
 * Servlet implementation class XuLyServlet
 */
@WebServlet("/View/XuLyServlet")
public class XuLyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XuLyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String tennut = request.getParameter("tennut");
		String[] nguoidung_id = request.getParameterValues("nguoi_dung_id");
		String nguoidungid = request.getParameter("themNguoiDungid");
		String loainguoidung = request.getParameter("loainguoidung");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String nguoidungid_ = request.getParameter("nguoidung_id");
		
		String thongBao;
		if(tennut.equals("them"))
		{
			boolean themNguoiDung = DAO.XuLyDAO.themNguoiDung(nguoidungid, loainguoidung, username, password);
			if(themNguoiDung == false)
			{
				thongBao = "Lỗi rồi. Vui lòng thử lại";
				request.setAttribute("thongBao", thongBao);
				request.getRequestDispatcher("NguoiDungServlet").forward(request, response);
			}
			if(themNguoiDung == true)
			{
				thongBao= "Đã thêm thành công";
				request.setAttribute("thongBao", thongBao);
				request.getRequestDispatcher("NguoiDungServlet").forward(request, response);
			}
		}
		if(tennut.equals("sua"))
		{
			DAO.XuLyDAO.suaNguoiDung(nguoidungid_, username, password);
			request.getRequestDispatcher("NguoiDungServlet").forward(request, response);
		}
		if(tennut.equals("xoa"))
		{
			for(String nguoi_dung_id : nguoidung_id)
			{
				DAO.XuLyDAO.xoaNguoiDung(nguoi_dung_id);
			}
			request.getRequestDispatcher("NguoiDungServlet").forward(request, response);
		}

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
