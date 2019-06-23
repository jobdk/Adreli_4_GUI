package service;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import model.Person;

/**
 * @version Adreli_3_Netcom_Client
 * @author Jan-Hendrik Hausner
 * @author John Budnik
 * @author Luca Weinmann
 */

public class F4DownloadPersonsImpl {
	private List<Person> personList;
	
	
	/**
	 * @param personList
	 */
	public F4DownloadPersonsImpl(List<Person> personList) {
		this.personList = personList;
	}
	
	
	/**
	 * @return
	 */
	public List<Person> getPersonList() {
		return this.personList;
	}

	
	@SuppressWarnings("unchecked")
	public void personenLaden(String ipAddress, String hostAddress) throws IOException {
		try {
			//InetSocketAddress inetSocketAddress = new InetSocketAddress(
			//"141.28.143.142", 56789);
			InetSocketAddress inetSocketAddress = new InetSocketAddress(
					ipAddress, Integer.valueOf(hostAddress));
			Socket client = new Socket();
			client.connect(inetSocketAddress);
			DataOutputStream dos = new DataOutputStream(
					client.getOutputStream());
			dos.writeUTF("personenLaden");
			ObjectInputStream ois = new ObjectInputStream(
					client.getInputStream());
			this.personList = (ArrayList<Person>) ois.readObject();
			client.close();
		}
		catch (ClassNotFoundException cnf) {
			System.out.println("Hallo1");
			cnf.printStackTrace();
		}
	}
}
