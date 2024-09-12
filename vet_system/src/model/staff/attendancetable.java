package model.staff;

import java.io.Serializable;

public class attendancetable implements Serializable{

	String staffnumber;
	String name;
	String date;
	String check_in_time;
	String check_out_time;
	
	public attendancetable() {
		super();
		// TODO Auto-generated constructor stub
	}

	public attendancetable(String staffnumber, String name, String date, String check_in_time, String check_out_time) {
		super();
		this.staffnumber = staffnumber;
		this.name = name;
		this.date = date;
		this.check_in_time = check_in_time;
		this.check_out_time = check_out_time;
	}

	public String getStaffnumber() {
		return staffnumber;
	}

	public void setStaffnumber(String staffnumber) {
		this.staffnumber = staffnumber;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCheck_in_time() {
		return check_in_time;
	}

	public void setCheck_in_time(String check_in_time) {
		this.check_in_time = check_in_time;
	}

	public String getCheck_out_time() {
		return check_out_time;
	}

	public void setCheck_out_time(String check_out_time) {
		this.check_out_time = check_out_time;
	}
	
	
}
