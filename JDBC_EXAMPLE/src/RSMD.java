import java.sql.*;

public class RSMD {

	public static void main(String args[]) throws Exception
	{
		Connection con = Provider.getOracleConnection();
		String sql = "select * from student";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		ResultSetMetaData rsmd = rs.getMetaData();
		int col_count = rsmd.getColumnCount();
		System.out.println("No. of column in table: "+col_count);
		
		for(int i = 1;i<=col_count;i++)
		{
			System.out.println(rsmd.getColumnLabel(i)+"\t"+rsmd.getColumnClassName(i)+"\t"+rsmd.getColumnTypeName(i));
		}
		}
}
