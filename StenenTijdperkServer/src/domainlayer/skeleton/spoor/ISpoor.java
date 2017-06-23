package domainlayer.skeleton.spoor;

import java.awt.Point;

/**
* @author Alex de Bruin, s1103096
* @author Erwin olie. s1103026
* @Version 0.1
*
* <br>
* <br>
* Dit is de interface waar de sporen van overerven
*/

import java.rmi.Remote;
import java.util.Map;
import java.rmi.RemoteException;
import domainlayer.skeleton.ISpeler;
import presentationlayer.skeleton.ISpoorObserver;

/**
 * Deze interface kan door de RMI worden gebruikt om
 * spoor-gegevens op te halen.
 * 
 * @author Erwin Olie, s1103026
 * @author Alex de Bruin, s1103096
 * @version 3.0
 */
public interface ISpoor extends Remote {

	/** @return De posities van alle markeerstenen op het spoor. */
	public Map<String, Integer> getMarkeerstenen() throws RemoteException;

	/**
	 * Het verlagen van de punten van een speler.
	 * @param speler  De speler wiens punten verlaagd word.
	 * @param aantal  Het aantal punten dat verlaagd word.
	 */
	public void verwijderPunten(ISpeler speler, int aantal) throws RemoteException;

	/**
	 * Het verhogen van de punten van een speler.
	 * @param speler  De speler wiens punten verhoogt word.
	 * @param aantal  Het aantal punten dat verhoogt word.
	 */
	public void verhoogPunten(ISpeler speler, int aantal) throws RemoteException;

	/**
	 * Het verkrijgen van de hoogte van het spoor.
	 * @param speler  De speler wiens hoogte verkregen word.
	 * @return De hoogte van het spoor.
	 */
	public int getProductie(ISpeler speler) throws RemoteException;

	/**
	 * Het verkrijgen van de positie van de markeersteen op het spoor.
	 * @param speler  De speler wiens markeersteenpositie word verkregen.
	 * @return De positie van de markeersteen op het spoor.
	 */
	public int getMarkeerSteen(ISpeler speler) throws RemoteException;

	/** @return Alle markeersteenposities in een array. */
	public Point[] getPunten() throws RemoteException;

	/**
	 * Het toevoegen van een markeersteen voor een speler.
	 * @param speler De speler om toe te voegen.
	 */
	public void addSpeler(ISpeler speler) throws RemoteException;

	/**
	 * Het registreren van een observer bij het model.
	 * @param observer  De observer van het model.
	 */
	public void registerObserver(ISpoorObserver observer) throws RemoteException;

	/** Het doorgeven aan de observers dat het model veranderd is. */
	public void notifyObservers() throws RemoteException;
}
