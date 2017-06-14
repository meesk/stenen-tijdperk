package domainlayer.skeleton;

import java.rmi.Remote;
import java.rmi.RemoteException;

import presentationlayer.skeleton.IDobbelsteenWorpPane;

/**
 * IDobbelsteenWorp.java
 * De interface van de DobbelsteenWorp.
 * 
 * @author	Erwin Olie, s1103026
 * @version	0.2
 */
public interface IDobbelsteenWorp extends Remote {
	/**
	 * Registreer een observer bij de observable 
	 * @param view	De observer met zijn view.
	 */
	public void addObserver(IDobbelsteenWorpPane view) throws RemoteException;
	/** Update de view in alle observers. */
	public void notifyObservers() throws RemoteException;
	/**
	 * Het werpen van dobbelstenen.
	 * @param aantal	Het aantal dobbelstenen dat moet worden geworpen.
	 */
	public void werp(int aantal) throws RemoteException;
	/** @return	Alle dobbelstenen die onderdeel zijn van deze worp. */
	public IDobbelsteen[] getDobbelstenen() throws RemoteException;
}