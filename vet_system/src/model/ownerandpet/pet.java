package model.ownerandpet;

import java.io.Serializable;

public class pet implements Serializable {
	
	
	String ownerName;
	String ownerPhone;
	String ownerAddress;
	String petName;
	String species;
	String variety;
	String sex;
	String birthday;
	Integer age;
	String sterilization;
	String color;
	String feeding;
	String drugAllergy;
	String drugAllergyContent;
	String noteContent;
	public pet() {
		super();
		// TODO Auto-generated constructor stub
	}
	public pet(String ownerName, String ownerPhone, String ownerAddress, String petName, String species, String variety,
			String sex, String birthday, Integer age, String sterilization, String color, String feeding,
			String drugAllergy, String drugAllergyContent, String noteContent) {
		super();
		this.ownerName = ownerName;
		this.ownerPhone = ownerPhone;
		this.ownerAddress = ownerAddress;
		this.petName = petName;
		this.species = species;
		this.variety = variety;
		this.sex = sex;
		this.birthday = birthday;
		this.age = age;
		this.sterilization = sterilization;
		this.color = color;
		this.feeding = feeding;
		this.drugAllergy = drugAllergy;
		this.drugAllergyContent = drugAllergyContent;
		this.noteContent = noteContent;
	}
	Integer id;
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
	public String getOwnerAddress() {
		return ownerAddress;
	}
	public void setOwnerAddress(String ownerAddress) {
		this.ownerAddress = ownerAddress;
	}
	public String getPetName() {
		return petName;
	}
	public void setPetName(String petName) {
		this.petName = petName;
	}
	public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
	public String getVariety() {
		return variety;
	}
	public void setVariety(String variety) {
		this.variety = variety;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getSterilization() {
		return sterilization;
	}
	public void setSterilization(String sterilization) {
		this.sterilization = sterilization;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getFeeding() {
		return feeding;
	}
	public void setFeeding(String feeding) {
		this.feeding = feeding;
	}
	public String getDrugAllergy() {
		return drugAllergy;
	}
	public void setDrugAllergy(String drugAllergy) {
		this.drugAllergy = drugAllergy;
	}
	public String getDrugAllergyContent() {
		return drugAllergyContent;
	}
	public void setDrugAllergyContent(String drugAllergyContent) {
		this.drugAllergyContent = drugAllergyContent;
	}
	public String getNoteContent() {
		return noteContent;
	}
	public void setNoteContent(String noteContent) {
		this.noteContent = noteContent;
	}

}
