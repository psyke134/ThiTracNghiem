package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import BEAN.cau_hoi;
import BEAN.cau_tra_loi;
import Connect.connection;

public class cauhoi {
	public static boolean insertCauHoi(cau_hoi ch)
	 {
		    Connection conn=null;
		    connection kn=new connection();
			conn=kn.CreateConnection();
	        String sql = "insert into cau_hoi value(?,?,?,?)";
	        try {
	        	PreparedStatement ptmt=conn.prepareStatement(sql);
	        	ptmt.setString(1, ch.getCau_hoi_id());
	        	ptmt.setString(2, ch.getCau_tra_loi_dung());
	        	ptmt.setString(3, ch.getNoi_dung());
	        	ptmt.setString(4, ch.getLoai_cau_hoi_id());
	            return ptmt.executeUpdate() == 1;
	        } catch (SQLException ex) {
	        }
	        return false;
	}
	public static ArrayList<cau_hoi> getListCauhoi() {
		ArrayList<cau_hoi> list = new ArrayList<>();
		try {
			String sql = "SELECT cau_hoi.cau_hoi_id, cau_hoi.noi_dung,loai_cau_hoi_id, cau_tra_loi.noi_dung\r\n"
					+ "FROM cau_hoi, cau_tra_loi\r\n" + "WHERE cau_hoi.cau_tra_loi_dung= cau_tra_loi.cau_tra_loi_id";
			PreparedStatement ps = connection.CreateConnection().prepareCall(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				cau_hoi ch = new cau_hoi();
				ch.setCau_hoi_id(rs.getString("cau_hoi.cau_hoi_id"));
				ch.setNoi_dung(rs.getString("cau_hoi.noi_dung"));
				ch.setCau_tra_loi_dung(rs.getString("cau_tra_loi.noi_dung"));
				ch.setLoai_cau_hoi_id(rs.getString("loai_cau_hoi_id"));
				list.add(ch);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static cau_hoi getcauhoi_byid(int id) {
		cau_hoi ch = new cau_hoi();
		try {
			String sql = "SELECT cau_hoi.cau_hoi_id, cau_hoi.noi_dung,cau_hoi.loai_cau_hoi_id, cau_tra_loi.noi_dung, loai_cau_hoi.ten_loai_cau_hoi\r\n" + 
					"FROM cau_hoi, cau_tra_loi, loai_cau_hoi\r\n" + 
					"WHERE cau_hoi.cau_tra_loi_dung= cau_tra_loi.cau_tra_loi_id \r\n" + 
					"and cau_hoi.loai_cau_hoi_id=loai_cau_hoi.loai_cau_hoi_id and cau_hoi.cau_hoi_id= ?";
			PreparedStatement ps = connection.CreateConnection().prepareCall(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ch.setTen_loai_cau_hoi(rs.getString("loai_cau_hoi.ten_loai_cau_hoi"));
				ch.setCau_hoi_id(rs.getString("cau_hoi.cau_hoi_id"));
				ch.setNoi_dung(rs.getString("cau_hoi.noi_dung"));
				ch.setCau_tra_loi_dung(rs.getString("cau_tra_loi.noi_dung"));
				ch.setLoai_cau_hoi_id(rs.getString("loai_cau_hoi_id"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ch;
	}
	
	

	public static boolean deleteQuestion(int id) {
		//Connection conn = connection.CreateConnection();
		String sql ="delete from cau_hoi where cau_hoi_id= ?";
		try {
			//PreparedStatement ptmt = conn.prepareStatement(sql);
			PreparedStatement ptmt = connection.CreateConnection().prepareCall(sql);
			ptmt.setInt(1, id);
			return ptmt.executeUpdate() == 1;
		} catch (SQLException ex) {
			Logger.getLogger(cautraloi.class.getName()).log(Level.SEVERE, null, ex);
		}
		return false;
	}
	public static int checkIDCauHoiMax()
	{
		Connection conn=null;
	    connection kn=new connection();
		conn=kn.CreateConnection();
		String sql="select fn_timIDCauHoiMax()";
		int result = 0;
		try {
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			
			while(rs.next())
			{
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static boolean updateQuestion(int id) {
		Connection conn = connection.CreateConnection();
		String sql = "UPDATE cau_tra_loi SET cau_hoi_id = NULL WHERE (cau_hoi_id = ?)";
		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			//PreparedStatement ptmt = connection.CreateConnection().prepareCall(sql);
			ptmt.setInt(1, id);
			return ptmt.executeUpdate() == 1;
		} catch (SQLException ex) {
			Logger.getLogger(cautraloi.class.getName()).log(Level.SEVERE, null, ex);
		}
		return false;
	}
	
	public static boolean insertlistcautraloi (cau_tra_loi ctl) {
		Connection conn= connection.CreateConnection();
		
		String sql="insert into cau_tra_loi(cau_tra_loi_id,noi_dung) value(?,?)";
		try {
			PreparedStatement ptmt= conn.prepareStatement(sql);
			ptmt.setString(1, ctl.getCau_hoi_id());
			ptmt.setString(2, ctl.getNoi_dung());
			
			return ptmt.executeUpdate()==1;
		}catch (SQLException ex) {
			ex.getErrorCode();
		}
		return false;
	}
	public static boolean updateCH(String cau_tra_loi_dung, String noi_dung, String loai_cau_hoi_id, String cau_hoi_id)
	 {
		Connection conn=null;
	    connection kn=new connection();
		conn=kn.CreateConnection();
	        String sql = "update cau_hoi set cau_tra_loi_dung=?,noi_dung=?,loai_cau_hoi_id=? where cau_hoi_id=?";
	        try {
	        	PreparedStatement ptmt=conn.prepareStatement(sql);
	        	ptmt.setString(1, cau_tra_loi_dung);
	        	ptmt.setString(2, noi_dung);
	        	ptmt.setString(3, loai_cau_hoi_id);
	        	ptmt.setString(4, cau_hoi_id);
	            return ptmt.executeUpdate() == 1;
	        } catch (SQLException ex) {
	        }
	        return false;
	}
	public static void main(String[] args) throws SQLException {
		cau_tra_loi ctl= new cau_tra_loi();
		ctl.setCau_tra_loi_id("66");
		ctl.setNoi_dung("Tím Tím");
		boolean test= cauhoi.insertlistcautraloi(ctl);
		

		ArrayList<cau_tra_loi> list = cautraloi.getListCautl();
		for(cau_tra_loi CH:list)
		{
			System.out.println(CH.getCau_tra_loi_id()+" "+ CH.getCau_hoi_id()+ " "+ CH.getNoi_dung());
		}
		
		/*ArrayList<cau_hoi> ch1= cauhoi.getListCauhoi();
		for(cau_hoi CH:ch1)
		{
			System.out.println(CH.getNoi_dung());
		}*/
		
		/*boolean testtl = cauhoi.updateQuestion(1);
		if (testtl) {
			System.out.println("update thất bại");
		} else {
			
			System.out.println("update thành công !");
		}*/
		
		
		/*boolean test = cauhoi.deleteQuestion(1);
		if (test) {
			System.out.println("Xóa thành công !");
		} else {
			System.out.println("Xóa thất bại");
		}*/
		
		
		
		
		/*ArrayList<cau_hoi> ch2= cauhoi.getListCauhoi();
		for(cau_hoi CH:ch2)
		{
			System.out.println(CH.getNoi_dung()+" "+CH.getCau_tra_loi_dung()+" "+CH.getTen_loai_cau_hoi());
		}*/
		
		
		
		
		
	}

}
