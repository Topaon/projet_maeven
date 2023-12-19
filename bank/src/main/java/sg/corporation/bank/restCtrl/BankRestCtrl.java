package sg.corporation.bank.restCtrl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bank-api") // mapping du rest controller, par défaut "*"
public class BankRestCtrl {
	
	@GetMapping // mapping du service, à ajouter à l'adresse du rest ctrl
	String getRequest() {
		return "Bonjour je m'appelle Simon et j'ai 26 ans";
	}
	
	@GetMapping("/autre") // mapping du service, à ajouter à l'adresse du rest ctrl
	String anotherGetRequest() {
		return "autre requète";
	}
}