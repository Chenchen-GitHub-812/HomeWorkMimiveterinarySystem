package daO.todo.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import daO.connectionDataBase;
import daO.todo.todo_dao;
import model.to_do;

public class todo_dao_impl implements todo_dao{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/*
	to_do td= new to_do("2024/09/06", "13:20:00", "19070412", "醫療", "請晚班醫師協助2號貓龍嘿黑量血糖");	
	new todo_dao_impl().insert(td);
	*/
	/*
	List<to_do> ltd= new todo_dao_impl().searchFinished(null);
	if(ltd.isEmpty())
	{
		System.out.println("NO records found.");
	}
	else
	{
	for (to_do o:ltd)
	{
		System.out.println(o.getNumber()+"\t"+ o.getAddDate() + "\t" + o.getAddTime() + "\t" + o.getContent());
		//o.setFinished("Yes");
		//o.setFinishedStaffNumber("24010812");
		new todo_dao_impl().update(1, "yes", "24010812");
	}
	*/
		new todo_dao_impl().delete(2);
	}
	
	
	
	

	@Override
	public void insert(to_do td) {
		// TODO Auto-generated method stub
	Connection conn = connectionDataBase.getDataBase();
	String SQL = "insert into to_do_table(adddate, addtime, addstaffnumber, transferto, content, finished, finishedstaffnumber)"
			+ " values(?, ?, ?, ?, ?, null, null)";
	try {
		PreparedStatement ps=conn.prepareStatement(SQL);
		ps.setString(1, td.getAddDate());
		ps.setString(2, td.getAddTime());
		ps.setString(3, td.getAddStaffNumber());
		ps.setString(4, td.getTransferTo());
		ps.setString(5, td.getContent());
		
		ps.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}

	@Override
	public List<to_do> searchnumber(int number) {
		// TODO Auto-generated method stub
		Connection conn = connectionDataBase.getDataBase();
		String SQL="select * from to_do_table where number = ?";
		List<to_do> l= new ArrayList(); 
		try {
			PreparedStatement ps= conn.prepareStatement(SQL);
			ps.setInt(1, number);
			ResultSet rs= ps.executeQuery();
			while(rs.next())
			{
				to_do td=new to_do();
				td.setNumber(rs.getInt("number"));
				td.setAddDate(rs.getString("addDate"));
				td.setAddTime(rs.getString("addTime"));
				td.setAddStaffNumber(rs.getString("addStaffNumber"));
				td.setTransferTo(rs.getString("transferTo"));
				td.setContent(rs.getString("content"));
				td.setFinished(rs.getString("finished"));
				td.setFinishedStaffNumber(rs.getString("finishedStaffNumber"));
			
				l.add(td);
			}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return l;
	}

	@Override
	public Object[][] searchFinished(String finished) {
		// TODO Auto-generated method stub
		Connection conn = connectionDataBase.getDataBase();
		String SQL;
		if ("false".equals(finished)) {
	        // 查詢未完成的事項 (未完成是 null)
			SQL = "SELECT * FROM to_do_table WHERE finished IS NULL or finished = ''";
	    } else if ("yes".equals(finished)) {
	        // 查詢已完成的事項
	    	SQL = "SELECT * FROM to_do_table WHERE finished = 'yes'";
	    } else {
	        // 如果參數不是 "false" 或 "yes"，返回所有事項
	    	SQL = "SELECT * FROM to_do_table";
	    }
		
		Object[][] tableData = null;
		int rowCount = 0;
		try {
			PreparedStatement ps = conn.prepareStatement(SQL, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = ps.executeQuery();{
			
				//先計算總資料的行數
				rs.last();
				rowCount = rs.getRow();
				rs.beforeFirst(); //算完行數要記得回到第一行
			tableData = new Object [rowCount][8];
			int i = 0;
			while(rs.next())
			{
				
				tableData[i][0] = rs.getInt("number");
	            tableData[i][1] = rs.getString("addDate");
	            tableData[i][2] = rs.getString("addTime");
	            tableData[i][3] = rs.getString("addStaffNumber");
	            tableData[i][4] = rs.getString("transferTo");
	            tableData[i][5] = rs.getString("content");
	            tableData[i][6] = rs.getString("finished");
	            tableData[i][7] = rs.getString("finishedStaffNumber");
	            i++;  // 遞增行索引
			}
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
		return tableData;
	}

	@Override
	public void update(int number, String finishedtstaffnumber) {
		// TODO Auto-generated method stub
		Connection conn = connectionDataBase.getDataBase();
		String SQL = "update to_do_table set finished = 'yes' ,  finishedstaffnumber = ? where number = ?";
		try {
			PreparedStatement ps= conn.prepareStatement(SQL);
			ps.setString(1, finishedtstaffnumber);
			ps.setInt(2, number);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void delete(int number) {
		// TODO Auto-generated method stub
		Connection conn= connectionDataBase.getDataBase();
		String SQL="delete from to_do_table where number=?";
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setInt(1, number);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		
	}



}
