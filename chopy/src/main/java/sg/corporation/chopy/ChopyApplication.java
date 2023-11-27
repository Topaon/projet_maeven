package sg.corporation.chopy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class ChopyApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ChopyApplication.class, args);
		log.info("Démarrage réussi à l'url : http://localhost:8080/chopy");
	}
	
	public static void test() {
		
	}
}