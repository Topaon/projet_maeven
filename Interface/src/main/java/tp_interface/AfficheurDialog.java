package tp_interface;

import javax.swing.JOptionPane;

public class AfficheurDialog implements Afficheur {
	public void affiche(String text) {
		JOptionPane.showMessageDialog(null, text);
	}
}
