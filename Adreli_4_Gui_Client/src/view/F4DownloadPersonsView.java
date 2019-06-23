package view;

import java.awt.BorderLayout;

import javax.swing.JOptionPane;

public class F4DownloadPersonsView {
	
	public void downloadSuccessful(ClientMainView generalView) {
		generalView.getContentPane().remove(generalView.getTopPanelHm());
		generalView.getTopPanelHm().remove(generalView.getjLabelHm());
		generalView.getjLabelHm().setText("Download erfolgreich");
		generalView.getTopPanelHm().add(generalView.getjLabelHm());
		generalView.getContentPane().add(generalView.getTopPanelHm(), BorderLayout.PAGE_START);
		generalView.getContentPane().validate();
		generalView.getContentPane().repaint();
	}
	
	public void downloadUnSuccessful(ClientMainView generalView) {
		JOptionPane.showMessageDialog(null, "Keine Verbindung zum Server!", "Download nicht erfolgreich!", JOptionPane.WARNING_MESSAGE);
		generalView.getContentPane().remove(generalView.getTopPanelHm());
		generalView.getTopPanelHm().remove(generalView.getjLabelHm());
		generalView.getjLabelHm().setText("Download nicht erfolgreich");
		generalView.getTopPanelHm().add(generalView.getjLabelHm());
		generalView.getContentPane().add(generalView.getTopPanelHm(), BorderLayout.PAGE_START);
		generalView.getContentPane().validate();
		generalView.getContentPane().repaint();
	}
}
