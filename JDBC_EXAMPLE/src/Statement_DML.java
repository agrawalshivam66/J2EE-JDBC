import java.sql.*;
import java.util.*;
public class Statement_DML {

	public static void main (String args[]) throws Exception
	{
		Connection con = Provider.getOracleConnection();
		Statement st = con.createStatement();
		String sql;
		int status;
		
		//update the record by 2 ways
		//1. static query name='XYZ',cgpa=6.6 where roll=100;
		//2. input by Scanner class name & cgpa and update

		//Delete the record by 2 ways
		//1. static query where roll = 101
		//2. input by scanner class and delete	
		
	
		
		// logic to insert record
		sql ="Insert into student values (100, 'raja',8.5)";
		status= st.executeUpdate(sql);
		
		if(status>0)
		{
			System.out.println("Record inserted Sucessfully");
		}
		else
		{
			System.out.println("Record inserted Unsucessful");
		}
		
		//logic to insert record
		int r=101;
		String n="rani";
		Double c = 8.4;
		
		sql = "insert into student values(" + r + ",'"+ n +"',"+c+")";
	status= st.executeUpdate(sql);
		
		if(status>0)
		{
			System.out.println("Record inserted Sucessfully");
		}
		else
		{
			System.out.println("Record inserted Unsucessful");
		}
		
		// logic to update record with static query
		sql ="update Student set name='XYZ',cgpa=6.6 where roll=100";
		status= st.executeUpdate(sql);
		
		if(status>0)
		{
			System.out.println("Record updated Sucessfully");
		}
		else
		{
			System.out.println("Record update Unsucessful");
		}
		
		
		// logic to update record with scanner class
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the name you want to update");
		 n = sc.next();
		System.out.println("Enter the CGPA you want to update");
		 c = sc.nextDouble();
		sql ="update Student set name='"+n+"',cgpa="+c+" where roll=100";
		status= st.executeUpdate(sql);
		
		if(status>0)
		{
			System.out.println("Record updated Sucessfully");
		}
		else
		{
			System.out.println("Record update Unsucessful");
		}
		
		
		// logic to delete record
		sql ="delete from Student where roll=100";
		status= st.executeUpdate(sql);
		
		if(status>0)
		{
			System.out.println("Record deleted Sucessfully");
		}
		else
		{
			System.out.println("Record delete Unsucessful");
		}
	
		// logic to delete record with scanner class
		System.out.println("Enter the roll you want to delete");
		r = sc.nextInt();
		sql ="delete from Student where roll="+r;
		status= st.executeUpdate(sql);
		
		if(status>0)
		{
			System.out.println("Record deleted Sucessfully");
		}
		else
		{
			System.out.println("Record delete Unsucessful");
		}
	}
}


