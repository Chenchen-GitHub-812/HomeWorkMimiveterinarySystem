package daO.staff;

import java.util.List;

import model.staff.attendancetable;

public interface attendance_dao {
	//新增上班
	void insertcheckintime(String staffnumber, String name, String date,String check_in_time);
	
	//新增下班
	void insertcheckouttime(String staffnumber, String check_out_time);
	
	//顯示全部
	List<attendancetable> selectAll();
	
	//查詢—用員工編號查打卡紀錄
	List<attendancetable> selectStaffNumber(String staffnumber);

}
