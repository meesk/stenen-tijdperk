package domainlayer.skeleton;

import java.rmi.Remote;
import java.rmi.RemoteException;

import presentationlayer.skeleton.IDobbelsteenWorpObserver;

/**
 * De interface voor RMI over de Dobbelsteenworp.
 * 
 * @author Erwin Olie, s1103026
 * @version 3.0
 */
public interface IDobbelsteenWorp extends Remote {
	/**
	 * Het toevoegen van een observer,
	 * @param observer  De observer die word toegevoegd.
	 */
	public void addObserver(IDobbelsteenWorpObserver observer) throws RemoteException;

	/** Update de view in alle observers. */
	public void notifyObservers() throws RemoteException;

	/**
	 * Het werpen van dobbelstenen.
	 * @param aantal  Het aantal dobbelstenen dat moet worden geworpen.
	 */
	public void werp(int aantal) throws RemoteException;

	/** @return Alle dobbelstenen die onderdeel zijn van deze worp. */
	public IDobbelsteen[] getDobbelstenen() throws RemoteException;

	/** @return De totale waarde van de worp. */
	public int getTotaal() throws RemoteException;

	/** Het (her-)berekenen van de totale waarde van de worp. */
	public void berekenTotaal() throws RemoteException;

	/**
	 * Het toevoegen van een aantal ogen aan de totale worpwaarde.
	 * @param aantal  Het aantal ogen dat word toegevoegd.
	 */
	public void addTotaal(int aantal) throws RemoteException;
}

