package sg.corporation.chopy;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChopyApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ChopyApplication.class, args);
		System.out.println("running at : http://localhost:8080/chopy");
	}
	
	public static void test() {
		String planning = "Lundi, Mardi, Mercredi, Jeudi";
		ArrayList<String> testParse = new ArrayList<String>(Arrays.asList(planning.split(", ")));
		testParse.add("Vendredi");
		for(String x : testParse) {
			System.out.println(x);
		}
	}
}