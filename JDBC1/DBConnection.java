package JDBC1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static void main(String[] args) throws SQLException
	{
		String driver="oracle.jdbc.driver.OracleDriver";
		Connection con=null;
		try
		{
			Class.forName(driver);
			System.out.println("driver loaded");
			
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String uname="system";
			String pwd="Veeranji";
			
			con=DriverManager.getConnection(url,uname,pwd);
			System.out.println("Connection established");
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("Exception: Driver is not loaded");
		}
		finally
		{
			if(con!=null)
			{
				con.close();
				System.out.println("connection is closed");
			}
		}
	}
}
