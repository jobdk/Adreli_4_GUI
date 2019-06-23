package model;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

import service.NumberingOnCsv;
import service.ReadFromCsv;
import service.WriteOnCsv;

/**
 * @version Adreli_4_Gui_Server
 * @author Jan-Hendrik Hausner
 * @author John Budnik
 * @author Luca Weinmann
 */

public class ServerThread implements Runnable {
	private Socket socket;
	private ReadFromCsv readFromCsv;
	private WriteOnCsv writeOnCsv;
	private NumberingOnCsv numberingOnCsv;
	//private PrintWriter printWriter;
	
	
	/**
	 * 
	 * @param socket
	 */
	/*public ServerThread(Socket socket, PrintWriter printWriter) {
		this.socket = socket;
		this.printWriter = printWriter;	
		Thread shutdownAction = new Thread(new ShutdownAction());
		Runtime.getRuntime().addShutdownHook(shutdownAction);	
	}*/
	public ServerThread(Socket socket) {
		this.socket = socket;
	}
	
	
	/**
	 * {@link #run()} schreibt Informationen in die "adrelilog.csv" Datei und 
	 * lässt den Thread laufen.
	 */
	public void run() {
		try {
			DataInputStream dis = new DataInputStream(
					this.socket.getInputStream());
			String antwort = dis.readUTF();
			if (antwort.equals("nummerieren")) {
				this.numberingOnCsv = new NumberingOnCsv(new ArrayList<Person>(), new ReadFromCsv(new ArrayList<>(),
								this.socket));
				this.numberingOnCsv.numbering();
			}
			if (antwort.equals("savePersons")) {
				this.writeOnCsv = new WriteOnCsv(this.socket, new ArrayList<Person>());
				this.writeOnCsv.saveDataInCsv();
			}
			if (antwort.equals("personenLaden")) {
				this.readFromCsv = new ReadFromCsv(new ArrayList<Person>(), this.socket);
				this.readFromCsv.loadDataFromCsv();
				this.readFromCsv.sendDataToClient();
			}
			/*if (antwort.equals("nummerieren")) {
				this.printWriter.println(new SimpleDateFormat("yyyy.MM.dd - HH:mm:ss").format(new Date()).concat("--> Personen wurden nummeriert").concat(this.socket.getLocalAddress().toString()));
			}
			if (antwort.equals("savePersons")) {
				this.printWriter.println(new SimpleDateFormat("yyyy.MM.dd - HH:mm:ss").format(new Date()).concat("--> Personen wurden gespeichert in: ").concat(path.toString()));
			}
			if (antwort.equals("personenLaden")) {
				this.printWriter.println(new SimpleDateFormat("yyyy.MM.dd - HH:mm:ss").format(new Date()).concat("--> Personen wurden geladen"));
			}
			if (antwort.equals("verlassen")) {
				this.printWriter.println(new SimpleDateFormat("yyyy.MM.dd - HH:mm:ss").format(new Date()).concat("--> Programm wurde verlassen"));
				//this.printWriter.close();
			}*/
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * @return
	 */
	/*public PrintWriter getPrintWriter() {
		return this.printWriter;
	}*/
	
	/*class ShutdownAction implements Runnable {
		public void run() {
			ServerThread.this.printWriter.close();
		}
	}*/
}
