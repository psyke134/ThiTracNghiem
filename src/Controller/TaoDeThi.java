package Controller;

import java.io.IOException;
import java.sql.Time;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BEAN.*;
import DAO.*;

/**
 * Servlet implementation class TaoDeThi
 */
@WebServlet("/View/TaoDeThi")
public class TaoDeThi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaoDeThi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String maDeThi = request.getParameter("maDeThi");
		String tenDeThi = request.getParameter("tenDeThi");
		String thoiLuong = request.getParameter("thoiLuong");
		String gio = request.getParameter("gio");
		String phut = request.getParameter("phut");
		String ngay = request.getParameter("ngay");
		String thang = request.getParameter("thang");
		String nam = request.getParameter("nam");
		String loaiDe = request.getParameter("loaiDe");
		String loaiTrungBinh = request.getParameter("loaiTrungBinh");
		String loaiKho = request.getParameter("loaiKho");
		
		List<String> danhSachMaCauHoi = ThemDeThiDAO.layDanhSachMaCauHoi(loaiDe, loaiTrungBinh, loaiKho);
		
		Time thoiGianLamBai = FormatDAO.minutesToTime(Integer.parseInt(thoiLuong));
		Time thoiGianBatDau = FormatDAO.timeCombination(Integer.parseInt(gio), Integer.parseInt(phut));
		Date ngayKiemTra = FormatDAO.dateCombination(Integer.parseInt(ngay), Integer.parseInt(thang), Integer.parseInt(nam));
		
		TaoDeBean de = new TaoDeBean();
		de.setMaDeThi(maDeThi);
		de.setTenDeThi(tenDeThi);
		de.setThoiLuong(thoiGianLamBai);
		de.setThoiGianBatDau(thoiGianBatDau);
		de.setNgayKiemTra(ngayKiemTra);
		de.setDanhSachMaCauHoi(danhSachMaCauHoi);
		
		String resultMsg = ThemDeThiDAO.themDeThi(de);
		
		request.setAttribute("resultMsg", resultMsg);
		request.getRequestDispatcher("TaoDeThi.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
