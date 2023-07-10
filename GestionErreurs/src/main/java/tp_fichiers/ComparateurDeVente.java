package tp_fichiers;

public class ComparateurDeVente implements java.util.Comparator<Vente> {

	@Override
	public int compare(Vente v1, Vente v2) {
		return (int) (v1.getCa() - v2.getCa());
	}	
}
