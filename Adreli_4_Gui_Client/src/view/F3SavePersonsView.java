package view;

import java.awt.BorderLayout;

import javax.swing.JOptionPane;

public class F3SavePersonsView {
	
	public void saveSuccessfull(ClientMainView generalView) {
		generalView.getContentPane().remove(generalView.getTopPanelHm());
		generalView.getTopPanelHm().remove(generalView.getjLabelHm());
		generalView.getjLabelHm().setText("Speichern erfolgreich");
		generalView.getTopPanelHm().add(generalView.getjLabelHm());
		generalView.getContentPane().add(generalView.getTopPanelHm(), BorderLayout.PAGE_START);
		generalView.getContentPane().validate();
		generalView.getContentPane().repaint();
	}
	
	public void saveUnSuccessfull(ClientMainView generalView) {
		JOptionPane.showMessageDialog(null, "Keine Verbindung zum Server!", "Speichern nicht erfolgreich!", JOptionPane.WARNING_MESSAGE);
		generalView.getContentPane().remove(generalView.getTopPanelHm());
		generalView.getTopPanelHm().remove(generalView.getjLabelHm());
		generalView.getjLabelHm().setText("Speichern nicht erfolgreich");
		generalView.getTopPanelHm().add(generalView.getjLabelHm());
		generalView.getContentPane().add(generalView.getTopPanelHm(), BorderLayout.PAGE_START);
		generalView.getContentPane().validate();
		generalView.getContentPane().repaint();
	}
}
