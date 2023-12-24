package JDBC1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RetrieveDynamic {
	public static void main(String[] args) throws SQLException
	{
		String driver="oracle.jdbc.driver.OracleDriver";
		Connection con=null;
		
		try
		{
			Class.forName(driver);
			System.out.println("Driver is loaded");
			
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String uname="system";
			String pwd="Veeranji";
			
			con=DriverManager.getConnection(url,uname,pwd);
			System.out.println("Connection is established");
			
			String query="select * from wheel where num=?";
			PreparedStatement ps=con.prepareStatement(query);
			int num = 3;
			ps.setInt(1,num);
			ResultSet rs=ps.executeQuery();
			 if(rs.next())
			 {
				 System.out.println(rs.getInt(1)+","+rs.getString(2)+","+rs.getInt(3));
			 }
			 else
			 {
				 System.out.println("Invalid Wheel Number");
			 }
			
		}
		catch(Exception e)
		{
			System.out.println("Exception:"+e.getMessage());
		}
		finally
		{
			if(con!=null)
			{
				con.close();
				System.out.println("Connection is closed");
			}
		}
	}

}
