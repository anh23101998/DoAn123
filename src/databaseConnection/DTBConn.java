package databaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DTBConn 
{
	public static Connection conn;
	public static Statement statement;
	
	public static Connection getDTBConn() {

		final String url = "jdbc:mysql://localhost:3306/baixe?useSSL=false";
		final String user = "root";
		final String password = "anh23101998";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Object [] GetData(String Mx) 
	{
		Object [] fina = new Object[5];
		String sql = "Select * From `baixe`.`new_table`  where Maxe = "+ Mx +";";
		try {
			  Connection connection = getDTBConn();			  
			  Statement statement = connection.createStatement(
		      ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			  ResultSet rs = statement.executeQuery(sql);
			  if(rs.next()){
				  rs.first();
				  fina[0] = rs.getString(2);
				  fina[1] = rs.getString(3);
         		  fina[2] = rs.getString(4);
				  fina[3] = rs.getString(5);
				  connection.close();	  
			    }
			  else
			  {
				  fina[0] = null;
				  fina[1] = null;			  
				  fina[2] = null;
				  fina[3] = null;
				  connection.close();
			  } 
		} catch (SQLException e) {	
			e.printStackTrace();
		}
			return fina; 
	}
	
	public static void InsertData(Object [] fina) 
	{
		String sql = " INSERT INTO `baixe`.`new_table`  (MaXe, Image1, Image2, Time, Date, Note)  VALUES ("+"'"+fina[0]+"'"+", "+"'"+fina[1]+"'"+", "+"'"+fina[2]+"'"+", "+"'"+fina[3]+"'"+", "+"'"+fina[4]+"'"+","+"'"+fina[5]+"'"+" );";
		try {
				Connection connection = getDTBConn();			 
				Statement statement = connection.createStatement();
				statement.executeUpdate(sql);
			    connection.close();    
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void DeleteData(String Maxe)  
	{
		String sql = "DELETE FROM `baixe`.`new_table` WHERE MaXe = " + Maxe + ";";
		try {
			Connection connection = getDTBConn();			 
			Statement statement = connection.createStatement();
			statement.executeUpdate(sql);
			connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	 
	
	public static void CountData(String SoLuong)
	{
		String sql = "SELECT COUNT * FROM `baixe`.`new_table`;";
		try {
			Connection connection = getDTBConn();			 
			Statement statement = connection.createStatement();
			statement.executeUpdate(sql);
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}	