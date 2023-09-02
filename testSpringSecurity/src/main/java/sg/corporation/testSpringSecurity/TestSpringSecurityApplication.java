package sg.corporation.testSpringSecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TestSpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestSpringSecurityApplication.class, args);
		System.out.println("Application running at this url : http://localhost:8080");
	}
	
	@GetMapping("/hello")
	public String helloWorld(@RequestParam(value="name", defaultValue = "World") String name) {
		System.out.println("/hello");
		return "Hello prout " + name + " !";
	}
}