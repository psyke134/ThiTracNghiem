package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BEAN.Exam;
import Connect.DBConnection;
import DAO.ExamDAO;

/**
 * Servlet implementation class SelectExam
 */
@WebServlet("/View/SelectExam")
public class SelectExam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SelectExam() {
        super();
    }
    public void init(ServletConfig config) throws ServletException {	
		super.init(config);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();
		String userId = (String)context.getAttribute("userId");
//		response.getWriter().println(userId);
		try {
			Connection conn = (Connection) DBConnection.getConn();
			List<Exam> listExams = ExamDAO.selectExam(userId, conn);
			List<Exam> listDoneExams = ExamDAO.selectDoneExam(userId, conn);
			
			request.setAttribute("listDoneExams", listDoneExams);
			request.setAttribute("listExams", listExams); 
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/View/SelectExam.jsp");
			rd.forward(request, response);
		
		} catch (Exception e) {	
			e.printStackTrace();	
			throw new ServletException(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
