package view;

import java.awt.BorderLayout;

import javax.swing.JOptionPane;

public class F6NumberingServiceView {
	public void numberingSuccessfull(ClientMainView clientMainView) {
		clientMainView.getContentPane().remove(clientMainView.getTopPanelHm());
		clientMainView.getTopPanelHm().remove(clientMainView.getjLabelHm());
		clientMainView.getjLabelHm().setText("Nummerierung erfolgreich");
		clientMainView.getTopPanelHm().add(clientMainView.getjLabelHm());
		clientMainView.getContentPane().add(clientMainView.getTopPanelHm(), BorderLayout.PAGE_START);
		clientMainView.getContentPane().validate();
		clientMainView.getContentPane().repaint();
	}
	
	public void numberingUnSuccessfull(ClientMainView clientMainView) {
		JOptionPane.showMessageDialog(null, "Keine Verbinung zum Server!", "Download nicht erfolgreich!", JOptionPane.WARNING_MESSAGE);
		clientMainView.getContentPane().remove(clientMainView.getTopPanelHm());
		clientMainView.getTopPanelHm().remove(clientMainView.getjLabelHm());
		clientMainView.getjLabelHm().setText("Keine Nummerierung");
		clientMainView.getTopPanelHm().add(clientMainView.getjLabelHm());
		clientMainView.getContentPane().add(clientMainView.getTopPanelHm(), BorderLayout.PAGE_START);
		clientMainView.getContentPane().validate();
		clientMainView.getContentPane().repaint();
	}

}
