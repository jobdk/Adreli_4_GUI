package controller;

import java.util.ArrayList;

import model.ClientModel;
import view.CollectionView;

/**
 * @version Adreli_3_Netcom_Client
 * @author Jan-Hendrik Hausner
 * @author John Budnik
 * @author Luca Weinmann
 */

public class StartUser {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(
			new Runnable() {
				public void run() {
					new ControllClient(new ClientModel(
						new ArrayList<>()), new CollectionView());
			}
		});		
	}
}
