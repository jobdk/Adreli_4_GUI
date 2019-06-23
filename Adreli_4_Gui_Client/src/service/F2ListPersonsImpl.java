package service;

import java.util.List;

import model.Person;
/**
 * @version Adreli_3_Netcom_Client
 * @author Jan-Hendrik Hausner
 * @author John Budnik
 * @author Luca Weinmann
 */

public class F2ListPersonsImpl {
	private List<Person> personList;
	private String [][] personData;
	
	public F2ListPersonsImpl(List<Person> personList) {
		this.personList = personList;
		this.personData = new String [this.personList.size()][9];
	}
	
	public String[][] changeDataType() {
		int counter = 0;
		for (Person person : this.personList) {
			personData[counter][0] = person.getName();
			personData[counter][1] = person.getVorname();
			personData[counter][2] = person.getAnrede();
			personData[counter][3] = person.getStrasse();
			personData[counter][4] = person.getPlz();
			personData[counter][5] = person.getOrt();
			personData[counter][6] = person.getTelefon();
			personData[counter][7] = person.getFax();
			personData[counter][8] = person.getBemerkung();
			counter++;
		}
		return this.personData;
	}
	
	
}
