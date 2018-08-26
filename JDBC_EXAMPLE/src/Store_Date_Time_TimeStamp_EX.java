import java.sql.*;
public class Store_Date_Time_TimeStamp_EX {

	public static void main(String args[]) throws Exception
	{
		Connection con = Provider.getMysqlConnection();
		
		String sql = "insert into DTS values(?,?,?)";
		PreparedStatement pst = con.prepareStatement(sql);
		String d = "2018-06-22";
		String t = "05:50:45";
		String s = "2018-06-22 05:50:45";
		
		Date dd = Date.valueOf(d);
		Time tt = Time.valueOf(t);
		Timestamp ss = Timestamp.valueOf(s);
		
		pst.setDate(1, dd);
		pst.setTime(2, tt);
		pst.setTimestamp(3, ss);
		
		int status = pst.executeUpdate();
		if(status>0)
		{
			System.out.println("Date, time, TimeStamp inserted successfully" );
		}
		else
		{
			System.out.println("Date, time, TimeStamp insert not successfully" );
		}
			
	}
}
