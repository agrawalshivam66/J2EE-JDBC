import java.io.*;
import java.sql.*;
public class Store_Multi_Data_Ex {
	
	public static void main (String args[]) throws Exception{
	Connection con = Provider.getOracleConnection();
	String sql = "insert into Data_multi values(?,?)";
	PreparedStatement pst = con.prepareStatement(sql);
	
	FileInputStream fis = new FileInputStream("Marvel.mkv");
	
	pst.setInt(1, 101);
	pst.setBinaryStream(2, fis, fis.available());
	
	
	
	int status = pst.executeUpdate();
	if(status>0)
	{
		System.out.println("Multimedia inserted successfully" );
	}
	else
	{
		System.out.println("Multimedia insert not successfully" );
	}
}
}
