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
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.MenuListener;

public class ClientMainView {
	private static final long serialVersionUID = 1L;
	private JFrame jFrame;
	private Container contentPane;
	private JMenuBar jMenuBar;
	private JMenu jMenuAdministration;
	private JMenu jMenuMainMenu;
	
	private JMenuItem addPersonBar;
	private JMenuItem listPersonsBar;
	private JMenuItem savePersonsBar;
	private JMenuItem downloadPersonsBar;
	private JMenuItem sortPersonsBar;
	private JMenuItem numberingInDatabaseBar;
	private JMenuItem serverSettingBar;
	private JMenuItem leaveProgrammBar;

	private JLabel jLabelHm;
	private JPanel topPanelHm;
	private JPanel downPanelHm;
	
	private JButton addPersonsHm;
	private JButton listPersonHm;
	private JButton savePersonHm;
	private JButton downloadPersonHm;
	private JButton sortPersonsHm;
	private JButton numberPersonsHm;
	private JButton serverSettingHm;
	private JButton leaveProgrammHm;
	
	private ImageIcon image;
	
	private JPopupMenu jPopupMenu;
	private JMenuItem addPersonsPopup;
	private JMenuItem listPersonPopup;
	private JMenuItem savePersonsPopup;
	private JMenuItem downloadPersonsPopup;
	private JMenuItem sortPersonsPopup;
	private JMenuItem numberingInDatabasePopup;
	private JMenuItem serverSettingPopup;
	private JMenuItem leaveProgrammPopup;
	
	public void setActionListener(ActionListener actionListener) {
		this.addPersonBar.addActionListener(actionListener);
		this.listPersonsBar.addActionListener(actionListener);
		this.savePersonsBar.addActionListener(actionListener);
		this.downloadPersonsBar.addActionListener(actionListener);
		this.sortPersonsBar.addActionListener(actionListener);
		this.numberingInDatabaseBar.addActionListener(actionListener);
		this.serverSettingBar.addActionListener(actionListener);
		this.leaveProgrammBar.addActionListener(actionListener);
		
		this.addPersonsHm.addActionListener(actionListener);
		this.listPersonHm.addActionListener(actionListener);
		this.savePersonHm.addActionListener(actionListener);
		this.downloadPersonHm.addActionListener(actionListener);
		this.sortPersonsHm.addActionListener(actionListener);
		this.numberPersonsHm.addActionListener(actionListener);
		this.serverSettingHm.addActionListener(actionListener);
		this.leaveProgrammHm.addActionListener(actionListener);
		
		this.addPersonsPopup.addActionListener(actionListener);
		this.listPersonPopup.addActionListener(actionListener);
		this.savePersonsPopup.addActionListener(actionListener);
		this.downloadPersonsPopup.addActionListener(actionListener);
		this.sortPersonsPopup.addActionListener(actionListener);
		this.numberingInDatabasePopup.addActionListener(actionListener);
		this.serverSettingPopup.addActionListener(actionListener);
		this.leaveProgrammPopup.addActionListener(actionListener);
	}
	
	public void setMenuListener(MenuListener menuListener) {
		this.jMenuMainMenu.addMenuListener(menuListener);
	}
	
	
	public void mainMenuView() {
		this.jFrame = new JFrame();
		this.image = new ImageIcon("icon.png");
		this.jFrame.setIconImage(image.getImage());
		this.contentPane = this.jFrame.getContentPane();
		this.jMenuBar = new JMenuBar();
		this.jMenuAdministration = new JMenu("Verwaltungsfunktionen");
		this.jMenuMainMenu = new JMenu("Hauptmenü");
		
		this.addPersonBar = new JMenuItem("Person aufnehmen");
		this.listPersonsBar = new JMenuItem("Records auflisten");
		this.savePersonsBar = new JMenuItem("Records sichern");
		this.downloadPersonsBar = new JMenuItem("Records laden");
		this.sortPersonsBar = new JMenuItem("Records sortieren");
		this.numberingInDatabaseBar = new JMenuItem("Datensaetze in Datenbasis nummerieren");
		this.serverSettingBar = new JMenuItem("Servereinstellungen");
		this.leaveProgrammBar = new JMenuItem("Programm verlassen");
		
		this.jMenuBar.add(this.jMenuAdministration);
		this.jMenuBar.add(this.jMenuMainMenu);
		this.jMenuAdministration.add(this.addPersonBar);
		this.jMenuAdministration.add(this.listPersonsBar);
		this.jMenuAdministration.add(this.savePersonsBar);
		this.jMenuAdministration.add(this.downloadPersonsBar);
		this.jMenuAdministration.add(this.sortPersonsBar);
		this.jMenuAdministration.add(this.numberingInDatabaseBar);
		this.jMenuAdministration.add(this.serverSettingBar);
		this.jMenuAdministration.add(this.leaveProgrammBar);
		
		this.jFrame.setJMenuBar(this.jMenuBar);
		
		this.addPersonsPopup = new JMenuItem("Person aufnehmen");
		this.listPersonPopup = new JMenuItem("Percords auflisten");
		this.savePersonsPopup = new JMenuItem("Records sichern");
		this.downloadPersonsPopup = new JMenuItem("Records laden");
		this.sortPersonsPopup = new JMenuItem("Records sortieren");
		this.numberingInDatabasePopup = new JMenuItem("Datensaetze in Datenbasis nummerieren");
		this.serverSettingPopup = new JMenuItem("Servereinstellungen");
		this.leaveProgrammPopup = new JMenuItem("Programm verlassen");
		
		this.jPopupMenu = new JPopupMenu();
		this.jPopupMenu.add(this.addPersonsPopup);
		this.jPopupMenu.add(this.listPersonPopup);
		this.jPopupMenu.add(this.savePersonsPopup);
		this.jPopupMenu.add(this.downloadPersonsPopup);
		this.jPopupMenu.add(this.sortPersonsPopup);
		this.jPopupMenu.add(this.numberingInDatabasePopup);
		this.jPopupMenu.add(this.serverSettingPopup);
		this.jPopupMenu.add(this.leaveProgrammPopup);
		
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			SwingUtilities.updateComponentTreeUI(this.jFrame);
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		catch (InstantiationException e) {
			e.printStackTrace();
		} 
		catch (IllegalAccessException e) {
			e.printStackTrace();
		} 
		catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		this.mainMenueLabel();
		this.mainMenueButton();
		this.addContentPane();
		
		this.jFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				JFrame jFrame = (JFrame) windowEvent.getSource();
				if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null, "Sind sie sicher, dass sie das Programm verlassen wollen?" + "\n" + "Alle nicht gespeicherten Daten gehen verloren!", "Programm verlassen", JOptionPane.YES_NO_CANCEL_OPTION)) {
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
		
		
		//this.contentPane.removeAll();
	}
	
	public void addContentPane() {
		this.jFrame.setSize(400, 400);
		this.jFrame.setTitle("Adreli - Adresslistenverwaltung");
		this.contentPane.add(this.topPanelHm, BorderLayout.PAGE_START);
		this.contentPane.add(this.downPanelHm, BorderLayout.CENTER);
	}
	
	
	public JPanel mainMenueLabel() {
		this.topPanelHm = new JPanel(new BorderLayout());
		this.topPanelHm.setComponentPopupMenu(this.jPopupMenu);
		this.jLabelHm = new JLabel("Hauptmenü", SwingConstants.CENTER);
		this.jLabelHm.setFont(new Font("Serial", Font.PLAIN, 30));
		this.topPanelHm.add(this.jLabelHm, BorderLayout.CENTER);
		return this.topPanelHm;
	}
	
	public JPanel mainMenueButton() {
		this.downPanelHm = new JPanel(new GridLayout(4,2));
		this.downPanelHm.setComponentPopupMenu(this.jPopupMenu);
		this.addPersonsHm = new JButton("Person aufnehmen");
		this.addPersonsHm.setComponentPopupMenu(this.jPopupMenu);
		this.downPanelHm.add(this.addPersonsHm);
		this.listPersonHm = new JButton("Records auflisten");
		this.listPersonHm.setComponentPopupMenu(this.jPopupMenu);
		this.downPanelHm.add(this.listPersonHm);
		this.savePersonHm = new JButton("Records sichern");
		this.savePersonHm.setComponentPopupMenu(this.jPopupMenu);
		this.downPanelHm.add(this.savePersonHm);
		this.downloadPersonHm = new JButton("Records laden");
		this.downloadPersonHm.setComponentPopupMenu(this.jPopupMenu);
		this.downPanelHm.add(this.downloadPersonHm);
		this.sortPersonsHm = new JButton("Records sortieren");
		this.sortPersonsHm.setComponentPopupMenu(this.jPopupMenu);
		this.downPanelHm.add(this.sortPersonsHm);
		this.numberPersonsHm = new JButton("Datensätze nummerieren");
		this.numberPersonsHm.setComponentPopupMenu(jPopupMenu);
		this.downPanelHm.add(this.numberPersonsHm);
		this.serverSettingHm = new JButton("Servereinstellungen");
		this.serverSettingHm.setComponentPopupMenu(this.jPopupMenu);
		this.downPanelHm.add(this.serverSettingHm);
		this.leaveProgrammHm = new JButton("Programm verlassen");
		this.leaveProgrammHm.setComponentPopupMenu(this.jPopupMenu);
		this.downPanelHm.add(this.leaveProgrammHm);
		return this.downPanelHm;	
	}
	
	
	
	public JMenuItem getServerSettingBar() {
		return serverSettingBar;
	}

	public JButton getServerSettingHm() {
		return serverSettingHm;
	}

	public JMenuItem getServerSettingPopup() {
		return serverSettingPopup;
	}
	
	public JButton getLeaveProgrammHm() {
		return leaveProgrammHm;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public JMenu getjMenuMainMenu() {
		return jMenuMainMenu;
	}


	public JFrame getjFrame() {
		return this.jFrame;
	}

	public Container getContentPane() {
		return contentPane;
	}

	public JMenuBar getjMenuBar() {
		return jMenuBar;
	}

	public JMenu getjMenu() {
		return jMenuAdministration;
	}

	public JMenuItem getAddPerson() {
		return addPersonBar;
	}

	public JMenuItem getListPersons() {
		return listPersonsBar;
	}

	public JMenuItem getSavePersons() {
		return savePersonsBar;
	}

	public JMenuItem getDownloadPersons() {
		return downloadPersonsBar;
	}

	public JMenuItem getSortPersons() {
		return sortPersonsBar;
	}

	public JMenuItem getNumberingInDatabase() {
		return numberingInDatabaseBar;
	}

	public JMenuItem getLeaveProgramm() {
		return leaveProgrammBar;
	}

	public JLabel getjLabelHm() {
		return jLabelHm;
	}

	public JPanel getTopPanelHm() {
		return topPanelHm;
	}

	public JPanel getDownPanelHm() {
		return downPanelHm;
	}

	public JButton getAddPersonsHm() {
		return addPersonsHm;
	}

	public JButton getListPersonHm() {
		return listPersonHm;
	}

	public JButton getSavePersonHm() {
		return savePersonHm;
	}

	public JButton getDownloadPersonHm() {
		return downloadPersonHm;
	}

	public JButton getSortPersonsHm() {
		return sortPersonsHm;
	}

	public JButton getNumberPersonsHm() {
		return numberPersonsHm;
	}

	public JMenuItem getAddPersonsPopup() {
		return addPersonsPopup;
	}

	public JMenuItem getListPersonPopup() {
		return listPersonPopup;
	}

	public JMenuItem getSavePersonsPopup() {
		return savePersonsPopup;
	}

	public JMenuItem getDownloadPersonsPopup() {
		return downloadPersonsPopup;
	}

	public JMenuItem getSortPersonsPopup() {
		return sortPersonsPopup;
	}

	public JMenuItem getNumberingInDatabasePopup() {
		return numberingInDatabasePopup;
	}

	public JMenuItem getLeaveProgrammPopup() {
		return leaveProgrammPopup;
	}

	public JPopupMenu getjPopupMenu() {
		return jPopupMenu;
	}

	public void setjPopupMenu(JPopupMenu jPopupMenu) {
		this.jPopupMenu = jPopupMenu;
	}
}
