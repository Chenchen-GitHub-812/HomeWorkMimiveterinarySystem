package daO.todo;

import java.util.List;

import model.to_do;

public interface todo_dao {
	//新增待辦事項
	void insert(to_do td);
	
	//用對象查詢
	List<to_do> searchnumber(int number);
	
	//用是否已完成查詢
	Object[][] searchFinished(String finished);
	
	//修改
	void update(int number, String finishedstaffnumber);
	

	
	//刪除
	void delete(int number);
	
	


}
