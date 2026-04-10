import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class JdbcUtil {
	static 
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("Driver is registered");
	}
	public static Connection getDBConnection() throws SQLException{
		String url = "jdbc:mysql://localhost:3306/user_db";
        String user = "root";
        String passcode = "Aditya@2002";
		return  DriverManager.getConnection(url, user, passcode);
	}
	public static void closeResource(Connection connect, Statement stmt) throws SQLException{
		if (connect!=null) {
			connect.close();
		} else {
			stmt.close();
		}
	}
}
