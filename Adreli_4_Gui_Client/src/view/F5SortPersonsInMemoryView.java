package view;

import java.awt.BorderLayout;

public class F5SortPersonsInMemoryView {
	public F5SortPersonsInMemoryView(ClientMainView generalView) {
		generalView.getContentPane().remove(generalView.getTopPanelHm());
		generalView.getTopPanelHm().remove(generalView.getjLabelHm());
		generalView.getjLabelHm().setText("Sortierung abgeschlossen");
		generalView.getTopPanelHm().add(generalView.getjLabelHm());
		generalView.getContentPane().add(generalView.getTopPanelHm(), BorderLayout.PAGE_START);
		generalView.getContentPane().validate();
		generalView.getContentPane().repaint();
	}
}
