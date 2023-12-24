package JDBC4;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertData {
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
			System.out.println("connection is closed");
			Scanner sc=new Scanner(System.in);
			while(true)
			{
				System.out.println("Enter details:");
				int id=sc.nextInt();
				String name=sc.next();
				int fees=sc.nextInt();
			
			String query="insert into ameerpet values(?,?,?)";
			PreparedStatement ps=con.prepareStatement(query);
			
			ps.setInt(1,id);
			ps.setString(2,name);
			ps.setInt(3, fees);
			ps.executeUpdate();
			System.out.println("Table inserted successfully");
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
