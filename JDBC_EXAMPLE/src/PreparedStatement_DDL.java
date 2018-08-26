import java.sql.*;
import java.util.Scanner;
public class PreparedStatement_DDL {

	public static void main(String[] args)throws Exception{
		Connection con = Provider.getOracleConnection();
		boolean result;
		String sql;
		Scanner sc = new Scanner(System.in);
		
		//Create a table with the name which issued from keyboard
	System.out.println("Enter the table name ");
	String table_name=sc.next();	
		sql = "Create table "+table_name+"(id number(4), name varchar2(20))";
		PreparedStatement pst = con.prepareStatement(sql);
		result=pst.execute();
		if(result==false)
		{
			System.out.println("The table created sucessfully");
		}
		
		//1. no.of column, name ,data type,size are dynamic by using PreparedStatement
	System.out.println("Enter the table name ");
	  table_name=sc.next();	
	 System.out.println("Enter the number of columns ");
	 int n=sc.nextInt();
	 String s;
	 sql = "Create table "+table_name+" (";
	 for(int i=1;i<=n;i++)
	 {
		 System.out.println("Enter the column name datatype and size ");
		s = sc.nextLine();
		 sql=sql+s+", ";		 
	 }
	 sql=sql.substring(0,sql.length()-1);
		sql=sql+")";
		System.out.println(sql);
		 pst = con.prepareStatement(sql);
		result=pst.execute();
		if(result==false)
		{
			System.out.println("The table created sucessfully");
		}
				
		 //Change the column name for one to another dynamically
		System.out.println("Enter the old column name ");
		 String old_col=sc.next();
		 System.out.println("Enter the new column name ");
		 String new_col=sc.next();
		sql="alter table Student rename column "+old_col+" to "+new_col;
		 pst = con.prepareStatement(sql);
		result = pst.execute();
		if(result==false)
		{
			System.out.println("rename sucessful");
		}
		
		//3. change the data type by using PreparedStatement static
		sql="alter table Student modify(name varchar2(50))";
		 pst = con.prepareStatement(sql);
		result = pst.execute();
		if(result==false)
		{
			System.out.println(" size of name from 20 to 50 sucessful");
		}
	
		//4. rename the table dynamically
		System.out.println("Enter the old table name ");
		 String old_table=sc.next();
		 System.out.println("Enter the new table name ");
		 String new_table=sc.next();
		sql="rename "+old_table+" to "+ new_table;
		 pst = con.prepareStatement(sql);
		result = pst.execute();
		if(result==false)
		{
			System.out.println("renme sucessful");
		}
		
		//5 drop the table dynamically
		System.out.println("Enter the table name to drop");
		 String drop_table=sc.next();
		sql="drop table "+drop_table;
		 pst = con.prepareStatement(sql);
		result = pst.execute();
		if(result==false)
		{
			System.out.println("drop sucessful");
		}
	}

}
//Create the table in which 
//1. no.of column, name ,data type,size are dynamic by using PreparedStatement
//2. Change the column name for one to another dynamically
//3. change the data type by using PreparedStatement static
//4. rename the table dynamically
//5 drop the table dynamically

