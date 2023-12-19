package sg.corporation.echo;

import java.util.ArrayList;
import java.util.List;

import sg.corporation.echo.util.ComparateurSearch;

//@SpringBootApplication
public class EchoApplication {

	public static void main(String[] args) {
//		SpringApplication.run(EchoApplication.class, args);
		test();
	}
	
	public static void test() {
		
	}
	
	public static void search(String txt) {
		ComparateurSearch comp = new ComparateurSearch();
		
		List<String> maliste = new ArrayList<String>();
		maliste.add("fraise");
		maliste.add("banane");
		maliste.add("tarte à la fraise");
		maliste.add("tourte");
		
		for(String x : maliste) {
			if(comp.compare(txt, x) > txt.length()*2) {
				System.out.println(x + ", score : " + comp.compare(txt, x) + "/" + txt.length()*3);
			}
		}
	}
}