package daO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.IdGenerator;

public class IdGenerator_dao_impl implements IdGenerator_dao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void loadCurrentMaxId(String sqlTable) {
		// TODO Auto-generated method stub
		Connection conn = connectionDataBase.getDataBase();
		String SQL = "select max(id) as max_id from " + sqlTable;
		
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ResultSet rs= ps.executeQuery();
			if(rs.next()) {
				String maxId = rs.getString("max_id");
				if(maxId != null) {
				int	currentMaxId =  Integer.parseInt(maxId.substring(1)) ;
				}
			}
			rs.close();
			ps.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
}//最後一個，不可以不見
