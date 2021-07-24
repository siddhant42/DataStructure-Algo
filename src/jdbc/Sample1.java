package jdbc;
import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Sample1 {
public static void main(String[] args) throws Exception{
	//String drivername="com.mysql.jdbc.Driver";
	//Class.forName(drivername).newInstance();
	DriverManager.registerDriver(new Driver());
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sapient","root","root");
	Statement st=con.createStatement();
	int status=st.executeUpdate("delete from employee where id=21");

	ResultSet rs=st.executeQuery("select *from employee");
	rs.last();
	rs.previous();
	while(rs.next()){
		System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
	}
	con.close();
}
}
