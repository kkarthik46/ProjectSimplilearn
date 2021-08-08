import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	public final static String url="jdbc:mysql://localhost:3306/student";
	public final static String username="root";
	public final static String password="123456";
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,username,password);
	return con;
	}

}
