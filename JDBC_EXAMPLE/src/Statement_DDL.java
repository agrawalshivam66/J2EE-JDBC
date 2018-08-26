import java.sql.*;
public class Statement_DDL {

	public static void main(String[] args) throws Exception
	{
		Connection con = Provider.getOracleConnection();
		Statement st= con.createStatement();
		boolean result;
		String sql;
		
		//1. Change the column name from roll to regno
		//2. Change the size of name from 20 to 50
		//3. Rename the table from student to std.
		
		//logic to drop a table
		sql="drop table student";
		result = st.execute(sql);
		if(result==false)
		{
			System.out.println("Table dropped successfully...");
		}
		//logic to drop a table
		sql="drop table std";
		result = st.execute(sql);
		if(result==false)
		{
			System.out.println("Table dropped successfully...");
		}
		
		//logic to create a table
		sql="Create table Student(roll number(4), name varchar2(20), cgpa number(3,1))";
		result = st.execute(sql);
		if(result==false)
		{
			System.out.println("Table created successfully...");
		}
		
		//logic to change column name 
		sql="alter table Student rename column roll to regno";
		result = st.execute(sql);
		if(result==false)
		{
			System.out.println("rename sucessful");
		}
		
		//logic to change size of name 
		sql="alter table Student modify(name varchar2(50))";
		result = st.execute(sql);
		if(result==false)
		{
			System.out.println(" size of name from 20 to 50 sucessful");
		}
		
		//logic to renam Student to std
				sql="rename Student to std";
				result = st.execute(sql);
				if(result==false)
				{
					System.out.println(" Rename table sucessful");
				}
	}
}
