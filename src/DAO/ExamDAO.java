package DAO;

import BEAN.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExamDAO {
	public static List<Exam> selectExam(String userId, Connection conn) {
		
		java.sql.PreparedStatement ptmt = null;

		String sql = "select * from bai_kiem_tra, chi_tiet_bai_kt where bai_kiem_tra.bai_kiem_tra_id = chi_tiet_bai_kt.bai_kiem_tra_id and chi_tiet_bai_kt.nguoi_dung_id ='"+ userId +"' and diem is null";
		List<Exam> listExams = new ArrayList<Exam>();
		try {
			ptmt = conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			Exam ex = null;
			while (rs.next()) {
				ex = new Exam();
				ex.setExamId(rs.getString("bai_kiem_tra_id"));
				ex.setExamName(rs.getString("ten_bai_kiem_tra"));
				ex.setStartDate(rs.getString("thoi_gian_bat_dau"));
				ex.setDuration(rs.getTime("thoi_luong"));
				listExams.add(ex);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listExams;
	}
	
public static List<Exam> selectDoneExam(String userId, Connection conn) {
		
		java.sql.PreparedStatement ptmt = null;

		String sql = "select * from bai_kiem_tra, chi_tiet_bai_kt where bai_kiem_tra.bai_kiem_tra_id = chi_tiet_bai_kt.bai_kiem_tra_id and chi_tiet_bai_kt.nguoi_dung_id ='"+ userId +"' and diem is not null";
		List<Exam> listDoneExams = new ArrayList<Exam>();
		try {
			ptmt = conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			Exam ex = null;
			while (rs.next()) {
				ex = new Exam();
				ex.setExamId(rs.getString("bai_kiem_tra_id"));
				ex.setStartDate(rs.getString("thoi_gian_bat_dau"));
				ex.setDuration(rs.getTime("thoi_luong"));
				ex.setExamName(rs.getString("ten_bai_kiem_tra"));
				ex.setScore(rs.getFloat("diem"));
				listDoneExams.add(ex);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listDoneExams;
	}
}
