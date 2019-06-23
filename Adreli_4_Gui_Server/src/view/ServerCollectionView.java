package view;

/**
 * @version Adreli_4_Gui_Server
 * @author Jan-Hendrik Hausner
 * @author John Budnik
 * @author Luca Weinmann
 */

public class ServerCollectionView {
	private ServerMainView serverMainView;
	private ServerStopView serverStopView;
	private ServerStartView serverStartView;
	private ServerElectionDatabaseView serverElectionDatabaseView;
	private ServerSettingView serverSettingView;
	
	
	/**
	 * 
	 * @return serverSettingView
	 */
	public ServerSettingView getServerSettingView() {
		return serverSettingView;
	}

	
	/**
	 * 
	 * @param serverSettingView
	 */
	public void setServerSettingView(ServerSettingView serverSettingView) {
		this.serverSettingView = serverSettingView;
	}

	
	/**
	 * 
	 * @param serverMainView
	 */
	public ServerCollectionView(ServerMainView serverMainView) {
		this.serverMainView = serverMainView;
	}
	
	
	/**
	 * 
	 * @param serverMainView
	 * @param serverStopView
	 */
	public ServerCollectionView(ServerMainView serverMainView, ServerStopView serverStopView) {
		this.serverMainView = serverMainView;
		this.serverStopView = serverStopView;
	}

	
	/**
	 * 
	 * @return serverElectionDatabaseView
	 */
	public ServerElectionDatabaseView getServerElectionDatabaseView() {
		return serverElectionDatabaseView;
	}

	
	/**
	 * 
	 * @param serverElectionDatabaseView
	 */
	public void setServerElectionDatabaseView(ServerElectionDatabaseView serverElectionDatabaseView) {
		this.serverElectionDatabaseView = serverElectionDatabaseView;
	}

	
	/**
	 * 
	 * @return serverStartView
	 */
	public ServerStartView getServerStartView() {
		return serverStartView;
	}

	
	/**
	 * 
	 * @param serverStartView
	 */
	public void setServerStartView(ServerStartView serverStartView) {
		this.serverStartView = serverStartView;
	}

	
	/**
	 * 
	 * @return serverMainView
	 */
	public ServerMainView getServerMainView() {
		return serverMainView;
	}

	
	/**
	 * 
	 * @param serverMainView
	 */
	public void setServerMainView(ServerMainView serverMainView) {
		this.serverMainView = serverMainView;
	}

	
	/**
	 * 
	 * @return serverStopView
	 */
	public ServerStopView getServerStopView() {
		return serverStopView;
	}

	
	/**
	 * 
	 * @param serverStopView
	 */
	public void setServerStopView(ServerStopView serverStopView) {
		this.serverStopView = serverStopView;
	}
}
