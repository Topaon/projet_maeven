package sg.corporation.echo.service;

import java.util.ArrayList;
import java.util.List;

public class ServiceEcho {
	
	public static List<String> salutations = new ArrayList<>();
	public static List<String> message = new ArrayList<>();
	
	public static String reponseEcho(String msg) {
		String reponse = "";
		
		salutations.add("bonjour");
		salutations.add("salut");
		salutations.add("coucou");
		salutations.add("hey");
		
		String[] mots = msg.split(" ");
		
		for(String x : mots) {
			message.add(x);
		}
		
		if(message.contains("coucou")) {
			reponse = "Bonjour !";
		}
		
		return reponse;
	}
}