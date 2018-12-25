package BEAN;

public class cau_tra_loi {
	private String cau_tra_loi_id;
	private String cau_hoi_id;
	private String noi_dung;
	public cau_tra_loi(String cau_tra_loi_id, String cau_hoi_id, String noi_dung) {
		super();
		this.cau_tra_loi_id = cau_tra_loi_id;
		this.cau_hoi_id = cau_hoi_id;
		this.noi_dung = noi_dung;
	}
	public cau_tra_loi()
	{
		
	}
	public String getCau_tra_loi_id() {
		return cau_tra_loi_id;
	}
	public void setCau_tra_loi_id(String cau_tra_loi_id) {
		this.cau_tra_loi_id = cau_tra_loi_id;
	}
	public String getCau_hoi_id() {
		return cau_hoi_id;
	}
	public void setCau_hoi_id(String cau_hoi_id) {
		this.cau_hoi_id = cau_hoi_id;
	}
	public String getNoi_dung() {
		return noi_dung;
	}
	public void setNoi_dung(String noi_dung) {
		this.noi_dung = noi_dung;
	}
	
}
