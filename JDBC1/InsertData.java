package JDBC1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
public class InsertData {
	public static void main(String[] args) throws SQLException, ClassNotFoundException
	{
		String driver="oracle.jdbc.driver.OracleDriver";
		Connection con=null;
		Scanner sc=new Scanner(System.in);
		
		try
		{
			Class.forName(driver);
			System.out.println("driver loaded");
			
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String uname="system";
			String pwd="Veeranji";
			
			con=DriverManager.getConnection(url,uname,pwd);
			System.out.println("connection is established");
			while(true)
			{
			System.out.println("Enter wheel details:");
			int num=sc.nextInt();
			String name=sc.next();
			double balance=sc.nextDouble();
			String query="insert into wheel values(?,?,?)";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, num);
			ps.setString(2, name);
			ps.setDouble(3,balance);
			ps.executeUpdate();
			System.out.println("Inserted successfully");
			System.out.println("y/n");
			}
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
