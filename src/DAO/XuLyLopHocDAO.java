package DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import BEAN.NguoiDungBEAN;
import Connect.DBConnection;

public class XuLyLopHocDAO {

	public static Boolean xoaLopHoc(String ten_lop_hoc) throws ServletException, IOException
	{	
		Connection c = (Connection)DBConnection.getConn();
		String sql = "Delete from lop_hoc where ten_lop_hoc = ?";
		try {
			PreparedStatement prstm = c.prepareStatement(sql);
			prstm.setString(1, ten_lop_hoc);
			prstm.executeUpdate();
			
			if(c!=null) {
				c.close();
			}
			
			return true;
			
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ServletException(e);
		}
	}
	public static Boolean themLopHoc(String ten_lop_hoc) throws ServletException, IOException
	{		
		Connection c = (Connection)DBConnection.getConn();
		String sql = "insert into lop_hoc values(?,?)";
		try {
			PreparedStatement prstm = c.prepareStatement(sql);
			prstm.setString(1, "LH"+ ten_lop_hoc);
			prstm.setString(2, ten_lop_hoc);
			prstm.executeUpdate();
			
			if(c!=null) {
				c.close();
			}
			
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ServletException(e);
		}

	}
	public static List<NguoiDungBEAN> xemChiTietLopHoc(String tenlophoc) throws ServletException, IOException
	{
		Connection c = (Connection)DBConnection.getConn();
		List<NguoiDungBEAN> thisinh = new ArrayList<NguoiDungBEAN>();
		String sql ="select lop_hoc_id from lop_hoc where ten_lop_hoc = ?";
		try {
			PreparedStatement prstm = c.prepareStatement(sql);
			prstm.setString(1,tenlophoc);
			ResultSet rs = prstm.executeQuery();
			
			rs.next();
			String lop_hoc_id = rs.getString("lop_hoc_id");
			
			String sql1 ="select chi_tiet_lop_hoc.nguoi_dung_id,loai_nguoi_dung_id,username,password from chi_tiet_lop_hoc,nguoi_dung where chi_tiet_lop_hoc.nguoi_dung_id = nguoi_dung.nguoi_dung_id and chi_tiet_lop_hoc.lop_hoc_id = ? and nguoi_dung.loai_nguoi_dung_id = 'ND1'";
			PreparedStatement prstm1 = c.prepareStatement(sql1);
			prstm1.setString(1,lop_hoc_id);
			ResultSet rs1 = prstm1.executeQuery();
			
			while(rs1.next())
			{
				NguoiDungBEAN tam = new NguoiDungBEAN();
				String nguoidung_id = rs1.getString("nguoi_dung_id");
				String loai_nguoi_dung_id = rs1.getString("loai_nguoi_dung_id");
				String username = rs1.getString("username");
				String password = rs1.getString("password");
				
				tam.setNguoi_dung_id(nguoidung_id);
				tam.setTen_loai_nguoi_dung(loai_nguoi_dung_id);
				tam.setUsername(username);
				tam.setPassword(password);
				
				thisinh.add(tam);
			}
			return thisinh;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ServletException(e);
		}
	}
	
}
