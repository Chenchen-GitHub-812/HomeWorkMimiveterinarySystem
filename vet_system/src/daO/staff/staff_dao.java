package daO.staff;

import java.util.List;

import model.staff.staff_table;

public interface staff_dao {
	
	//新增
	 void insert(staff_table st);
	
	//顯示全部
	
	 List<staff_table> selectAll();
	 
	 //查詢---用員工編號與密碼查詢(登入確認資料用)
	 
	 List<staff_table> selectstaff(String staffnumber, String staffpassword);
	 
	//查詢——用員工編號查詢
	
	 List<staff_table> selectStaffNumber(String staffnumber);
	 
	//查詢——用員工姓名查詢
	 
	 List<staff_table> selectStaffName(String name);
	
	//修改
	
	 void update(staff_table st);
	
	//刪除

	 void delete(String staffnumber);
}
