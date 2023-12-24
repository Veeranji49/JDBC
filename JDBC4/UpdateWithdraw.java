package JDBC4;
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
		Scanner sc=new Scanner(System.in);
		try
		{
			Class.forName(driver);
			System.out.println("driver is loaded");
			
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String uname="system";
			String pwd="Veeranji";
			
			con=DriverManager.getConnection(url,uname,pwd);
			System.out.println("Connection is established");
			
			String query="update ameerpet set fees=fees-? where id=?";
			PreparedStatement ps=con.prepareStatement(query);
			
			System.out.println("Enter id :");
			int id=sc.nextInt();
			
			System.out.println("Enter amt:");
			int amt=sc.nextInt();
			
			ps.setInt(1, amt);
			ps.setInt(2, id);
			int count=ps.executeUpdate();
			if(count>0)
			{
				System.out.println("Amount withdraw is successfully");
			}
			else
			{
				System.out.println("failed in withdraw amount");
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
