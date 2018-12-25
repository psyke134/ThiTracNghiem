package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BEAN.NguoiDungBEAN;

/**
 * Servlet implementation class XuLyChiTietLopHocServlet
 */
@WebServlet("/View/XuLyChiTietLopHocServlet")
public class XuLyChiTietLopHocServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XuLyChiTietLopHocServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tenlophoc = request.getParameter("tenlophoc");
		String tennut = request.getParameter("tennut");
		String nguoi_dung_id = request.getParameter("mathisinh");

		String malophoc = DAO.XuLyChiTietLopHocDAO.layMalopHoc(tenlophoc);
		List<NguoiDungBEAN> danhsachts = DAO.XuLyChiTietLopHocDAO.xemThiSinhChuaVaoLop(malophoc);
		
		if(tennut.equals("xoa"))
		{
			DAO.XuLyChiTietLopHocDAO.xoaThiSinh(nguoi_dung_id, tenlophoc);
			request.setAttribute("tenlophoc", tenlophoc);
			request.getRequestDispatcher("XemChiTietLopHocServlet").forward(request, response);

		}
		if(tennut.equals("them"))
		{
			request.setAttribute("tenlophoc", tenlophoc);
			request.setAttribute("malophoc", malophoc);
			request.setAttribute("danhsachts", danhsachts);
			request.getRequestDispatcher("ThemThiSinh.jsp").forward(request, response);
		}
		if(tennut.equals("thoat"))
		{
			request.getRequestDispatcher("LopHocServlet").forward(request, response);
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
