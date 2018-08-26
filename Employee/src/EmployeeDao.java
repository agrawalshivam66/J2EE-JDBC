import java.sql.Connection;
import java.sql.PreparedStatement;

public class EmployeeDao {
public static int save(String id,String name,String designation,String ctc,String dob,String date_of_joining){
	int status=0;
	try{
		Connection con=DB.getConnection();
		PreparedStatement ps=con.prepareStatement("insert into employee values(?,?,?,?,?,?)");
		ps.setString(1,id);
		ps.setString(2,name);
		ps.setString(3,designation);
		ps.setString(4,ctc);
		ps.setString(5,dob);
		ps.setString(6, date_of_joining);
		status=ps.executeUpdate();
		con.close();
	}catch(Exception e){System.out.println(e);}
	return status;
}

public static int delete(int id) {
	// TODO Auto-generated method stub
	return 0;
}
}
