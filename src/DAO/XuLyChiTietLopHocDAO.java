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

public class XuLyChiTietLopHocDAO {

	public static Boolean xoaThiSinh(String nguoi_dung_id, String tenlophoc) throws ServletException, IOException
	{
		Connection c = (Connection)DBConnection.getConn();
		String sql = "select lop_hoc_id from lop_hoc where ten_lop_hoc = ?";
		try {
			PreparedStatement prstm = c.prepareStatement(sql);
			prstm.setString(1,tenlophoc);
			ResultSet rs = prstm.executeQuery();
			
			rs.next();
			String lop_hoc_id = rs.getString("lop_hoc_id");
			
			String sql1 ="Delete from chi_tiet_lop_hoc where nguoi_dung_id = ? and lop_hoc_id = ?";
			PreparedStatement prstm1 = c.prepareStatement(sql1);
			prstm1.setString(1,nguoi_dung_id);
			prstm1.setString(2,lop_hoc_id);
			prstm1.executeUpdate();
			
			if(c!=null) {
				c.close();
			}
			
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ServletException(e);
		}
	}
	public static List<NguoiDungBEAN> xemThiSinhChuaVaoLop(String malophoc) throws ServletException, IOException
	{
		
		Connection c = (Connection)DBConnection.getConn();
		List<NguoiDungBEAN> danhsachts = new ArrayList<NguoiDungBEAN>();
		String sql = "select lop_hoc_id,nguoi_dung.nguoi_dung_id,username,password from chi_tiet_lop_hoc right join nguoi_dung on chi_tiet_lop_hoc.nguoi_dung_id = nguoi_dung.nguoi_dung_id and chi_tiet_lop_hoc.lop_hoc_id = ? where nguoi_dung.loai_nguoi_dung_id = 'ND1'";
		
		try {
			PreparedStatement prstm = c.prepareStatement(sql);
			prstm.setString(1,malophoc);
			ResultSet rs = prstm.executeQuery();
			
			while(rs.next())
			{
				NguoiDungBEAN tam = new NguoiDungBEAN();
				String nguoidung_id = rs.getString("nguoi_dung_id");
				String ten_loai_nguoi_dung = rs.getString("lop_hoc_id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				
				tam.setNguoi_dung_id(nguoidung_id);
				tam.setTen_loai_nguoi_dung(ten_loai_nguoi_dung);
				tam.setUsername(username);
				tam.setPassword(password);
				
				danhsachts.add(tam);
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
	
	public static String layMalopHoc(String tenlophoc) throws ServletException, IOException
	{
		Connection c = (Connection)DBConnection.getConn();
		String sql = "select lop_hoc_id from lop_hoc where ten_lop_hoc = ?";
		try {
			PreparedStatement prstm = c.prepareStatement(sql);
			prstm.setString(1,tenlophoc);
			ResultSet rs = prstm.executeQuery();
			
			rs.next();
			String lop_hoc_id = rs.getString("lop_hoc_id");
			
			if(c!=null) {
				c.close();
			}
			return lop_hoc_id;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ServletException(e);
		}
	}
	public static Boolean themThiSinh(String mathisinh, String malophoc ) throws ServletException, IOException
	{
		Connection c = (Connection)DBConnection.getConn();
		String sql = "Insert into chi_tiet_lop_hoc values(?,?)";
		try {
			PreparedStatement prstm = c.prepareStatement(sql);
			prstm.setString(1,malophoc);
			prstm.setString(2,mathisinh);
			
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
	
}
