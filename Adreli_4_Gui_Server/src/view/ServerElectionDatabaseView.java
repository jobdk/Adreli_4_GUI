package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * @version Adreli_4_Gui_Server
 * @author Jan-Hendrik Hausner
 * @author John Budnik
 * @author Luca Weinmann
 */

public class ServerElectionDatabaseView {
	private JButton datenbankButton;
	private JButton csvButton;
	
	/**
	 * 
	 * @param serverMainView
	 */
	public ServerElectionDatabaseView(ServerMainView serverMainView) {
		serverMainView.getjFrame().setSize(400, 200);
		
		serverMainView.getContentPane().remove(serverMainView.getTopPanelHm());
		serverMainView.getTopPanelHm().remove(serverMainView.getjLabelHm());
		serverMainView.getjLabelHm().setText("Datenbasis auswählen");
		serverMainView.getTopPanelHm().add(serverMainView.getjLabelHm());
		serverMainView.getContentPane().add(serverMainView.getTopPanelHm(), BorderLayout.PAGE_START);
		
		serverMainView.getContentPane().remove(serverMainView.getDonwpanelHm());
		serverMainView.getDonwpanelHm().removeAll();
		serverMainView.getDonwpanelHm().setLayout(new GridLayout(1,2));
		this.datenbankButton = new JButton("Datenbank");
		this.datenbankButton.setComponentPopupMenu(serverMainView.getjPopupMenu());
		this.csvButton = new JButton("CSV-Datei");
		this.csvButton.setComponentPopupMenu(serverMainView.getjPopupMenu());
		serverMainView.getDonwpanelHm().add(this.datenbankButton);
		serverMainView.getDonwpanelHm().add(this.csvButton);
		serverMainView.getContentPane().add(serverMainView.getDonwpanelHm(), BorderLayout.CENTER);
		serverMainView.getContentPane().validate();
		serverMainView.getContentPane().repaint();
	}
	
	
	/**
	 * 
	 * @param serverMainView
	 */
	public void datbaseChoosed(ServerMainView serverMainView) {
		serverMainView.getContentPane().remove(serverMainView.getTopPanelHm());
		serverMainView.getTopPanelHm().remove(serverMainView.getjLabelHm());
		serverMainView.getjLabelHm().setText("Datenbank ausgewählt");
		serverMainView.getTopPanelHm().add(serverMainView.getjLabelHm());
		serverMainView.getContentPane().add(serverMainView.getTopPanelHm(), BorderLayout.PAGE_START);
		serverMainView.getContentPane().validate();
		serverMainView.getContentPane().repaint();
	}
	
	
	/**
	 * 
	 * @param serverMainView
	 */
	public void csvChoosed(ServerMainView serverMainView) {
		serverMainView.getContentPane().remove(serverMainView.getTopPanelHm());
		serverMainView.getTopPanelHm().remove(serverMainView.getjLabelHm());
		serverMainView.getjLabelHm().setText("CSV-Datei ausgewählt");
		serverMainView.getTopPanelHm().add(serverMainView.getjLabelHm());
		serverMainView.getContentPane().add(serverMainView.getTopPanelHm(), BorderLayout.PAGE_START);
		serverMainView.getContentPane().validate();
		serverMainView.getContentPane().repaint();
	}
	
	
	/**
	 * 
	 * @param actionListener
	 */
	public void setActionListener(ActionListener actionListener) {
		this.datenbankButton.addActionListener(actionListener);
		this.csvButton.addActionListener(actionListener);
	}

	
	/**
	 * 
	 * @return datenbankButton
	 */
	public JButton getDatenbankButton() {
		return datenbankButton;
	}

	
	/**
	 * 
	 * @return csvButton;
	}

	 */
	public JButton getCsvButton() {
		return csvButton;
	}
}
