package BEAN;

import java.sql.Date;
import java.sql.Time;

public class bai_kiem_tra {
	private String bai_kiem_tra_id;
	private Time thoi_gian_bat_dau;
	private Time thoi_luong;
	private String ten_bai_kiem_tra;
	private Date ngay_kiem_tra;
	public String getBai_kiem_tra_id() {
		return bai_kiem_tra_id;
	}
	public void setBai_kiem_tra_id(String bai_kiem_tra_id) {
		this.bai_kiem_tra_id = bai_kiem_tra_id;
	}
	public Time getThoi_gian_bat_dau() {
		return thoi_gian_bat_dau;
	}
	public void setThoi_gian_bat_dau(Time thoi_gian_bat_dau) {
		this.thoi_gian_bat_dau = thoi_gian_bat_dau;
	}
	public Time getThoi_luong() {
		return thoi_luong;
	}
	public void setThoi_luong(Time thoi_luong) {
		this.thoi_luong = thoi_luong;
	}
	public String getTen_bai_kiem_tra() {
		return ten_bai_kiem_tra;
	}
	public void setTen_bai_kiem_tra(String ten_bai_kiem_tra) {
		this.ten_bai_kiem_tra = ten_bai_kiem_tra;
	}
	public Date getNgay_kiem_tra() {
		return ngay_kiem_tra;
	}
	public void setNgay_kiem_tra(Date ngay_kiem_tra) {
		this.ngay_kiem_tra = ngay_kiem_tra;
	}
	
}
