import java.sql.*;
public class Non_Scrollable_Ex {
public static void main(String[] args) throws Exception
{
	Connection con = Provider.getOracleConnection();
	Statement st = con.createStatement();
	String sql = "select cgpa, name, roll from student";
	
	ResultSet rs = st.executeQuery(sql);
	while(rs.next())
	{
		System.out.println(rs.getDouble(1)+"\t"+rs.getString("name")+"\t"+rs.getInt(3));
	}
}
}
