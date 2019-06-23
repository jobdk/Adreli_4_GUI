package model;


import java.io.Serializable;

/**
 * @version Adreli_4_Gui_Server
 * @author Jan-Hendrik Hausner
 * @author John Budnik
 * @author Luca Weinmann
 */

public class Person implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private String vorname;
	private String anrede;
	private String strasse;
	private String plz;
	private String ort;
	private String telefon;
	private String fax;
	private String bemerkung;
	public static final String [] AUSGABE = {
			new String("     Name: "),
			new String("  Vorname: "),
			new String("   Anrede: "),
			new String("  Strasse: "),
			new String("      PLZ: "),
			new String("      Ort: "),
			new String("  Telefon: "),
			new String("      Fax: "),
			new String("Bemerkung: ")
	};
	
	
	public Person() {
		
	}
	
	
	/**
	 * @param name
	 * @param vorname
	 * @param anrede
	 * @param strasse
	 * @param plz
	 * @param ort
	 * @param telefon
	 * @param fax
	 * @param bemerkung
	 */
	public Person(String name, String vorname, String anrede, String strasse,
			String plz, String ort, String telefon, String fax, 
			String bemerkung) {
		this.name = name;
		this.vorname = vorname;
		this.anrede = anrede;
		this.strasse = strasse;
		this.plz = plz;
		this.ort = ort;
		this.telefon = telefon;
		this.fax = fax;
		this.bemerkung = bemerkung;
	}

	
	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
	/**
	 * @return name
	 */
	public String getName() {
		return this.name;
	}
	
	
	/**
	 * @param vorname
	 */
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	
	
	/**
	 * @return vorname
	 */
	public String getVorname() {
		return this.vorname;
	}
	
	
	/**
	 * @param anrede
	 */
	public void setAnrede(String anrede) {
		this.anrede = anrede;
	}
	
	
	/**
	 * @return anrede
	 */
	public String getAnrede() {
		return this.anrede;
	}
	
	
	/**
	 * @param strasse
	 */
	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}
	
	
	/** 
	 * @return strasse
	 */
	public String getStrasse() {
		return this.strasse;
	}
	
	
	/**
	 * @param plz
	 */
	public void setPlz(String plz) {
		this.plz = plz;
	}
	
	
	/**
	 * @return plz
	 */
	public String getPlz() {
		return this.plz;
	}
	
	
	/**
	 * @param ort
	 */
	public void setOrt(String ort) {
		this.ort = ort;
	}
	
	
	/**
	 * @return ort
	 */
	public String getOrt() {
		return this.ort;
	}
	
	
	/**
	 * @param telefon
	 */
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	
	
	/**
	 * @return telefon
	 */
	public String getTelefon() {
		return this.telefon;
	}
	
	
	/**
	 * @param fax
	 */
	public void setFax(String fax) {
		this.fax = fax;
	}
	
	
	/**
	 * @return fax
	 */
	public String getFax() {
		return this.fax;
	}
	
	
	/**
	 * @param bemerkung
	 */
	public void setBemerkung(String bemerkung) {
		this.bemerkung = bemerkung;
	}

	
	/**
	 * @return bemerkung
	 */
	public String getBemerkung() {
		return this.bemerkung;
	}
}
