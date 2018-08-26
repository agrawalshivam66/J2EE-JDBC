import java.sql.*;
public class Batch_Ex {
	public static void main (String[] args) throws Exception
	{
		Connection con = Provider.getOracleConnection();
		String sql1 = "insert into student values (100,'raja',8.7)"; 
		String sql2 = "insert into student values (101,'rani',8.2)"; 
		String sql3 = "insert into student values (102,'ram',8.5)"; 
	Statement st = con.createStatement();
	st.addBatch(sql1);
	st.addBatch(sql2);
	st.addBatch(sql3);
	int status[] = st.executeBatch();
	for(int i=0;i<status.length;i++)
	{
		System.out.println(status[i]);
	}

	}

}
