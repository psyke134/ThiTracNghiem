package BEAN;

public class NguoiDungBEAN {

	private String nguoi_dung_id;
	private String ten_loai_nguoi_dung;
	private String username;
	private String password;
	
	public String getNguoi_dung_id() {
		return nguoi_dung_id;
	}
	public void setNguoi_dung_id(String nguoi_dung_id) {
		this.nguoi_dung_id = nguoi_dung_id;
	}
	public String getTen_loai_nguoi_dung() {
		return ten_loai_nguoi_dung;
	}
	public void setTen_loai_nguoi_dung(String ten_loai_nguoi_dung) {
		this.ten_loai_nguoi_dung = ten_loai_nguoi_dung;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public NguoiDungBEAN()
	{
		
	}
	public NguoiDungBEAN(String nguoi_dung_id,String ten_loai_nguoi_dung,String username,String password)
	{
		this.nguoi_dung_id = nguoi_dung_id;
		this.ten_loai_nguoi_dung = ten_loai_nguoi_dung;
		this.username = username;
		this.password = password;
	}
}
