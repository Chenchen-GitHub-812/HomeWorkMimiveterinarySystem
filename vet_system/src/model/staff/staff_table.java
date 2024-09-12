package model.staff;

import java.io.Serializable;

public class staff_table implements Serializable{
	
	private String name;
	private String sex;
	private String idnumber;
	private String birthday;
	private String address;
	private String phone;
	private String email;
	private String emergency_contact_name;
	private String emergency_contact_phone;
	private String emergency_contact_relationship;
	private String start_date;
	private String end_date;
	private String staffnumber;
	private String staffpassword;
	
	
	public staff_table() {
		super();
		// TODO Auto-generated constructor stub
	}



	public staff_table(String name, String sex, String idnumber, String birthday, String address, String phone,
			String email, String emergency_contact_name, String emergency_contact_phone,
			String emergency_contact_relationship, String start_date,String staffnumber, String staffpassword) {
		super();
		this.name = name;
		this.sex = sex;
		this.idnumber = idnumber;
		this.birthday = birthday;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.emergency_contact_name = emergency_contact_name;
		this.emergency_contact_phone = emergency_contact_phone;
		this.emergency_contact_relationship = emergency_contact_relationship;
		this.start_date = start_date;
		this.staffnumber = staffnumber;
		this.staffpassword = staffpassword;
	}



	public String getEnd_date() {
		return end_date;
	}



	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getSex() {
		return sex;
	}



	public void setSex(String sex) {
		this.sex = sex;
	}



	public String getIdnumber() {
		return idnumber;
	}



	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
	}



	public String getBirthday() {
		return birthday;
	}



	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getEmergency_contact_name() {
		return emergency_contact_name;
	}



	public void setEmergency_contact_name(String emergency_contact_name) {
		this.emergency_contact_name = emergency_contact_name;
	}



	public String getEmergency_contact_phone() {
		return emergency_contact_phone;
	}



	public void setEmergency_contact_phone(String emergency_contact_phone) {
		this.emergency_contact_phone = emergency_contact_phone;
	}



	public String getEmergency_contact_relationship() {
		return emergency_contact_relationship;
	}



	public void setEmergency_contact_relationship(String emergency_contact_relationship) {
		this.emergency_contact_relationship = emergency_contact_relationship;
	}



	public String getStart_date() {
		return start_date;
	}



	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}



	public String getStaffnumber() {
		return staffnumber;
	}



	public void setStaffnumber(String staffnumber) {
		this.staffnumber = staffnumber;
	}



	public String getStaffpassword() {
		return staffpassword;
	}



	public void setStaffpassword(String staffpassword) {
		this.staffpassword = staffpassword;
	}
	
}
