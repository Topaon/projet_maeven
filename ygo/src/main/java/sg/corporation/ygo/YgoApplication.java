package sg.corporation.ygo;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class YgoApplication {

	public static void main(String[] args) {
		SpringApplication.run(YgoApplication.class, args);
		System.out.println("http://localhost:8080/ygo");
		
		MilieuYgoJson();
	}
	
	public static void MilieuYgoJson() {
		JSONParser jsp = new JSONParser();
		JSONObject jso;
		JSONArray arr;
		try {
			jso = (JSONObject) jsp.parse(new FileReader("C:/Users/Administrateur/OneDrive - M2I/Bureau/ygo.json"));
			arr = (JSONArray) jso.get("data");
			System.out.println( arr.get(0));
		} catch (ParseException | IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static void DebutYgoJson() {
		JSONParser jsp = new JSONParser();
		try {
			JSONObject jso = (JSONObject) jsp.parse(new FileReader("C:/Users/Administrateur/OneDrive - M2I/Bureau/ygo.json"));
			JSONArray arr = (JSONArray) jso.get("data");
			
			Set<String> listArchetypeWithoutDuplicates = new HashSet<>();
			for(int i=0; i<arr.size(); i++) {
				JSONObject j = (JSONObject) arr.get(i);
				listArchetypeWithoutDuplicates.add((String) j.get("archetype"));
			}
			for(String i:listArchetypeWithoutDuplicates) {
				System.out.println(i);
			}
			System.out.println(listArchetypeWithoutDuplicates.size());
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}