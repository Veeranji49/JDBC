package JDBC1;

public class LoadDriver1 {
	public static void main(String[] args)
	{
		String driver="oracle.jdbc.driver.OracleDriver";
		try
		{
			Class.forName(driver);
			System.out.println("Driver loaded");
			
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("Exception:Driver is not present");
		}
	}

}
