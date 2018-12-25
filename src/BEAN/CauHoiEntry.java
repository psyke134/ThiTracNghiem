package BEAN;
import java.util.ArrayList;
import java.util.List;

public class CauHoiEntry {
	private String maCauHoi;
	private List<CauTraLoiEntry> cauTraLoiEntries = new ArrayList<CauTraLoiEntry>();
	private CauTraLoiEntry cauTraLoiDung = new CauTraLoiEntry();
	private CauTraLoiEntry cauTraLoiDaChon = new CauTraLoiEntry();
	private String chiTiet;
	
	public CauHoiEntry()
	{
		
	}

	public String getMaCauHoi() {
		return maCauHoi;
	}

	public void setMaCauHoi(String maCauHoi) {
		this.maCauHoi = maCauHoi;
	}

	public List<CauTraLoiEntry> getCauTraLoiEntries() {
		return cauTraLoiEntries;
	}

	public void setCauTraLoiEntries(List<CauTraLoiEntry> cauTraLoiEntries) {
		this.cauTraLoiEntries = cauTraLoiEntries;
	}

	public CauTraLoiEntry getCauTraLoiDung() {
		return cauTraLoiDung;
	}

	public void setCauTraLoiDung(CauTraLoiEntry cauTraLoiDung) {
		this.cauTraLoiDung = cauTraLoiDung;
	}

	public CauTraLoiEntry getCauTraLoiDaChon() {
		return cauTraLoiDaChon;
	}

	public void setCauTraLoiDaChon(CauTraLoiEntry cauTraLoiDaChon) {
		this.cauTraLoiDaChon = cauTraLoiDaChon;
	}

	public String getChiTiet() {
		return chiTiet;
	}

	public void setChiTiet(String chiTiet) {
		this.chiTiet = chiTiet;
	}
	
}
