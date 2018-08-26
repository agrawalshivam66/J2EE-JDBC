import java.sql.Connection;
import java.sql.Statement;
public class Transaction {
	public static void main (String[] args) throws Exception
	{
		Connection con = Provider.getOracleConnection();
		String sql1 = "insert into student values (100,'raja',8.7)"; 
		String sql2 = "insert into student values (101,'rani',8.2)"; 
		String sql3 = "insert into student values (102,'ram',8.5)"; 
		String sql4 = "Delete from student where roll=101";
		
	Statement st = con.createStatement();
	con.setAutoCommit(false);
	
	int status1,status2,status3,status4;
	status1=st.executeUpdate(sql1);
	status2=st.executeUpdate(sql2);
	status3=st.executeUpdate(sql3);
	status4=st.executeUpdate(sql4);
	
	System.out.println(status1 +"\t"+status2+"\t"+status3+"\t"+status4 );
	
	if(status1>0 && status2>0 && status3>0 && status4>0)
	{
		con.commit();
		System.out.println("Commited...");
	}
	else
	{
		con.rollback();
		System.out.println("Rollback...");
	}
	
	}

}


