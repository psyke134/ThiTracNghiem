package DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import BEAN.*;
import Connect.*;

public class LopHocDAO {

	public static List<LopHocBEAN> xemThongTinLopHoc() throws ServletException, IOException
	{
		Connection c = (Connection)DBConnection.getConn();
		List<LopHocBEAN> lophoc = new ArrayList<LopHocBEAN>();
		String sql = "Select ten_lop_hoc from lop_hoc";
		try {
			PreparedStatement prstm = c.prepareStatement(sql);
			ResultSet rs = prstm.executeQuery();
			while(rs.next())
			{
				LopHocBEAN tam = new LopHocBEAN();
				String ten_lop_hoc = rs.getString("ten_lop_hoc");
				
				tam.setTen_lop_hoc(ten_lop_hoc);
				
				lophoc.add(tam);
			}
			if(c!=null) {
				c.close();
			}
			
			return lophoc;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ServletException(e);
		}
	}
	
}
