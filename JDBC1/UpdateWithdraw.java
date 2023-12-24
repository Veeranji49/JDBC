package JDBC1;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateWithdraw {
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
			
			String query="update wheel set balance=balance-? where num=?";
			PreparedStatement ps=con.prepareStatement(query);
			
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter wheel number:");
			int num=sc.nextInt();
			
			System.out.println("Enter withdraw amount:");
			int amt=sc.nextInt();
			
			ps.setInt(1, amt);
			ps.setInt(2, num);
			
			int count=ps.executeUpdate();
			if(count>0)
			{
				System.out.println("Record updation is successfully");
			}
			else
			{
				System.out.println("Record failed in updation");
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
