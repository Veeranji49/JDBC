package JDBC4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateDeposit {
	public static void main(String[] args) throws SQLException {
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
			
			String query="update ameerpet set fees=fees+? where id=?";
			PreparedStatement ps=con.prepareStatement(query);
			
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter amt:");
			int id=sc.nextInt();
			
			System.out.println("Enter id:");
			int fees=sc.nextInt();
			
			ps.setInt(1, fees);
			ps.setInt(2, id);
			
			int count=ps.executeUpdate();
			if(count>0)
			{
				System.out.println("deposited successfully");
			}
			else
			{
				System.out.println("failed in updation");
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
