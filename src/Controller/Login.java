package Controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Connect.DBConnection;
import DAO.LoginDAO;

/**
 * Servlet implementation class Login
 */
@WebServlet("/View/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("txtUsername");
		String password = request.getParameter("txtPassword");
		
		
//		String username = "nd1";
//		String password = "123";
		
		try {
			Connection conn = (Connection) DBConnection.getConn();
			String userId = LoginDAO.getUserId(username, conn);
			String phanQuyen = LoginDAO.LoginUser(username, password, conn);
			if(phanQuyen.equals("ND1"))
			{
				ServletContext context = getServletContext();
				context.setAttribute("username", username);
				context.setAttribute("userId", userId);
				RequestDispatcher rd = request.getRequestDispatcher("SelectExam");
				rd.forward(request, response);
			}
			else if(phanQuyen.equals("ND2"))	//quan ly thi sinh
			{
				ServletContext context = getServletContext();
				context.setAttribute("username", username);
				context.setAttribute("userId", userId);
				RequestDispatcher rd = request.getRequestDispatcher("NguoiDungServlet");
				rd.forward(request, response);
			}
			else if(phanQuyen.equals("ND3"))	//quan ly de
			{
				ServletContext context = getServletContext();
				context.setAttribute("username", username);
				context.setAttribute("userId", userId);
				RequestDispatcher rd = request.getRequestDispatcher("TaoDeThi.jsp");
				rd.forward(request, response);
			}
			else if(phanQuyen.equals("ND4"))	//quan ly cau hoi
			{
				ServletContext context = getServletContext();
				context.setAttribute("username", username);
				context.setAttribute("userId", userId);
				response.sendRedirect("/ThiTracNghiem/CauHoi");
			}
			else
			{
				response.sendRedirect("Login.jsp");
			}
		} catch (Exception e) {	
			e.printStackTrace();	
			throw new ServletException(e);
		}
		response.getWriter().append("ye").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
