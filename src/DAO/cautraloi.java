package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;

import Connect.connection;
import BEAN.cau_hoi;
import BEAN.cau_tra_loi;
public class cautraloi {
	public static ArrayList<cau_tra_loi> getListCautl() {
		ArrayList<cau_tra_loi> list = new ArrayList<>();
		try {
			String sql = "SELECT * FROM cau_tra_loi;";
			PreparedStatement ps = connection.CreateConnection().prepareCall(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				cau_tra_loi ctl = new cau_tra_loi();
				ctl.setCau_hoi_id(rs.getString("cau_hoi_id"));
				ctl.setNoi_dung(rs.getString("noi_dung"));
				ctl.setCau_tra_loi_id(rs.getString("cau_tra_loi_id"));
				list.add(ctl);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public static int checkIDCauTraLoiMax()
	{
		Connection conn=null;
	    connection kn=new connection();
		conn=kn.CreateConnection();
		String sql="select fn_timIDMax()";
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
	public static boolean insertCauTraLoi(String idctl,String nd)
	 {
		    Connection conn=null;
		    connection kn=new connection();
			conn=kn.CreateConnection();
	        String sql = "insert into cau_tra_loi(cau_tra_loi_id,noi_dung) value(?,?);";
	        try {
	        	PreparedStatement ptmt=conn.prepareStatement(sql);
	        	ptmt.setString(1, idctl);
	        	ptmt.setString(2, nd);
	            return ptmt.executeUpdate() == 1;
	        } catch (SQLException ex) {
	        }
	        return false;
	}
	public static boolean updateCauTraLoi(String cauhoiid, String cautraloiid)
	 {
		Connection conn=null;
	    connection kn=new connection();
		conn=kn.CreateConnection();
	        String sql = "update cau_tra_loi set cau_hoi_id=? where cau_tra_loi_id=?";
	        try {
	        	PreparedStatement ptmt=conn.prepareStatement(sql);
	        	ptmt.setString(1, cauhoiid);
	        	ptmt.setString(2, cautraloiid);
	            return ptmt.executeUpdate() == 1;
	        } catch (SQLException ex) {
	        }
	        return false;
	}
	public static boolean updateCTL(String cauhoiid, String noidung)
	 {
		Connection conn=null;
	    connection kn=new connection();
		conn=kn.CreateConnection();
	        String sql = "update cau_tra_loi set noi_dung=? where cau_hoi_id=?";
	        try {
	        	PreparedStatement ptmt=conn.prepareStatement(sql);
	        	ptmt.setString(1, cauhoiid);
	        	ptmt.setString(2, noidung);
	            return ptmt.executeUpdate() == 1;
	        } catch (SQLException ex) {
	        }
	        return false;
	}
	public static boolean deleteAnswers(int id) {
		Connection conn= connection.CreateConnection();
		String sql= "delete from cau_tra_loi where cau_tra_loi_id=?";
		try {
			PreparedStatement ptmt= conn.prepareStatement(sql);
			ptmt.setInt(1, id);
			return ptmt.executeUpdate()==1;
		} catch (SQLException ex) {
			Logger.getLogger(cautraloi.class.getName()).log(Level.SEVERE, null, ex);
		}
				return false;
	}
	
	

	public static void main(String[] args) throws SQLException {
		
		boolean testtl= cautraloi.deleteAnswers(1);
		if(testtl)
		{
			System.out.println("Xóa thành công !");
		}
		else
		{
			System.out.println("Xóa thất bại");
		}
		
	}

}
