package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ThemThiSinhServlet
 */
@WebServlet("/View/ThemThiSinhServlet")
public class ThemThiSinhServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThemThiSinhServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String tennut = request.getParameter("tennut");
		String[] thi_sinh_id = request.getParameterValues("nguoi_dung_id");
		String tenlophoc = request.getParameter("tenlophoc");
		String malophoc = DAO.XuLyChiTietLopHocDAO.layMalopHoc(tenlophoc);
		
		if(tennut.equals("them"))
		{
			for(String mathisinh : thi_sinh_id)
			{
				DAO.XuLyChiTietLopHocDAO.themThiSinh(mathisinh, malophoc);
			}
		}
		if(tennut.equals("huy"))
		{
			
		}
		request.setAttribute("tenlophoc", tenlophoc);
		request.getRequestDispatcher("XemChiTietLopHocServlet").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
