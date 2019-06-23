package service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @version Adreli_4_Gui_Server
 * @author Jan-Hendrik Hausner
 * @author John Budnik
 * @author Luca Weinmann
 */

public class ServerSettingImpl {
	private String serverIpAddress;
	private String hostAddress;
	public static final Pattern PATTERNIP = Pattern.compile("localhost|(([0-9]){1,3}.([0-9]){1,3}.([0-9]){1,3}.([0-9]){1,3})"); 
	public static final Pattern PATTERNPORT = Pattern.compile("([0-9]){1,5}");
	
	
	public ServerSettingImpl() {
		this("localhost", "56789"); 
	}
	
	
	/**
	 * 
	 * @param serverIpAddress
	 * @param hostAddress
	 */
	public ServerSettingImpl(String serverIpAddress, String hostAddress) {
		this.serverIpAddress = serverIpAddress;
		this.hostAddress = hostAddress;
	}
	
	
	/**
	 * 
	 * @param pattern
	 * @param eingabe
	 * @return
	 */
	public boolean patternMatcher(Pattern pattern, String eingabe) {
		Matcher matcher = pattern.matcher(eingabe);
		return matcher.matches();
	}

	
	/**
	 * 
	 * @return serverIpAddress
	 */
	public String getServerIpAddress() {
		return serverIpAddress;
	}

	
	/**
	 * 
	 * @param serverIpAddress
	 */
	public void setServerIpAddress(String serverIpAddress) {
		this.serverIpAddress = serverIpAddress;
	}

	
	/**
	 * 
	 * @return hostAddress
	 */
	public String getHostAddress() {
		return hostAddress;
	}

	
	/**
	 * 
	 * @param hostAddress
	 */
	public void setHostAddress(String hostAddress) {
		this.hostAddress = hostAddress;
	}
}
