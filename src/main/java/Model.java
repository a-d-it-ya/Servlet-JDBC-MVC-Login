import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Model {
	private String username;
	private String email;
	private String password;
	private String city;
	private Connection connection=null;
	private PreparedStatement ptsmt=null;
	private int row;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public int register(){
		try {
			connection = JdbcUtil.getDBConnection();
			String sql="INSERT INTO users(username,email,password,city) VALUES(?,?,?,?)";
			
			ptsmt=connection.prepareStatement(sql);
			
			ptsmt.setString(1, username);
            ptsmt.setString(2, email);
            ptsmt.setString(3, password);
            ptsmt.setString(4, city);
            
            row = ptsmt.executeUpdate();
            
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				JdbcUtil.closeResource(	connection, ptsmt);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return row;
	}
}
