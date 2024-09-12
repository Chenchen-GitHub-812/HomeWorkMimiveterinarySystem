package service.impl;

import java.util.ArrayList;
import java.util.List;

import daO.ownerandpet.impl.owner_dao_impl;
import model.ownerandpet.owner;
import service.owner_service;

public class owner_service_impl implements owner_service{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private owner_dao_impl odi = new owner_dao_impl();
	@Override
	public void insert(owner o) {
		// TODO Auto-generated method stub
		odi.insert(o);
	}

	@Override
	public List<owner> searchPhone(String ownerPhone) {
		// TODO Auto-generated method stub
		
		List<owner> listOwner = odi.searchPhone(ownerPhone);
		return listOwner;

	}
	
	@Override
	public void updateOwner(owner o) {
		// TODO Auto-generated method stub
		  if (o == null) {
		        throw new IllegalArgumentException("Owner cannot be null");
		    }
		
		  try {
		        // 更新 owner 資料
		        odi.updateOwner(o);
		    } catch (Exception e) {
		        // 日誌記錄錯誤並處理例外
		        System.err.println("Error updating owner: " + e.getMessage());
		        // 重新拋出例外或進行自定義錯誤處理
		        throw e;
		    }
	}

}
