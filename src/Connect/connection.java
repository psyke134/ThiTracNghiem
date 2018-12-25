package Connect;
import java.sql.*;

import Connect.connection;
public class connection {
	public static Connection CreateConnection(){
		Connection conn= null;

		
		String url="jdbc:mysql://localhost:3306/web";
		String username="root";
		String password="1234";
		try {
			// load Driver
			Class.forName("com.mysql.jdbc.Driver");
			
			// create connection
			conn = DriverManager.getConnection(url,username,password);
			
			//System.out.println("Connected successfully hihi...");
		} 
		catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		catch(SQLException ex){
			ex.printStackTrace();
			System.out.println("Error connection " + ex); 
		}

		return conn;
	}
	public static void main(String[] args) {
		System.out.println(connection.CreateConnection());
	}
}
