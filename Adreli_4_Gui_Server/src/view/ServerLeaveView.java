package view;

import javax.swing.JOptionPane;

/**
 * @version Adreli_4_Gui_Server
 * @author Jan-Hendrik Hausner
 * @author John Budnik
 * @author Luca Weinmann
 */

public class ServerLeaveView {
	
	/**
	 * 
	 * @return JOptionPane
	 */
	public int leaveServer() {
		return JOptionPane.showConfirmDialog(null, "Möchten sie das Servermenü wirklich verlassen", "Servermenü verlassen", JOptionPane.YES_NO_CANCEL_OPTION);
	}
}
