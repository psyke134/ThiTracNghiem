package Controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Connection.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BEAN.*;
import DAO.XuLyThiDAO;


/**
 * Servlet implementation class LayChiTietDeThi
 */
@WebServlet("/View/LayChiTietDeThi")
public class LayChiTietDeThi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LayChiTietDeThi() {
        super();
        // TODO Auto-generated constructor stub
    }
    /**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		BaiThiBean baiThi = new BaiThiBean();
		super.init(config);
		ServletContext context = getServletContext();
		context.setAttribute("baiThi", baiThi);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String maBaiThi = request.getParameter("quiz_id");		//quiz_id is an input for this servlet
		String maThiSinh = request.getParameter("candidate_id");		//candidate_id is an inoout for this servlet
		
		ServletContext context = getServletContext();
		BaiThiBean baiThi = (BaiThiBean)context.getAttribute("baiThi");
		
		XuLyThiDAO.layChiTietBaiThi(maBaiThi, maThiSinh, baiThi);
		int thoiLuong = baiThi.getThoiLuong().getHours()*3600 + baiThi.getThoiLuong().getMinutes()*60 + baiThi.getThoiLuong().getSeconds(); 
		request.setAttribute("thoiLuong", thoiLuong);
		request.getRequestDispatcher("ChiTietBaiThi.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
