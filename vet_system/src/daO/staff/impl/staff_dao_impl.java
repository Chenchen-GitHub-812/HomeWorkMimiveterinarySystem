package daO.staff.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import daO.connectionDataBase;
import daO.staff.staff_dao;
import model.staff.staff_table;

public class staff_dao_impl implements staff_dao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//新增測試
		/*
		staff_table st = new staff_table("陳*育", "女","F22*****93","1990/08/12","新北市土城區**路**號**樓","0932****75","yuyu*****@yahoo.com.tw","楊*琴","0975****14","母女","2024/01/01","24010812","0812");
		new staff_dao_impl().insert(st);
		*/
		//顯示所有資料
		/*
		List<staff_table> ls=new staff_dao_impl().selectAll();
		for(staff_table s:ls)
		{
			System.out.println("Name :" +s.getName()+ "\tSex:" + s.getSex()+"\tStaffnumber : " + s.getStaffnumber());
		}
		*/
		//用員工編號尋找
		/*
		List<staff_table> ls=new staff_dao_impl().selectStaffNumber("24010812");
		for(staff_table s:ls)
		{
			System.out.println("Name :" +s.getName()+ "\tSex:" + s.getSex()+"\tStaffnumber : " + s.getStaffnumber());
		}
		*/
		//用員工姓名尋找
		/*
		List<staff_table> ls=new staff_dao_impl().selectStaffName("chenchen");
		for(staff_table s:ls)
		{
			System.out.println("Name :" +s.getName()+ "\tSex:" + s.getSex()+"\tStaffnumber : " + s.getStaffnumber());
		}
		*/
		// 用員工編號下去修改資料
		/*
		List<staff_table> ls=new staff_dao_impl().selectStaffNumber("11111111");
		staff_table st=ls.get(0);
		System.out.println("Name :" +st.getName()+ "\tSex:" + st.getSex()+"\tStaffnumber : " + st.getStaffnumber());
		st.setName("chenchenyu");
		st.setAddress("newtaipeicity");
		st.setPhone("**23547");
		
		new staff_dao_impl().update(st);
		System.out.println("Name :" +st.getName()+ "\tSex:" + st.getSex()+"\tStaffnumber : " + st.getStaffnumber());
		*/
		//用員工編號刪除資料
		List<staff_table> ls=new staff_dao_impl().selectStaffNumber("11111111");
		staff_table st=ls.get(0);
		new staff_dao_impl().delete("11111111");
		
	}
	/*----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
	@Override
	public void insert(staff_table st) {
		// TODO Auto-generated method stub
		Connection conn= connectionDataBase.getDataBase();
		String SQL = "insert into staff(name,sex,idnumber,birthday,address,phone,email,emergency_contact_name,emergency_contact_phone,emergency_contact_relationship,start_date,staffnumber,staffpassword)"
					+"values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, st.getName());
			ps.setString(2, st.getSex());
			ps.setString(3, st.getIdnumber());
			ps.setString(4, st.getBirthday());
			ps.setString(5, st.getAddress());
			ps.setString(6, st.getPhone());
			ps.setString(7, st.getEmail());
			ps.setString(8, st.getEmergency_contact_name());
			ps.setString(9, st.getEmergency_contact_phone());
			ps.setString(10, st.getEmergency_contact_relationship());
			ps.setString(11, st.getStart_date());
			ps.setString(12, st.getStaffnumber());
			ps.setString(13, st.getStaffpassword());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
	@Override
	public List<staff_table> selectAll() {
		// TODO Auto-generated method stub
		Connection conn = connectionDataBase.getDataBase();
		String SQL = "SELECT * FROM mimiveterinary.staff";
		List<staff_table> ls= new ArrayList();
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				staff_table st=new staff_table();
				st.setName(rs.getString("name"));
				st.setSex(rs.getString("sex"));
				st.setIdnumber(rs.getString("idnumber"));
				st.setBirthday(rs.getString("birthday"));
				st.setAddress(rs.getString("address"));
				st.setPhone(rs.getString("phone"));
				st.setEmail(rs.getString("email"));
				st.setEmergency_contact_name(rs.getString("emergency_contact_name"));
				st.setEmergency_contact_phone(rs.getString("emergency_contact_phone"));
				st.setEmergency_contact_relationship(rs.getString("emergency_contact_relationship"));
				st.setStart_date(rs.getString("start_date"));
				st.setStaffnumber(rs.getString("staffnumber"));
				st.setStaffpassword(rs.getString("staffpassword"));
				
				ls.add(st);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ls;
	}
	/*----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
	@Override
	public List<staff_table> selectStaffNumber(String staffnumber) {
		// TODO Auto-generated method stub
		Connection conn=connectionDataBase.getDataBase();
		String SQL = "select * from mimiveterinary.staff where staffnumber = ?";
		List<staff_table> ls=new ArrayList();
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, staffnumber);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				staff_table st=new staff_table();
				st.setName(rs.getString("name"));
				st.setSex(rs.getString("sex"));
				st.setIdnumber(rs.getString("idnumber"));
				st.setBirthday(rs.getString("birthday"));
				st.setAddress(rs.getString("address"));
				st.setPhone(rs.getString("phone"));
				st.setEmail(rs.getString("email"));
				st.setEmergency_contact_name(rs.getString("emergency_contact_name"));
				st.setEmergency_contact_phone(rs.getString("emergency_contact_phone"));
				st.setEmergency_contact_relationship(rs.getString("emergency_contact_relationship"));
				st.setStart_date(rs.getString("start_date"));
				st.setStaffnumber(rs.getString("staffnumber"));
				st.setStaffpassword(rs.getString("staffpassword"));
				
				ls.add(st);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("找不到資料");
			e.printStackTrace();
		}
		return ls;
	}
	/*----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
	@Override
	public List<staff_table> selectStaffName(String name) {
		// TODO Auto-generated method stub
		Connection conn=connectionDataBase.getDataBase();
		String SQL = "select * from mimiveterinary.staff where name = ?";
		List<staff_table> ls=new ArrayList();
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, name);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				staff_table st=new staff_table();
				st.setName(rs.getString("name"));
				st.setSex(rs.getString("sex"));
				st.setIdnumber(rs.getString("idnumber"));
				st.setBirthday(rs.getString("birthday"));
				st.setAddress(rs.getString("address"));
				st.setPhone(rs.getString("phone"));
				st.setEmail(rs.getString("email"));
				st.setEmergency_contact_name(rs.getString("emergency_contact_name"));
				st.setEmergency_contact_phone(rs.getString("emergency_contact_phone"));
				st.setEmergency_contact_relationship(rs.getString("emergency_contact_relationship"));
				st.setStart_date(rs.getString("start_date"));
				st.setStaffnumber(rs.getString("staffnumber"));
				st.setStaffpassword(rs.getString("staffpassword"));
				
				ls.add(st);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("找不到資料");
			e.printStackTrace();
		}
		return ls;
	}
	/*----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
	@Override
	public void update(staff_table st) {
		// TODO Auto-generated method stub
		Connection conn = connectionDataBase.getDataBase();
		String SQL = "update staff set name=?, address=?, phone=? where staffnumber=?";
		try {
			PreparedStatement ps= conn.prepareStatement(SQL);
			ps.setString(1, st.getName());
			ps.setString(2, st.getAddress());
			ps.setString(3, st.getPhone());
			ps.setString(4, st.getStaffnumber());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/*----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
	@Override
	public void delete(String staffnumber) {
		// TODO Auto-generated method stub
		Connection conn = connectionDataBase.getDataBase();
		String SQL = "delete from staff where staffnumber=?";
		try {
			PreparedStatement ps= conn.prepareStatement(SQL);
			ps.setString(1, staffnumber);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	/*----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
	@Override
	public List<staff_table> selectstaff(String staffnumber, String staffpassword) {
		// TODO Auto-generated method stub
		Connection conn=connectionDataBase.getDataBase();
		String SQL = "select * from staff where staffnumber = ? and staffpassword = ?";
		List<staff_table> ls= new ArrayList();
		
		try {
			PreparedStatement ps= conn.prepareStatement(SQL);
			ps.setString(1, staffnumber);
			ps.setString(2, staffpassword);
			ResultSet rs= ps.executeQuery();
			
			while(rs.next())
			{

				staff_table st=new staff_table();
				st.setName(rs.getString("name"));
				st.setSex(rs.getString("sex"));
				st.setIdnumber(rs.getString("idnumber"));
				st.setBirthday(rs.getString("birthday"));
				st.setAddress(rs.getString("address"));
				st.setPhone(rs.getString("phone"));
				st.setEmail(rs.getString("email"));
				st.setEmergency_contact_name(rs.getString("emergency_contact_name"));
				st.setEmergency_contact_phone(rs.getString("emergency_contact_phone"));
				st.setEmergency_contact_relationship(rs.getString("emergency_contact_relationship"));
				st.setStart_date(rs.getString("start_date"));
				st.setStaffnumber(rs.getString("staffnumber"));
				st.setStaffpassword(rs.getString("staffpassword"));
				
				ls.add(st);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ls;
	}

}
