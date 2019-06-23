package service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.Person;

/**
 * @version Adreli_3_Netcom_Client
 * @author Jan-Hendrik Hausner
 * @author John Budnik
 * @author Luca Weinmann
 */

public class F1CreateNewPersonImpl {
	private Person person;
	private List<Person> personList;
	public static final Pattern PATTERNNAME  = Pattern.compile("([A-ZÜÖÄa-züöäß -]){2,32}");
	public static final Pattern PATTERNVORNAME = Pattern.compile("([A-ZÜÖÄa-züöäß -]){2,32}");
	public static final Pattern PATTERNSTRASSE = Pattern.compile("([A-Za-zäöüß -])+([ ])+(\\d){1,4}([ ])*([A-Za-z])?");
	public static final Pattern PATTERNPLZ = Pattern.compile("\\d{5}");
	public static final Pattern PATTERNORT = Pattern.compile("([A-ZÜÖÄa-züöäß -]){2,32}");
	public static final Pattern PATTERNTELEFON = Pattern.compile("(\\+)?(\\d){2}?(\\(0\\))?([0-9 -])+");
	public static final Pattern PATTERNFAX = Pattern.compile("(\\+)?(\\d){2}?(\\(0\\))?([0-9 -])+");

	
	/**
	 * @param person
	 * @param personList
	 */
	public F1CreateNewPersonImpl(Person person, List<Person> personList) {
		this.person = person;
		this.personList = personList;
	}
	
	public boolean patternMatcher(Pattern pattern, String eingabe) {
		Matcher matcher = pattern.matcher(eingabe);
		return matcher.matches();
	}
	
	/**
	 * @return
	 */
	public List<Person> getPersonList() {
		return this.personList;
	}
	
	public Person getPerson() {
		return this.person;
	}
}
