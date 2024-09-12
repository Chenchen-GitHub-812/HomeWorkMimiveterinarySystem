package model;

import java.io.Serializable;

public class to_do implements Serializable {
	
	private Integer number;
	private String addDate;
	private String addTime;
	private String addStaffNumber;
	private String transferTo;
	private String content;
	private String finished;
	private String finishedStaffNumber;
	
	public to_do() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public to_do(String addDate, String addTime, String addStaffNumber, String transferTo, String content) {
		super();
		this.addDate = addDate;
		this.addTime = addTime;
		this.addStaffNumber = addStaffNumber;
		this.transferTo = transferTo;
		this.content = content;
		
	}

	
	public String getAddTime() {
		return addTime;
	}

	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}

	public String getAddStaffNumber() {
		return addStaffNumber;
	}

	public void setAddStaffNumber(String addStaffNumber) {
		this.addStaffNumber = addStaffNumber;
	}

	public String getFinishedStaffNumber() {
		return finishedStaffNumber;
	}

	public void setFinishedStaffNumber(String finishedStaffNumber) {
		this.finishedStaffNumber = finishedStaffNumber;
	}

	public String getAddDate() {
		return addDate;
	}
	public void setAddDate(String addDate) {
		this.addDate = addDate;
	}
	public String getTransferTo() {
		return transferTo;
	}
	public void setTransferTo(String transferTo) {
		this.transferTo = transferTo;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getFinished() {
		return finished;
	}
	public void setFinished(String finished) {
		this.finished = finished;
	}
	
	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

}
