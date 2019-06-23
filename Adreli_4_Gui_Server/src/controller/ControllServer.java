package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import model.MultipleServer;
import service.ServerSettingImpl;
import view.ServerCollectionView;
import view.ServerElectionDatabaseView;
import view.ServerSettingView;
import view.ServerStartView;
import view.ServerStopView;

/**
 * @version Adreli_4_Gui_Server
 * @author Jan-Hendrik Hausner
 * @author John Budnik
 * @author Luca Weinmann
 */

public class ControllServer{
	private Thread thread;
	private ServerCollectionView serverCollectionView;
	private MultipleServer multipleServer;
	private PrintWriter printWriter;
	
	
	/**
	 * @param serverCollectionView
	 */
	public ControllServer(ServerCollectionView serverCollectionView) {
		this.serverCollectionView = serverCollectionView;
		try {
			ControllServer.this.printWriter = new PrintWriter("adrelilog.csv");
		} 
		catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		ControllServer.this.serverCollectionView.setServerStartView(new ServerStartView());	
		this.addListener();
		this.multipleServer = new MultipleServer("adreli.csv", new ServerSettingImpl(), ControllServer.this.serverCollectionView.getServerStartView(), ControllServer.this.serverCollectionView.getServerMainView());
	    Thread shutdownActions = new Thread(new ShutdownActions());
	    Runtime.getRuntime().addShutdownHook(shutdownActions);
	}
	
	
	private void addListener() {
		this.serverCollectionView.getServerMainView().setActionListener(new MyActionListener());
		this.serverCollectionView.getServerMainView().setMenuListener(new MyMenuListener());
	}
	
	
	private void addServerElectionDatabaseListener() {
		this.serverCollectionView.getServerElectionDatabaseView().setActionListener(new MyServerElectionDatabaseListener());
	}
	
	
	private void addServerSettingListener() {
		this.serverCollectionView.getServerSettingView().setFocusListener(new MyFocusListener());
	}
	
	
	
	
	class ShutdownActions implements Runnable {  
		
		
	    public void run() {
	    	ControllServer.this.printWriter.close();
	    }
	 }
	
	
	
	
	class MyActionListener implements ActionListener {
		
		
		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			//Startfunktion
			if (actionEvent.getSource() == ControllServer.this.serverCollectionView.getServerMainView().getServerStartItem()
					|| actionEvent.getSource() == ControllServer.this.serverCollectionView.getServerMainView().getServerStartButton()
					|| actionEvent.getSource() == ControllServer.this.serverCollectionView.getServerMainView().getServerStartPopup()) {	
				ControllServer.this.thread = new Thread(ControllServer.this.multipleServer);
				ControllServer.this.thread.start();
				ControllServer.this.printWriter.println(new SimpleDateFormat("yyyy.MM.dd - HH:mm:ss ").format(new Date()).concat("--> Server wurde gestartet"));
			}
			
			//Stopfunktion
			if (actionEvent.getSource() == ControllServer.this.serverCollectionView.getServerMainView().getServerStopItem()
					|| actionEvent.getSource() == ControllServer.this.serverCollectionView.getServerMainView().getServerStopButton()
					|| actionEvent.getSource() == ControllServer.this.serverCollectionView.getServerMainView().getServerStopPopup()) {
				ControllServer.this.serverCollectionView.setServerStopView(new ServerStopView());
				try {
					if (JOptionPane.YES_OPTION == ControllServer.this.serverCollectionView.getServerStopView().quitServer()) {
						ControllServer.this.thread.interrupt();
						ControllServer.this.printWriter.println(new SimpleDateFormat("yyyy.MM.dd - HH:mm:ss ").format(new Date()).concat("--> Server wurde gestoppt"));
						System.exit(0);
					}
				}
				catch (NullPointerException npe) {
					ControllServer.this.printWriter.println(new SimpleDateFormat("yyyy.MM.dd - HH:mm:ss ").format(new Date()).concat(" --> Server wurde nicht ordnungsgemäß gestoppt"));
					ControllServer.this.serverCollectionView.getServerStopView().unSuccessfullServerStop(ControllServer.this.serverCollectionView.getServerMainView());
					ControllServer.this.printWriter.println(new SimpleDateFormat("yyyy.MM.dd - HH:mm:ss ").format(new Date()).concat("--> Server wurde nicht gestoppt"));
				}
			}
			
			//Servereinstellungen
			if (actionEvent.getSource() == ControllServer.this.serverCollectionView.getServerMainView().getWahlServerPortItem()
					|| actionEvent.getSource() == ControllServer.this.serverCollectionView.getServerMainView().getWahlServerPortButton()
					|| actionEvent.getSource() == ControllServer.this.serverCollectionView.getServerMainView().getWahlServerPortPopup()) {
				ControllServer.this.serverCollectionView.setServerSettingView(new ServerSettingView(ControllServer.this.serverCollectionView.getServerMainView()));
				ControllServer.this.serverCollectionView.getServerSettingView().getHostTextField().setText(ControllServer.this.multipleServer.getServerSettingImpl().getHostAddress());
				ControllServer.this.serverCollectionView.getServerSettingView().getIpAddressTextField().setText(ControllServer.this.multipleServer.getServerSettingImpl().getServerIpAddress());
				ControllServer.this.addServerSettingListener();
			}
			
			//Datenbasis auswaehlen
			if (actionEvent.getSource() == ControllServer.this.serverCollectionView.getServerMainView().getElectionDatabaseItem()
					|| actionEvent.getSource() == ControllServer.this.serverCollectionView.getServerMainView().getElectionDatabaseButton()
					|| actionEvent.getSource() == ControllServer.this.serverCollectionView.getServerMainView().getElectionDatabasePopup()) {
				ControllServer.this.serverCollectionView.setServerElectionDatabaseView(new ServerElectionDatabaseView(ControllServer.this.serverCollectionView.getServerMainView()));
				ControllServer.this.addServerElectionDatabaseListener();
			}
			
		}
	}
	
	
	
	
	class MyServerElectionDatabaseListener implements ActionListener {
		
		
		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if (actionEvent.getSource() == ControllServer.this.serverCollectionView.getServerElectionDatabaseView().getDatenbankButton()) {
				ControllServer.this.serverCollectionView.getServerElectionDatabaseView().datbaseChoosed(ControllServer.this.serverCollectionView.getServerMainView());
				ControllServer.this.printWriter.println(new SimpleDateFormat("yyyy.MM.dd - HH:mm:ss ").format(new Date()).concat("--> Datenbank als Datenbasis wurde ausgewählt"));
			}
			if (actionEvent.getSource() == ControllServer.this.serverCollectionView.getServerElectionDatabaseView().getCsvButton()) {
				ControllServer.this.serverCollectionView.getServerElectionDatabaseView().csvChoosed(ControllServer.this.serverCollectionView.getServerMainView());
				ControllServer.this.printWriter.println(new SimpleDateFormat("yyyy.MM.dd - HH:mm:ss ").format(new Date()).concat("--> CSV-Datei als Dastenbasis wurde ausgewählt"));
			}
		}
	}
	
	
	
	
	class MyMenuListener implements MenuListener {
		
		
		@Override
		public void menuCanceled(MenuEvent menuEvent) {
		}

		
		@Override
		public void menuDeselected(MenuEvent menuEvent) {
		}

		
		@Override
		public void menuSelected(MenuEvent menuEvent) {
			if (ControllServer.this.serverCollectionView.getServerMainView().getjMenuMainMenu() == menuEvent.getSource()) {
				ControllServer.this.serverCollectionView.getServerMainView().getContentPane().removeAll();
				ControllServer.this.serverCollectionView.getServerMainView().addContentPane();
				ControllServer.this.serverCollectionView.getServerMainView().getContentPane().validate();
				ControllServer.this.serverCollectionView.getServerMainView().getContentPane().repaint();
			}
		}		
	}
	
	
	
	
	class MyFocusListener extends FocusAdapter {
		
		
		public void focusLost(FocusEvent focusEvent) {
			if (ControllServer.this.multipleServer.getServerSettingImpl().patternMatcher(ServerSettingImpl.PATTERNPORT, ControllServer.this.serverCollectionView.getServerSettingView().getHostTextField().getText())) {
				ControllServer.this.multipleServer.getServerSettingImpl().setHostAddress(ControllServer.this.serverCollectionView.getServerSettingView().getHostTextField().getText());
				ControllServer.this.printWriter.println(new SimpleDateFormat("yyyy.MM.dd - HH:mm:ss ").format(new Date()).concat("--> Server hat neue Host-Adresse: ").concat(ControllServer.this.serverCollectionView.getServerSettingView().getHostTextField().getText()));
				if (ControllServer.this.multipleServer.getServerSettingImpl().patternMatcher(ServerSettingImpl.PATTERNIP, ControllServer.this.serverCollectionView.getServerSettingView().getIpAddressTextField().getText())) {
					ControllServer.this.multipleServer.getServerSettingImpl().setServerIpAddress(ControllServer.this.serverCollectionView.getServerSettingView().getIpAddressTextField().getText());
					ControllServer.this.printWriter.println(new SimpleDateFormat("yyyy.MM.dd - HH:mm:ss ").format(new Date()).concat("--> Server hat neue IP-Adresse: ").concat(ControllServer.this.serverCollectionView.getServerSettingView().getIpAddressTextField().getText()));
				}
				else {
					ControllServer.this.serverCollectionView.getServerSettingView().somethingNotRight("Server-IP-Adresse");
				}	
			}
			else {
				ControllServer.this.serverCollectionView.getServerSettingView().somethingNotRight("Port");
			}
		}
	}
}
