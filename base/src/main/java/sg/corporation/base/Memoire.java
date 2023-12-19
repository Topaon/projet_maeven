package sg.corporation.base;

public class Memoire {
	public static void memoire() {
		System.gc();
	    Runtime rt = Runtime.getRuntime();
	    long usedMB = (rt.totalMemory() - rt.freeMemory());
	    System.out.println(usedMB);
	}
}
