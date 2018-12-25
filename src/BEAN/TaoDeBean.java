package BEAN;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class TaoDeBean {
	private String maDeThi;
	private String tenDeThi;
	private Time thoiLuong;
	private Time thoiGianBatDau;
	private Date ngayKiemTra;
	private List<String> danhSachMaCauHoi = new ArrayList<String>();
	
	public TaoDeBean()
	{
		
	}

	public String getMaDeThi() {
		return maDeThi;
	}

	public void setMaDeThi(String maDeThi) {
		this.maDeThi = maDeThi;
	}

	public String getTenDeThi() {
		return tenDeThi;
	}

	public void setTenDeThi(String tenDeThi) {
		this.tenDeThi = tenDeThi;
	}

	public Time getThoiLuong() {
		return thoiLuong;
	}

	public void setThoiLuong(Time thoiLuong) {
		this.thoiLuong = thoiLuong;
	}

	public Time getThoiGianBatDau() {
		return thoiGianBatDau;
	}

	public void setThoiGianBatDau(Time thoiGianBatDau) {
		this.thoiGianBatDau = thoiGianBatDau;
	}

	public Date getNgayKiemTra() {
		return ngayKiemTra;
	}

	public void setNgayKiemTra(Date ngayKiemTra) {
		this.ngayKiemTra = ngayKiemTra;
	}

	public List<String> getDanhSachMaCauHoi() {
		return danhSachMaCauHoi;
	}

	public void setDanhSachMaCauHoi(List<String> danhSachMaCauHoi) {
		this.danhSachMaCauHoi = danhSachMaCauHoi;
	}
	
}
