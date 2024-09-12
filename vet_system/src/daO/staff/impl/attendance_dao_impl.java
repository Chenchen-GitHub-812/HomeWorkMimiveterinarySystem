package daO.staff.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import daO.connectionDataBase;
import daO.staff.attendance_dao;
import model.staff.attendancetable;

public class attendance_dao_impl implements attendance_dao{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertcheckintime(String staffnumber, String name, String date, String check_in_time) {
		// TODO Auto-generated method stub
		Connection conn = connectionDataBase.getDataBase();
		String SQL = "insert into checkin_table(staffnumber,name,date,check_in_time,check_out_time)"
				+ "values(?, ?, ?, ?, null)";
		try {
			PreparedStatement ps= conn.prepareStatement(SQL);
			ps.setString(1, staffnumber);
			ps.setString(2, name);
			ps.setString(3, date);
			ps.setString(4, check_in_time);
			//ps.setString(4, at.getCheck_out_time());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<attendancetable> selectAll() {
		// TODO Auto-generated method stub
		Connection conn = connectionDataBase.getDataBase();
		String SQL = "select * From mimiveterinary.checkin_table";
		List<attendancetable> la = new ArrayList();
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ResultSet rs= ps.executeQuery();
			
			while(rs.next())
			{
				attendancetable at= new attendancetable();
				at.setStaffnumber(rs.getString("staffnumber"));
				at.setName(rs.getString("name"));
				at.setCheck_in_time(rs.getString("check_in_time"));
				at.setCheck_out_time(rs.getString("check_out_time"));
				
				la.add(at);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return la;
	}

	@Override
	public List<attendancetable> selectStaffNumber(String staffnumber) {
		// TODO Auto-generated method stub
		Connection conn = connectionDataBase.getDataBase();
		String SQL = "select * from mimiveterinary.checkin_table where staffnumber =?";
		List<attendancetable> ls= new ArrayList();
		try {
			PreparedStatement ps= conn.prepareStatement(SQL);
			ps.setString(1, staffnumber);
			ResultSet rs= ps.executeQuery();
			while(rs.next())
			{
				attendancetable at= new attendancetable();
				at.setStaffnumber(rs.getString("staffnumber"));
				at.setName(rs.getString("name"));
				at.setCheck_in_time(rs.getString("check_in_time"));
				at.setCheck_out_time(rs.getString("check_out_time"));
				
				ls.add(at);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ls;
	}

	@Override
	public void insertcheckouttime(String staffnumber, String check_out_time) {
		// TODO Auto-generated method stub
		Connection conn= connectionDataBase.getDataBase();
		String SQL="update checkin_table set check_out_time = ? where staffnumber = ?";
		try {
			PreparedStatement ps= conn.prepareStatement(SQL);
			ps.setString(1, check_out_time);
			ps.setString(2, staffnumber);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
