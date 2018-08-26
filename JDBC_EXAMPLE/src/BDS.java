import java.sql.*;

import org.apache.commons.dbcp.BasicDataSource;
public class BDS {
	public static void main (String args[]) throws SQLException {
		String driver="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1522:xe";
		String username="system";
		String password="root";
		
		BasicDataSource bds = new BasicDataSource();
		bds.setDriverClassName(driver);
		bds.setUrl(url);
		bds.setUsername(username);
		bds.setPassword(password);
		Connection con = bds.getConnection();
		if(con!=null)
		{
			System.out.println("Connected with oracle using BDS");
		}
	}

}
