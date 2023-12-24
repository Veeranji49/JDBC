package JDBC4;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteData {
	public static void main(String[] args) throws SQLException
	{
		String driver="oracle.jdbc.driver.OracleDriver";
		Connection con=null;
		
		try
		{
			Class.forName(driver);
			System.out.println("driver is loaded");
			
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String uname="system";
			String pwd="Veeranji";
			
			con=DriverManager.getConnection(url,uname,pwd);
			System.out.println("Connection is established");
			
			while(true)
			{
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter details:");
			int id=sc.nextInt();
			
			String query="delete from ameerpet where id=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, id);
			int count=ps.executeUpdate();
			if(count>0)
			{
				System.out.println("deleted successfully");
			}
			else
			{
				System.out.println("failed in deletion");
			}
			System.out.println("y/n");
			
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
				System.out.println("connection is closed");
			}
		}

	}
}
