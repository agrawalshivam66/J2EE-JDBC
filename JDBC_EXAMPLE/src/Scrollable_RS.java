import java.sql.*;
public class Scrollable_RS {
public static void main(String args[]) throws Exception
{
	Connection con = Provider.getOracleConnection();
	Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
	
	String sql = "Select roll, name, cgpa from student";
	ResultSet rs = st.executeQuery(sql);
	System.out.println("Traverse in forward direction");
	while(rs.next())
	{
		System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getDouble(3));
	}
	
	rs.afterLast();
	System.out.println("Traverse in background direction");
	while(rs.previous())
	{
		System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getDouble(3));
	}
	
	rs.absolute(4);
	System.out.println("4th record");
		System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getDouble(3));
		
	rs.afterLast();
	System.out.println(rs.getRow());
	rs.beforeFirst();
	System.out.println(rs.getRow());
	
	rs.first();
	System.out.println("First record");
	System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getDouble(3));
	
	rs.last();
	System.out.println("First record");
	System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getDouble(3));

System.out.println(rs.isLast());
System.out.println(rs.isFirst());
System.out.println(rs.isBeforeFirst());
System.out.println(rs.isAfterLast());

rs.absolute(3);
//rs.deleteRow(); Not Possible as it is read only ResultSet

}
}


//Following are the method of Scrollable ResultSet
//-------------------------------------------------
//getRow(): It returns the row number pointed by cursor pointer.
//isFirst(): Check the cursor pointer, pointing to first record or not.
//isLast(): Check the cursor pointer, pointing to last record or not.
//isBeforeFirst(): Check cursor pointer, pointing ti before first row or not.
//isAfterLast(): Check cursor pointer, pointing to after last row or not.
//first(): Move the cursor pointer to first row.
//last(): Move the cursor pointer to last row.
//absolute(): Move the cursor pointer to a specific row.
//deleteRow(): delete a record from ResultSet and also deleted from DB
//insertRow(): insert a record into ResultSet and also inserted into DB table.
//updateRow(): Update the record in ResultSet and alse updated in DB.
//moveToInsertRow(): move the cursor pointer to inserted row.