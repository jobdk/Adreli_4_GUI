package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import model.Person;

/**
 * @version Adreli_4_Gui_Server
 * @author Jan-Hendrik Hausner
 * @author John Budnik
 * @author Luca Weinmann
 */

public class ReadFromCsv {
	private String data;
	private String oneData[];
	private ArrayList<Person> personList;
	private Socket socket;
	
	
	/**
	 * 
	 * @param personList
	 * @param socket
	 */
	public ReadFromCsv(ArrayList<Person> personList, Socket socket) {
		this.personList = personList;
		this.socket = socket;
		this.data = null;
	}
	
	
	/**
	 * {@link #loadDataFromCsv()} liest Datensätze aus der "adreli.csv" Datei
	 *  und schreibt diese in die ArrayList
	 */
	public void loadDataFromCsv() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader
				(Files.newInputStream(Paths.get("adreli.csv"))))) {
			int numberCounter = 1;
			while ((this.data = br.readLine()) != null) {
				Person person = new Person();
				this.oneData = data.split(";");
				if (this.oneData[0].equals(String.valueOf(numberCounter))) {
					person.setName(this.oneData[1]);
					person.setVorname(this.oneData[2]);
					person.setAnrede(this.oneData[3]);
					person.setStrasse(this.oneData[4]);
					person.setPlz(this.oneData[5]);
					person.setOrt(this.oneData[6]);
					person.setTelefon(this.oneData[7]);
					person.setFax(this.oneData[8]);
					person.setBemerkung(this.oneData[9]);
				}
				else {
					person.setName(this.oneData[0]);
					person.setVorname(this.oneData[1]);
					person.setAnrede(this.oneData[2]);
					person.setStrasse(this.oneData[3]);
					person.setPlz(this.oneData[4]);
					person.setOrt(this.oneData[5]);
					person.setTelefon(this.oneData[6]);
					person.setFax(this.oneData[7]);
					person.setBemerkung(this.oneData[8]);
				}
				this.personList.add(person);
				numberCounter++;
			}
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	
	public void sendDataToClient() {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(
					this.socket.getOutputStream());
			oos.writeObject(this.personList);
			oos.flush();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @return personList
	 */
	public ArrayList<Person> getPersonList() {
		return this.personList;
	}
}
