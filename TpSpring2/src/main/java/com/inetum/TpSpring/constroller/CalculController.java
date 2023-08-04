package com.inetum.TpSpring.constroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/calcul")
public class CalculController {

	@RequestMapping("/saisieHt")
	public String versSaisieTva(Model model) {
		return "declencherCalcul";
	}
	
	// URL : http://localhost:8080/TpSpring2/calcul/calculTva?montantHt=100&taux=20
	// ou
	// URL : http://localhost:8080/TpSpring2/calcul/calculTva avec valeurs transmise via un formulaire
	@RequestMapping("/calculTva")
	public String calculTva(Model model,
			@RequestParam(name="montantHt") Double montantHt,
			@RequestParam(name="taux") Double taux) {
		Double tva = taux/100 * montantHt;
		Double montantTtc = montantHt + tva;
		
		model.addAttribute("tva", tva);
		model.addAttribute("montantTtc", montantTtc);
		return "resTva"; // on renvoie la page resTva.jsp
	}	
}