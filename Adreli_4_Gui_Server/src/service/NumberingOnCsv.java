package service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
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

public class NumberingOnCsv {
	private ArrayList<Person> cachePersons;
	private String data;
	private String oneData[];
	
	
	/**
	 * 
	 * @param cachePersons
	 * @param readFromCsv
	 */
	public NumberingOnCsv(ArrayList<Person> cachePersons, ReadFromCsv readFromCsv) {
		this.cachePersons = cachePersons;
		this.data = null;
	}
	
	
	/**
	 * {@link #numbering()} liest die Datensätze aus der "adreli.csv" Datei und 
	 * schreibt sie in nummerierter Form wieder hinein.
	 */
	public void numbering() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader
				(Files.newInputStream(Paths.get("adreli.csv"))))) {
			int counterNumberReader = 1;
			while ((this.data = br.readLine()) != null) {
				this.oneData = data.split(";");
				if (this.oneData[0].equals(String.valueOf(counterNumberReader))) 
				{
					Person person = new Person();
					person.setName(this.oneData[1]);
					person.setVorname(this.oneData[2]);
					person.setAnrede(this.oneData[3]);
					person.setStrasse(this.oneData[4]);
					person.setPlz(this.oneData[5]);
					person.setOrt(this.oneData[6]);
					person.setTelefon(this.oneData[7]);
					person.setFax(this.oneData[8]);
					person.setBemerkung(this.oneData[9]);
					this.cachePersons.add(person);
				}
				else {
					Person person = new Person();
					person.setName(this.oneData[0]);
					person.setVorname(this.oneData[1]);
					person.setAnrede(this.oneData[2]);
					person.setStrasse(this.oneData[3]);
					person.setPlz(this.oneData[4]);
					person.setOrt(this.oneData[5]);
					person.setTelefon(this.oneData[6]);
					person.setFax(this.oneData[7]);
					person.setBemerkung(this.oneData[8]);
					this.cachePersons.add(person);
				}
				counterNumberReader++;
			}
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		try (BufferedWriter dos = new BufferedWriter(new OutputStreamWriter
				(Files.newOutputStream
						(Paths.get("adreli.csv"),StandardOpenOption.CREATE)))) {
			int counterNumberWriter = 1;
			for (Person person : this.cachePersons) {
				dos.write((counterNumberWriter++)+ ";");
				dos.write(person.getName()+";");
				dos.write(person.getVorname()+";");
				dos.write(person.getAnrede()+";");
				dos.write(person.getStrasse()+";");
				dos.write(person.getPlz()+";");
				dos.write(person.getOrt()+";");
				dos.write(person.getTelefon()+";");
				dos.write(person.getFax()+";");
				dos.write(person.getBemerkung()+";");
				dos.newLine();
			}
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}	
	}
}
