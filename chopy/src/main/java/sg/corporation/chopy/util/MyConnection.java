package sg.corporation.chopy.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MyConnection {
	
	public static Connection getConnection() {
		ResourceBundle res = ResourceBundle.getBundle("jdbc");
		
		String driver = res.getString("driver");
		String url = res.getString("url");
		String user = res.getString("user");
		String password = res.getString("password");
		
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}
}
