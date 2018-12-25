package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ThemDeThiVaoLopServlet
 */
@WebServlet("/View/ThemDeThiVaoLopServlet")
public class ThemDeThiVaoLopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThemDeThiVaoLopServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String madethi= request.getParameter("madethi");
		String malop = request.getParameter("malop");
		List<String> danhsachts = DAO.ThemDeThiVaoLopDAO.danhSachThiSinh(malop);
		
		String thongBao;
		for(String mathisinh : danhsachts)
		{
			 thongBao = DAO.ThemDeThiVaoLopDAO.themDeThiVaoThiSinh(mathisinh, madethi);
			 request.setAttribute("thongBao", thongBao);
		}
		request.getRequestDispatcher("ThemDeThiVaoLop.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
