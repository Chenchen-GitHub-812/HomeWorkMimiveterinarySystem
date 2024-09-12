package service;

import java.util.List;

import model.ownerandpet.pet;

public interface pet_service {
	
	//新增寵物資料
	void addPet(pet p);
	
	//修改
	void updatePet(pet p);
	
	//刪除
	void delete (int id);

	//用主人電話號碼查詢
	Object[][] searchOwnerPhone(String ownerPhone);
	
	//用寵物姓名查詢
	Object[][]  searchPetName(String petName);
	
	//顯示全部
	Object[][]  selectAll();
	
	//用id查
	 List<pet> searchId(int id);
	 
	//用寵物名與電話號碼查詢
	 List<pet> searchPetNameAndOwnerPhone(String petName, String ownerPhone);

}
