package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.Driver;
public class Sample2 {
public static void main(String[] args) throws Exception{
	DriverManager.registerDriver(new Driver());
	//Class.forName("com.mysql.jdbc.Driver").newInstance();
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sapient","root","root");
	PreparedStatement ps=con.prepareStatement("insert into employee values(?,?,?)");
	ps.setInt(1, 28);
	ps.setString(2, "vikas");
	ps.setInt(3, 28000);
	int status=ps.executeUpdate();
	System.out.println(status+" record inserted");
	ResultSet rs=ps.executeQuery("select *from employee");
	while(rs.next()){
		System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
	}
	con.close();
}
}
