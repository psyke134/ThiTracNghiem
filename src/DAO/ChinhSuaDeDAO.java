package DAO;
import Connect.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import BEAN.*;

public class ChinhSuaDeDAO {
	public static List<DeThiEntry> layDanhSachDe() throws ServletException, IOException
	{
		List<DeThiEntry> deThiEntries = new ArrayList<DeThiEntry>();
		Connection c = null;
		try
		{
			c = DBConnection.getConn();
			String sql = "SELECT bai_kiem_tra.bai_kiem_tra_id, bai_kiem_tra.ten_bai_kiem_tra, count(cau_hoi_id) as so_luong_cau_hoi "
					+ "from chi_tiet_de_kt, bai_kiem_tra "
					+ "where chi_tiet_de_kt.bai_kiem_tra_id = bai_kiem_tra.bai_kiem_tra_id "
					+ "group by chi_tiet_de_kt.bai_kiem_tra_id";
			PreparedStatement prstm = c.prepareStatement(sql);
			ResultSet rs = prstm.executeQuery();
			while(rs.next())
			{
				DeThiEntry deThiEntry = new DeThiEntry();
				deThiEntry.setMaDeThi(rs.getString("bai_kiem_tra_id"));
				deThiEntry.setTenDeThi(rs.getString("ten_bai_kiem_tra"));
				deThiEntry.setSoLuongCauHoi(rs.getInt("so_luong_cau_hoi"));
				deThiEntries.add(deThiEntry);
			}
			
			if(c != null)
				c.close();
			
			return deThiEntries;
		}
		catch(SQLException e)
		{
			throw new ServletException(e);
		}
	}
}
