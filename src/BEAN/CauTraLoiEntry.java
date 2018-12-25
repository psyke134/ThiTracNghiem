package BEAN;

public class CauTraLoiEntry {
	private String maCauTraLoi;
	private String chiTiet;
	
	public CauTraLoiEntry()
	{
		maCauTraLoi = null;
		chiTiet = null;
	}
	public CauTraLoiEntry(String maCauTraLoi, String chiTiet)
	{
		this.maCauTraLoi = maCauTraLoi;
		this.chiTiet = chiTiet;
	}
	public String getMaCauTraLoi() {
		return maCauTraLoi;
	}
	public void setMaCauTraLoi(String maCauTraLoi) {
		this.maCauTraLoi = maCauTraLoi;
	}
	public String getChiTiet() {
		return chiTiet;
	}
	public void setChiTiet(String chiTiet) {
		this.chiTiet = chiTiet;
	}
	
}
