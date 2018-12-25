package BEAN;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class BaiThiBean {
	private String maBaiThi;
	private String maThiSinh;
	private List<CauHoiEntry> cauHoiEntries = new ArrayList<CauHoiEntry>();
	private Time thoiGianBatDau;
	private Time thoiLuong;
	private Integer cauHoiHienTai;
	private Integer soLuongCauHoi;
	private String tenBaiThi;
	private Date ngayThi;
	
	public BaiThiBean()
	{
		this.tenBaiThi = null;
		this.maBaiThi = null;
		this.maThiSinh = null;
		this.thoiGianBatDau = null;
		this.thoiLuong = null;
		this.cauHoiHienTai = 1;
		this.soLuongCauHoi = 0;
		this.ngayThi = null;
	}

	public String getMaBaiThi() {
		return maBaiThi;
	}

	public void setMaBaiThi(String maBaiThi) {
		this.maBaiThi = maBaiThi;
	}

	public String getMaThiSinh() {
		return maThiSinh;
	}

	public void setMaThiSinh(String maThiSinh) {
		this.maThiSinh = maThiSinh;
	}

	public List<CauHoiEntry> getCauHoiEntries() {
		return cauHoiEntries;
	}

	public void setCauHoiEntries(List<CauHoiEntry> cauHoiEntries) {
		this.cauHoiEntries = cauHoiEntries;
	}

	public Time getThoiGianBatDau() {
		return thoiGianBatDau;
	}

	public void setThoiGianBatDau(Time thoiGianBatDau) {
		this.thoiGianBatDau = thoiGianBatDau;
	}

	public Time getThoiLuong() {
		return thoiLuong;
	}

	public void setThoiLuong(Time thoiLuong) {
		this.thoiLuong = thoiLuong;
	}

	public Integer getCauHoiHienTai() {
		return cauHoiHienTai;
	}

	public void setCauHoiHienTai(Integer cauHoiHienTai) {
		this.cauHoiHienTai = cauHoiHienTai;
	}

	public Integer getSoLuongCauHoi() {
		return soLuongCauHoi;
	}

	public void setSoLuongCauHoi(Integer soLuongCauHoi) {
		this.soLuongCauHoi = soLuongCauHoi;
	}

	public String getTenBaiThi() {
		return tenBaiThi;
	}

	public void setTenBaiThi(String tenBaiThi) {
		this.tenBaiThi = tenBaiThi;
	}

	public Date getNgayThi() {
		return ngayThi;
	}

	public void setNgayThi(Date ngayThi) {
		this.ngayThi = ngayThi;
	}
	
}
