package daO.ownerandpet;

import java.util.List;

import model.ownerandpet.owner;

public interface owner_dao {
	//新增飼主資料
	public void insert(owner o);
	
	//查詢-用電話號碼查
	public List<owner> searchPhone(String ownerPhone);
	
	//修改
	public void updateOwner(owner o);
	
	/*
	*沒有新增刪除是因為到時候飼主資料表與寵物資料表有關聯，
	*如果不小心刪除會造成寵物資料表有問題
	*/
}
