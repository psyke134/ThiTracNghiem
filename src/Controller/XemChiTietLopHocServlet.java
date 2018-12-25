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
 * Servlet implementation class XemChiTietLopHocServlet
 */
@WebServlet("/View/XemChiTietLopHocServlet")
public class XemChiTietLopHocServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XemChiTietLopHocServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String tenlophoc =(String) request.getAttribute("tenlophoc");
		List<NguoiDungBEAN> thisinh = DAO.XuLyLopHocDAO.xemChiTietLopHoc(tenlophoc);
		request.setAttribute("thisinh", thisinh);
		request.setAttribute("tenlophoc", tenlophoc);
		request.getRequestDispatcher("XemChiTietThiSinh.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
