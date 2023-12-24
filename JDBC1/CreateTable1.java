package JDBC1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable1 {
	public static void main(String[] args) throws SQLException, ClassNotFoundException
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
			System.out.println("connection is Established");
			
			Statement st=con.createStatement();
			String query="create table wheel(num number(5), name varchar2(30), balance number(7))";
			st.execute(query);
			System.out.println("Table Created successfully");
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
