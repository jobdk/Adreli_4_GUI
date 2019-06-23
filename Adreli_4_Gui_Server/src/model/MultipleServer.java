package model;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.cert.PKIXRevocationChecker.Option;

import javax.swing.text.ChangedCharSetException;

import service.ServerSettingImpl;
import view.ServerMainView;
import view.ServerStartView;

/**
 * @version Adreli_4_Gui_Server
 * @author Jan-Hendrik Hausner
 * @author John Budnik
 * @author Luca Weinmann
 */

public class MultipleServer implements Runnable, ServerLogTxt {
	private Path path;
	private ServerSocket serverSocket;
	private InetSocketAddress inetSocketAddress;
	private ServerSettingImpl serverSettingImpl;
	private ServerStartView serverStartView;
	private ServerMainView serverMainView;
	private static int logCounter = 0;
	//private ArrayList<Thread> threadList;
	
	
	/**
	 * 
	 * @param path
	 * @param serverSettingImpl
	 * @param serverStartView
	 * @param serverMainView
	 */
	public MultipleServer(String path, ServerSettingImpl serverSettingImpl, ServerStartView serverStartView, ServerMainView serverMainView) {
		try {
			//this.threadList = new ArrayList<Thread>();
			this.serverSettingImpl = serverSettingImpl;
			this.inetSocketAddress = new InetSocketAddress(this.serverSettingImpl.getServerIpAddress(), Integer.valueOf(this.serverSettingImpl.getHostAddress()));
			this.serverSocket = new ServerSocket();
			this.path = Paths.get(path);
			this.serverStartView = serverStartView;
			this.serverMainView = serverMainView;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * {@link #verbinde()} wartet, bis eine Verbindung mit dem Client 
	 * eingegangen wird
	 */
	public void run() {
		try {
			this.serverSocket.bind(inetSocketAddress);
			while (!Thread.currentThread().isInterrupted()) {
				this.serverStartView.successfullServerStart(this.serverMainView);
				Socket server = this.serverSocket.accept();
				MultipleServer.logCounter++;
				try (DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(Files.newOutputStream(serverLogPath)))) {
					dos.writeUTF(String.valueOf(logCounter));		
				}
				catch (IOException ioe) {
					ioe.printStackTrace();
				}	
				Thread serverThread = new Thread(new ServerThread(server));
				serverThread.start();
			}
		}
		catch (IOException ioe) {
			this.serverStartView.unSuccessfullServerStart(this.serverMainView);
		}
	}
	
	
	/**
	 * 
	 * @return serverSettingImpl
	 */
	public ServerSettingImpl getServerSettingImpl() {
		return serverSettingImpl;
	}

	
	/**
	 * 
	 * @param serverSettingImpl
	 */
	public void setServerSettingImpl(ServerSettingImpl serverSettingImpl) {
		this.serverSettingImpl = serverSettingImpl;
	}

	
	/**
	 * 
	 * @param inetSocketAddress
	 */
	public void setInetSocketAddress(InetSocketAddress inetSocketAddress) {
		this.inetSocketAddress = inetSocketAddress;
	}

	/**
	 * @return serverSocket
	 */
	public ServerSocket getServerSocket() {
		return this.serverSocket;
	}
	
	
	/**
	 * @return path
	 */
	public Path getPath() {
		return this.path;
	}
}
