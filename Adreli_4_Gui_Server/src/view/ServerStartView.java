package view;

import java.awt.BorderLayout;
import javax.swing.JOptionPane;

/**
 * @version Adreli_4_Gui_Server
 * @author Jan-Hendrik Hausner
 * @author John Budnik
 * @author Luca Weinmann
 */

public class ServerStartView {
	
	
	/**
	 * 
	 * @param serverMainView
	 */
	public void successfullServerStart(ServerMainView serverMainView) {
		serverMainView.getContentPane().remove(serverMainView.getTopPanelHm());
		serverMainView.getTopPanelHm().remove(serverMainView.getjLabelHm());
		serverMainView.getjLabelHm().setText("Server gestartet");
		serverMainView.getTopPanelHm().add(serverMainView.getjLabelHm());
		serverMainView.getContentPane().add(serverMainView.getTopPanelHm(), BorderLayout.PAGE_START);
		serverMainView.getContentPane().validate();
		serverMainView.getContentPane().repaint();
		
	}
	
	
	/**
	 * 
	 * @param serverMainView
	 */
	public void unSuccessfullServerStart(ServerMainView serverMainView) {
		JOptionPane.showMessageDialog(null, "Server wurde bereits gestartet!", "Probleme beim Serverstart", JOptionPane.WARNING_MESSAGE);
		serverMainView.getContentPane().remove(serverMainView.getTopPanelHm());
		serverMainView.getTopPanelHm().remove(serverMainView.getjLabelHm());
		serverMainView.getjLabelHm().setText("Server bereits gestartet");
		serverMainView.getTopPanelHm().add(serverMainView.getjLabelHm());
		serverMainView.getContentPane().add(serverMainView.getTopPanelHm(), BorderLayout.PAGE_START);
		serverMainView.getContentPane().validate();
		serverMainView.getContentPane().repaint();
	}
}
