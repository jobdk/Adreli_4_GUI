package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.MenuListener;

/**
 * @version Adreli_4_Gui_Server
 * @author Jan-Hendrik Hausner
 * @author John Budnik
 * @author Luca Weinmann
 */

public class ServerMainView {
	private JFrame jFrame;
	private Container contentPane;
	private JMenuBar jMenuBar;
	private JMenu jMenuAdministration;
	private JMenu jMenuMainMenu;
	private JMenuItem serverStartItem;
	private JMenuItem serverStopItem;
	private JMenuItem wahlServerPortItem;
	private JMenuItem electionDatabaseItem;
	
	private JLabel jLabelHm;
	private JPanel topPanelHm;
	private JPanel donwpanelHm;
	
	private JButton serverStartButton;
	private JButton serverStopButton;
	private JButton wahlServerPortButton;
	private JButton electionDatabaseButton;
	
	private JPopupMenu jPopupMenu;
	private JMenuItem serverStartPopup;
	private JMenuItem serverStopPopup;
	private JMenuItem wahlServerPortPopup;
	private JMenuItem electionDatabasePopup;
	
	private ImageIcon imageIcon;
	//private JPopupMenu jPopupMenu;
	
	
	public ServerMainView() {
		this.jFrame = new JFrame("Adreli - Serververwaltung");
		this.imageIcon = new ImageIcon("icon.png");
		this.jFrame.setIconImage(this.imageIcon.getImage());
		this.contentPane = this.jFrame.getContentPane();
		this.contentPane.setLayout(new BorderLayout());
		
		this.jPopupMenu = new JPopupMenu();
		this.serverStartPopup = new JMenuItem("Server starten");
		this.serverStopPopup = new JMenuItem("Server stoppen");
		this.electionDatabasePopup = new JMenuItem("Datenbasis auswählen");
		this.wahlServerPortPopup = new JMenuItem("Servereinstellungen");
		this.jPopupMenu.add(this.serverStartPopup);
		this.jPopupMenu.add(this.serverStopPopup);
		this.jPopupMenu.add(this.electionDatabasePopup);
		this.jPopupMenu.add(this.wahlServerPortPopup);
		
		this.jMenuBar = new JMenuBar();
		this.jMenuAdministration = new JMenu("Serverfunktionen");
		this.jMenuMainMenu = new JMenu("Hauptmenü");
		this.serverStartItem = new JMenuItem("Server starten");
		this.serverStopItem = new JMenuItem("Server stoppen");
		this.wahlServerPortItem = new JMenuItem("Servereinstellungen");
		this.electionDatabaseItem = new JMenuItem("Datenbasis auswählen");
		
		this.jMenuBar.add(this.jMenuAdministration);
		this.jMenuBar.add(this.jMenuMainMenu);
		this.jMenuAdministration.add(this.serverStartItem);
		this.jMenuAdministration.add(this.serverStopItem);
		this.jMenuAdministration.add(this.electionDatabaseItem);
		this.jMenuAdministration.add(this.wahlServerPortItem);
		this.jFrame.setJMenuBar(this.jMenuBar);
		
		this.serverStartButton = new JButton("Server starten");
		this.serverStartButton.setComponentPopupMenu(this.jPopupMenu);
		this.serverStopButton = new JButton("Server stoppen");
		this.serverStopButton.setComponentPopupMenu(this.jPopupMenu);
		this.wahlServerPortButton = new JButton("Servereinstellungen");
		this.wahlServerPortButton.setComponentPopupMenu(this.jPopupMenu);
		this.electionDatabaseButton = new JButton("Datenbasis auswählen");
		this.electionDatabaseButton.setComponentPopupMenu(this.jPopupMenu);
		this.addContentPane();
		
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			SwingUtilities.updateComponentTreeUI(this.jFrame);
		}
		catch (ClassNotFoundException cnf) {
			cnf.printStackTrace();
		}
		catch (InstantiationException ie) {
			ie.printStackTrace();
		}
		catch (IllegalAccessException iae) {
			iae.printStackTrace();
		}
		catch (UnsupportedLookAndFeelException ul) {
			ul.printStackTrace();
		}
		this.jFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				JFrame jFrame = (JFrame) windowEvent.getSource();
				if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null, "Sind sie sicher, dass sie das Programm verlassen wollen?" + "\n"+  "Alle nicht gespeicherten Daten gehen verloren!", "Programm verlassen", JOptionPane.YES_NO_CANCEL_OPTION)) {
					jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}
				else {
					jFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				}
			}
		});
		this.jFrame.setLocation(200, 200);
		this.jFrame.setBackground(Color.LIGHT_GRAY);
		this.jFrame.setVisible(true);
	}
	
	
	public void addContentPane() {
		this.jFrame.setSize(400, 400);
		this.donwpanelHm = new JPanel();
		this.donwpanelHm.setLayout(new GridLayout(2,2));
		this.donwpanelHm.setComponentPopupMenu(this.jPopupMenu);
		this.topPanelHm = new JPanel();
		this.topPanelHm.setComponentPopupMenu(this.jPopupMenu);
		this.jLabelHm = new JLabel("Hauptmenü");
		this.jLabelHm.setFont(new Font("Serial", Font.PLAIN, 35));
		this.topPanelHm.add(this.jLabelHm);
		this.donwpanelHm.add(this.serverStartButton);
		this.donwpanelHm.add(this.serverStopButton);
		this.donwpanelHm.add(this.electionDatabaseButton);
		this.donwpanelHm.add(this.wahlServerPortButton);
		this.contentPane.add(this.topPanelHm, BorderLayout.PAGE_START);
		this.contentPane.add(this.donwpanelHm, BorderLayout.CENTER);
	}
	
	
	/**
	 * 
	 * @param actionListener
	 */
	public void setActionListener(ActionListener actionListener) {
		this.serverStartItem.addActionListener(actionListener);
		this.serverStopItem.addActionListener(actionListener);
		this.wahlServerPortItem.addActionListener(actionListener);
		this.electionDatabaseItem.addActionListener(actionListener);
		this.serverStartButton.addActionListener(actionListener);
		this.serverStopButton.addActionListener(actionListener);
		this.wahlServerPortButton.addActionListener(actionListener);
		this.electionDatabaseButton.addActionListener(actionListener);
		this.serverStartPopup.addActionListener(actionListener);
		this.serverStopPopup.addActionListener(actionListener);
		this.wahlServerPortPopup.addActionListener(actionListener);
		this.electionDatabasePopup.addActionListener(actionListener);
	}
	
	
	/**
	 * 
	 * @param menuListener
	 */
	public void setMenuListener(MenuListener menuListener) {
		this.jMenuMainMenu.addMenuListener(menuListener);
	}

	
	/**
	 * 
	 * @return jFrame
	 */
	public JFrame getjFrame() {
		return jFrame;
	}

	
	/**
	 * 
	 * @return contentPane
	 */
	public Container getContentPane() {
		return contentPane;
	}

	
	/**
	 * 
	 * @return jMenuBar
	 */
	public JMenuBar getjMenuBar() {
		return jMenuBar;
	}

	
	/**
	 * 
	 * @return jMenuAdministration
	 */
	public JMenu getjMenuAdministration() {
		return jMenuAdministration;
	}

	
	/**
	 * 
	 * @return jMenuMainMenu
	 */
	public JMenu getjMenuMainMenu() {
		return jMenuMainMenu;
	}

	
	/**
	 * 
	 * @return serverStartItem
	 */
	public JMenuItem getServerStartItem() {
		return serverStartItem;
	}

	
	/**
	 * 
	 * @return serverStopItem
	 */
	public JMenuItem getServerStopItem() {
		return serverStopItem;
	}

	
	/**
	 * 
	 * @return wahlServerPortItem
	 */
	public JMenuItem getWahlServerPortItem() {
		return wahlServerPortItem;
	}

	
	/**
	 * 
	 * @return electionDatabaseItem
	 */
	public JMenuItem getElectionDatabaseItem() {
		return electionDatabaseItem;
	}

	
	/**
	 * 
	 * @return jLabelHm
	 */
	public JLabel getjLabelHm() {
		return jLabelHm;
	}

	
	/**
	 * 
	 * @return topPanelHm
	 */
	public JPanel getTopPanelHm() {
		return topPanelHm;
	}

	
	/**
	 * 
	 * @return donwpanelHm
	 */
	public JPanel getDonwpanelHm() {
		return donwpanelHm;
	}

	
	/**
	 *  
	 * @return serverStartButton
	 */
	public JButton getServerStartButton() {
		return serverStartButton;
	}

	
	/**
	 * 
	 * @return serverStopButton
	 */
	public JButton getServerStopButton() {
		return serverStopButton;
	}

	
	/**
	 * 
	 * @return wahlServerPortButton
	 */
	public JButton getWahlServerPortButton() {
		return wahlServerPortButton;
	}

	
	/**
	 * 
	 * @return electionDatabaseButton
	 */
	public JButton getElectionDatabaseButton() {
		return electionDatabaseButton;
	}

	
	/**
	 * 
	 * @return jPopupMenu
	 */
	public JPopupMenu getjPopupMenu() {
		return jPopupMenu;
	}

	
	/**
	 * 
	 * @return serverStartPopup
	 */
	public JMenuItem getServerStartPopup() {
		return serverStartPopup;
	}

	
	/**
	 * 
	 * @return serverStopPopup
	 */
	public JMenuItem getServerStopPopup() {
		return serverStopPopup;
	}

	
	/**
	 * 
	 * @return wahlServerPortPopup
	 */
	public JMenuItem getWahlServerPortPopup() {
		return wahlServerPortPopup;
	}

	
	/**
	 * 
	 * @return electionDatabasePopup
	 */
	public JMenuItem getElectionDatabasePopup() {
		return electionDatabasePopup;
	}

	
	/**
	 * 
	 * @return imageIcon
	 */
	public ImageIcon getImageIcon() {
		return imageIcon;
	}
}

