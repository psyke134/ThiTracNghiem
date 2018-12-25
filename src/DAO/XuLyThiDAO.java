package DAO;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import BEAN.*;
import Connect.*;

public class XuLyThiDAO {
	public static void layChiTietBaiThi(String maBaiThi, String maThiSinh, BaiThiBean baiThi) throws ServletException, IOException
	{
		Connection c = null;
		List<CauHoiEntry> danhSachCauHoi = new ArrayList<CauHoiEntry>();
		try
		{
			c = DBConnection.getConn();
			String sql = "select * from chi_tiet_de_kt where bai_kiem_tra_id = ?";
			PreparedStatement prstm = c.prepareStatement(sql);
			prstm.setString(1, maBaiThi);
			ResultSet rs = prstm.executeQuery();
			//lay danh sach cau_hoi_id
			while(rs.next())
			{
				CauHoiEntry cauHoi = new CauHoiEntry();
				cauHoi.setMaCauHoi(rs.getString("cau_hoi_id"));
				danhSachCauHoi.add(cauHoi);
			}
			//lay danh sach cau_tra_loi theo tung cau hoi va cau_tra_loi_dung
			for(int i=0;i<danhSachCauHoi.size();i++)
			{
				String maCauHoi;
				List<CauTraLoiEntry> danhSachCauTraLoi = new ArrayList<CauTraLoiEntry>();
				maCauHoi = danhSachCauHoi.get(i).getMaCauHoi();
				sql = "select * from cau_tra_loi where cau_hoi_id = ?";
				prstm = c.prepareStatement(sql);
				prstm.setString(1, maCauHoi);
				rs = prstm.executeQuery();
				//lay danh sach cau_tra_loi
				while(rs.next())
				{
					CauTraLoiEntry cauTraLoi = new CauTraLoiEntry();
					cauTraLoi.setMaCauTraLoi(rs.getString("cau_tra_loi_id"));
					cauTraLoi.setChiTiet(rs.getString("noi_dung"));
					danhSachCauTraLoi.add(cauTraLoi);
				}
				danhSachCauHoi.get(i).setCauTraLoiEntries(danhSachCauTraLoi);
				//lay cau_tra_loi_dung va noi_dung_cau_hoi
				sql = "select * from cau_hoi where cau_hoi_id = ?";
				prstm = c.prepareStatement(sql);
				prstm.setString(1, maCauHoi);
				rs = prstm.executeQuery();
				if(rs.next())
				{
					String maCauTraLoiDung = rs.getString("cau_tra_loi_dung");
					CauTraLoiEntry cauTraLoiDung = new CauTraLoiEntry();
					cauTraLoiDung.setMaCauTraLoi(maCauTraLoiDung);
					String noiDung = rs.getString("noi_dung");
					danhSachCauHoi.get(i).setCauTraLoiDung(cauTraLoiDung);
					danhSachCauHoi.get(i).setChiTiet(noiDung);
				}
			}
			//set quiz properties
			baiThi.setCauHoiEntries(danhSachCauHoi);
			baiThi.setMaBaiThi(maBaiThi);
			baiThi.setMaThiSinh(maThiSinh);
			baiThi.setSoLuongCauHoi(danhSachCauHoi.size());
		
			sql = "select * from bai_kiem_tra where bai_kiem_tra_id = ?";
			prstm = c.prepareStatement(sql);
			prstm.setString(1, maBaiThi);
			rs = prstm.executeQuery();
			if(rs.next())
			{
				String tenBaiKiemTra = rs.getString("ten_bai_kiem_tra");
				Time thoiGianBatDau = rs.getTime("thoi_gian_bat_dau");
				Time thoiLuong = rs.getTime("thoi_luong");
				Date ngayKiemTra = rs.getDate("ngay_kiem_tra");
				baiThi.setTenBaiThi(tenBaiKiemTra);
				baiThi.setThoiGianBatDau(thoiGianBatDau);
				baiThi.setThoiLuong(thoiLuong);
				baiThi.setNgayThi(ngayKiemTra);
			}
		
		}
		catch(SQLException e)
		{
			throw new ServletException(e);
		}
	}
	public static void tinhToanDiem(BaiThiBean baiThi, KetQua ketQua) throws ServletException, IOException, SQLException
	{
		Connection c = null;
		int soCauDung = 0;
		int tongSoCau = baiThi.getSoLuongCauHoi();
		for(int i=0;i<tongSoCau;i++)
		{
			CauHoiEntry cauHoi = baiThi.getCauHoiEntries().get(i);
			if(cauHoi.getCauTraLoiDaChon() != null && cauHoi.getCauTraLoiDaChon().getMaCauTraLoi() != null)
			{
				if(cauHoi.getCauTraLoiDaChon().getMaCauTraLoi().equals(cauHoi.getCauTraLoiDung().getMaCauTraLoi()))
				{
					soCauDung++;
				}
			}
		}
		
		float diem = (float)(soCauDung * 10) / (tongSoCau);
		
		try
		{
			c = DBConnection.getConn();
			String sql = "update chi_tiet_bai_kt set diem = ? where bai_kiem_tra_id = ? and nguoi_dung_id = ?";
			PreparedStatement prstm = c.prepareStatement(sql);
			prstm.setString(1, Float.toString(diem));
			prstm.setString(2, baiThi.getMaBaiThi());
			prstm.setString(3, baiThi.getMaThiSinh());
			prstm.executeUpdate();
		}
		catch(SQLException e)
		{
			throw new ServletException(e);
		}
		finally
		{
			if(c != null)
				c.close();
		}
		ketQua.setDiem(diem);
		ketQua.setSoCauDung(soCauDung);
		ketQua.setTongSoCau(tongSoCau);
	}
}
