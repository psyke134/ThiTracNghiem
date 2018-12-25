package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.cauhoi;
import DAO.cautraloi;
import BEAN.cau_hoi;

@WebServlet("/EditQuestion")
public class Editquestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Editquestion() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		int idcauhoi= Integer.parseInt(request.getParameter("id"));
		boolean testtl=cauhoi.updateQuestion(idcauhoi);
		boolean test =cauhoi.deleteQuestion(idcauhoi);
		if(test)
		{
			request.setAttribute("msgdelete", "Xóa thành công");
			RequestDispatcher rd =request.getRequestDispatcher("CauHoi");
			rd.forward(request, response);
		}
		else
		{
			
			
			request.setAttribute("msgdelete", "Xóa thất bại, kiểm tra lại!");
			RequestDispatcher rd =request.getRequestDispatcher("CauHoi");
			rd.forward(request, response);
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
