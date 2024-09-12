package service.impl;

import java.util.List;

import daO.ownerandpet.impl.pet_dao_impl;
import model.ownerandpet.pet;
import service.pet_service;

public class pet_service_impl implements pet_service{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	pet_dao_impl pdi = new pet_dao_impl();
	@Override
	public void addPet(pet p) {
		// TODO Auto-generated method stub
		pdi.insert(p);
	}

	@Override
	public void updatePet(pet p) {
		// TODO Auto-generated method stub
		pdi.updatePet(p);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		pdi.deletePet(id);
	}

	@Override
	public Object[][] searchOwnerPhone(String ownerPhone) {
		// TODO Auto-generated method stub
		Object[][] objectPet = pdi.searchOwnerPhone(ownerPhone);
		return objectPet;
	}

	@Override
	public Object[][] searchPetName(String petName) {
		// TODO Auto-generated method stub
		Object[][] objectPet = pdi.searchPetName(petName);
		return objectPet;
	}

	@Override
	public Object[][] selectAll() {
		// TODO Auto-generated method stub
		Object[][] objectPet = pdi.selectAll();
		return objectPet;
	}

	@Override
	public List<pet> searchId(int id) {
		// TODO Auto-generated method stub
		List<pet> listPet = pdi.searchId(id);
		return listPet;
	}

	@Override
	public List<pet> searchPetNameAndOwnerPhone(String petName, String ownerPhone) {
		// TODO Auto-generated method stub
		List<pet>	listPet = pdi.searchPetNameAndOwnerPhone(petName, ownerPhone);
		if (listPet.isEmpty()) {
	        System.out.println("No pets found for the given criteria.");
	    } else {
	        System.out.println("Found " + listPet.size() + " pets.");
	    }
	    
	    return listPet;
	}
}
