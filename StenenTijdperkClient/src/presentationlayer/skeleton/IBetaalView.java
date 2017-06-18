package presentationlayer.skeleton;

import java.rmi.Remote;

import java.rmi.RemoteException;

import domainlayer.skeleton.ITableau;

/**
 * IBetaalView.java
 * De interface voor de view van de betaalview
 * 
 * @author	Mees Kluivers, s1102358
 * @version	0.1
 */
public interface IBetaalView extends Remote {
	/**
	 * Ververs de view naar de huidige versie van het model.
	 * @param model	Het model van de dobbelsteen dat hier moet worden weergegeven.
	 */
	public void modelChanged(ITableau model) throws RemoteException;
}
