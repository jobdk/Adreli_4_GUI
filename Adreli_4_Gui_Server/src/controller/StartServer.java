package controller;

import view.ServerCollectionView;
import view.ServerMainView;

/**
 * @version Adreli_4_Gui_Server
 * @author Jan-Hendrik Hausner
 * @author John Budnik
 * @author Luca Weinmann
 */

public class StartServer {
	
	
	/**
	 * @param args
	 */
	public static void main(String[]args) {
		new ControllServer(new ServerCollectionView(new ServerMainView()));
	}
}
