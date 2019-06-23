package service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

import model.Person;

/**
 * @version Adreli_4_Gui_Server
 * @author Jan-Hendrik Hausner
 * @author John Budnik
 * @author Luca Weinmann
 */

public class WriteOnCsv {
	private Socket socket;
	private ArrayList<Person> personList;
	
	/**
	 * 
	 * @param socket
	 * @param personList
	 */
	public WriteOnCsv(Socket socket, ArrayList<Person> personList) {
		this.socket = socket;
		this.personList = personList;
	}
	
	
	/**
	 * {@link #saveDataInCsv()} schreibt Daten aus der ArrayList in die
	 *  "adreli.csv Datei.
	 */
	@SuppressWarnings("unchecked")
	public void saveDataInCsv() {
		try {
			//Files.createFile(Paths.get("adreli.csv"));
			BufferedWriter writerAdreli = new BufferedWriter(new OutputStreamWriter
					(Files.newOutputStream(Paths.get("adreli.csv"), 
							StandardOpenOption.APPEND, 
							StandardOpenOption.CREATE)));
			ObjectInputStream ois = new ObjectInputStream(
					this.socket.getInputStream());
			this.personList = (ArrayList<Person>) ois.readObject();
			for (Person person : this.personList) {
				writerAdreli.write(person.getName()+";");
				writerAdreli.write(person.getVorname()+";");
				writerAdreli.write(person.getAnrede()+";");
				writerAdreli.write(person.getStrasse()+";");
				writerAdreli.write(person.getPlz()+";");
				writerAdreli.write(person.getOrt()+";");
				writerAdreli.write(person.getTelefon()+";");
				writerAdreli.write(person.getFax()+";");
				writerAdreli.write(person.getBemerkung()+";");
				writerAdreli.newLine();
			}
			writerAdreli.close();
			ois.close();
			ObjectOutputStream writerAdreliLogFile = new ObjectOutputStream(new BufferedOutputStream(Files.newOutputStream(Paths.get("adrelilogfile.txt"), StandardOpenOption.APPEND)));
			for (Person person : this.personList) {			
				writerAdreliLogFile.writeObject(person);
			}
			writerAdreliLogFile.close();
			/*ObjectInputStream test = new ObjectInputStream(new BufferedInputStream(Files.newInputStream(Paths.get("adrelilogfile.txt"))));
			Person person = (Person) test.readObject();
			System.out.println(person.getName());
			test.close();*/
		}
		catch (ClassNotFoundException cnf) {
			cnf.printStackTrace();
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
