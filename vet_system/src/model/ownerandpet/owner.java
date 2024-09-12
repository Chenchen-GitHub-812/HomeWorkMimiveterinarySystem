package model.ownerandpet;

public class owner {
	private Integer id;
	
	private String ownerName;
	private String ownerPhone;
	private String ownerAddddress;
	public owner() {
		super();
		// TODO Auto-generated constructor stub
	}
	public owner(String ownerName, String ownerPhone, String ownerAddddress) {
		super();
		this.ownerName = ownerName;
		this.ownerPhone = ownerPhone;
		this.ownerAddddress = ownerAddddress;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getOwnerPhone() {
		return ownerPhone;
	}
	public void setOwnerPhone(String ownerPhone) {
		this.ownerPhone = ownerPhone;
	}
	public String getOwnerAddddress() {
		return ownerAddddress;
	}
	public void setOwnerAddddress(String ownerAddddress) {
		this.ownerAddddress = ownerAddddress;
	}

	}