package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.FocusListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class F8ServerSettingView {
	private JPanel jPanel;
	private JTextField hostTextField;
	private JTextField ipAddressTextField;
	private JLabel hostLabel;
	private JLabel ipAddressLabel;
	
	public F8ServerSettingView(ClientMainView clientMainView) {
		clientMainView.getContentPane().removeAll();
		clientMainView.getjFrame().setSize(400, 200);
		this.jPanel = new JPanel();
		this.jPanel.setComponentPopupMenu(clientMainView.getjPopupMenu());
		this.jPanel.setLayout(new GridLayout(2,2));
		this.ipAddressLabel = new JLabel("Server-IP-Adresse:", SwingConstants.CENTER);
		this.jPanel.add(this.ipAddressLabel);
		this.ipAddressTextField = new JTextField();
		this.ipAddressTextField.setComponentPopupMenu(clientMainView.getjPopupMenu());
		this.jPanel.add(this.ipAddressTextField);
		this.hostLabel = new JLabel("Port:", SwingConstants.CENTER);
		this.jPanel.add(this.hostLabel);
		this.hostTextField = new JTextField();
		this.hostTextField.setComponentPopupMenu(clientMainView.getjPopupMenu());
		this.jPanel.add(this.hostTextField);
		clientMainView.getjLabelHm().setText("Servereinstellungen");
		clientMainView.getContentPane().add(clientMainView.getTopPanelHm(), BorderLayout.PAGE_START);
		clientMainView.getContentPane().add(this.jPanel, BorderLayout.CENTER);
		clientMainView.getContentPane().validate();
		clientMainView.getContentPane().repaint();
	}
	
	public void somethingNotRight(String problem) {
		JOptionPane.showMessageDialog(null, "Die Eingabe bei " + problem + " ist nicht korrekt", "Falsche Eingabe", JOptionPane.WARNING_MESSAGE);
	}
	
	public void setFocusListener(FocusListener focusListener) {
		this.ipAddressTextField.addFocusListener(focusListener);
		this.hostTextField.addFocusListener(focusListener);
	}

	public JTextField getHostTextField() {
		return hostTextField;
	}

	public JTextField getIpAddressTextField() {
		return ipAddressTextField;
	}
}
