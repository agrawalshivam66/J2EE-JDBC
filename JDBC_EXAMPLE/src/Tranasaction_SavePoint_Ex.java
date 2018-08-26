import java.sql.*;
public class Tranasaction_SavePoint_Ex {
		public static void main (String[] args) throws Exception
		{
			Connection con = Provider.getOracleConnection();
			String sql1 = "insert into student values (100,'raja',8.7)"; 
			String sql2 = "insert into student values (101,'rani',8.2)"; 
			String sql3 = "insert into student values (102,'ram',8.5)"; 
			String sql4 = "insert into student values (103,'lal',8.4)"; 
			
		Statement st = con.createStatement();
		con.setAutoCommit(false);
		
		int status1,status2,status3,status4;
		status1=st.executeUpdate(sql1);
		Savepoint sp1 = con.setSavepoint();
				
		status2=st.executeUpdate(sql2);
		status3=st.executeUpdate(sql3);
		Savepoint sp2 = con.setSavepoint();
		
		status4=st.executeUpdate(sql4);
		con.rollback(sp2);
		con.rollback(sp1);
		con.commit();
			System.out.println("Commited...");
			
		}

	}

