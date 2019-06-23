package service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class F8ServerSettingImpl {
	private String serverIpAddress;
	private String hostAddress;
	public static final Pattern PATTERNIP = Pattern.compile("localhost|(([0-9]){1,3}.([0-9]){1,3}.([0-9]){1,3}.([0-9]){1,3})"); 
	public static final Pattern PATTERNPORT = Pattern.compile("([0-9]){1,5}");
	
	public F8ServerSettingImpl() {
		this("localhost", "56789"); 
	}
	
	public F8ServerSettingImpl(String serverIpAddress, String hostAddress) {
		this.serverIpAddress = serverIpAddress;
		this.hostAddress = hostAddress;
	}
	
	public boolean patternMatcher(Pattern pattern, String eingabe) {
		Matcher matcher = pattern.matcher(eingabe);
		return matcher.matches();
	}

	public String getServerIpAddress() {
		return serverIpAddress;
	}

	public void setServerIpAddress(String serverIpAddress) {
		this.serverIpAddress = serverIpAddress;
	}

	public String getHostAddress() {
		return hostAddress;
	}

	public void setHostAddress(String hostAddress) {
		this.hostAddress = hostAddress;
	}
}
