package daO.ownerandpet.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import daO.connectionDataBase;
import daO.ownerandpet.pet_dao;
import model.ownerandpet.pet;

public class pet_dao_impl implements pet_dao{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pet_dao_impl pdi = new pet_dao_impl();
		List<pet> listPet = pdi.searchPetNameAndOwnerPhone("Orange", "0937***192");
		System.out.println(listPet);
		//List<pet> listPet2 = pdi.searchId(1);
		//System.out.println(listPet2);
		
	}

	@Override
	public void insert(pet p) {
		// TODO Auto-generated method stub
		Connection conn = connectionDataBase.getDataBase();
		String SQL = "insert into pet (ownerName,"
				+ "						ownerPhone,"
				+ "						ownerAddress,"
				+ "						petName,"
				+ "						species,"
				+ "						variety,"
				+ "						sex,"
				+ "						birthday,"
				+ "						age,"
				+ "						sterilization,"
				+ "						color,"
				+ "						feeding,"
				+ "						drugallergy,"
				+ "						drugallergyContent,"
				+ "						noteContent)"
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, p.getOwnerName());
			ps.setString(2, p.getOwnerPhone());
			ps.setString(3, p.getOwnerAddress());
			ps.setString(4, p.getPetName());
			ps.setString(5, p.getSpecies());
			ps.setString(6, p.getVariety());
			ps.setString(7, p.getSex());
			ps.setString(8, p.getBirthday());
			ps.setInt(9, p.getAge());
			ps.setString(10, p.getSterilization());
			ps.setString(11, p.getColor());
			ps.setString(12, p.getFeeding());
			ps.setString(13, p.getDrugAllergy());
			ps.setString(14, p.getDrugAllergyContent());
			ps.setString(15, p.getNoteContent());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Object[][] searchOwnerPhone(String ownerPhone) {
		// TODO Auto-generated method stub
		Connection conn = connectionDataBase.getDataBase();
		String SQL = "select * from pet where ownerPhone = ?";
		Object [][] objectPet = null;
		int rowCount = 0;
		try {
			PreparedStatement ps = conn.prepareStatement(SQL, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ps.setString(1, ownerPhone);
			ResultSet rs= ps.executeQuery();
			
				rs.last();
				rowCount = rs.getRow();
				rs.beforeFirst();
			
				objectPet = new Object[rowCount][16];
				int i = 0;
			while(rs.next())
			{
			
					objectPet[i][0] = rs.getInt("id");
		            objectPet[i][1] = rs.getString("ownerName");
		            objectPet[i][2] = rs.getString("ownerPhone");
		            objectPet[i][3] = rs.getString("ownerAddress");
		            objectPet[i][4] = rs.getString("petName");
		            objectPet[i][5] = rs.getString("species");
		            objectPet[i][6] = rs.getString("variety");
		            objectPet[i][7] = rs.getString("sex");
		            objectPet[i][8] = rs.getString("birthday");
		            objectPet[i][9] = rs.getInt("age");
		            objectPet[i][10] = rs.getString("sterilization");
		            objectPet[i][11] = rs.getString("color");
		            objectPet[i][12] = rs.getString("feeding");
		            objectPet[i][13] = rs.getString("drugallergy");
		            objectPet[i][14] = rs.getString("drugallergyContent");
		            objectPet[i][15] = rs.getString("noteContent");
		            i++;  // 增加行数索引
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return objectPet;
	}
	

	@Override
	public Object[][] searchPetName(String petName) {
		// TODO Auto-generated method stub
		Connection conn = connectionDataBase.getDataBase();
		String SQL = "select * from pet where PetName = ?";
		Object [][] objectPet = null;
		int rowCount = 0;
		try {
			PreparedStatement ps = conn.prepareStatement(SQL, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ps.setString(1, petName);
			ResultSet rs= ps.executeQuery();
			
			rs.last();
			rowCount = rs.getRow();
			rs.beforeFirst();
		
			objectPet = new Object[rowCount][16];
			int i = 0;
			while(rs.next())
			{

				objectPet[i][0] = rs.getInt("id");
	            objectPet[i][1] = rs.getString("ownerName");
	            objectPet[i][2] = rs.getString("ownerPhone");
	            objectPet[i][3] = rs.getString("ownerAddress");
	            objectPet[i][4] = rs.getString("petName");
	            objectPet[i][5] = rs.getString("species");
	            objectPet[i][6] = rs.getString("variety");
	            objectPet[i][7] = rs.getString("sex");
	            objectPet[i][8] = rs.getString("birthday");
	            objectPet[i][9] = rs.getInt("age");
	            objectPet[i][10] = rs.getString("sterilization");
	            objectPet[i][11] = rs.getString("color");
	            objectPet[i][12] = rs.getString("feeding");
	            objectPet[i][13] = rs.getString("drugallergy");
	            objectPet[i][14] = rs.getString("drugallergyContent");
	            objectPet[i][15] = rs.getString("noteContent");
	            i++;  // 增加行数索引
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objectPet;
	}

	@Override
	public void updatePet(pet p) {
		// TODO Auto-generated method stub
		Connection conn = connectionDataBase.getDataBase();
		String SQL = "update pet set   petName= ?,"
				+ "						species= ?,"
				+ "						variety= ?,"
				+ "						sex= ?,"
				+ "						birthday= ?,"
				+ "						age= ?,"
				+ "						sterilization= ?,"
				+ "						color= ?,"
				+ "						feeding= ?,"
				+ "						drugallergy= ?,"
				+ "						drugallergyContent= ?,"
				+ "						noteContent= ?"
				+ "where id =? ";
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			
			ps.setString(1, p.getPetName());
			ps.setString(2, p.getSpecies());
			ps.setString(3, p.getVariety());
			ps.setString(4, p.getSex());
			ps.setString(5, p.getBirthday());
			ps.setInt(6, p.getAge());
			ps.setString(7, p.getSterilization());
			ps.setString(8, p.getColor());
			ps.setString(9, p.getFeeding());
			ps.setString(10, p.getDrugAllergy());
			ps.setString(11, p.getDrugAllergyContent());
			ps.setString(12, p.getNoteContent());
			ps.setInt(13, p.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void deletePet(int id) {
		// TODO Auto-generated method stub
		Connection conn = connectionDataBase.getDataBase();
		String SQL = "delete from pet where id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public Object[][] selectAll() {
		// TODO Auto-generated method stub
		Connection conn = connectionDataBase.getDataBase();
		String SQL = "select * from pet";
		Object [][] objectPet = null;
		int rowCount = 0;
		try {
			PreparedStatement ps = conn.prepareStatement(SQL, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs= ps.executeQuery();
			
			rs.last();
			rowCount = rs.getRow();
			rs.beforeFirst();
		
			objectPet = new Object[rowCount][16];
			int i = 0;
			
			while(rs.next())
			{

				objectPet[i][0] = rs.getInt("id");
	            objectPet[i][1] = rs.getString("ownerName");
	            objectPet[i][2] = rs.getString("ownerPhone");
	            objectPet[i][3] = rs.getString("ownerAddress");
	            objectPet[i][4] = rs.getString("petName");
	            objectPet[i][5] = rs.getString("species");
	            objectPet[i][6] = rs.getString("variety");
	            objectPet[i][7] = rs.getString("sex");
	            objectPet[i][8] = rs.getString("birthday");
	            objectPet[i][9] = rs.getInt("age");
	            objectPet[i][10] = rs.getString("sterilization");
	            objectPet[i][11] = rs.getString("color");
	            objectPet[i][12] = rs.getString("feeding");
	            objectPet[i][13] = rs.getString("drugallergy");
	            objectPet[i][14] = rs.getString("drugallergyContent");
	            objectPet[i][15] = rs.getString("noteContent");
	            i++;  // 增加行数索引
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objectPet;
		
	}

	@Override
	public List<pet> searchId(int id) {
		// TODO Auto-generated method stub
		Connection conn = connectionDataBase.getDataBase();
		String SQL = "select * from pet where id = ?";
		List<pet> listPet = new ArrayList();
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				pet p = new pet();
				 p.setId(rs.getInt("id"));  // 設定id
			        p.setOwnerName(rs.getString("ownerName"));  // 設定飼主姓名
			        p.setOwnerPhone(rs.getString("ownerPhone"));  // 設定飼主電話
			        p.setOwnerAddress(rs.getString("ownerAddress"));  // 設定飼主地址
			        p.setPetName(rs.getString("petName"));  // 設定寵物姓名
			        p.setSpecies(rs.getString("species"));  // 設定物種
			        p.setVariety(rs.getString("variety"));  // 設定品種
			        p.setSex(rs.getString("sex"));  // 設定性別
			        p.setBirthday(rs.getString("birthday"));  // 設定生日
			        p.setAge(rs.getInt("age"));  // 設定年齡
			        p.setSterilization(rs.getString("sterilization"));  // 設定是否結紮
			        p.setColor(rs.getString("color"));  // 設定毛色
			        p.setFeeding(rs.getString("feeding"));  // 設定餵養習慣
			        p.setDrugAllergy(rs.getString("drugallergy"));  // 設定藥物過敏
			        p.setDrugAllergyContent(rs.getString("drugallergyContent"));  // 設定藥物過敏項目
			        p.setNoteContent(rs.getString("noteContent"));  // 設定其他注意事項
			        
			        listPet.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listPet;
	}

	@Override
	public List<pet> searchPetNameAndOwnerPhone(String petName, String ownerPhone) {
		// TODO Auto-generated method stub
		Connection conn = connectionDataBase.getDataBase();
		String SQL = "select * from pet where petName = ? and ownerPhone= ?";
		List<pet> listPet = new ArrayList();
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, petName);
			ps.setString(2, ownerPhone);
			ResultSet rs = ps.executeQuery();
			//System.out.println(rs);
			while(rs.next())
			{
					pet p = new pet();
					p.setId(rs.getInt("id"));  // 設定id
			        p.setOwnerName(rs.getString("ownerName"));  // 設定飼主姓名
			        p.setOwnerPhone(rs.getString("ownerPhone"));  // 設定飼主電話
			        p.setOwnerAddress(rs.getString("ownerAddress"));  // 設定飼主地址
			        p.setPetName(rs.getString("petName"));  // 設定寵物姓名
			        p.setSpecies(rs.getString("species"));  // 設定物種
			        p.setVariety(rs.getString("variety"));  // 設定品種
			        p.setSex(rs.getString("sex"));  // 設定性別
			        p.setBirthday(rs.getString("birthday"));  // 設定生日
			        p.setAge(rs.getInt("age"));  // 設定年齡
			        p.setSterilization(rs.getString("sterilization"));  // 設定是否結紮
			        p.setColor(rs.getString("color"));  // 設定毛色
			        p.setFeeding(rs.getString("feeding"));  // 設定餵養習慣
			        p.setDrugAllergy(rs.getString("drugallergy"));  // 設定藥物過敏
			        p.setDrugAllergyContent(rs.getString("drugallergyContent"));  // 設定藥物過敏項目
			        p.setNoteContent(rs.getString("noteContent"));  // 設定其他注意事項
			        
			        System.out.println("352pet :" + p.toString());
			        listPet.add(p);
			        System.out.println("pdi:347" +listPet);
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listPet;
	}

}//最後一個不可以不見


