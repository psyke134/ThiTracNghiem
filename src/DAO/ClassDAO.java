package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import BEAN.Class;

public class ClassDAO {
	public static List<Class> getClass(String name, Connection conn) {
		
		List<Class> listClass = new ArrayList<Class>();
		Class classObj = null;
		
		java.sql.PreparedStatement ptmt = null;

		String sql = "select * from chi_tiet_lop_hoc, lop_hoc where nguoi_dung_id = '"+ name +"'";
		
		try {
			ptmt = conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();

			while (rs.next()) {
				classObj = new Class();
				classObj.setClassId(rs.getString("lop_hoc_id"));
				classObj.setClassName(rs.getString("ten_lop_hoc"));
				
				listClass.add(classObj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listClass;	
	}
}
