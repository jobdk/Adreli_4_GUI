package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class F1CreateNewPersonView {
	private JPanel buttonArea;
	private JPanel insertArea;
	
	private JLabel nameLabel;
	private JLabel vornameLabel;
	private JLabel anredeLabel;
	private JLabel strasseLabel;
	private JLabel plzLabel;
	private JLabel ortLabel;
	private JLabel telefonLabel;
	private JLabel faxLabel;
	private JLabel bemerkungLabel;
	
	private JTextField nameText;
	private JTextField vornameText;
	private JComboBox<String> anredeCombobox;
	private JTextField strasseText;
	private JTextField plzText;
	private JTextField ortText;
	private JTextField telefonText;
	private JTextField faxText;
	private JTextField bemerkungText;
	
	private JButton okButton;
	private JButton abbrechenButton;
	
	public F1CreateNewPersonView(ClientMainView generalView) {
		generalView.getContentPane().removeAll();
		generalView.getjFrame().setTitle("Eine neuen Person aufnehmen");
		generalView.getjFrame().setSize(400, 400);
		
		this.insertArea = new JPanel(new GridLayout(9,2));
		
		this.nameLabel = new JLabel("Name:", SwingConstants.CENTER);
		//this.nameLabel.setVerticalAlignment(JLabel.CENTER);
		this.insertArea.add(this.nameLabel);
		this.nameText = new JTextField();
		this.nameText.setComponentPopupMenu(generalView.getjPopupMenu());
		this.insertArea.add(this.nameText);
		
		this.vornameLabel = new JLabel("Vorname:", SwingConstants.CENTER);
		//this.vornameLabel.setVerticalAlignment(JLabel.CENTER);
		this.insertArea.add(this.vornameLabel);
		this.vornameText = new JTextField();
		this.vornameText.setComponentPopupMenu(generalView.getjPopupMenu());
		this.insertArea.add(this.vornameText);
		
		this.anredeLabel = new JLabel("Anrede:", SwingConstants.CENTER);
		this.insertArea.add(this.anredeLabel);
		this.anredeCombobox = new JComboBox<>();
		this.anredeCombobox.setComponentPopupMenu(generalView.getjPopupMenu());
		this.anredeCombobox.addItem("Herr");
		this.anredeCombobox.addItem("Frau");
		this.anredeCombobox.addItem("Divers");
		this.anredeCombobox.setEditable(false);
		this.insertArea.add(this.anredeCombobox);
		
		
		//this.anredeLabel.setVerticalAlignment(JLabel.CENTER);
		
		this.strasseLabel = new JLabel("Strasse:", SwingConstants.CENTER);
		//this.strasseLabel.setVerticalAlignment(JLabel.CENTER);
		this.insertArea.add(this.strasseLabel);
		this.strasseText = new JTextField();
		this.strasseText.setComponentPopupMenu(generalView.getjPopupMenu());
		this.insertArea.add(this.strasseText);
		
		this.plzLabel = new JLabel("PLZ:", SwingConstants.CENTER);
		//this.plzLabel.setVerticalAlignment(JLabel.CENTER);
		this.insertArea.add(this.plzLabel);
		this.plzText = new JTextField();
		this.plzText.setComponentPopupMenu(generalView.getjPopupMenu());
		this.insertArea.add(this.plzText);
		
		this.ortLabel = new JLabel("Ort:", SwingConstants.CENTER);
		//this.ortLabel.setVerticalAlignment(JLabel.CENTER);
		this.insertArea.add(this.ortLabel);
		this.ortText = new JTextField();
		this.ortText.setComponentPopupMenu(generalView.getjPopupMenu());
		this.insertArea.add(this.ortText);
		
		this.telefonLabel = new JLabel("Telefon:", SwingConstants.CENTER);
		//this.telefonLabel.setVerticalAlignment(JLabel.CENTER);
		this.insertArea.add(this.telefonLabel);
		this.telefonText = new JTextField();
		this.telefonText.setComponentPopupMenu(generalView.getjPopupMenu());
		this.insertArea.add(this.telefonText);
		
		this.faxLabel = new JLabel("Fax:", SwingConstants.CENTER);
		//this.faxLabel.setVerticalAlignment(JLabel.CENTER);
		this.insertArea.add(this.faxLabel);
		this.faxText = new JTextField();
		this.faxText.setComponentPopupMenu(generalView.getjPopupMenu());
		this.insertArea.add(this.faxText);
		
		//this.jDialog.add(this.jDialog);
		
		this.bemerkungLabel = new JLabel("Bemerkung:", SwingConstants.CENTER);
		//this.bemerkungLabel.setVerticalAlignment(JLabel.CENTER);
		this.insertArea.add(this.bemerkungLabel);
		this.bemerkungText = new JTextField();
		this.bemerkungText.setComponentPopupMenu(generalView.getjPopupMenu());
		this.insertArea.add(this.bemerkungText);
		
		this.buttonArea = new JPanel(new BorderLayout());
		
		this.okButton = new JButton("Person aufnehmen");
		this.okButton.setComponentPopupMenu(generalView.getjPopupMenu());
		this.abbrechenButton = new JButton("Abbrechen");
		this.abbrechenButton.setComponentPopupMenu(generalView.getjPopupMenu());
		this.buttonArea.add(this.okButton, BorderLayout.CENTER);
		this.buttonArea.add(this.abbrechenButton, BorderLayout.LINE_END);
		
		this.insertArea.setComponentPopupMenu(generalView.getjPopupMenu());
		this.buttonArea.setComponentPopupMenu(generalView.getjPopupMenu());
		generalView.getContentPane().add(this.insertArea, BorderLayout.CENTER);
		generalView.getContentPane().add(this.buttonArea, BorderLayout.PAGE_END);
		
		//generalView.getContentPane().add(generalView.mainMenueLabel(), BorderLayout.LINE_START);
		//generalView.getContentPane().add(generalView.mainMenueButton(), BorderLayout.LINE_START);
		generalView.getContentPane().validate();
		generalView.getContentPane().repaint();
	}
	
	public void setActionListener(ActionListener actionListener) {
		this.abbrechenButton.addActionListener(actionListener);
		this.okButton.addActionListener(actionListener);
	}
	
	public void okButtonNotFull() {
		JOptionPane.showMessageDialog(null, "Die Eingabefelder sind nicht vollständig", "Unvollständige Eingabefelder", JOptionPane.WARNING_MESSAGE);
	}
	
	public void somethingNotRight(String problem) {
		JOptionPane.showMessageDialog(null, "Die Eingabe bei " + problem + " ist nicht korrekt", "Falsche Eingabe", JOptionPane.WARNING_MESSAGE);
	}
	
	
	public JComboBox<String> getAnredeCombobox() {
		return anredeCombobox;
	}

	public JButton getOkButton() {
		return okButton;
	}

	public JButton getAbbrechenButton() {
		return abbrechenButton;
	}

	public JTextField getNameText() {
		return nameText;
	}

	public JTextField getVornameText() {
		return vornameText;
	}

	public JTextField getStrasseText() {
		return strasseText;
	}

	public JTextField getPlzText() {
		return plzText;
	}

	public JTextField getOrtText() {
		return ortText;
	}

	public JTextField getTelefonText() {
		return telefonText;
	}

	public JTextField getFaxText() {
		return faxText;
	}

	public JTextField getBemerkungText() {
		return bemerkungText;
	}
}
