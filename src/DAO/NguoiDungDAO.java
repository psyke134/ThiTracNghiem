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
import Connect.*;

public class NguoiDungDAO {

	public static List<NguoiDungBEAN> xemThongTinNguoiDung() throws ServletException, IOException
	{
		Connection c = (Connection)DBConnection.getConn();
		List<NguoiDungBEAN> nguoidung = new ArrayList<NguoiDungBEAN>();
		String sql = "Select * from nguoi_dung,loai_nguoi_dung where nguoi_dung.loai_nguoi_dung_id = loai_nguoi_dung.loai_nguoi_dung_id ";
		try {
			PreparedStatement prstm = c.prepareStatement(sql);
			ResultSet rs = prstm.executeQuery();
			while(rs.next())
			{
				NguoiDungBEAN tam = new NguoiDungBEAN();
				String nguoidung_id = rs.getString("nguoi_dung_id");
				String ten_loai_nguoi_dung = rs.getString("ten_loai_nguoi_dung");
				String username = rs.getString("username");
				String password = rs.getString("password");
				
				tam.setNguoi_dung_id(nguoidung_id);
				tam.setTen_loai_nguoi_dung(ten_loai_nguoi_dung);
				tam.setUsername(username);
				tam.setPassword(password);
				
				nguoidung.add(tam);
			}
			
			if(c!=null) {
				c.close();
			}
			return nguoidung;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ServletException(e);
		}	
	}
}
