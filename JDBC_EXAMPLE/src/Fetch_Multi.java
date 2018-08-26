import java.sql.*;
import java.io.*;
public class Fetch_Multi {

	public static void main(String[] args) throws Exception
	{
		Connection con = Provider.getOracleConnection();
	
		
		String sql = "select data from data_multi where slno=?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, 101);
		ResultSet rs = pst.executeQuery(); 
	if(rs.next())
	{
		FileOutputStream fos = new FileOutputStream("lit.mkv");
		InputStream iis = rs.getBinaryStream(1);
		int ch;
		while((ch=iis.read())!=-1)
		{
			fos.write(ch);
		}
	System.out.println("File sucessfully written");
	fos.close();
	iis.close();
	}
	}
}
