import java.sql.*;
import java.util.Scanner;
public class Callable_Procedure {

	public static void main(String[] args)throws Exception
	{
		Connection con = Provider.getOracleConnection();
		CallableStatement cst = con.prepareCall("{call proc_insert (?,?,?)}");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the details for student(Roll,Name,Cgpa):");
		int roll = sc.nextInt();
		String name = sc.next();
		double cgpa =sc.nextDouble();
		cst.setInt(1,roll);
		cst.setString(2, name);
		cst.setDouble(3,cgpa);
		
		cst.execute();
		System.out.println("Procedure executed sucessfully");
		System.out.println("Record inserted sucessfully");
		
		//1. Procedure which will delete a record based in roll	
		System.out.println("Enter the roll to delete:");
		 roll = sc.nextInt();
		CallableStatement cst2 = con.prepareCall("{call del_rec_roll(?)}");
		cst2.setInt(1,roll);
		cst2.execute();
		System.out.println("Record deleted sucessfully");
		
		
	
		//2. procedure which accept roll, name, cgpa and update record based on roll
		 con = Provider.getOracleConnection();
		 cst = con.prepareCall("{call upd_rec_roll(?,?,?)}");
		
		 sc = new Scanner(System.in);
		
		System.out.println("Enter the details for student(Roll,Name,Cgpa):");
		 roll = sc.nextInt();
	 name = sc.next();
		 cgpa =sc.nextDouble();
		cst.setInt(1,roll);
		cst.setString(2, name);
		cst.setDouble(3,cgpa);
		
		cst.execute();
		System.out.println("Procedure executed sucessfully");
		System.out.println("Record updated sucessfully");
	
	}
}

/*
  create or replace procedure proc_insert
(r number , n varchar2, c number)
is
begin
	insert into student values(r,n,c);
end proc_insert;
/
 */
//1. Procedure which will delete a record based in roll
/*
create or replace procedure del_rec_roll(r number)
is
begin
delete from student where roll=r;

 end del_rec_roll;
 /
 */
//2. procedure which accept roll, name, cgpa and update record based on roll

/*
create or replace procedure upd_rec_roll(r number, n varchar2, c number)
is
begin
update student set name=n, cgpa=c where roll=r; 

 end upd_rec_roll;
 /
 */
