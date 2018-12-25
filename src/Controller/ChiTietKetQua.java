package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BEAN.*;
import DAO.*;

/**
 * Servlet implementation class ChiTietKetQua
 */
@WebServlet("/View/ChiTietKetQua")
public class ChiTietKetQua extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChiTietKetQua() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext context = getServletContext();
		BaiThiBean quiz = (BaiThiBean)context.getAttribute("baiThi");
		KetQua ketQua = new KetQua();
		
		try {
			XuLyThiDAO.tinhToanDiem(quiz, ketQua);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("diem", Float.toString(ketQua.getDiem()));
		request.setAttribute("soCauDung", Integer.toString(ketQua.getSoCauDung()));
		request.setAttribute("tongSoCau", Integer.toString(ketQua.getTongSoCau()));
		request.getRequestDispatcher("ChiTietKetQua.jsp").forward(request, response);
		quiz = new BaiThiBean();		//reset quiz bean
		context.removeAttribute("baiThi");
		context.setAttribute("baiThi", quiz);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
