package sg.corporation.chopy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChopyApplication {
	public static void main(String[] args) {
		SpringApplication.run(ChopyApplication.class, args);
		System.out.println("running at : http://localhost:8080/Chopy");
	}
}