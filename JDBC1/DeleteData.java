package JDBC1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
public class DeleteData {
	public static void main(String[] args) throws ClassNotFoundException, SQLException
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
			System.out.println("Connection is Established");
			
			System.out.println("Enter wheel num:");
			int num=sc.nextInt();
			String query="delete from wheel where num=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, num);
			ps.executeUpdate();
			System.out.println("Deleted successfully");
			
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
