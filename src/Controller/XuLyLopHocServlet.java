package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class XuLyLopHocServlet
 */
@WebServlet("/View/XuLyLopHocServlet")
public class XuLyLopHocServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XuLyLopHocServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String tenlophoc = request.getParameter("tenlophoc");
		String tennut = request.getParameter("tennut");
		String ten_lop_hoc = request.getParameter("ten_lop_hoc");
		
		if(tennut.equals("xoa"))
		{
			DAO.XuLyLopHocDAO.xoaLopHoc(tenlophoc);
			request.getRequestDispatcher("LopHocServlet").forward(request, response);
		}
		if(tennut.equals("them"))
		{
			DAO.XuLyLopHocDAO.themLopHoc(ten_lop_hoc);
			request.getRequestDispatcher("LopHocServlet").forward(request, response);
		}
		if(tennut.equals("xemchitiet"))
		{
			request.setAttribute("tenlophoc", tenlophoc);
			request.getRequestDispatcher("XemChiTietLopHocServlet").forward(request, response);
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
