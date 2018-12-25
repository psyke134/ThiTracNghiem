package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LoginDAO {
	public static String getUserId(String name, Connection conn) {
		String userId = null;
		
		java.sql.PreparedStatement ptmt = null;

		String sql = "select * from nguoi_dung where username = '"+ name +"'";
		
		try {

			ptmt = conn.prepareStatement(sql);

			ResultSet rs = ptmt.executeQuery();

			while (rs.next()) {
				userId = rs.getString("nguoi_dung_id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return userId;	
	}
	public static String LoginUser(String name, String pass, Connection conn) {

		String phanQuyen = null;

		java.sql.PreparedStatement ptmt = null;

		String sql = "select * from nguoi_dung where username = '"+ name +"' and password = '"+ pass +"'";
	
		try {

			ptmt = conn.prepareStatement(sql);

			ResultSet rs = ptmt.executeQuery();

			while (rs.next()) {

				String username = rs.getString("username");
				String password = rs.getString("password");
				phanQuyen = rs.getString("loai_nguoi_dung_id");
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return phanQuyen;
	}
}
