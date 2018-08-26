import java.sql.*;
public class Fetch_Date {
public static void main (String args[]) throws Exception{
	Connection con = Provider.getMysqlConnection();
	Statement st = con.createStatement();
	String sql = "select * from dts";
	ResultSet rs = st.executeQuery(sql);
	while(rs.next())
	{
		System.out.println(rs.getDate(1)+"\t"+rs.getTime(2)+"\t"+rs.getTimestamp(3));
		
	}
}
}
