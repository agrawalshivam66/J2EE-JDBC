import java.sql.*;
import java.util.Scanner;
public class Callable_Function {
	public static void main(String[] args) throws Exception
	{
		Connection con = Provider.getOracleConnection();
		CallableStatement cst=con.prepareCall("{?=call find_max_cgpa(?,?,?)}");
		cst.registerOutParameter(1, Types.DOUBLE);
	Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the details for student(Roll,Name,Cgpa):");
		int roll = sc.nextInt();
		String name = sc.next();
		double cgpa =sc.nextDouble();
		cst.setInt(2,roll);
		cst.setString(3, name);
		cst.setDouble(4,cgpa);
		
		cst.execute();
		System.out.println("Max cgpa is "+cst.getDouble(1));
		System.out.println("Function executed sucessfully");
		System.out.println("Record inserted sucessfully");
		
		//3. function  which find out no. of student present in student table.	
		
		CallableStatement cst2=con.prepareCall("{?=call find_no_std}");
		cst2.registerOutParameter(1, Types.INTEGER);		
		cst2.execute();
		System.out.println("total number of student is "+cst2.getInt(1));
		System.out.println("Function executed sucessfully");
		
		CallableStatement cst3=con.prepareCall("{?=call find_min_cgpa}");
		cst3.registerOutParameter(1, Types.DOUBLE);		
		cst3.execute();
		System.out.println("Min CGPA is "+cst3.getDouble(1));
		System.out.println("Function executed sucessfully");
	}
	}
/*
create or replace function find_max_cgpa(r number, n varchar2, c number)
return number
is 
 	max_cgpa number(3,1);
begin
insert into student values(r,n,c);
select max(cgpa) into max_cgpa from student;
return max_cgpa;

 end find_max_cgpa;
 /
 */

/*

//3. function  which find out no. of student present in student table.
 
create or replace function find_no_std
return number
is 
 	no number(4);
begin
select count(*) into no from student;

return no;

 end find_no_std;
 /
 */

//4. function which find out minimum cgpa.
/*
create or replace function find_min_cgpa
return number
is 
 	min_cgpa number(3,1);
begin
select min(cgpa) into min_cgpa from student;
return min_cgpa;

 end find_min_cgpa;
 /
 */