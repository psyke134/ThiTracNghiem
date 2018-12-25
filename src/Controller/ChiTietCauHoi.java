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

/**
 * Servlet implementation class questionDetail
 */
@WebServlet("/View/ChiTietCauHoi")
public class ChiTietCauHoi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChiTietCauHoi() {
        super();
        // TODO Auto-generated constructor stub
    }
    /**
	 * @see Servlet#init(ServletConfig)
	 */
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
		BaiThiBean baiThi = (BaiThiBean)context.getAttribute("baiThi");
		//neu nhu da den cau cuoi ma user con bam "next" thi ket thuc bai kiem tra
		//this servlet recieve param from questionDetail.jsp
		if(request.getParameter("previous_question") != null)
		{
			int temp = Integer.parseInt(request.getParameter("previous_question"));
			CauTraLoiEntry chosenAnswer = new CauTraLoiEntry();
			String maCauTraLoi = request.getParameter("chosen_answer");
			chosenAnswer.setMaCauTraLoi(maCauTraLoi);
			baiThi.getCauHoiEntries().get(temp - 1).setCauTraLoiDaChon(chosenAnswer);
		}
		if(request.getParameter("current_question") != null)
		{
			int temp = Integer.parseInt(request.getParameter("current_question"));
			if(temp > 0 && temp <= baiThi.getSoLuongCauHoi())
			{
				baiThi.setCauHoiHienTai(temp);
			}
		}
		if(request.getParameter("current_question") != null)
		{
			if(Integer.parseInt(request.getParameter("current_question")) > baiThi.getSoLuongCauHoi())
			{
				response.sendRedirect("XacNhanKetThucBai.jsp");
				return;
			}
		}
		List<CauHoiEntry> questionEntries = baiThi.getCauHoiEntries();
		int currentQuestion = baiThi.getCauHoiHienTai();
		CauHoiEntry questionDetail = questionEntries.get(currentQuestion - 1);
		request.setAttribute("questionDetail", questionDetail);
		request.setAttribute("thoiLuong", request.getParameter("thoiLuog"));
		request.getRequestDispatcher("ChiTietCauHoi.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
