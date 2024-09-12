package service.impl;

import java.util.List;

import daO.staff.impl.attendance_dao_impl;
import model.staff.attendancetable;
import service.attendanct_service;

public class attendanc_service_impl implements attendanct_service{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static attendance_dao_impl adi= new attendance_dao_impl();
	@Override
	public attendancetable checkin(String staffnumber, String name, String date, String check_in_time) {
		// TODO Auto-generated method stub
		attendancetable at = new attendancetable();
		at.setStaffnumber(staffnumber);
		at.setName(name);
		at.setDate(date);
		at.setCheck_in_time(check_in_time);
		adi.insertcheckintime(staffnumber, name, date, check_in_time);
	
		return at;
	}
	@Override
	public void checkout(String staffnumber, String check_out_time) {
		// TODO Auto-generated method stub
		adi.insertcheckouttime(staffnumber, check_out_time);
	}
	@Override
	public void allrecord(attendancetable at) {
		// TODO Auto-generated method stub
		adi.selectAll();
	}
	@Override
	public List<attendancetable> searchrecord(String staffnumber) {
		// TODO Auto-generated method stub
		return adi.selectStaffNumber(staffnumber);
	}
	
	
}