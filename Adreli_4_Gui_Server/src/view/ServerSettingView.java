package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.FocusListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * @version Adreli_4_Gui_Server
 * @author Jan-Hendrik Hausner
 * @author John Budnik
 * @author Luca Weinmann
 */

public class ServerSettingView {
	private JPanel jPanel;
	private JTextField hostTextField;
	private JTextField ipAddressTextField;
	private JLabel hostLabel;
	private JLabel ipAddressLabel;
	
	
	/**
	 * 
	 * @param serverMainView
	 */
	public ServerSettingView(ServerMainView serverMainView) {
		serverMainView.getContentPane().removeAll();
		serverMainView.getjFrame().setSize(400, 200);
		this.jPanel = new JPanel();
		this.jPanel.setComponentPopupMenu(serverMainView.getjPopupMenu());
		this.jPanel.setLayout(new GridLayout(2,2));
		this.ipAddressLabel = new JLabel("Server-IP-Adresse:", SwingConstants.CENTER);
		this.jPanel.add(this.ipAddressLabel);
		this.ipAddressTextField = new JTextField();
		this.ipAddressTextField.setComponentPopupMenu(serverMainView.getjPopupMenu());
		this.jPanel.add(this.ipAddressTextField);
		this.hostLabel = new JLabel("Port:", SwingConstants.CENTER);
		this.jPanel.add(this.hostLabel);
		this.hostTextField = new JTextField();
		this.hostTextField.setComponentPopupMenu(serverMainView.getjPopupMenu());
		this.jPanel.add(this.hostTextField);
		serverMainView.getjLabelHm().setText("Servereinstellungen");
		serverMainView.getContentPane().add(serverMainView.getTopPanelHm(), BorderLayout.PAGE_START);
		serverMainView.getContentPane().add(this.jPanel, BorderLayout.CENTER);
		serverMainView.getContentPane().validate();
		serverMainView.getContentPane().repaint();
	}
	
	
	/**
	 * 
	 * @param problem
	 */
	public void somethingNotRight(String problem) {
		JOptionPane.showMessageDialog(null, "Die Eingabe bei " + problem + " ist nicht korrekt", "Falsche Eingabe", JOptionPane.WARNING_MESSAGE);
	}
	
	
	/**
	 * 
	 * @param focusListener
	 */
	public void setFocusListener(FocusListener focusListener) {
		this.ipAddressTextField.addFocusListener(focusListener);
		this.hostTextField.addFocusListener(focusListener);
	}

	
	/**
	 * 
	 * @return hostTextField
	 */
	public JTextField getHostTextField() {
		return hostTextField;
	}

	
	/**
	 * 
	 * @return ipAddressTextField
	 */
	public JTextField getIpAddressTextField() {
		return ipAddressTextField;
	}
}
