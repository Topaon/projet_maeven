package sg.corporation.chopy;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChopyApplication {

	public static void main(String[] args) throws IOException, InterruptedException {
		SpringApplication.run(ChopyApplication.class, args);
		System.out.println("Application launched successfully");
//		test();
	}
	
	public static void test() {	
		System.out.println("coucou");
	}
}