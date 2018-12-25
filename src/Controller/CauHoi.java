package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BEAN.cau_hoi;
import DAO.cauhoi;


@WebServlet("/CauHoi")
public class CauHoi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CauHoi() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<cau_hoi> listCauHoi=cauhoi.getListCauhoi();
		request.setAttribute("listCauHoi", listCauHoi);
		RequestDispatcher rd =request.getRequestDispatcher("Homepage.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stu
		doGet(request, response);
	}

}
