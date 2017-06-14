package presentationlayer.skeleton;

import java.rmi.Remote;
import java.rmi.RemoteException;

import domainlayer.skeleton.IDobbelsteenWorp;

/**
 * IDobbelsteenWorpPane.java
 * De interface voor de view over dobbelsteen worpen.
 * 
 * @author	Erwin Olie, s1103026
 * @version	0.1
 */
public interface IDobbelsteenWorpPane extends Remote {
	/**
	 * Ververs de view naar de huidige versie van het model.
	 * @param model	Het model van de dobbelsteen dat hier moet worden weergegeven.
	 */
	public void modelChanged(IDobbelsteenWorp model) throws RemoteException;
}
