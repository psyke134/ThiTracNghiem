package DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;

import Connect.DBConnection;

public class XuLyDAO {

	public static Boolean xoaNguoiDung(String nguoi_dung_id) throws ServletException, IOException
	{
		Connection c = (Connection)DBConnection.getConn();
		String sql = "Delete from nguoi_dung where nguoi_dung_id = ?";
		try {
			PreparedStatement prstm = c.prepareStatement(sql);
			prstm.setString(1, nguoi_dung_id);
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
	public static Boolean themNguoiDung(String nguoi_dung_id, String loai_nguoi_dung_id, String username, String password) throws ServletException, IOException
	{
		Connection c = (Connection)DBConnection.getConn();
		String sql = "insert into nguoi_dung values(?,?,?,?)";
		try {
			PreparedStatement prstm = c.prepareStatement(sql);
			prstm.setString(1, nguoi_dung_id);
			prstm.setString(2, loai_nguoi_dung_id);
			prstm.setString(3, username);
			prstm.setString(4, password);
			prstm.executeUpdate();
			
			if(c!=null) {
				c.close();
			}
			
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
	}
	public static Boolean suaNguoiDung(String nguoi_dung_id, String username, String password) throws ServletException, IOException
	{
		Connection c = (Connection)DBConnection.getConn();
		String sql = "Update nguoi_dung set username=?,password=? where nguoi_dung_id=?";
		try {
			PreparedStatement prstm = c.prepareStatement(sql);			
			prstm.setString(1, username);
			prstm.setString(2, password);
			prstm.setString(3, nguoi_dung_id);
			prstm.executeUpdate();
			
			if(c!=null) {
				c.close();
			}
			
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
	}
	
	
}
