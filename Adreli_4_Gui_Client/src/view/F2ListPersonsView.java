package view;

import java.awt.BorderLayout;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class F2ListPersonsView {
	private JTable tabelle;
	private DefaultTableModel defaultTableModel;
	
	/*public static void main(String[] args) {
		String [][] daten = {{"Hallo"}};
		String [] spalten = {"Hallo"};
		F2ListPersonsView f2ListPersonsView = new F2ListPersonsView(daten, spalten);
	}*/
	
	public F2ListPersonsView(Object[][] data, Object [] columnNames, ClientMainView generalView) {
		generalView.getContentPane().removeAll();
		generalView.getjFrame().setSize(1000, 400);
		generalView.getjFrame().setTitle("Gespeicherte Informationen");
		this.defaultTableModel = new DefaultTableModel(data, columnNames);
		this.tabelle = new JTable(defaultTableModel);
		this.tabelle.setComponentPopupMenu(generalView.getjPopupMenu());
		generalView.getContentPane().add(new JScrollPane(this.tabelle), BorderLayout.CENTER);
		generalView.getContentPane().validate();
		generalView.getContentPane().repaint();
	}
}
