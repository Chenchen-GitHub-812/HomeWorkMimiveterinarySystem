package service;

import java.util.List;

import model.staff.attendancetable;

public interface attendanct_service {

	//新增上班時間
	
	attendancetable checkin(String staffnumber, String name,String date, String check_in_time);
	
	//新增下班時間
	void checkout(String staffnumber, String check_out_time);
	
	//顯示打卡記錄
	void allrecord(attendancetable at);
	
	//查詢打卡記錄
	List<attendancetable> searchrecord(String staffnumber);
	
}

