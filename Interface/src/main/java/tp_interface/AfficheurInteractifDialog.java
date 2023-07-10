package tp_interface;

import javax.swing.JOptionPane;

public class AfficheurInteractifDialog extends AfficheurDialog {

	public String ecrire() {
		String ecrire = JOptionPane.showInputDialog(null, null);
		return ecrire;
	}
}
