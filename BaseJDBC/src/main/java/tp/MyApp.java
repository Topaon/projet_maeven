package tp;

import java.lang.reflect.Field;
import java.util.Random;

import tp.entity.Personne;

public class MyApp {

	public static void main(String[] args) {
		
		testIntrospection();
		
	}
	
	public static void test() {
		
		Random generateur = new Random();
		int c1 = generateur.nextInt(10);
		int c2 = generateur.nextInt(10);
		int c3 = generateur.nextInt(10);
		int c4 = generateur.nextInt(10);
		
		System.out.println("\t" + c1 + " " + c2 + " " + c3 + " " + c4);
		
	}
	
	public static void testIntrospection() {
		try {
			Personne p1 = new Personne(1, "Simon", "Granier");
			Class<?> c = p1.getClass();
			Field[] fields = c.getDeclaredFields();
			System.out.println("Liste des attributs :");
			for(Field f : fields) {
				f.setAccessible(true);
				String fieldValue = f.get(p1)==null?null:f.get(p1).toString();
				System.out.println(f.getName() + "\t" + 
							f.getType().getSimpleName() + "\t"+ 
							"de valeur " + fieldValue);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
