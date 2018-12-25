package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BEAN.cau_hoi;
import BEAN.cau_tra_loi;
import DAO.cauhoi;
import DAO.cautraloi;


@WebServlet("/InsertQuestion")
public class InsertQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public InsertQuestion() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String macauhoi=String.valueOf(cauhoi.checkIDCauHoiMax()+1);
		//System.out.println(macauhoi);
		int idcautraloi=cautraloi.checkIDCauTraLoiMax();
		String mucdo=request.getParameter("mucdoid");
		String noidungcauhoi=request.getParameter("noidungcauhoi");
		
		String dapana=request.getParameter("dapana");
		String madapana=String.valueOf(idcautraloi+1);
		cautraloi.insertCauTraLoi(madapana,dapana);
		
		String dapanb=request.getParameter("dapanb");
		String madapanb=String.valueOf(idcautraloi+2);
		cautraloi.insertCauTraLoi(madapanb,dapanb);
		
		String dapanc=request.getParameter("dapanc");
		String madapanc=String.valueOf(idcautraloi+3);
		cautraloi.insertCauTraLoi(madapanc,dapanc);
		
		String dapand=request.getParameter("dapand");
		String madapand=String.valueOf(idcautraloi+4);
		cautraloi.insertCauTraLoi(madapand,dapand);
		String idctl="";
		String macautraloidung=request.getParameter("da");
		if(macautraloidung.equals("A"))
		{
			idctl=madapana;
		}
		else if(macautraloidung.equals("B"))
		{
			idctl=madapanb;
		}
		else if(macautraloidung.equals("C"))
		{
			idctl=madapanc;
		}
		else if(macautraloidung.equals("D"))
		{
			idctl=madapand;
		}
		cau_hoi y=new cau_hoi(macauhoi,idctl,noidungcauhoi,mucdo);
		cauhoi.insertCauHoi(y);
		cautraloi.updateCauTraLoi(macauhoi, madapana);
		cautraloi.updateCauTraLoi(macauhoi, madapanb);
		cautraloi.updateCauTraLoi(macauhoi, madapanc);
		cautraloi.updateCauTraLoi(macauhoi, madapand);
		
		RequestDispatcher rd =request.getRequestDispatcher("Homepage.jsp");
		rd.forward(request, response);
		
		
		
		
	}

}
