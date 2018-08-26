import java.sql.*;
import org.apache.commons.dbcp.BasicDataSource;

public class BDS_Faster {
	public static void main (String args[]) throws Exception {
		String driver="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1522:xe";
		String username="system";
		String password="root";
		
		BasicDataSource bds = new BasicDataSource();
		bds.setDriverClassName(driver);
		bds.setUrl(url);
		bds.setUsername(username);
		bds.setPassword(password);
		
		long start,stop;
		start = System.currentTimeMillis();
		for(int i = 1;i<=50;i++)
		{
			Connection con = bds.getConnection();
			con.close();
		}
		stop= System.currentTimeMillis();
		System.out.println("Time taken BDS: "+(stop-start));
		System.out.println("------------------------------------");
		
		Class.forName(driver);
		start = System.currentTimeMillis();
		for(int i = 1;i<=50;i++)
		{
			
			Connection con = DriverManager.getConnection(url, username, password);
			con.close();
		}
		stop= System.currentTimeMillis();
		System.out.println("Time taken DriverManager: "+(stop-start));

}
}
