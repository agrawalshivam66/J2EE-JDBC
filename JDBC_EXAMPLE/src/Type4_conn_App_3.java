import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;
public class Type4_conn_App_3 {
	public static void main(String args[])
	{
		Connection con = null;
		try
		{
			Properties p = new Properties();
			p.load(new FileInputStream("db.properties"));
			Class.forName(p.getProperty("driver"));
			con = DriverManager.getConnection(p.getProperty("url"),p);
			
			if (con != null)
			{
				System.out.println("Connected with ORACLE DB using TYPE-4 approach 3");
				System.out.println(con);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
}
