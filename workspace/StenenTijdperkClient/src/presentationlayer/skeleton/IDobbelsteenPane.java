package presentationlayer.skeleton;

import java.rmi.Remote;

import java.rmi.RemoteException;

import domainlayer.skeleton.IDobbelsteen;

/**
 * IDobbelsteenPane.java
 * De interface voor de view over losse dobbelstenen.
 * 
 * @author	Erwin Olie, s1103026
 * @version	0.1
 */
public interface IDobbelsteenPane extends Remote {
	/**
	 * Ververs de view naar de huidige versie van het model.
	 * @param model	Het model van de dobbelsteen dat hier moet worden weergegeven.
	 */
	public void modelChanged(IDobbelsteen model) throws RemoteException;
}
