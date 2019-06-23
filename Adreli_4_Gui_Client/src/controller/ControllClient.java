package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import model.ClientModel;
import model.Person;
import model.PersonView;
import service.F1CreateNewPersonImpl;
import service.F2ListPersonsImpl;
import service.F3SavePersonsImpl;
import service.F4DownloadPersonsImpl;
import service.F5SortPersonsInMemoryImpl;
import service.F6NumberingServiceImpl;
import service.F7LeaveProgramImpl;
import service.F8ServerSettingImpl;
import view.CollectionView;
import view.F1CreateNewPersonView;
import view.F2ListPersonsView;
import view.F3SavePersonsView;
import view.F4DownloadPersonsView;
import view.F5SortPersonsInMemoryView;
import view.F6NumberingServiceView;
import view.F7LeaveProgrammView;
import view.F8ServerSettingView;
import view.ClientMainView;

public class ControllClient implements PersonView {
	private ClientModel clientModel;
	private CollectionView collectionView;
	
	public ControllClient(ClientModel clientModel, CollectionView collectionView) {
		this.clientModel = clientModel;
		this.collectionView = collectionView;
		this.clientModel.setF8ServerSettingImpl(new F8ServerSettingImpl());
		this.collectionView.setGeneralView(new ClientMainView());
		this.collectionView.getGeneralView().mainMenuView();
		this.addListener();
	}
	
	private void addListener() {
		this.collectionView.getGeneralView().setActionListener(new MyActionListener());
		this.collectionView.getGeneralView().setMenuListener(new MyMenuListener());
	}
	
	private void addF1Listener() {
		this.collectionView.getF1CreateNewPersonView().setActionListener(new F1ActionListener());
	}
	
	private void addF8Listener() {
		this.collectionView.getF8ServerSettingView().setFocusListener(new MyFocusListener());
	}
	
	class MyActionListener implements ActionListener {
		public void actionPerformed(ActionEvent actionEvent) {
			//Verwaltungsfunktion 1
			if (actionEvent.getSource() == ControllClient.this.collectionView.getGeneralView().getAddPerson()
					|| actionEvent.getSource() == ControllClient.this.collectionView.getGeneralView().getAddPersonsHm()
					|| actionEvent.getSource() == ControllClient.this.collectionView.getGeneralView().getAddPersonsPopup()) {
				
				ControllClient.this.collectionView.setF1CreateNewPersonView1(new F1CreateNewPersonView(ControllClient.this.collectionView.getGeneralView()));
				ControllClient.this.addF1Listener();
								//ControllClient.this.clientModel.setCreateNewPersonImpl(new F1CreateNewPersonImpl(new Person(), new ArrayList<>()));
				//ControllClient.this.clientModel.getCreateNewPersonImpl().personAufnehmen();
				//ControllClient.this.clientModel.getPersonList().addAll(ControllClient.this.clientModel.getCreateNewPersonImpl().getPersonList());
			}
			
			
			
			//Verwaltungsfukntion 2
			if (actionEvent.getSource() == ControllClient.this.collectionView.getGeneralView().getListPersons()
					|| actionEvent.getSource() == ControllClient.this.collectionView.getGeneralView().getListPersonHm()
					|| actionEvent.getSource() == ControllClient.this.collectionView.getGeneralView().getListPersonPopup()) {
				
				ControllClient.this.clientModel.setListPersonsImpl(new F2ListPersonsImpl(ControllClient.this.clientModel.getPersonList()));
				ControllClient.this.collectionView.setF2ListPersonsView(new F2ListPersonsView(ControllClient.this.clientModel.getListPersonsImpl().changeDataType(), Person.getAusgabe(), ControllClient.this.collectionView.getGeneralView()));
			}
			
			//Verwaltungsfunktion 3
			if (actionEvent.getSource() == ControllClient.this.collectionView.getGeneralView().getSavePersons()
					|| actionEvent.getSource() == ControllClient.this.collectionView.getGeneralView().getSavePersonHm()
					|| actionEvent.getSource() == ControllClient.this.collectionView.getGeneralView().getSavePersonsPopup()) {
				ControllClient.this.collectionView.setF3SavePersonsView(new F3SavePersonsView());
				try {
					ControllClient.this.clientModel.setSavePersonsImpl(new F3SavePersonsImpl(ControllClient.this.clientModel.getPersonList()));
					ControllClient.this.clientModel.getSavePersonsImpl().personSichern(ControllClient.this.clientModel.getF8ServerSettingImpl().getServerIpAddress(), ControllClient.this.clientModel.getF8ServerSettingImpl().getHostAddress());
					ControllClient.this.collectionView.getF3SavePersonsView().saveSuccessfull(ControllClient.this.collectionView.getGeneralView());
				}
				catch (IOException ioe) {
					ControllClient.this.collectionView.getF3SavePersonsView().saveUnSuccessfull(ControllClient.this.collectionView.getGeneralView());
				}
				
			}
			
			//Verwaltungsfunktion 4
			if (actionEvent.getSource() == ControllClient.this.collectionView.getGeneralView().getDownloadPersons()
					|| actionEvent.getSource() == ControllClient.this.collectionView.getGeneralView().getDownloadPersonHm()
					|| actionEvent.getSource() == ControllClient.this.collectionView.getGeneralView().getDownloadPersonsPopup()) {
				ControllClient.this.collectionView.setF4DownloadPersonsView(new F4DownloadPersonsView());
				try {
					ControllClient.this.clientModel.setDownloadPersonsImpl(new F4DownloadPersonsImpl(new ArrayList<Person>()));
					ControllClient.this.clientModel.getDownloadPersonsImpl().personenLaden(ControllClient.this.clientModel.getF8ServerSettingImpl().getServerIpAddress(), ControllClient.this.clientModel.getF8ServerSettingImpl().getHostAddress());
					for (Person person : ControllClient.this.clientModel.getDownloadPersonsImpl().getPersonList()) {
						ControllClient.this.clientModel.getPersonList().add(person);
					}
					ControllClient.this.collectionView.getF4DownloadPersonsView().downloadSuccessful(ControllClient.this.collectionView.getGeneralView());
				}
				catch (IOException ioe) {
					ControllClient.this.collectionView.getF4DownloadPersonsView().downloadUnSuccessful(ControllClient.this.collectionView.getGeneralView());
				}
			}
			
			
			//Verwaltungsfunktion 5
			if (actionEvent.getSource() == ControllClient.this.collectionView.getGeneralView().getSortPersons()
					|| actionEvent.getSource() == ControllClient.this.collectionView.getGeneralView().getSortPersonsHm()
					|| actionEvent.getSource() == ControllClient.this.collectionView.getGeneralView().getSortPersonsPopup()) {
				ControllClient.this.clientModel.setSortPersonsInMemoryImpl(new F5SortPersonsInMemoryImpl(ControllClient.this.clientModel.getPersonList()));
				ControllClient.this.clientModel.getSortPersonsInMemoryImpl().personenSortieren();
				ControllClient.this.collectionView.setF5SortPersonsInMemoryView(new F5SortPersonsInMemoryView(ControllClient.this.collectionView.getGeneralView()));
			}
			
			//Verwaltungsfunktion 6
			if (actionEvent.getSource() == ControllClient.this.collectionView.getGeneralView().getNumberingInDatabase()
					|| actionEvent.getSource() == ControllClient.this.collectionView.getGeneralView().getNumberPersonsHm()
					|| actionEvent.getSource() == ControllClient.this.collectionView.getGeneralView().getNumberingInDatabasePopup()) {
				ControllClient.this.collectionView.setF6NumberingServiceView(new F6NumberingServiceView());
				try {
					ControllClient.this.clientModel.setNumberingServiceImpl(new F6NumberingServiceImpl());
					ControllClient.this.clientModel.getNumberingServiceImpl().numbering(ControllClient.this.clientModel.getF8ServerSettingImpl().getServerIpAddress(), ControllClient.this.clientModel.getF8ServerSettingImpl().getHostAddress());
					
					ControllClient.this.collectionView.getF6NumberingServiceView().numberingSuccessfull(ControllClient.this.collectionView.getGeneralView());
				}
				catch (IOException ioe) {
					ControllClient.this.collectionView.getF6NumberingServiceView().numberingUnSuccessfull(ControllClient.this.collectionView.getGeneralView());
				}
			}
			
			//Verwaltungsfunktion 7
			if (actionEvent.getSource() == ControllClient.this.collectionView.getGeneralView().getLeaveProgramm()
					|| actionEvent.getSource() == ControllClient.this.collectionView.getGeneralView().getLeaveProgrammPopup()
					|| actionEvent.getSource() == ControllClient.this.collectionView.getGeneralView().getLeaveProgrammHm()) {
				ControllClient.this.collectionView.setF7LeaveProgrammView(new F7LeaveProgrammView());
				if (ControllClient.this.collectionView.getF7LeaveProgrammView().leaveProgramm() == JOptionPane.YES_OPTION) {
					ControllClient.this.clientModel.setLeaveProgramImpl(new F7LeaveProgramImpl());
				}
			}
			
			//Verwaltungsfunktion 8
			if (actionEvent.getSource() == ControllClient.this.collectionView.getGeneralView().getServerSettingBar()
					|| actionEvent.getSource() == ControllClient.this.collectionView.getGeneralView().getServerSettingPopup()
					|| actionEvent.getSource() == ControllClient.this.collectionView.getGeneralView().getServerSettingHm()) {
				ControllClient.this.collectionView.setF8ServerSettingView(new F8ServerSettingView(ControllClient.this.collectionView.getGeneralView()));
				ControllClient.this.collectionView.getF8ServerSettingView().getHostTextField().setText(ControllClient.this.clientModel.getF8ServerSettingImpl().getHostAddress());
				ControllClient.this.collectionView.getF8ServerSettingView().getIpAddressTextField().setText(ControllClient.this.clientModel.getF8ServerSettingImpl().getServerIpAddress());
				ControllClient.this.addF8Listener();
			}
		}
	}
	
	class F1ActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if (actionEvent.getSource() == ControllClient.this.collectionView.getF1CreateNewPersonView().getOkButton()) {
				ControllClient.this.clientModel.setCreateNewPersonImpl(new F1CreateNewPersonImpl(new Person(), new ArrayList<>()));
				if (ControllClient.this.clientModel.getCreateNewPersonImpl().patternMatcher(F1CreateNewPersonImpl.PATTERNNAME, ControllClient.this.collectionView.getF1CreateNewPersonView().getNameText().getText())) {
					ControllClient.this.clientModel.getCreateNewPersonImpl().getPerson().setName(ControllClient.this.collectionView.getF1CreateNewPersonView().getNameText().getText());
					if (ControllClient.this.clientModel.getCreateNewPersonImpl().patternMatcher(F1CreateNewPersonImpl.PATTERNVORNAME, ControllClient.this.collectionView.getF1CreateNewPersonView().getVornameText().getText())) {
						ControllClient.this.clientModel.getCreateNewPersonImpl().getPerson().setVorname(ControllClient.this.collectionView.getF1CreateNewPersonView().getVornameText().getText());
						ControllClient.this.clientModel.getCreateNewPersonImpl().getPerson().setAnrede(ControllClient.this.collectionView.getF1CreateNewPersonView().getAnredeCombobox().getSelectedItem().toString());
						if (ControllClient.this.clientModel.getCreateNewPersonImpl().patternMatcher(F1CreateNewPersonImpl.PATTERNSTRASSE, ControllClient.this.collectionView.getF1CreateNewPersonView().getStrasseText().getText())) {
							ControllClient.this.clientModel.getCreateNewPersonImpl().getPerson().setStrasse(ControllClient.this.collectionView.getF1CreateNewPersonView().getStrasseText().getText());
							if (ControllClient.this.clientModel.getCreateNewPersonImpl().patternMatcher(F1CreateNewPersonImpl.PATTERNPLZ, ControllClient.this.collectionView.getF1CreateNewPersonView().getPlzText().getText())) {
								ControllClient.this.clientModel.getCreateNewPersonImpl().getPerson().setPlz(ControllClient.this.collectionView.getF1CreateNewPersonView().getPlzText().getText());
								if (ControllClient.this.clientModel.getCreateNewPersonImpl().patternMatcher(F1CreateNewPersonImpl.PATTERNORT, ControllClient.this.collectionView.getF1CreateNewPersonView().getOrtText().getText())) {
									ControllClient.this.clientModel.getCreateNewPersonImpl().getPerson().setOrt(ControllClient.this.collectionView.getF1CreateNewPersonView().getOrtText().getText());
									if (ControllClient.this.clientModel.getCreateNewPersonImpl().patternMatcher(F1CreateNewPersonImpl.PATTERNTELEFON, ControllClient.this.collectionView.getF1CreateNewPersonView().getTelefonText().getText())) {
										ControllClient.this.clientModel.getCreateNewPersonImpl().getPerson().setTelefon(ControllClient.this.collectionView.getF1CreateNewPersonView().getTelefonText().getText());
										if (ControllClient.this.clientModel.getCreateNewPersonImpl().patternMatcher(F1CreateNewPersonImpl.PATTERNFAX, ControllClient.this.collectionView.getF1CreateNewPersonView().getFaxText().getText())) {
											ControllClient.this.clientModel.getCreateNewPersonImpl().getPerson().setFax(ControllClient.this.collectionView.getF1CreateNewPersonView().getFaxText().getText());
											ControllClient.this.clientModel.getCreateNewPersonImpl().getPerson().setBemerkung(ControllClient.this.collectionView.getF1CreateNewPersonView().getBemerkungText().getText());
											ControllClient.this.clientModel.getPersonList().add(ControllClient.this.clientModel.getCreateNewPersonImpl().getPerson());
											ControllClient.this.collectionView.getGeneralView().getContentPane().removeAll();
											ControllClient.this.collectionView.getGeneralView().mainMenueLabel();
											ControllClient.this.collectionView.getGeneralView().addContentPane();
											ControllClient.this.collectionView.getGeneralView().getContentPane().validate();
											ControllClient.this.collectionView.getGeneralView().getContentPane().repaint();	
										}
										else {
											ControllClient.this.collectionView.getF1CreateNewPersonView().somethingNotRight(AUSGABE[7]);
										}
									}
									else {
										ControllClient.this.collectionView.getF1CreateNewPersonView().somethingNotRight(AUSGABE[6]);
									}
								}
								else {
									ControllClient.this.collectionView.getF1CreateNewPersonView().somethingNotRight(AUSGABE[5]);
								}
							}
							else {
								ControllClient.this.collectionView.getF1CreateNewPersonView().somethingNotRight(AUSGABE[4]);
							}
						}
						else {
							ControllClient.this.collectionView.getF1CreateNewPersonView().somethingNotRight(AUSGABE[3]);
						} 
					}
					else {
						ControllClient.this.collectionView.getF1CreateNewPersonView().somethingNotRight(AUSGABE[1]);
					}
				}
				else {
					ControllClient.this.collectionView.getF1CreateNewPersonView().somethingNotRight(AUSGABE[0]);
				}
			}
			
			if (actionEvent.getSource() == ControllClient.this.collectionView.getF1CreateNewPersonView().getAbbrechenButton()) {
				ControllClient.this.collectionView.getGeneralView().getContentPane().removeAll();
				ControllClient.this.collectionView.getGeneralView().mainMenueLabel();
				ControllClient.this.collectionView.getGeneralView().addContentPane();
				ControllClient.this.collectionView.getGeneralView().getContentPane().validate();
				ControllClient.this.collectionView.getGeneralView().getContentPane().repaint();
			}
		}
	}
	
	class MyMenuListener implements MenuListener {
		@Override
		public void menuCanceled(MenuEvent mouseEvent) {
			
		}

		@Override
		public void menuDeselected(MenuEvent mouseEvent) {
			
		}

		@Override
		public void menuSelected(MenuEvent mouseEvent) {
			ControllClient.this.collectionView.getGeneralView().getContentPane().removeAll();
			ControllClient.this.collectionView.getGeneralView().mainMenueLabel();
			ControllClient.this.collectionView.getGeneralView().addContentPane();
			ControllClient.this.collectionView.getGeneralView().getContentPane().validate();
			ControllClient.this.collectionView.getGeneralView().getContentPane().repaint();
		}
	}
	
	class MyFocusListener extends FocusAdapter {
		public void focusLost(FocusEvent focusEvent) {
			if (ControllClient.this.clientModel.getF8ServerSettingImpl().patternMatcher(F8ServerSettingImpl.PATTERNPORT, ControllClient.this.collectionView.getF8ServerSettingView().getHostTextField().getText())) {
				ControllClient.this.clientModel.getF8ServerSettingImpl().setHostAddress(ControllClient.this.collectionView.getF8ServerSettingView().getHostTextField().getText());
				if (ControllClient.this.clientModel.getF8ServerSettingImpl().patternMatcher(F8ServerSettingImpl.PATTERNIP, ControllClient.this.collectionView.getF8ServerSettingView().getIpAddressTextField().getText())) {
					ControllClient.this.clientModel.getF8ServerSettingImpl().setServerIpAddress(ControllClient.this.collectionView.getF8ServerSettingView().getIpAddressTextField().getText());
				}
				else {
					ControllClient.this.collectionView.getF8ServerSettingView().somethingNotRight("Server-IP-Adresse");
				}	
			}
			else {
				ControllClient.this.collectionView.getF8ServerSettingView().somethingNotRight("Port");
			}
		}
	}
}
