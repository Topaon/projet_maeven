package tp;

public class MyApp {

	public static void main(String[] args) {
		Personne Joe = new Personne("Joe", "Dalton", 32);
		System.out.println(Joe.getAge());
		
		Personne William = new Personne();
		
		System.out.println(Joe.getPrenom());
		Joe.setPrenom("Avrell");
		System.out.println(Joe.getPrenom());
		
		System.out.println(Joe.test());
		System.out.println(Joe.test("quatre"));
	}
}
