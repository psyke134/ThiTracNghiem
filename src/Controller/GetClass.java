package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import DAO.ClassDAO;
import DAO.ExamDAO;
import BEAN.Class;
import BEAN.Exam;
import Connect.DBConnection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetClass
 */
@WebServlet("/View/GetClass")
public class GetClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetClass() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init(ServletConfig config) throws ServletException {	
		super.init(config);
	}
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext context = getServletContext();
		String userId = context.getAttribute("userId").toString();
		try {
			Connection conn = (Connection) DBConnection.getConn();
			List<Class> listClass = ClassDAO.getClass(userId, conn);
			
			request.setAttribute("listClass", listClass);
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/View/ClassList.jsp");
			rd.forward(request, response);
		
		} catch (Exception e) {	
			e.printStackTrace();	
			throw new ServletException(e);
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
