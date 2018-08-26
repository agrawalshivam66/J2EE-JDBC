import java.sql.*;
import java.util.Scanner;
public class PreparedStatement_DML {

	public static void main (String[] args) throws Exception
	{
		Connection con = Provider.getOracleConnection();
		String sql;
		int status;
		Scanner sc = new Scanner(System.in);
		
		//Logic to insert record dynamically
		sql = "Insert into student values(?,?,?)";
		PreparedStatement pst = con.prepareStatement(sql);
		
			System.out.println("Enter the details for student : ");
			int roll=sc.nextInt();
			String name=sc.next();
			Double cgpa=sc.nextDouble();
			pst.setInt(1,roll);
			pst.setString(2,name);
			pst.setDouble(3, cgpa);
			status=pst.executeUpdate();
			if(status>0)
			{
				System.out.println("The values Inserted Sucessfully");
			}
					
		//Delete record using PreparedStatement
		//1. based on roll
		System.out.println("Enter the roll for student : ");
		int roll=sc.nextInt();
		sql = "delete from student where regno = "+roll;
	 pst = con.prepareStatement(sql);
			status=pst.executeUpdate();
			if(status>0)
			{
				System.out.println("The row deleted Sucessfully");
			}
			
			//2. based on name.
			System.out.println("Enter the name for student : ");
			String nam=sc.next();
			sql = "delete from student where name = "+nam;
		 pst = con.prepareStatement(sql);
				status=pst.executeUpdate();
				if(status>0)
				{
					System.out.println("The row deleted Sucessfully");
				}
			
			//3. based on cgpa.
			System.out.println("Enter the cgpa for student : ");
			 cgpa=sc.nextDouble();
			sql = "delete from student where cgpa = "+cgpa;
		 pst = con.prepareStatement(sql);
				status=pst.executeUpdate();
				if(status>0)
				{
					System.out.println("The row deleted Sucessfully");
				}
			
			//2. insert record based on yes input by using PreparedStatement
				
				String choice = "yes";
				while(choice.equalsIgnoreCase("yes"))
				{
					
					sql = "Insert into student values(?,?,?)";
					 pst = con.prepareStatement(sql);
					
						System.out.println("Enter the details for student : ");
						 roll=sc.nextInt();
						 name=sc.next();
						 cgpa=sc.nextDouble();
						pst.setInt(1,roll);
						pst.setString(2,name);
						pst.setDouble(3, cgpa);
						status=pst.executeUpdate();
						if(status>0)
						{
							System.out.println("The values Inserted Sucessfully");
						}
						 
						 System.out.println("Press yes if u want to enter more");
							 choice=sc.next();
						 
//				}
			
			//3. Update the record by using PreparedStatement
			System.out.println("Enter the old roll for student : ");
			int old_roll=sc.nextInt();
				System.out.println("Enter the details for student : ");
				 roll=sc.nextInt();
				 name=sc.next();
				 cgpa=sc.nextDouble();
			sql = "update student set roll="+roll+", name="+name+", cgpa="+cgpa+" where roll = "+old_roll;
		 pst = con.prepareStatement(sql);
				status=pst.executeUpdate();
				if(status>0)
				{
					System.out.println("The row updated Sucessfully");
				}
	
	
	
	}
		
	}

//Delete record using PreparedStatement
//1. based on roll
//2. based on name.
//3. based on cgpa.
//2. insert record based on yes input by using PreparedStatement
//3. Update the record by using PreparedStatement
//All the fields should be dynamic
