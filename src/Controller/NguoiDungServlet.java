package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BEAN.NguoiDungBEAN;
import DAO.*;

/**
 * Servlet implementation class NguoiDungServlet
 */
@WebServlet("/View/NguoiDungServlet")
public class NguoiDungServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NguoiDungServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String thongBao =(String) request.getAttribute("thongBao");
		List<NguoiDungBEAN> nguoidung = DAO.NguoiDungDAO.xemThongTinNguoiDung();
		request.setAttribute("nguoidung", nguoidung);
		request.setAttribute("thongBao", thongBao);
		request.getRequestDispatcher("NguoiDung.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
