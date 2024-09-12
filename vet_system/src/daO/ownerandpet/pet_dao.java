package daO.ownerandpet;

import java.util.List;

import model.ownerandpet.pet;

public interface pet_dao {
	
	//新增寵物資料
	public void insert(pet p);
	
	//查詢-用飼主電話號碼
	public Object[][] searchOwnerPhone(String ownerPhone);
	
	//查詢-用寵物名查詢
	public Object[][] searchPetName(String petName);
	
	//修改資料
	public void updatePet(pet p);
	
	//刪除資料
	public void deletePet(int id);
	
	//顯示全部
	public Object[][] selectAll();
	
	//用id查詢
	public List<pet> searchId(int id);
	
	//用寵物名與電話號碼查詢
	public List<pet> searchPetNameAndOwnerPhone(String petName, String ownerPhone);

}
