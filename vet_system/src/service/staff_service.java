package service;

import java.util.List;

import model.staff.staff_table;

public interface staff_service {
	
	//登入
	staff_table login(String staffnumber, String staffpassword); 
	
	//新增員工
	void addstaff(staff_table st);
	
	//用員工工號查詢資料
	List<staff_table> searchstaffnumber(String staffnumber);

	//修改員工資料
	void update(staff_table st);
}


//@FunctionalInterface (interface的方法相同的只能有一個 用這個可以幫你檢查)