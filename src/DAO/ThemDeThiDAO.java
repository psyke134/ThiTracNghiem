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

public class ThemDeThiDAO {
	public static List<String> layDanhSachMaCauHoi(String loaiDe, String loaiTrungBinh, String loaiKho) throws ServletException, IOException
	{
		List<String> danhSach = new ArrayList<String>();
		
		Connection c = null;
		try
		{
			c = DBConnection.getConn();
			List<String> danhSachCauHoiDe = new ArrayList<String>();
			List<String> danhSachCauHoiTrungBinh = new ArrayList<String>();
			List<String> danhSachCauHoiKho = new ArrayList<String>();

			//-------------lay danh sach cac cau hoi theo loai--------------------
			
			String sql = "select cau_hoi_id, cau_hoi.loai_cau_hoi_id "
					+ "from cau_hoi, loai_cau_hoi "
					+ "where cau_hoi.loai_cau_hoi_id = loai_cau_hoi.loai_cau_hoi_id and loai_cau_hoi.ten_loai_cau_hoi = ?";
			//lay cau hoi de
			PreparedStatement prstm = c.prepareStatement(sql);
			prstm.setString(1, "de");
			ResultSet rs = prstm.executeQuery();
			while(rs.next())
			{
				String maCauHoi = null;
				maCauHoi = rs.getString("cau_hoi_id");
				danhSachCauHoiDe.add(maCauHoi);
			}
			//lay cau hoi trung binh
			prstm = c.prepareStatement(sql);
			prstm.setString(1, "trung binh");
			rs = prstm.executeQuery();
			rs.beforeFirst();
			while(rs.next())
			{
				String maCauHoi = null;
				maCauHoi = rs.getString("cau_hoi_id");
				danhSachCauHoiTrungBinh.add(maCauHoi);
			}
			//lay cau hoi kho
			prstm = c.prepareStatement(sql);
			prstm.setString(1, "kho");
			rs = prstm.executeQuery();
			rs.beforeFirst();
			while(rs.next())
			{
				String maCauHoi = null;
				maCauHoi = rs.getString("cau_hoi_id");
				danhSachCauHoiKho.add(maCauHoi);
			}
			//--------------lay ngau nhien cac cau hoi-----------------
			int soCauDe = Integer.parseInt(loaiDe);
			int soCauTrungBinh = Integer.parseInt(loaiTrungBinh);
			int soCauKho = Integer.parseInt(loaiKho);
			
			//lay ngau nhien cau hoi
			layNgauNhienCauHoi(danhSachCauHoiDe, danhSach, soCauDe);
			layNgauNhienCauHoi(danhSachCauHoiTrungBinh, danhSach, soCauTrungBinh);
			layNgauNhienCauHoi(danhSachCauHoiKho, danhSach, soCauKho);
			
			if(c != null)
			{
				c.close();
			}
			return danhSach;
		}
		catch(SQLException e)
		{
			throw new ServletException(e);
		}
	}
	private static void layNgauNhienCauHoi(List<String> danhSachCauHoiTheoLoai, List<String> danhSachCauHoiChung, 
			int soLuongCauHoi)
	{
		List<Integer> existedRand = new ArrayList<Integer>();
		for(int i = 0; i < soLuongCauHoi; i++)
		{
			int rand = (int)(Math.random()*(soLuongCauHoi-1));
			while(existedRand.contains(rand))
			{
				rand = (int)(Math.random()*(soLuongCauHoi));
				//lay random nhung so chua xuat hien
			}
			danhSachCauHoiChung.add(danhSachCauHoiTheoLoai.get(rand));
			existedRand.add(rand);
		}
	}
	public static String themDeThi(TaoDeBean de) throws ServletException, IOException
	{
		Connection c = null;
		try
		{
			c = DBConnection.getConn();
			
			String sql = "insert into bai_kiem_tra values(?, ?, ?, ?, ?)";
			PreparedStatement prstm = c.prepareStatement(sql);
			prstm.setString(1, de.getMaDeThi());
			prstm.setTime(2, de.getThoiGianBatDau());
			prstm.setTime(3, de.getThoiLuong());
			prstm.setString(4, de.getTenDeThi());
			prstm.setDate(5, de.getNgayKiemTra());
			prstm.executeUpdate();
			
			for(int i=0; i < de.getDanhSachMaCauHoi().size(); i++)
			{
				sql = "insert into chi_tiet_de_kt values(?, ?)";
				prstm = c.prepareStatement(sql);
				prstm.setString(1, de.getMaDeThi());
				prstm.setString(2, de.getDanhSachMaCauHoi().get(i));
				prstm.executeUpdate();
			}
			
			if(c != null)
			{
				c.close();
			}
			
			return "thanh cong";
		}
		catch(SQLException e)
		{
			return "that bai";
		}
	}
}
