package BEAN;

public class cau_hoi {
	private String cau_hoi_id;
	private String cau_tra_loi_dung;
	private String noi_dung;
	private String loai_cau_hoi_id;
	private String ten_loai_cau_hoi;
	public cau_hoi(String cau_hoi_id, String cau_tra_loi_dung, String noi_dung, String loai_cau_hoi_id) {
		super();
		this.cau_hoi_id = cau_hoi_id;
		this.cau_tra_loi_dung = cau_tra_loi_dung;
		this.noi_dung = noi_dung;
		this.loai_cau_hoi_id = loai_cau_hoi_id;
		//this.ten_loai_cau_hoi = ten_loai_cau_hoi;
	}
	public cau_hoi()
	{
		
	}
	public String getTen_loai_cau_hoi() {
		return ten_loai_cau_hoi;
	}
	public void setTen_loai_cau_hoi(String ten_loai_cau_hoi) {
		this.ten_loai_cau_hoi = ten_loai_cau_hoi;
	}
	public String getCau_hoi_id() {
		return cau_hoi_id;
	}
	public void setCau_hoi_id(String cau_hoi_id) {
		this.cau_hoi_id = cau_hoi_id;
	}
	public String getCau_tra_loi_dung() {
		return cau_tra_loi_dung;
	}
	public void setCau_tra_loi_dung(String cau_tra_loi_dung) {
		this.cau_tra_loi_dung = cau_tra_loi_dung;
	}
	public String getNoi_dung() {
		return noi_dung;
	}
	public void setNoi_dung(String noi_dung) {
		this.noi_dung = noi_dung;
	}
	public String getLoai_cau_hoi_id() {
		return loai_cau_hoi_id;
	}
	public void setLoai_cau_hoi_id(String loai_cau_hoi_id) {
		this.loai_cau_hoi_id = loai_cau_hoi_id;
	}
	
}
