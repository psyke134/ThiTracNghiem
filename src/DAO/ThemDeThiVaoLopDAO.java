package DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import Connect.DBConnection;

public class ThemDeThiVaoLopDAO {

	public static List<String> danhSachThiSinh(String malop) throws ServletException, IOException
	{
		Connection c = (Connection)DBConnection.getConn();
		List<String> danhsachts = new ArrayList<String>();
		//tim tat ca sinh thi sinh trong lop
		String sql = "Select * from chi_tiet_lop_hoc where lop_hoc_id = ?";
		try {
			PreparedStatement prstm = c.prepareStatement(sql);
			prstm.setString(1,malop);
			ResultSet rs = prstm.executeQuery();
			
			while(rs.next())
			{
				String mathisinh = rs.getString("nguoi_dung_id");
				
				danhsachts.add(mathisinh);
			}
			
			if(c!=null) {
				c.close();
			}
			return danhsachts;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ServletException(e);
		}
	}
	
	public static String themDeThiVaoThiSinh(String mathisinh, String madethi) throws ServletException, IOException
	{
		Connection c = (Connection)DBConnection.getConn();
		String sql = "insert into chi_tiet_bai_kt value(?,?,null) ";
		try {
			PreparedStatement prstm = c.prepareStatement(sql);
			prstm.setString(1,madethi);
			prstm.setString(2,mathisinh);
			prstm.executeUpdate();
			
			if(c!=null) {
				c.close();
			}
			return "thanh cong";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return "that bai";
		}
	
	}
	
}
