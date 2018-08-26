
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Scrollable_RS_Updatable {

public static void main(String args[]) throws Exception
{
	Connection con = Provider.getOracleConnection();
	Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
	
	String sql = "Select roll, name, cgpa from student";
	ResultSet rs = st.executeQuery(sql);
	
	rs.absolute(4);
	System.out.println("4th record ");
	System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getDouble(3));
	
	rs.moveToInsertRow();
	rs.updateInt(1, 110);
	rs.updateString(2, "ABC");
	rs.updateDouble(3, 9.1);
	rs.insertRow();
	System.out.println("Record Inserted");
	
	rs.absolute(3);
	rs.updateString(2, "XYZ");
	rs.updateDouble(3, 9.4);
	rs.updateRow();
	System.out.println("Record Updated");
	
	rs.absolute(2);
	rs.deleteRow();
	System.out.println("Record deleted");
	
}
}
