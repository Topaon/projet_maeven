package app;

import crud.Stagiaire;
import crud.StagiaireService;

public class MyApp {

	public static void main(String[] args) {
		StagiaireService ss = new StagiaireService();
		for(Stagiaire i : ss.getAllStagiaires()) {
			System.out.println(i.toString());
		}
	}
}