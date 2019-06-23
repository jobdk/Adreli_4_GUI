package view;

import javax.swing.JOptionPane;

public class F7LeaveProgrammView {
	public int leaveProgramm() {
		return JOptionPane.showConfirmDialog(null, "Sind sie sicher, dass sie das Programm verlassen wollen?" + "\n" + "Alle nicht gespeicherten Daten gehen verloren!", "Programm verlassen", JOptionPane.YES_NO_CANCEL_OPTION);
	}
}
