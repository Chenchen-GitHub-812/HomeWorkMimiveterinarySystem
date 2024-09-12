package service;

import java.util.List;

import model.to_do;

public interface to_do_service {
	//新增
	void addToDo(to_do td);
	
	//顯示
	Object[][] searchfished(String finished);
	
	//修改
	void update(int number,  String finishstaffnumber);
	
	//刪除
	void delete(int number);
	
	//查詢
	List<to_do> searchnumber(int number);
	

	
	
}
