package service.impl;

import java.util.ArrayList;
import java.util.List;

import daO.staff.impl.staff_dao_impl;
import model.staff.staff_table;
import service.staff_service;

public class staff_service_impl implements staff_service{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static staff_dao_impl sdi = new staff_dao_impl();
	/*----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
	@Override
	public staff_table login(String staffnumber, String staffpassword) {
		// TODO Auto-generated method stub
		List<staff_table> ls=sdi.selectstaff(staffnumber, staffpassword);
		staff_table st=null;
		if(ls.size()!=0)
		{
			st=ls.get(0);
		}
		
		return st;
	}
	/*----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
	//這個要用在新客戶新增資料時的檢查
	/*@Override
	public boolean findbystaffnumber(String staffnumber) {
		// TODO Auto-generated method stub
		List<staff_table> ls= sdi.selectStaffNumber(staffnumber);
		boolean reasult=false;
		if(ls.size())
		return false;
	}*/
	/*----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
	@Override
	public void addstaff(staff_table st) {
		// TODO Auto-generated method stub
		sdi.insert(st);
	}
	@Override
	public void update(staff_table st) {
		// TODO Auto-generated method stub
		sdi.update(st);
		
	}
	@Override
	public List<staff_table> searchstaffnumber(String staffnumber) {
		// TODO Auto-generated method stub
		List<staff_table> ls=sdi.selectStaffNumber(staffnumber);
	
		if(ls != null)
		{
			return ls;
		}
		return new ArrayList<>();
		
	}

}
