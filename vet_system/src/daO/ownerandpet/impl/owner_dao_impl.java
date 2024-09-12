package daO.ownerandpet.impl;

import java.sql.Connection;

import daO.connectionDataBase;
import daO.ownerandpet.owner_dao;

import model.ownerandpet.owner;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class owner_dao_impl implements owner_dao{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		owner o = new owner("Chenchen","0937******","NewTaipeiCity");
		owner_dao_impl odi=new owner_dao_impl();
		odi.insert(o);

	}

	@Override
	public void insert(owner o) {
		// TODO Auto-generated method stub
		Connection conn= connectionDataBase.getDataBase();
		String SQL="insert into owner(ownername, ownerphone, owneraddress)"
				+ "values(?, ?, ?)";
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, o.getOwnerName());
			ps.setString(2, o.getOwnerPhone());
			ps.setString(3, o.getOwnerAddddress());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public List<owner> searchPhone(String ownerPhone) {
		// TODO Auto-generated method stub
		Connection conn = connectionDataBase.getDataBase();
		String SQL="select * from owner where ownerPhone = ?";
		List<owner> lo=new ArrayList<>();
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, ownerPhone);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				owner o = new owner();
				o.setId(rs.getInt("id"));
				o.setOwnerName(rs.getString("ownerName"));
				o.setOwnerPhone(rs.getString("OwnerPhone"));
				o.setOwnerAddddress(rs.getString("ownerAddress"));
				
				lo.add(o);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lo;
	}

	@Override
	public void updateOwner(owner o) {
		// TODO Auto-generated method stub
		Connection conn = connectionDataBase.getDataBase();
		String SQL = "update owner set ownerName=? , ownerPhone=?, ownerAddress=? where id = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, o.getOwnerName());
			ps.setString(2, o.getOwnerPhone());
			ps.setString(3, o.getOwnerAddddress());
			ps.setInt(4, o.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	

}
