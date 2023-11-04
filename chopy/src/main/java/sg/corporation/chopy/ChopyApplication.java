package sg.corporation.chopy;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChopyApplication {

	public static void main(String[] args) throws IOException, InterruptedException {
		SpringApplication.run(ChopyApplication.class, args);
		System.out.println("Server ready at the URL 'http://localhost:8080/chopy'");
//		test();
	}
	
	public static void test() {	
		String DB_URL = "jdbc:oracle:thin:@chopyoracle.ckjgk0obymny.eu-north-1.rds.amazonaws.com:1521:orcl";
	    String DB_USER = "chopyadmin";
	    String DB_PASSWORD = "chopychopy";
	    
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            System.out.println("Connexion réussi");
            Statement stmt = connection.createStatement();
            ResultSet set = stmt.executeQuery("SELECT * FROM mytable");
            set.next();
            System.out.println(set.getNString(2));
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
}