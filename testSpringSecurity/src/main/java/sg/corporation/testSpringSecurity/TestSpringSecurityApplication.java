package sg.corporation.testSpringSecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestSpringSecurityApplication {
	public static void main(String[] args) {
		SpringApplication.run(TestSpringSecurityApplication.class, args);
		System.out.println("Application running at this url : http://localhost:8080");
	}
}