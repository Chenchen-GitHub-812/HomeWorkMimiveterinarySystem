package daO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectionDataBase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	System.out.println(connectionDataBase.getDataBase());
		
	}
	
	public static Connection getDataBase()
	{
		
		String URL = "jdbc:mysql://localhost:3306/mimiveterinary";
		String username = "root";
		String password = "1234";
		Connection conn = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL,username, password);			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return conn;
	}

}
