import java.sql.*;
public class Type4_Conn_Ora_Mysql {

	public static void main(String args[]) throws Exception{
		Connection con_ora = Provider.getOracleConnection();
		Connection con_mysql = Provider.getMysqlConnection();
		
		if (con_ora != null)
		{
			System.out.println("Yes Connected with ORACLE");
			System.out.println(con_ora);
		}
	
	if (con_mysql != null)
	{
		System.out.println("Yes Connected with MySQL");
		System.out.println(con_mysql);
	}

	}
}

