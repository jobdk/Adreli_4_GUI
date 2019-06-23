package view;

import java.awt.BorderLayout;

import javax.swing.JOptionPane;

/**
 * @version Adreli_4_Gui_Server
 * @author Jan-Hendrik Hausner
 * @author John Budnik
 * @author Luca Weinmann
 */

public class ServerStopView {
	
	
	/**
	 * 
	 * @param serverMainView
	 */
	public void unSuccessfullServerStop(ServerMainView serverMainView) {
		JOptionPane.showMessageDialog(null, "Es wurde kein Server gestartet!", "Probleme beim Serverstop", JOptionPane.WARNING_MESSAGE);
		serverMainView.getContentPane().remove(serverMainView.getTopPanelHm());
		serverMainView.getTopPanelHm().remove(serverMainView.getjLabelHm());
		serverMainView.getjLabelHm().setText("Kein Server gestartet");
		serverMainView.getTopPanelHm().add(serverMainView.getjLabelHm());
		serverMainView.getContentPane().add(serverMainView.getTopPanelHm(), BorderLayout.PAGE_START);
		serverMainView.getContentPane().validate();
		serverMainView.getContentPane().repaint();
	}
	
	
	/**
	 * 
	 * @return JOptionPane
	 */
	public int quitServer() {
		return JOptionPane.showConfirmDialog(null, "Möchten sie den Server wirklich stoppen?", "Serverstopp", JOptionPane.YES_NO_CANCEL_OPTION);
	}
}